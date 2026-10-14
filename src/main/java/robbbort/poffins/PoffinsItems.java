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
    public static final Item DRY_SPICY_POFFIN = poffin(10, 15, 0, 0, 0);
    public static final Item DRY_POFFIN = poffin(0, 10, 0, 0, 0);
    public static final Item DRY_SWEET_POFFIN = poffin(0, 15, 10, 0, 0);
    public static final Item DRY_BITTER_POFFIN = poffin(0, 15, 0, 10, 0);
    public static final Item DRY_SOUR_POFFIN = poffin(0, 15, 0, 0, 10);
    public static final Item SWEET_SPICY_POFFIN = poffin(10, 0, 15, 0, 0);
    public static final Item SWEET_DRY_POFFIN = poffin(0, 10, 15, 0, 0);
    public static final Item SWEET_POFFIN = poffin(0, 0, 10, 0, 0);
    public static final Item SWEET_BITTER_POFFIN = poffin(0, 0, 15, 10, 0);
    public static final Item SWEET_SOUR_POFFIN = poffin(0, 0, 15, 0, 10);
    public static final Item BITTER_SPICY_POFFIN = poffin(10, 0, 0, 15, 0);
    public static final Item BITTER_DRY_POFFIN = poffin(0, 10, 0, 15, 0);
    public static final Item BITTER_SWEET_POFFIN = poffin(0, 0, 10, 15, 0);
    public static final Item BITTER_POFFIN = poffin(0, 0, 0, 10, 0);
    public static final Item BITTER_SOUR_POFFIN = poffin(0, 0, 0, 15, 10);
    public static final Item SOUR_SPICY_POFFIN = poffin(10, 0, 0, 0, 15);
    public static final Item SOUR_DRY_POFFIN = poffin(0, 10, 0, 0, 15);
    public static final Item SOUR_SWEET_POFFIN = poffin(0, 0, 10, 0, 15);
    public static final Item SOUR_BITTER_POFFIN = poffin(0, 0, 0, 10, 15);
    public static final Item SOUR_POFFIN = poffin(0, 0, 0, 0, 10);

    public static void register() {
        Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, Poffins.resourceLocation("flavors"), FLAVORS);
        register("spicy_poffin", SPICY_POFFIN);
        register("spicy_dry_poffin", SPICY_DRY_POFFIN);
        register("spicy_sweet_poffin", SPICY_SWEET_POFFIN);
        register("spicy_bitter_poffin", SPICY_BITTER_POFFIN);
        register("spicy_sour_poffin", SPICY_SOUR_POFFIN);
        register("dry_spicy_poffin", DRY_SPICY_POFFIN);
        register("dry_poffin", DRY_POFFIN);
        register("dry_sweet_poffin", DRY_SWEET_POFFIN);
        register("dry_bitter_poffin", DRY_BITTER_POFFIN);
        register("dry_sour_poffin", DRY_SOUR_POFFIN);
        register("sweet_spicy_poffin", SWEET_SPICY_POFFIN);
        register("sweet_dry_poffin", SWEET_DRY_POFFIN);
        register("sweet_poffin", SWEET_POFFIN);
        register("sweet_bitter_poffin", SWEET_BITTER_POFFIN);
        register("sweet_sour_poffin", SWEET_SOUR_POFFIN);
        register("bitter_spicy_poffin", BITTER_SPICY_POFFIN);
        register("bitter_dry_poffin", BITTER_DRY_POFFIN);
        register("bitter_sweet_poffin", BITTER_SWEET_POFFIN);
        register("bitter_poffin", BITTER_POFFIN);
        register("bitter_sour_poffin", BITTER_SOUR_POFFIN);
        register("sour_spicy_poffin", SOUR_SPICY_POFFIN);
        register("sour_dry_poffin", SOUR_DRY_POFFIN);
        register("sour_sweet_poffin", SOUR_SWEET_POFFIN);
        register("sour_bitter_poffin", SOUR_BITTER_POFFIN);
        register("sour_poffin", SOUR_POFFIN);
    }

    public static void register(String name, Item item) {
        Registry.register(BuiltInRegistries.ITEM, Poffins.resourceLocation(name), item);
    }

    public static Item poffin(int spicy, int dry, int sweet, int bitter, int sour) {
        return new PoffinItem(new Item.Properties().component(FLAVORS, new Flavors(new int[] {spicy, dry, sweet, bitter, sour})));
    }
}
