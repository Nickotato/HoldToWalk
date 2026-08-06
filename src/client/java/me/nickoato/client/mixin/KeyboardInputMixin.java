package me.nickoato.client.mixin;

import me.nickoato.client.HoldToWalkClient;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(KeyboardInput.class)
public class KeyboardInputMixin {
    @Redirect(method = "tick", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/option/KeyBinding;isPressed()Z")
    )
    private boolean changeSprint(KeyBinding key) {

        if (key == HoldToWalkClient.getSprintKey() && HoldToWalkClient.config.enabled) {
            return !HoldToWalkClient.isSprintKeyDown();
        }

        return key.isPressed();
    }
}
