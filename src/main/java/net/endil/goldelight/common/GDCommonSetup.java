package net.endil.goldelight.common;

import accieo.midas.hunger.registry.ItemRegistry;
import net.endil.goldelight.common.entity.RottenGoldenTomato;
import net.endil.goldelight.common.entity.ThrownGoldenEgg;
import net.endil.goldelight.common.registry.GDModBlocks;
import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import vectorwing.farmersdelight.common.registry.ModItems;

import static net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES;

public class GDCommonSetup {
    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            registerDispenserBehaviors();
            registerStackSizeOverrides();
            registerCompostables();
            registerPottedFlowers();
            registerBrewingRecipes();
        });
    }
    public static void registerDispenserBehaviors() {
        DispenserBlock.registerBehavior(GDModItems.GOLDEN_EGG.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return new ThrownGoldenEgg(pLevel, pPosition.x(), pPosition.y(), pPosition.z());
            }
        });
        DispenserBlock.registerBehavior(GDModItems.ROTTEN_GOLDEN_TOMATO.get(), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level pLevel, Position pPosition, ItemStack pStack) {
                return new RottenGoldenTomato(pLevel, pPosition.x(), pPosition.y(), pPosition.z());
            }
        });
    }
    public static void registerStackSizeOverrides() {
        ObfuscationReflectionHelper.setPrivateValue(Item.class, ItemRegistry.GOLDEN_BEETROOT_SOUP.get(), 16, "f_41370_");
    }
    public static void registerCompostables() {
        //Minecraft
        add(0.6F, ItemRegistry.GOLDEN_BEETROOT_SEEDS.get());
        add(0.6F, ItemRegistry.DRIED_GOLDEN_KELP.get());
        add(0.6F, ItemRegistry.GOLDEN_KELP.get());
        add(0.6F, GDModItems.GOLDEN_MELON_SEEDS.get());
        add(0.6F, GDModItems.GOLDEN_PUMPKIN_SEEDS.get());
        add(0.6F, ItemRegistry.SWEET_GOLDEN_BERRIES.get());
        add(0.6F, GDModItems.GOLDEN_GLOW_BERRIES.get());
        add(0.6F, GDModItems.GOLDEN_WHEAT_SEEDS.get());
        add(1.0F, ItemRegistry.DRIED_GOLDEN_KELP_BLOCK.get());
        add(1.0F, GDModBlocks.GOLDEN_CACTUS.get());
        add(1.0F, GDModItems.GOLDEN_SUGAR_CANE.get());
        add(1.0F, GDModItems.GOLDEN_MELON_SLICE.get());
        add(1.0F, GDModBlocks.GOLDEN_PUMPKIN.get());
        add(1.0F, GDModBlocks.GOLDEN_CARVED_PUMPKIN.get());
        add(1.0F, GDModBlocks.GOLDEN_MELON.get());
        add(1.0F, ItemRegistry.GOLDEN_BEETROOT.get());
        add(1.0F, GDModItems.GOLDEN_COCOA_BEANS.get());
        add(1.0F, GDModItems.GOLDEN_POTATO.get());
        add(1.0F, GDModItems.GOLDEN_WHEAT.get());
        add(1.0F, GDModBlocks.GOLDEN_MUSHROOM.get());
        add(1.0F, GDModBlocks.GOLDEN_MUSHROOM_STEM.get());
        add(1.0F, GDModBlocks.GOLDEN_FUNGUS.get());
        add(1.0F, GDModItems.GOLDEN_WART.get());
        add(1.0F, GDModBlocks.GROOMLIGHT.get());
        add(1.0F, GDModBlocks.GOLDEN_MUSHROOM_BLOCK.get());
        add(1.0F, GDModBlocks.GOLDEN_WART_BLOCK.get());
        add(1.0F, GDModItems.GOLDEN_BREAD.get());
        add(1.0F, ItemRegistry.BAKED_GOLDEN_POTATO.get());
        add(1.0F, GDModItems.GOLDEN_COOKIE.get());
        add(1.0F, GDModItems.GOLDEN_CAKE.get());
        add(1.0F, ItemRegistry.GOLDEN_PUMPKIN_PIE.get());

        //FD
        add(0.6F, GDModItems.GOLDEN_CABBAGE_SEEDS.get());
        add(0.6F, GDModItems.GOLDEN_TOMATO_SEEDS.get());
        add(0.6F, GDModItems.GOLDEN_RICE.get());
        add(0.6F, GDModItems.GOLDEN_RICE_PANICLE.get());
        add(1.0F, GDModItems.GOLDEN_PUMPKIN_SLICE.get());
        add(1.0F, GDModItems.GOLDEN_CABBAGE_LEAF.get());
        add(1.0F, GDModItems.GOLDEN_KELP_ROLL_SLICE.get());
        add(1.0F, GDModItems.GOLDEN_CABBAGE.get());
        add(1.0F, GDModItems.GOLDEN_ONION.get());
        add(1.0F, GDModItems.GOLDEN_TOMATO.get());
        add(1.0F, GDModItems.GOLDEN_PIE_CRUST.get());
        add(1.0F, GDModBlocks.GOLDEN_RICE_BALE.get());
        add(1.0F, GDModItems.SWEET_GOLDEN_BERRY_COOKIE.get());
        add(1.0F, GDModItems.GOLDEN_HONEY_COOKIE.get());
        add(1.0F, GDModItems.GOLDEN_CAKE_SLICE.get());
        add(1.0F, GDModItems.GOLDEN_APPLE_PIE_SLICE.get());
        add(1.0F, GDModItems.SWEET_GOLDEN_BERRY_CHEESECAKE_SLICE.get());
        add(1.0F, GDModItems.GOLDEN_CHOCOLATE_PIE_SLICE.get());
        add(1.0F, GDModItems.RAW_GOLDEN_PASTA.get());
        add(1.0F, GDModItems.ROTTEN_GOLDEN_TOMATO.get());
        add(1.0F, GDModItems.GOLDEN_KELP_ROLL.get());
        add(1.0F, GDModItems.GOLDEN_APPLE_PIE.get());
        add(1.0F, GDModItems.SWEET_GOLDEN_BERRY_CHEESECAKE.get());
        add(1.0F, GDModItems.GOLDEN_CHOCOLATE_PIE.get());
        add(1.0F, GDModItems.GUMPLINGS.get());
        add(1.0F, GDModItems.STUFFED_GOLDEN_PUMPKIN_BLOCK.get());
        add(1.0F, GDModItems.GOLDEN_MUSHROOM_COLONY.get());
        add(1.0F, GDModItems.GOLDEN_FUNGUS_COLONY.get());
    }
    private static void add(float pChance, ItemLike pItem) {
        COMPOSTABLES.put(pItem.asItem(), pChance);
    }
    public static void registerPottedFlowers() {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GDModBlocks.GOLDEN_CACTUS.getId(), GDModBlocks.POTTED_GOLDEN_CACTUS);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GDModBlocks.GOLDEN_MUSHROOM.getId(), GDModBlocks.POTTED_GOLDEN_MUSHROOM);
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GDModBlocks.GOLDEN_FUNGUS.getId(), GDModBlocks.POTTED_GOLDEN_FUNGUS);
    }
    public static void registerBrewingRecipes() {
        BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(Items.DRAGON_BREATH),Ingredient.of(GDModItems.ANCIENT_GOLD_DUST.get()), new ItemStack(GDModItems.MIDAS_POTION.get())));
    }
}
