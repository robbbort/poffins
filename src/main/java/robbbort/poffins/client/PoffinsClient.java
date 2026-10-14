package robbbort.poffins.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.TooltipComponentCallback;
import robbbort.poffins.Flavors;

public class PoffinsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TooltipComponentCallback.EVENT.register(data -> data instanceof Flavors flavors ? new FlavorsTooltip(flavors.flavors()) : null);
    }
}
