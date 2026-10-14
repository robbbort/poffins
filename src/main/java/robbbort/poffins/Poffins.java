package robbbort.poffins;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class Poffins implements ModInitializer {
    public static final String MOD_ID = "poffins";

    @Override
    public void onInitialize() {
        PoffinsBlocks.register();
        PoffinsItems.register();

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, resourceLocation(MOD_ID), FabricItemGroup.builder()
                        .title(Component.translatable("itemGroup.poffins"))
                        .icon(() -> PoffinsItems.SPICY_POFFIN.getDefaultInstance())
                        .displayItems((params, output) -> {
                            output.accept(PoffinsItems.SPICY_POFFIN);
                            output.accept(PoffinsItems.SPICY_DRY_POFFIN);
                            output.accept(PoffinsItems.SPICY_SWEET_POFFIN);
                            output.accept(PoffinsItems.SPICY_BITTER_POFFIN);
                            output.accept(PoffinsItems.SPICY_SOUR_POFFIN);
                            output.accept(PoffinsItems.DRY_SPICY_POFFIN);
                            output.accept(PoffinsItems.DRY_POFFIN);
                            output.accept(PoffinsItems.DRY_SWEET_POFFIN);
                            output.accept(PoffinsItems.DRY_BITTER_POFFIN);
                            output.accept(PoffinsItems.DRY_SOUR_POFFIN);
                            output.accept(PoffinsItems.SWEET_SPICY_POFFIN);
                            output.accept(PoffinsItems.SWEET_DRY_POFFIN);
                            output.accept(PoffinsItems.SWEET_POFFIN);
                            output.accept(PoffinsItems.SWEET_BITTER_POFFIN);
                            output.accept(PoffinsItems.SWEET_SOUR_POFFIN);
                            output.accept(PoffinsItems.BITTER_SPICY_POFFIN);
                            output.accept(PoffinsItems.BITTER_DRY_POFFIN);
                            output.accept(PoffinsItems.BITTER_SWEET_POFFIN);
                            output.accept(PoffinsItems.BITTER_POFFIN);
                            output.accept(PoffinsItems.BITTER_SOUR_POFFIN);
                            output.accept(PoffinsItems.SOUR_SPICY_POFFIN);
                            output.accept(PoffinsItems.SOUR_DRY_POFFIN);
                            output.accept(PoffinsItems.SOUR_SWEET_POFFIN);
                            output.accept(PoffinsItems.SOUR_BITTER_POFFIN);
                            output.accept(PoffinsItems.SOUR_POFFIN);
                        })
                .build());
    }

    public static ResourceLocation resourceLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}
