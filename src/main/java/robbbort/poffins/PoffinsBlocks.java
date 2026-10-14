package robbbort.poffins;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import robbbort.poffins.block.PoffinMachineBlock;

public class PoffinsBlocks {
    public static final Block RED_POFFIN_MACHINE = poffinMachine();
    public static final Block YELLOW_POFFIN_MACHINE = poffinMachine();
    public static final Block GREEN_POFFIN_MACHINE = poffinMachine();
    public static final Block BLUE_POFFIN_MACHINE = poffinMachine();
    public static final Block PINK_POFFIN_MACHINE = poffinMachine();
    public static final Block BLACK_POFFIN_MACHINE = poffinMachine();
    public static final Block WHITE_POFFIN_MACHINE = poffinMachine();

    public static void register() {
        register("red_poffin_machine", RED_POFFIN_MACHINE);
        register("yellow_poffin_machine", YELLOW_POFFIN_MACHINE);
        register("green_poffin_machine", GREEN_POFFIN_MACHINE);
        register("blue_poffin_machine", BLUE_POFFIN_MACHINE);
        register("pink_poffin_machine", PINK_POFFIN_MACHINE);
        register("black_poffin_machine", BLACK_POFFIN_MACHINE);
        register("white_poffin_machine", WHITE_POFFIN_MACHINE);
    }

    public static void register(String name, Block block) {
        Registry.register(BuiltInRegistries.BLOCK, Poffins.resourceLocation(name), block);

        PoffinsItems.register(name, new DoubleHighBlockItem(block, new Item.Properties()) {

            @Override
            protected boolean canPlace(BlockPlaceContext context, BlockState blockState) {
                return super.canPlace(context, blockState) && context.getLevel().getBlockState(context.getClickedPos().above()).is(BlockTags.REPLACEABLE);
            }
        });
    }

    public static Block poffinMachine() {
        return new PoffinMachineBlock(BlockBehaviour.Properties.of());
    }
}
