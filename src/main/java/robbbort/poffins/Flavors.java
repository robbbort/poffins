package robbbort.poffins;

import com.mojang.serialization.Codec;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.inventory.tooltip.TooltipComponent;

import java.util.Arrays;

public record Flavors(int[] flavors) implements TooltipComponent {
    public static final Codec<Flavors> CODEC = Codec.INT_STREAM.xmap(ints -> new Flavors(ints.toArray()), flavors -> Arrays.stream(flavors.flavors));

    public static final StreamCodec<FriendlyByteBuf, Flavors> STREAM_CODEC = new StreamCodec<>() {
        @Override
        public Flavors decode(FriendlyByteBuf object) {
            return new Flavors(object.readVarIntArray());
        }

        @Override
        public void encode(FriendlyByteBuf object, Flavors object2) {
            object.writeVarIntArray(object2.flavors);
        }
    };

}
