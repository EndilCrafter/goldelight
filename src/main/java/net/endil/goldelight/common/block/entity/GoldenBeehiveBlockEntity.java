package net.endil.goldelight.common.block.entity;

import com.google.common.collect.Lists;
import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.block.vanilla.GoldenBeehiveBlock;
import net.endil.goldelight.common.entity.GoldenBee;
import net.endil.goldelight.common.registry.GDModBlockEntityTypes;
import net.endil.goldelight.common.registry.GDModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GoldenBeehiveBlockEntity extends BlockEntity {
    public static final String TAG_FLOWER_POS = "FlowerPos";
    public static final String MIN_OCCUPATION_TICKS = "MinOccupationTicks";
    public static final String ENTITY_DATA = "EntityData";
    public static final String TICKS_IN_HIVE = "TicksInHive";
    public static final String HAS_NECTAR = "HasNectar";
    public static final String BEES = "Bees";
    public static final int MAX_OCCUPANTS = 3;
    public static final int MIN_OCCUPATION_TICKS_NECTARLESS = 600;
    private static final List<String> IGNORED_BEE_TAGS = Arrays.asList("Air", "ArmorDropChances", "ArmorItems", "Brain", "CanPickUpLoot", "DeathTime", "FallDistance", "FallFlying", "Fire", "HandDropChances", "HandItems", "HurtByTimestamp", "HurtTime", "LeftHanded", "Motion", "NoGravity", "OnGround", "PortalCooldown", "Pos", "Rotation", "CannotEnterHiveTicks", "TicksSincePollination", "CropsGrownSincePollination", "HivePos", "Passengers", "Leash", "UUID");
    private static final int MIN_TICKS_BEFORE_REENTERING_HIVE = 400;
    private static final int MIN_OCCUPATION_TICKS_NECTAR = 2400;
    private final List<GoldenBeehiveBlockEntity.BeeData> stored = Lists.newArrayList();
    @Nullable
    private BlockPos savedFlowerPos;

    public GoldenBeehiveBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(GDModBlockEntityTypes.GOLDEN_BEEHIVE.get(), pPos, pBlockState);
    }

    public static int getHoneyLevel(BlockState pState) {
        return pState.getValue(GoldenBeehiveBlock.HONEY_LEVEL);
    }

    private static boolean releaseOccupant(Level pLevel, BlockPos pPos, BlockState pState, GoldenBeehiveBlockEntity.BeeData pData, @Nullable List<Entity> pStoredInHives, GoldenBeehiveBlockEntity.BeeReleaseStatus pReleaseStatus, @Nullable BlockPos pSavedFlowerPos) {
        if ((pLevel.isNight() || pLevel.isRaining()) && pReleaseStatus != GoldenBeehiveBlockEntity.BeeReleaseStatus.EMERGENCY) {
            return false;
        } else {
            CompoundTag compoundtag = pData.entityData.copy();
            removeIgnoredBeeTags(compoundtag);
            compoundtag.put("HivePos", NbtUtils.writeBlockPos(pPos));
            compoundtag.putBoolean("NoGravity", true);
            Direction direction = pState.getValue(BeehiveBlock.FACING);
            BlockPos blockpos = pPos.relative(direction);
            boolean flag = !pLevel.getBlockState(blockpos).getCollisionShape(pLevel, blockpos).isEmpty();
            if (flag && pReleaseStatus != GoldenBeehiveBlockEntity.BeeReleaseStatus.EMERGENCY) {
                return false;
            } else {
                Entity entity = EntityType.loadEntityRecursive(compoundtag, pLevel, (p_58740_) -> {
                    return p_58740_;
                });
                if (entity != null) {
                    if (!entity.getType().is(GDModTags.EntityTypes.GOLDEN_BEEHIVE_INHABITORS)) {
                        return false;
                    } else {
                        if (entity instanceof GoldenBee bee) {
                            if (pSavedFlowerPos != null && !bee.hasSavedFlowerPos() && pLevel.random.nextFloat() < 0.9F) {
                                bee.setSavedFlowerPos(pSavedFlowerPos);
                            }

                            if (pReleaseStatus == GoldenBeehiveBlockEntity.BeeReleaseStatus.HONEY_DELIVERED) {
                                bee.dropOffNectar();
                                if (pState.is(GDModTags.Blocks.GOLDEN_BEEHIVES, (base) -> {
                                    return base.hasProperty(GoldenBeehiveBlock.HONEY_LEVEL);
                                })) {
                                    int i = getHoneyLevel(pState);
                                    if (i < 5) {
                                        int j = pLevel.random.nextInt(100) == 0 ? 2 : 1;
                                        if (i + j > 5) {
                                            --j;
                                        }

                                        pLevel.setBlockAndUpdate(pPos, pState.setValue(GoldenBeehiveBlock.HONEY_LEVEL, Integer.valueOf(i + j)));
                                    }
                                }
                            }

                            setBeeReleaseData(pData.ticksInHive, bee);
                            if (pStoredInHives != null) {
                                pStoredInHives.add(bee);
                            }

                            float f = entity.getBbWidth();
                            double d3 = flag ? 0.0D : 0.55D + (double) (f / 2.0F);
                            double d0 = (double) pPos.getX() + 0.5D + d3 * (double) direction.getStepX();
                            double d1 = (double) pPos.getY() + 0.5D - (double) (entity.getBbHeight() / 2.0F);
                            double d2 = (double) pPos.getZ() + 0.5D + d3 * (double) direction.getStepZ();
                            entity.moveTo(d0, d1, d2, entity.getYRot(), entity.getXRot());
                        }

                        pLevel.playSound(null, pPos, SoundEvents.BEEHIVE_EXIT, SoundSource.BLOCKS, 1.0F, 1.0F);
                        pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(entity, pLevel.getBlockState(pPos)));
                        return pLevel.addFreshEntity(entity);
                    }
                } else {
                    return false;
                }
            }
        }
    }

    static void removeIgnoredBeeTags(CompoundTag pTag) {
        for (String s : IGNORED_BEE_TAGS) {
            pTag.remove(s);
        }

    }

    private static void setBeeReleaseData(int pTimeInHive, GoldenBee pBee) {
        int i = pBee.getAge();
        if (i < 0) {
            pBee.setAge(Math.min(0, i + pTimeInHive));
        } else if (i > 0) {
            pBee.setAge(Math.max(0, i - pTimeInHive));
        }

        pBee.setInLoveTime(Math.max(0, pBee.getInLoveTime() - pTimeInHive));
    }

    private static void tickOccupants(Level pLevel, BlockPos pPos, BlockState pState, List<GoldenBeehiveBlockEntity.BeeData> pData, @Nullable BlockPos pSavedFlowerPos) {
        boolean flag = false;

        GoldenBeehiveBlockEntity.BeeData beehiveblockentity$beedata;
        for (Iterator<GoldenBeehiveBlockEntity.BeeData> iterator = pData.iterator(); iterator.hasNext(); ++beehiveblockentity$beedata.ticksInHive) {
            beehiveblockentity$beedata = iterator.next();
            if (beehiveblockentity$beedata.ticksInHive > beehiveblockentity$beedata.minOccupationTicks) {
                GoldenBeehiveBlockEntity.BeeReleaseStatus beehiveblockentity$beereleasestatus = beehiveblockentity$beedata.entityData.getBoolean("HasNectar") ? GoldenBeehiveBlockEntity.BeeReleaseStatus.HONEY_DELIVERED : GoldenBeehiveBlockEntity.BeeReleaseStatus.BEE_RELEASED;
                if (releaseOccupant(pLevel, pPos, pState, beehiveblockentity$beedata, null, beehiveblockentity$beereleasestatus, pSavedFlowerPos)) {
                    flag = true;
                    iterator.remove();
                }
            }
        }

        if (flag) {
            setChanged(pLevel, pPos, pState);
        }

    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, GoldenBeehiveBlockEntity pBeehive) {
        tickOccupants(pLevel, pPos, pState, pBeehive.stored, pBeehive.savedFlowerPos);
        if (!pBeehive.stored.isEmpty() && pLevel.getRandom().nextDouble() < 0.005D) {
            double d0 = (double) pPos.getX() + 0.5D;
            double d1 = pPos.getY();
            double d2 = (double) pPos.getZ() + 0.5D;
            pLevel.playSound(null, d0, d1, d2, SoundEvents.BEEHIVE_WORK, SoundSource.BLOCKS, 1.0F, 1.0F);
        }

        GolDelight.sendHiveInfo(pLevel, pPos, pState, pBeehive);
    }

    /**
     * For block entities, ensures the chunk containing the block entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    public void setChanged() {
        if (this.isFireNearby()) {
            this.emptyAllLivingFromHive(null, this.level.getBlockState(this.getBlockPos()), GoldenBeehiveBlockEntity.BeeReleaseStatus.EMERGENCY);
        }

        super.setChanged();
    }

    public boolean isFireNearby() {
        if (this.level == null) {
            return false;
        } else {
            for (BlockPos blockpos : BlockPos.betweenClosed(this.worldPosition.offset(-1, -1, -1), this.worldPosition.offset(1, 1, 1))) {
                if (this.level.getBlockState(blockpos).getBlock() instanceof FireBlock) {
                    return true;
                }
            }

            return false;
        }
    }

    public boolean isEmpty() {
        return this.stored.isEmpty();
    }

    public boolean isFull() {
        return this.stored.size() == 3;
    }

    public void emptyAllLivingFromHive(@Nullable Player pPlayer, BlockState pState, GoldenBeehiveBlockEntity.BeeReleaseStatus pReleaseStatus) {
        List<Entity> list = this.releaseAllOccupants(pState, pReleaseStatus);
        if (pPlayer != null) {
            for (Entity entity : list) {
                if (entity instanceof GoldenBee bee) {
                    if (pPlayer.position().distanceToSqr(entity.position()) <= 16.0D) {
                        if (!this.isSedated()) {
                            bee.setTarget(pPlayer);
                        } else {
                            bee.setStayOutOfHiveCountdown(400);
                        }
                    }
                }
            }
        }

    }

    private List<Entity> releaseAllOccupants(BlockState pState, GoldenBeehiveBlockEntity.BeeReleaseStatus pReleaseStatus) {
        List<Entity> list = Lists.newArrayList();
        this.stored.removeIf((p_272556_) -> {
            return releaseOccupant(this.level, this.worldPosition, pState, p_272556_, list, pReleaseStatus, this.savedFlowerPos);
        });
        if (!list.isEmpty()) {
            super.setChanged();
        }

        return list;
    }

    public void addOccupant(Entity pOccupant, boolean pHasNectar) {
        this.addOccupantWithPresetTicks(pOccupant, pHasNectar, 0);
    }

    @VisibleForDebug
    public int getOccupantCount() {
        return this.stored.size();
    }

    @VisibleForDebug
    public boolean isSedated() {
        return CampfireBlock.isSmokeyPos(this.level, this.getBlockPos());
    }

    public void addOccupantWithPresetTicks(Entity pOccupant, boolean pHasNectar, int pTicksInHive) {
        if (this.stored.size() < 3) {
            pOccupant.stopRiding();
            pOccupant.ejectPassengers();
            CompoundTag compoundtag = new CompoundTag();
            pOccupant.save(compoundtag);
            this.storeBee(compoundtag, pTicksInHive, pHasNectar);
            if (this.level != null) {
                if (pOccupant instanceof GoldenBee bee) {
                    if (bee.hasSavedFlowerPos() && (!this.hasSavedFlowerPos() || this.level.random.nextBoolean())) {
                        this.savedFlowerPos = bee.getSavedFlowerPos();
                    }
                }

                BlockPos blockpos = this.getBlockPos();
                this.level.playSound(null, blockpos.getX(), blockpos.getY(), blockpos.getZ(), SoundEvents.BEEHIVE_ENTER, SoundSource.BLOCKS, 1.0F, 1.0F);
                this.level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(pOccupant, this.getBlockState()));
            }

            pOccupant.discard();
            super.setChanged();
        }
    }

    public void storeBee(CompoundTag pEntityData, int pTicksInHive, boolean pHasNectar) {
        this.stored.add(new GoldenBeehiveBlockEntity.BeeData(pEntityData, pTicksInHive, pHasNectar ? 2400 : 600));
    }

    private boolean hasSavedFlowerPos() {
        return this.savedFlowerPos != null;
    }

    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.stored.clear();
        ListTag listtag = pTag.getList("Bees", 10);

        for (int i = 0; i < listtag.size(); ++i) {
            CompoundTag compoundtag = listtag.getCompound(i);
            GoldenBeehiveBlockEntity.BeeData beehiveblockentity$beedata = new GoldenBeehiveBlockEntity.BeeData(compoundtag.getCompound("EntityData"), compoundtag.getInt("TicksInHive"), compoundtag.getInt("MinOccupationTicks"));
            this.stored.add(beehiveblockentity$beedata);
        }

        this.savedFlowerPos = null;
        if (pTag.contains("FlowerPos")) {
            this.savedFlowerPos = NbtUtils.readBlockPos(pTag.getCompound("FlowerPos"));
        }

    }

    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.put("Bees", this.writeBees());
        if (this.hasSavedFlowerPos()) {
            pTag.put("FlowerPos", NbtUtils.writeBlockPos(this.savedFlowerPos));
        }

    }

    public ListTag writeBees() {
        ListTag listtag = new ListTag();

        for (GoldenBeehiveBlockEntity.BeeData beehiveblockentity$beedata : this.stored) {
            CompoundTag compoundtag = beehiveblockentity$beedata.entityData.copy();
            compoundtag.remove("UUID");
            CompoundTag compoundtag1 = new CompoundTag();
            compoundtag1.put("EntityData", compoundtag);
            compoundtag1.putInt("TicksInHive", beehiveblockentity$beedata.ticksInHive);
            compoundtag1.putInt("MinOccupationTicks", beehiveblockentity$beedata.minOccupationTicks);
            listtag.add(compoundtag1);
        }

        return listtag;
    }

    public enum BeeReleaseStatus {
        HONEY_DELIVERED,
        BEE_RELEASED,
        EMERGENCY
    }

    static class BeeData {
        final CompoundTag entityData;
        final int minOccupationTicks;
        int ticksInHive;

        BeeData(CompoundTag pEntityData, int pTicksInHive, int pMinOccupationTicks) {
            GoldenBeehiveBlockEntity.removeIgnoredBeeTags(pEntityData);
            this.entityData = pEntityData;
            this.ticksInHive = pTicksInHive;
            this.minOccupationTicks = pMinOccupationTicks;
        }
    }
}
