package com.koirdsuzu.chatfilter;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class HistoryManager {
    private final Main plugin;
    private final File historyFile;
    private final YamlConfiguration historyConfig;

    public HistoryManager(Main plugin) {
        this.plugin = plugin;
        this.historyFile = new File(plugin.getDataFolder(), "history.yml");
        this.historyConfig = YamlConfiguration.loadConfiguration(historyFile);
    }

    // プレイヤーの警告回数を1増やす
    public int addInfraction(Player uuid) {
        String key = uuid.toString();
        int infractions = historyConfig.getInt(key, 0);
        infractions++;
        historyConfig.set(key, infractions);
        saveHistory();
        return infractions;
    }

    // 警告回数を取得
    public int getWarnings(UUID uuid) {
        return historyConfig.getInt(uuid.toString(), 0);
    }

    // 警告回数をリセット
    public void clearWarnings(UUID uuid) {
        historyConfig.set(uuid.toString(), 0);
        saveHistory();
    }

    // 履歴データをファイルに保存
    void saveHistory() {
        try {
            historyConfig.save(historyFile);
        } catch (IOException e) {
            plugin.getLogger().severe("Could not save history file!");
            e.printStackTrace();
        }
    }

    public int getInfractions(String uuid) {
        return 0;
    }
}
