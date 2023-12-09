package net.endil.goldelight.common.registry;

import net.endil.goldelight.GolDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GDModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GolDelight.MOD_ID);

    //Ancient Gold Block
    public static final ForgeSoundType ANCIENT_GOLD_BLOCK;
    public static final RegistryObject<SoundEvent> BLOCK_ANCIENT_GOLD_BLOCK_BREAK;
    public static final RegistryObject<SoundEvent> BLOCK_ANCIENT_GOLD_BLOCK_STEP;
    public static final RegistryObject<SoundEvent> BLOCK_ANCIENT_GOLD_BLOCK_PLACE;
    public static final RegistryObject<SoundEvent> BLOCK_ANCIENT_GOLD_BLOCK_HIT;
    public static final RegistryObject<SoundEvent> BLOCK_ANCIENT_GOLD_BLOCK_FALL;

    //Golden Mutation
    public static final RegistryObject<SoundEvent> ENTITY_CONVERT_TO_GOLD;

    static {
        BLOCK_ANCIENT_GOLD_BLOCK_BREAK = registerSound("block.ancient_gold_block.break");
        BLOCK_ANCIENT_GOLD_BLOCK_STEP = registerSound("block.ancient_gold_block.step");
        BLOCK_ANCIENT_GOLD_BLOCK_PLACE = registerSound("block.ancient_gold_block.place");
        BLOCK_ANCIENT_GOLD_BLOCK_HIT = registerSound("block.ancient_gold_block.hit");
        BLOCK_ANCIENT_GOLD_BLOCK_FALL = registerSound("block.ancient_gold_block.fall");
        ENTITY_CONVERT_TO_GOLD = registerSound("entity.convert_to_gold");
    }

    static {
        ANCIENT_GOLD_BLOCK = new ForgeSoundType(1.0F, 1.0F,
                GDModSounds.BLOCK_ANCIENT_GOLD_BLOCK_BREAK, GDModSounds.BLOCK_ANCIENT_GOLD_BLOCK_STEP, GDModSounds.BLOCK_ANCIENT_GOLD_BLOCK_PLACE, GDModSounds.BLOCK_ANCIENT_GOLD_BLOCK_HIT, GDModSounds.BLOCK_ANCIENT_GOLD_BLOCK_FALL);
    }

    private static RegistryObject<SoundEvent> registerSound(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GolDelight.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}
