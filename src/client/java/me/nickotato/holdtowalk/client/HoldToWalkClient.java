package me.nickotato.holdtowalk.client;

import me.nickotato.holdtowalk.client.config.ModConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HoldToWalkClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("HoldToWalk");
	public static final ModConfig config = new ModConfig();

	@Override
	public void onInitializeClient() {
		LOGGER.info("HoldToWalk Client Initialized");



		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.world == null) {
				return;
			}

			if (!config.isEnabled()) {
				return;
			}

			client.options.getSprintToggled().setValue(false);

		});
	}

	public static KeyBinding getSprintKey() {
		return MinecraftClient.getInstance().options.sprintKey;
	}

	public static boolean isSprintKeyDown() {
		return getSprintKey().isPressed();
	}
}