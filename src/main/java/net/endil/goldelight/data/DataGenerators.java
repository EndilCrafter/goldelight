package net.endil.goldelight.data;

import net.endil.goldelight.GolDelight;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = GolDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new ModRecipes(packOutput));
        generator.addProvider(event.includeServer(), ModLootTables.create(packOutput));
        generator.addProvider(event.includeClient(), new ModItemModels(packOutput, existingFileHelper));
        ModBlockTags blockTags = generator.addProvider(event.includeServer(),
                new ModBlockTags(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModItemTags(packOutput, lookupProvider, blockTags.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeClient(), new ModBlockStates(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModPoiTypeTags(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ModWorldGen(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ModAdvancements(packOutput, lookupProvider, existingFileHelper));
    }
}
