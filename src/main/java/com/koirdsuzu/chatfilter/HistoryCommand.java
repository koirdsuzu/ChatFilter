package com.koirdsuzu.chatfilter;

import com.koirdsuzu.chatfilter.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HistoryCommand implements CommandExecutor, TabCompleter {
    private final Main plugin;

    public HistoryCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage(ChatColor.RED + "Usage: /history <player>");
            return true;
        }

        String uuid = args[0];
        int infractions = plugin.getHistoryManager().getInfractions(uuid);

        sender.sendMessage(ChatColor.YELLOW + "Player " + uuid + " has " + infractions + " infractions.");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> suggestions = new ArrayList<>();
            for (Player player : plugin.getServer().getOnlinePlayers()) {
                suggestions.add(player.getUniqueId().toString());
            }
            return suggestions;
        }
        return null;
    }
}