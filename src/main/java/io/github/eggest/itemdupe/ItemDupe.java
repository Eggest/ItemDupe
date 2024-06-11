package io.github.eggest.itemdupe;

import io.github.eggest.itemdupe.Command.DupeCommand;
import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class ItemDupe extends JavaPlugin {
    public static Configuration config;
    public static Logger logger;
    public static JavaPlugin ins;


    @Override
    public void onEnable() {
        // Plugin startup logic
        config = getConfig();
        logger = getLogger();
        ins = this;
        Bukkit.getPluginCommand("dupe").setExecutor(new DupeCommand());
        Bukkit.getPluginManager().registerEvents(new Listener(),this);
    }

    @Override
    public void onLoad(){
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
