package com.nametagedit.plugin.storage.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class PlayerData {

    private String name;
    private UUID uuid;
    private String prefix;
    private String suffix;

    public PlayerData() {

    }

    public static PlayerData fromFile(String key, YamlConfiguration file) {
        if (!file.contains("Players." + key)) return null;
        PlayerData data = new PlayerData();
        data.setUuid(UUID.fromString(key));
        data.setName(file.getString("Players." + key + ".Name"));
        data.setPrefix(file.getString("Players." + key + ".Prefix", ""));
        data.setSuffix(file.getString("Players." + key + ".Suffix", ""));
        return data;
    }

}