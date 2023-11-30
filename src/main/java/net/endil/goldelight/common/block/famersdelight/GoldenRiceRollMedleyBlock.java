package net.endil.goldelight.common.block.famersdelight;

import net.endil.goldelight.common.registry.GDModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.block.RiceRollMedleyBlock;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class GoldenRiceRollMedleyBlock extends FeastBlock {
    public static final IntegerProperty ROLL_SERVINGS = IntegerProperty.create("servings", 0, 8);
    protected static final VoxelShape PLATE_SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
    protected static final VoxelShape FOOD_SHAPE;
    public final List<Supplier<Item>> riceRollServings;

    public GoldenRiceRollMedleyBlock(BlockBehaviour.Properties properties) {
        super(properties, GDModItems.GOLDEN_SALMON_ROLL, true);
        this.riceRollServings = Arrays.asList(GDModItems.GOLDEN_COD_ROLL, GDModItems.GOLDEN_COD_ROLL, GDModItems.GOLDEN_SALMON_ROLL, GDModItems.GOLDEN_SALMON_ROLL, GDModItems.GOLDEN_SALMON_ROLL, GDModItems.GOLDEN_KELP_ROLL_SLICE, GDModItems.GOLDEN_KELP_ROLL_SLICE, GDModItems.GOLDEN_KELP_ROLL_SLICE);
    }

    public IntegerProperty getServingsProperty() {
        return ROLL_SERVINGS;
    }

    public int getMaxServings() {
        return 8;
    }

    public ItemStack getServingItem(BlockState state) {
        return new ItemStack((ItemLike)((Supplier)this.riceRollServings.get(state.getValue(this.getServingsProperty()) - 1)).get());
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(this.getServingsProperty()) == 0 ? PLATE_SHAPE : FOOD_SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, ROLL_SERVINGS);
    }

    static {
        FOOD_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(2.0, 2.0, 2.0, 14.0, 4.0, 14.0), BooleanOp.OR);
    }
}
