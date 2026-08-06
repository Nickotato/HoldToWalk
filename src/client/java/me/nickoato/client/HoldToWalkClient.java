package me.nickoato.client;

import me.nickoato.client.config.ModConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HoldToWalkClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("HoldToWalk");
	private final ModConfig config = new ModConfig();
	private boolean originalToggleSprint = false;

	@Override
	public void onInitializeClient() {
		LOGGER.info("HoldToWalk Client Initialized");

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (client.world == null) {
				return;
			}

			originalToggleSprint = client.options.getSprintToggled().getValue();

			if (config.enabled) {
				client.options.getSprintToggled().setValue(true);
			} else {
				client.options.getSprintToggled().setValue(originalToggleSprint);
			}
		});
	}
}