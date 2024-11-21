package com.koirdsuzu.chatfilter;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;
    private com.koirdsuzu.chatfilter.HistoryManager historyManager;

    @Override
    public void onEnable() {
        getLogger().info("ChatFilter plugin is enabling...");

        instance = this;

        // Load configuration
        saveDefaultConfig();

        // Initialize history manager
        historyManager = new com.koirdsuzu.chatfilter.HistoryManager(this);

        // Register events and commands
        getServer().getPluginManager().registerEvents(new com.koirdsuzu.chatfilter.ChatListener(this), this);
        getCommand("history").setExecutor(new com.koirdsuzu.chatfilter.HistoryCommand(this));
        getCommand("history").setTabCompleter(new com.koirdsuzu.chatfilter.HistoryCommand(this));

        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
        getCommand("clearhistory").setExecutor(new ClearHistoryCommand(this));

        getLogger().info("ChatFilter plugin has been enabled successfully!");
    }

    @Override
    public void onDisable() {
        historyManager.saveHistory();
        getLogger().info("ChatFilter plugin has been disabled.");
    }

    public static Main getInstance() {
        return instance;
    }

    public HistoryManager getHistoryManager() {
        return historyManager;
    }
}