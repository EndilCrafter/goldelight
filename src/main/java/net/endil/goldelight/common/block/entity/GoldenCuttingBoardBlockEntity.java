package net.endil.goldelight.common.block.entity;

import net.endil.goldelight.common.recipe.GoldenCuttingBoardRecipe;
import net.endil.goldelight.common.registry.GDModBlockEntityTypes;
import net.endil.goldelight.common.registry.GDModRecipeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.block.CuttingBoardBlock;
import vectorwing.farmersdelight.common.block.entity.SyncedBlockEntity;
import vectorwing.farmersdelight.common.mixin.accessor.RecipeManagerAccessor;
import vectorwing.farmersdelight.common.registry.ModAdvancements;
import vectorwing.farmersdelight.common.registry.ModSounds;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.common.utility.ItemUtils;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class GoldenCuttingBoardBlockEntity extends SyncedBlockEntity {
    private final ItemStackHandler inventory = this.createHandler();
    private final LazyOptional<IItemHandler> inputHandler = LazyOptional.of(() -> {
        return this.inventory;
    });
    private ResourceLocation lastRecipeID;
    private boolean isItemCarvingBoard = false;

    public GoldenCuttingBoardBlockEntity(BlockPos pos, BlockState state) {
        super(GDModBlockEntityTypes.GOLDEN_CUTTING_BOARD.get(), pos, state);
    }

    public void load(CompoundTag compound) {
        super.load(compound);
        this.isItemCarvingBoard = compound.getBoolean("IsItemCarved");
        this.inventory.deserializeNBT(compound.getCompound("Inventory"));
    }

    public void saveAdditional(CompoundTag compound) {
        super.saveAdditional(compound);
        compound.put("Inventory", this.inventory.serializeNBT());
        compound.putBoolean("IsItemCarved", this.isItemCarvingBoard);
    }

    public boolean processStoredItemUsingTool(ItemStack toolStack, @Nullable Player player) {
        if (this.level == null) {
            return false;
        } else if (this.isItemCarvingBoard) {
            return false;
        } else {
            Optional<GoldenCuttingBoardRecipe> matchingRecipe = this.getMatchingRecipe(new RecipeWrapper(this.inventory), toolStack, player);
            matchingRecipe.ifPresent((recipe) -> {
                List<ItemStack> results = recipe.rollResults(this.level.random, EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, toolStack));
                Iterator var5 = results.iterator();

                while (var5.hasNext()) {
                    ItemStack resultStack = (ItemStack) var5.next();
                    Direction direction = this.getBlockState().getValue(CuttingBoardBlock.FACING).getCounterClockWise();
                    ItemUtils.spawnItemEntity(this.level, resultStack.copy(), (double) this.worldPosition.getX() + 0.5 + (double) direction.getStepX() * 0.2, (double) this.worldPosition.getY() + 0.2, (double) this.worldPosition.getZ() + 0.5 + (double) direction.getStepZ() * 0.2, (float) direction.getStepX() * 0.2F, 0.0, (float) direction.getStepZ() * 0.2F);
                }

                if (player != null) {
                    toolStack.hurtAndBreak(1, player, (user) -> {
                        user.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                    });
                } else if (toolStack.hurt(1, this.level.random, null)) {
                    toolStack.setCount(0);
                }

                this.playProcessingSound(recipe.getSoundEventID(), toolStack, this.getStoredItem());
                this.removeItem();
                if (player instanceof ServerPlayer) {
                    ModAdvancements.CUTTING_BOARD.trigger((ServerPlayer) player);
                }

            });
            return matchingRecipe.isPresent();
        }
    }

    private Optional<GoldenCuttingBoardRecipe> getMatchingRecipe(RecipeWrapper recipeWrapper, ItemStack toolStack, @Nullable Player player) {
        if (this.level == null) {
            return Optional.empty();
        } else {
            if (this.lastRecipeID != null) {
                Recipe<RecipeWrapper> recipe = (Recipe) ((RecipeManagerAccessor) this.level.getRecipeManager()).getRecipeMap((RecipeType) GDModRecipeTypes.GOLDEN_CUTTING.get()).get(this.lastRecipeID);
                if (recipe instanceof GoldenCuttingBoardRecipe && recipe.matches(recipeWrapper, this.level) && ((GoldenCuttingBoardRecipe) recipe).getTool().test(toolStack)) {
                    return Optional.of((GoldenCuttingBoardRecipe) recipe);
                }
            }

            List<GoldenCuttingBoardRecipe> recipeList = this.level.getRecipeManager().getRecipesFor((RecipeType) GDModRecipeTypes.GOLDEN_CUTTING.get(), recipeWrapper, this.level);
            if (recipeList.isEmpty()) {
                if (player != null) {
                    player.displayClientMessage(TextUtils.getTranslation("block.cutting_board.invalid_item"), true);
                }

                return Optional.empty();
            } else {
                Optional<GoldenCuttingBoardRecipe> recipe = recipeList.stream().filter((cuttingRecipe) -> {
                    return cuttingRecipe.getTool().test(toolStack);
                }).findFirst();
                if (!recipe.isPresent()) {
                    if (player != null) {
                        player.displayClientMessage(TextUtils.getTranslation("block.cutting_board.invalid_tool"), true);
                    }

                    return Optional.empty();
                } else {
                    this.lastRecipeID = recipe.get().getId();
                    return recipe;
                }
            }
        }
    }

    public void playProcessingSound(String soundEventID, ItemStack tool, ItemStack boardItem) {
        SoundEvent sound = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(soundEventID));
        if (sound != null) {
            this.playSound(sound, 1.0F, 1.0F);
        } else if (tool.is(Tags.Items.SHEARS)) {
            this.playSound(SoundEvents.SHEEP_SHEAR, 1.0F, 1.0F);
        } else if (tool.is(ForgeTags.TOOLS_KNIVES)) {
            this.playSound(ModSounds.BLOCK_CUTTING_BOARD_KNIFE.get(), 0.8F, 1.0F);
        } else {
            Item var6 = boardItem.getItem();
            if (var6 instanceof BlockItem blockItem) {
                Block block = blockItem.getBlock();
                SoundType soundType = block.defaultBlockState().getSoundType();
                this.playSound(soundType.getBreakSound(), 1.0F, 0.8F);
            } else {
                this.playSound(SoundEvents.WOOD_BREAK, 1.0F, 0.8F);
            }
        }

    }

    public void playSound(SoundEvent sound, float volume, float pitch) {
        if (this.level != null) {
            this.level.playSound(null, (float) this.worldPosition.getX() + 0.5F, (float) this.worldPosition.getY() + 0.5F, (float) this.worldPosition.getZ() + 0.5F, sound, SoundSource.BLOCKS, volume, pitch);
        }

    }

    public boolean addItem(ItemStack itemStack) {
        if (this.isEmpty() && !itemStack.isEmpty()) {
            this.inventory.setStackInSlot(0, itemStack.split(1));
            this.isItemCarvingBoard = false;
            this.inventoryChanged();
            return true;
        } else {
            return false;
        }
    }

    public boolean carveToolOnBoard(ItemStack tool) {
        if (this.addItem(tool)) {
            this.isItemCarvingBoard = true;
            return true;
        } else {
            return false;
        }
    }

    public ItemStack removeItem() {
        if (!this.isEmpty()) {
            this.isItemCarvingBoard = false;
            ItemStack item = this.getStoredItem().split(1);
            this.inventoryChanged();
            return item;
        } else {
            return ItemStack.EMPTY;
        }
    }

    public IItemHandler getInventory() {
        return this.inventory;
    }

    public ItemStack getStoredItem() {
        return this.inventory.getStackInSlot(0);
    }

    public boolean isEmpty() {
        return this.inventory.getStackInSlot(0).isEmpty();
    }

    public boolean isItemCarvingBoard() {
        return this.isItemCarvingBoard;
    }

    @Nonnull
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        return cap.equals(ForgeCapabilities.ITEM_HANDLER) ? this.inputHandler.cast() : super.getCapability(cap, side);
    }

    public void setRemoved() {
        super.setRemoved();
        this.inputHandler.invalidate();
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler() {
            public int getSlotLimit(int slot) {
                return 1;
            }

            protected void onContentsChanged(int slot) {
                GoldenCuttingBoardBlockEntity.this.inventoryChanged();
            }
        };
    }
}
