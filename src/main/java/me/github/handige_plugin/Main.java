package me.github.handige_plugin;


import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginCommand("gmc").setExecutor(new gmc());
        getServer().getPluginCommand("gmsp").setExecutor(new gmsp());
        getServer().getPluginCommand("gms").setExecutor(new gms());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
