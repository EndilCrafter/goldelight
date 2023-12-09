package net.endil.goldelight.common.entity;

import net.endil.goldelight.common.registry.GDModEntityTypes;
import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import vectorwing.farmersdelight.common.registry.ModSounds;

public class RottenGoldenTomato extends ThrowableItemProjectile {
    public RottenGoldenTomato(EntityType<? extends RottenGoldenTomato> entityType, Level level) {
        super(entityType, level);
    }

    public RottenGoldenTomato(Level level, LivingEntity entity) {
        super(GDModEntityTypes.ROTTEN_GOLDEN_TOMATO.get(), entity, level);
    }

    public RottenGoldenTomato(Level level, double x, double y, double z) {
        super(GDModEntityTypes.ROTTEN_GOLDEN_TOMATO.get(), x, y, z, level);
    }

    protected Item getDefaultItem() {
        return GDModItems.ROTTEN_GOLDEN_TOMATO.get();
    }

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte id) {
        ItemStack entityStack = new ItemStack(this.getDefaultItem());
        if (id == 3) {
            ParticleOptions iparticledata = new ItemParticleOption(ParticleTypes.ITEM, entityStack);

            for (int i = 0; i < 12; ++i) {
                this.level().addParticle(iparticledata, this.getX(), this.getY(), this.getZ(), ((double) this.random.nextFloat() * 2.0 - 1.0) * 0.10000000149011612, ((double) this.random.nextFloat() * 2.0 - 1.0) * 0.10000000149011612 + 0.10000000149011612, ((double) this.random.nextFloat() * 2.0 - 1.0) * 0.10000000149011612);
            }
        }

    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 1.0F);
        this.playSound(ModSounds.ENTITY_ROTTEN_TOMATO_HIT.get(), 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.playSound(ModSounds.ENTITY_ROTTEN_TOMATO_HIT.get(), 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.discard();
        }

    }

    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
