package com.koirdsuzu.chatfilter;

import com.koirdsuzu.chatfilter.Main;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class ChatListener implements Listener {
    private final Main plugin;

    public ChatListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage().toLowerCase();
        FileConfiguration config = plugin.getConfig();

        List<String> bannedWords = config.getStringList("banned-words");
        int maxInfractions = config.getInt("max-infractions", 5);

        for (String word : bannedWords) {
            if (message.contains(word.toLowerCase())) {
                event.setCancelled(true);

                // Increment infractions
                int infractions = plugin.getHistoryManager().addInfraction(player);

                // Notify player and OPs
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        config.getString("messages.warning")
                                .replace("{remaining}", String.valueOf(maxInfractions - infractions))));
                Bukkit.getOnlinePlayers().stream()
                        .filter(p -> p.isOp())
                        .forEach(op -> op.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                config.getString("messages.admin-notify")
                                        .replace("{player}", player.getName())
                                        .replace("{infractions}", String.valueOf(infractions)))));

                // Ban player if infractions exceed max
                if (infractions >= maxInfractions) {
                    Bukkit.getScheduler().runTask(plugin, () -> {
                        Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), config.getString("messages.ban-reason"), null, null);
                        player.kickPlayer(ChatColor.translateAlternateColorCodes('&', config.getString("messages.ban-reason")));
                    });
                }
                return;
            }
        }
    }
}
