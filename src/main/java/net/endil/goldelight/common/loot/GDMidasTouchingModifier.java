package net.endil.goldelight.common.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.endil.goldelight.common.recipe.MidasTouchingRecipe;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class GDMidasTouchingModifier extends LootModifier {
    public static final Supplier<Codec<GDMidasTouchingModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, GDMidasTouchingModifier::new)));
    protected GDMidasTouchingModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        ObjectArrayList<ItemStack> golden = new ObjectArrayList<ItemStack>();
        generatedLoot.forEach((stack) -> golden.add(midas(stack, context)));
        return golden;
    }

    private static ItemStack midas(ItemStack stack, LootContext context) {
        return context.getLevel().getRecipeManager().getRecipeFor(MidasTouchingRecipe.Type.INSTANCE, new SimpleContainer(stack), context.getLevel())
                .map(midasTouchingRecipe -> midasTouchingRecipe.getResultItem(context.getLevel().registryAccess()))
                .filter(itemStack -> !itemStack.isEmpty())
                .map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack, stack.getCount() * itemStack.getCount()))
                .orElse(stack);
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
