package me.nickotato.holdtowalk.client.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import me.nickotato.holdtowalk.client.HoldToWalkClient;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @ModifyReturnValue(
            method = "canSprint",
            at = @At("RETURN")
    )
    private boolean preventSprintWhileWalking(boolean original) {
        if (HoldToWalkClient.isSprintKeyDown() && HoldToWalkClient.config.enabled) {
            return false;
        }

        return original;
    }
}
