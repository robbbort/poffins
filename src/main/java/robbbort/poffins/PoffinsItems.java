package robbbort.poffins;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

public class PoffinsItems {
    public static final DataComponentType<Flavors> FLAVORS = DataComponentType.<Flavors>builder().persistent(Flavors.CODEC).networkSynchronized(Flavors.STREAM_CODEC).build();

    public static final Item SPICY_POFFIN = poffin(10, 0, 0, 0, 0);
    public static final Item SPICY_DRY_POFFIN = poffin(15, 10, 0, 0, 0);
    public static final Item SPICY_SWEET_POFFIN = poffin(15, 0, 10, 0, 0);
    public static final Item SPICY_BITTER_POFFIN = poffin(15, 0, 0, 10, 0);
    public static final Item SPICY_SOUR_POFFIN = poffin(15, 0, 0, 0, 10);

    public static void register() {
        Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, Poffins.resourceLocation("flavors"), FLAVORS);
        register("spicy_poffin", SPICY_POFFIN);
        register("spicy_dry_poffin", SPICY_DRY_POFFIN);
        register("spicy_sweet_poffin", SPICY_SWEET_POFFIN);
        register("spicy_bitter_poffin", SPICY_BITTER_POFFIN);
        register("spicy_sour_poffin", SPICY_SOUR_POFFIN);
    }

    public static void register(String name, Item item) {
        Registry.register(BuiltInRegistries.ITEM, Poffins.resourceLocation(name), item);
    }

    public static Item poffin(int spicy, int dry, int sweet, int bitter, int sour) {
        return new PoffinItem(new Item.Properties().component(FLAVORS, new Flavors(new int[] {spicy, dry, sweet, bitter, sour})));
    }
}
