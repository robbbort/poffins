package robbbort.poffins.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class PoffinMachineBlock extends Block {
    public static final EnumProperty<Half> HALF = EnumProperty.create("half", Half.class);

    public PoffinMachineBlock(Properties properties) {
        super(properties);
    }
}
