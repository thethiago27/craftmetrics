package net.pentazy.craftmetrics;

import net.pentazy.commands.Metrics;
import net.pentazy.events.PlayerDeath;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

  private static Main instance;

  @Override
  public void onEnable() {
    instance = this;
    saveDefaultConfig();
    registerCommands();
    registerEvents();
    getLogger().info("Plugin has been enabled!");
  }

  @Override
  public void onDisable() {
    getLogger().info("Plugin has been disabled!");
  }

  public static Main getInstance() {
    return instance;
  }

  private void registerEvents() {
    Bukkit.getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
  }

  private void registerCommands() {
    getCommand("metrics").setExecutor(new Metrics());
  }

}