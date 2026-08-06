package me.nickoato.client;

import me.nickoato.client.config.ModConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HoldToWalkClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("HoldToWalk");
	public static final ModConfig config = new ModConfig();
	private Boolean originalToggleSprint = null;

	@Override
	public void onInitializeClient() {
		LOGGER.info("HoldToWalk Client Initialized");



		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.world == null) {
				return;
			}

			if (originalToggleSprint == null) {
				originalToggleSprint = client.options.getSprintToggled().getValue();
			}

			if (client.options.backKey.isPressed()) {
				config.enabled = !config.enabled;
				LOGGER.info(String.valueOf(config.enabled));
				// This if statement is only for testing, remove later.
			}

			if (!config.enabled) {
//				if (originalToggleSprint != null ){
//					client.options.getSprintToggled().setValue(originalToggleSprint);
//				}

				return;
			}


			client.options.getSprintToggled().setValue(false);

//			if (client.options.sprintKey.isPressed()) {
//				client.options.getSprintToggled().setValue(false);
//				LOGGER.info("HOLDING SPRINT KEY");
//			} else {
//				client.options.getSprintToggled().setValue(true);
//			}


		});
	}

	public static KeyBinding getSprintKey() {
		return MinecraftClient.getInstance().options.sprintKey;
	}

	public static boolean isSprintKeyDown() {
		MinecraftClient client = MinecraftClient.getInstance();

		long window = client.getWindow().getHandle();

		int key = getSprintKey().getDefaultKey().getCode();

        return GLFW.glfwGetKey(window, key) == GLFW.GLFW_PRESS;
	}
}