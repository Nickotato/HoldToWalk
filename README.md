# Hold To Walk

A simple client-side Fabric mod that changes Minecraft's sprint behavior.

Normally, Minecraft requires you to hold the sprint key to sprint (or use Toggle Sprint). Hold To Walk changes this by making sprinting the default state and allowing you to temporarily walk by holding your sprint key.

![License](https://img.shields.io/badge/license-Mozzila%20Public%202.0-green)

## Features

- Automatically enables Toggle Sprint while the mod is active.
- Sprint normally without holding a key.
- Hold your sprint key to temporarily walk.
- Uses Minecraft's built-in movement logic instead of modifying player speed.
- Keeps vanilla sprint behavior logic, including:
  - Hunger requirements
  - Collision checks
  - Swimming sprint
  - Sprint particles
  - FOV changes
  - Server sprint handling

## Modes

Hold To Walk has three operating modes:

### Vanilla-Compatible

The default mode. This keeps Minecraft's normal sprint logic while reversing the sprint key behavior.

Normal gameplay:

Hold W → Sprint


Hold Sprint Key:

Hold W + Sprint Key → Walk


Release Sprint Key:

Hold W → Sprint again


This mode preserves vanilla sprint behavior and is recommended for multiplayer servers.

### Disabled

Disables Hold To Walk behavior and restores normal Minecraft sprint controls.


### Responsive

A more immediate version of Hold To Walk.

When the sprint key is held, sprinting is prevented immediately, causing the player to start walking without waiting for Minecraft's normal sprint state checks.


Hold W → Sprint
Press Sprint Key → Immediately Walk
Release Sprint Key → Sprint again


Responsive mode differs from vanilla sprint behavior. Some competitive servers may not allow it because it changes how sprint input is handled.

## Configuration

The mod includes an optional configuration screen through Mod Menu.

Settings:
- Mode:
  - Vanilla-Compatible
  - Disabled
  - Responsive

Mod Menu is optional. The mod will function without it.

## How It Works

Hold To Walk changes the way sprint input is interpreted instead of changing player movement speed.

In Vanilla-Compatible mode, the mod uses Minecraft's existing sprint system and only changes the default sprint state.

In Responsive mode, the mod additionally overrides sprint prevention behavior while the sprint key is held, allowing walking to begin instantly.

## Requirements

- Minecraft Fabric
- Fabric Loader
- Fabric API

Optional:
- Mod Menu (for configuration)

## Compatibility

Hold To Walk is a client-side mod and does not need to be installed on servers.

It should work with most mods that do not heavily modify Minecraft's movement input system.

Vanilla-Compatible mode is designed to maintain compatibility with multiplayer servers. Responsive mode may not be accepted on some competitive servers due to its different sprint input behavior.

## Contributing

* Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
* For bug reporting, please report it in my discord: `https://discord.gg/aEGxqg8VbZ`

By submitting a contribution (pull request, patch, or otherwise), you agree that your code will be licensed under the Mozilla Public License 2.0 (MPL 2.0) and that you have the right to submit it (i.e., it is your original work or from compatible sources).
