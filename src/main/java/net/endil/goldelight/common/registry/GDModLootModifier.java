package net.endil.goldelight.common.registry;

import com.mojang.serialization.Codec;
import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.loot.GDAddItemModifier;
import net.endil.goldelight.common.loot.GDAddLootTableModifier;
import net.endil.goldelight.common.loot.GDMidasTouchingModifier;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GDModLootModifier {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, GolDelight.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM =
            LOOT_MODIFIER_SERIALIZERS.register("add_item", GDAddItemModifier.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> MIDAS_TOUCHING =
            LOOT_MODIFIER_SERIALIZERS.register("midas_touching", GDMidasTouchingModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_LOOTTABLE =
            LOOT_MODIFIER_SERIALIZERS.register("add_loot_table", GDAddLootTableModifier.CODEC);

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }
}
