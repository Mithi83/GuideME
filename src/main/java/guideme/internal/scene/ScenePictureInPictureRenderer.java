package guideme.internal.scene;

import com.mojang.blaze3d.vertex.PoseStack;
import guideme.scene.LytGuidebookScene;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.gui.render.pip.PictureInPictureRenderer;
import net.minecraft.client.gui.render.state.pip.PictureInPictureRenderState;
import net.minecraft.client.renderer.MultiBufferSource;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix3x2f;

public class ScenePictureInPictureRenderer extends PictureInPictureRenderer<ScenePictureInPictureRenderer.State> {
    public ScenePictureInPictureRenderer(MultiBufferSource.BufferSource bufferSource) {
        super(bufferSource);
    }

    @Override
    public Class<State> getRenderStateClass() {
        return State.class;
    }

    @Override
    protected void renderToTexture(State state, PoseStack pose) {

    }

    @Override
    protected String getTextureLabel() {
        return "GuideME game scene";
    }

    public record State(
            Matrix3x2f pose,
            int x0, int y0,
            int x1, int y1,
            LytGuidebookScene scene,
            ScreenRectangle bounds,
            @Nullable ScreenRectangle scissorArea
    ) implements PictureInPictureRenderState {
        @Override
        public float scale() {
            return 1;
        }
    }
}
