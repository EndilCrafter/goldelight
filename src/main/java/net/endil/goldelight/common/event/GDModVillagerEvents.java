package net.endil.goldelight.common.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.endil.goldelight.GolDelight;
import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = GolDelight.MOD_ID)
public class GDModVillagerEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.LEATHERWORKER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(GDModItems.GOLDEN_LEATHER.get(), 3),
                    new ItemStack(Items.EMERALD),
                    32, 30, 0.025F
            ));
        }
        if (event.getType() == VillagerProfession.FLETCHER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            trades.get(5).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(GDModItems.GOLDEN_FEATHER.get(), 12),
                    new ItemStack(Items.EMERALD),
                    32, 30, 0.025F
            ));
        }

    }
}
