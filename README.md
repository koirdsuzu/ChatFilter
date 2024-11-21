# ChatFilter Plugin

A Minecraft plugin that filters prohibited words from the chat. Players who use prohibited words will receive warnings, and if they exceed a certain number of infractions, they will be automatically banned. The plugin also allows server administrators to manage player infraction histories.

## Features
- Prohibited words are removed from chat messages.
- Players are warned upon using prohibited words.
- Infractions are tracked, and players are banned after exceeding the maximum infractions.
- Infraction count and messages are fully configurable.
- Admins can clear a player's infraction history using a command.
- Works with Minecraft versions 1.16 and above.

## Commands
### `/clearhistory <player>`
- **Description:** Clears the infraction history of a specified player.
- **Permission:** `chatfilter.clearhistory`
- **Usage Example:** `/clearhistory Steve`

### `/history <player>`
- **Description:** View the infraction history of a specified player.
- **Permission:** `chatfilter.history`
- **Usage Example:** `/history Steve`

## Configuration
The plugin uses a `config.yml` file for settings. Here are the key options:

```yaml
banned-words:
  - badword1
  - badword2
max-infractions: 5
messages:
  warning: "&cYou used a prohibited word! {remaining} warnings left before a ban."
  admin-notify: "&ePlayer {player} used a prohibited word! Total infractions: {infractions}."
  ban-reason: "You have been banned for excessive prohibited word usage."
```

 - ``banned-words``: List of prohibited words.
 - ``max-infractions``: Number of infractions before a player is banned.
 - ``messages``: Customize messages for warnings, notifications, and ban reasons.

# Installation
 - 1.Download the plugin jar file.
 - 2.Place the jar file in your server's plugins folder.
 - 3.Restart your server to generate the configuration file.
 - 4.Edit config.yml to customize settings if needed.
 - 5.Use /reload or restart the server to apply changes.

# Permissions
 - chatfilter.clearhistory: Allows clearing a player's infraction history.
 - chatfilter.history: Allows viewing a player's infraction history.
 - chatfilter.bypass: Prevents the player from being affected by chat filtering.
# Compatibility
 - Minecraft Versions: 1.16 and above.
 - Server Software: Bukkit, Spigot, Paper.
