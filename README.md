# Hold To Walk

A simple client-side Fabric mod that reverses Minecraft's sprint behavior.

Normally, Minecraft requires you to hold the sprint key to sprint (or use Toggle Sprint). Hold To Walk changes this by making sprinting the default state and allowing you to temporarily walk by holding your sprint key.

![License](https://img.shields.io/badge/license-Mozzila%20Public%202.0-green)

## Features

- Automatically enables Toggle Sprint while the mod is active.
- Sprint normally without holding a key.
- Hold your sprint key to temporarily walk.
- Uses Minecraft's built-in movement logic instead of modifying player speed.
- Keeps vanilla sprint behavior, including:
  - Hunger requirements
  - Collision checks
  - Swimming sprint
  - Sprint particles
  - FOV changes
  - Server sprint handling

## How It Works

When enabled:
Normal gameplay:
Hold W → Sprint

Hold Sprint Key:
Hold W + Sprint Key → Walk

Release Sprint Key:
Hold W → Sprint again

## Configuration

The mod includes an optional configuration screen through Mod Menu.

Settings:
- Enable/Disable Hold to Walk

Mod Menu is optional. The mod will function without it.

## Requirements

- Minecraft Fabric
- Fabric Loader
- Fabric API

Optional:
- Mod Menu (for configuration)

## Compatibility

Hold To Walk is a client-side mod and does not need to be installed on servers.

It should work with most mods that do not heavily modify Minecraft's movement input system.

## Contributing
* Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
* For bug reporting, please report it in my discord: `https://discord.gg/aEGxqg8VbZ`

By submitting a contribution (pull request, patch, or otherwise), you agree that your code will be licensed under the Mozilla Public License 2.0 (MPL 2.0) and that you have the right to submit it (i.e., it is your original work or from compatible sources).
