package io.bytestorm.bridge.paper;

import io.bytestorm.api.CloudAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PaperBootstrap extends JavaPlugin {

    private PaperPlatformAdapter adapter;

    @Override
    public void onEnable() {
        this.adapter = new PaperPlatformAdapter();
         // Bootstrap API


    }

    @Override
    public void onDisable() {
        CloudAPI.shutdown();
    }
}

