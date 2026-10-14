package robbbort.poffins.client;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;

public record FlavorsTooltip(int[] flavors) implements ClientTooltipComponent {
    @Override
    public int getHeight() {
        return 32;
    }

    @Override
    public int getWidth(Font font) {
        return 32;
    }
}
