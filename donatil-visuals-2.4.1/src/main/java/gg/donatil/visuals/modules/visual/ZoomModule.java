package gg.donatil.visuals.modules.visual;

import gg.donatil.visuals.modules.Module;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.FovModifierEvent;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

/** Зум на клавишу C: просто делим FOV — как у OptiFine. */
public class ZoomModule extends Module {

    private static KeyBinding zoomKey;

    public ZoomModule() {
        super("Smooth Zoom", "Приближение на клавишу C", true);

        zoomKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.donatil-visuals.zoom",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_C,
                "category.donatil-visuals"
        ));

        FovModifierEvent.EVENT.register(fov ->
                enabled() && zoomKey.isPressed() ? fov / 4f : fov);
    }
}
