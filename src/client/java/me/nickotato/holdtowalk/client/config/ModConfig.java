package me.nickotato.holdtowalk.client.config;

import me.nickotato.holdtowalk.client.enums.WalkMode;

public class ModConfig {
    public WalkMode mode = WalkMode.VANILLA;

    public boolean isEnabled() {
        return mode != WalkMode.OFF;
    }
}
