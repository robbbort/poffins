package robbbort.poffins.client;

import com.cobblemon.mod.common.api.cooking.Flavour;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.joml.Matrix4f;
import robbbort.poffins.Poffins;

public record FlavorsTooltip(int[] flavors) implements ClientTooltipComponent {
    public static final ResourceLocation TEXTURE = Poffins.resourceLocation("flavors_background");

    @Override
    public int getHeight() {
        return 32;
    }

    @Override
    public int getWidth(Font font) {
        return 32;
    }

    @Override
    public void renderImage(Font font, int i, int j, GuiGraphics guiGraphics) {
        guiGraphics.blitSprite(TEXTURE, i, j, 32, 32);

        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);

        RenderSystem.disableCull();
        var pose = guiGraphics.pose().last().pose();
        var builder = Tesselator.getInstance().begin(VertexFormat.Mode.TRIANGLES, DefaultVertexFormat.POSITION_COLOR);

        var spicy = Mth.lerp((float) flavors[0] / 50.0f, 12.0f, 6.0f);
        var dry = Mth.lerp((float) flavors[1] / 50.0f, 17.5f, 25.0f);

        var sweet = (float) flavors[2] / 50.0f;
        var sweetX = Mth.lerp(sweet, 17.0f, 25.0f);
        var sweetY = Mth.lerp(sweet, 17.5f, 22.0f);

        var bitter = (float) flavors[3] / 50.0f;
        var bitterX = Mth.lerp(bitter, 14.0f, 9.0f);
        var bitterY = Mth.lerp(bitter, 17.5f, 25.0f);

        var sour = Mth.lerp((float) flavors[4] / 50.0f, 13.5f, 6.0f);

        vertex(builder, pose, sour, 14.0f, 0.0f, i, j, Flavour.SOUR);
        vertex(builder, pose, dry, 14.0f, 0.0f, i, j, Flavour.DRY);
        vertex(builder, pose, sweetX, sweetY, 0.0f, i, j, Flavour.SWEET);

        vertex(builder, pose, bitterX, bitterY, 0.0f, i, j, Flavour.BITTER);
        vertex(builder, pose, sweetX, sweetY, 0.0f, i, j, Flavour.SWEET);
        vertex(builder, pose, sour, 14.0f, 0.0f, i, j, Flavour.SOUR);

        vertex(builder, pose, sour, 14.0f, 0.0f, i, j, Flavour.SOUR);
        vertex(builder, pose, dry, 14.0f, 0.0f, i, j, Flavour.DRY);
        vertex(builder, pose, 15.5f, spicy, 0.0f, i, j, Flavour.SPICY);

        BufferUploader.drawWithShader(builder.buildOrThrow());
        RenderSystem.enableCull();
    }

    public void vertex(BufferBuilder builder, Matrix4f pose, float x, float y, float z, float i, float j, Flavour flavour) {
        builder.addVertex(pose, x + i, y + j, z).setColor(flavour.getColour() | 255 << 24);
    }
}
