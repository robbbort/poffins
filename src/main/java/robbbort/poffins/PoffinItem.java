package robbbort.poffins;

import com.cobblemon.mod.common.api.interaction.PokemonEntityInteraction;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class PoffinItem extends Item implements PokemonEntityInteraction {

    public PoffinItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull Set<Ownership> getAccepted() {
        return Set.of(Ownership.OWNER);
    }

    @Override
    public boolean processInteraction(@NotNull ServerPlayer serverPlayer, @NotNull PokemonEntity pokemonEntity, @NotNull ItemStack itemStack) {
        itemStack.shrink(1);
        return true;
    }
}
