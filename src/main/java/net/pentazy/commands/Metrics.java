package net.pentazy.commands;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.pentazy.utils.CommandHelper;
import net.pentazy.utils.PlayerDeathEventUtils;

public class Metrics extends CommandHelper implements CommandExecutor {

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!isCommand(label)) {
      return false;
    }

    if (getCommandName(label).equalsIgnoreCase("metrics") && args.length == 0) {
      if (!(sender instanceof Player)) {
        sender.sendMessage("§cThis command can only be executed by players.");
        return true;
      }

      Player player = (Player) sender;
      PlayerDeathEventUtils playerDeathEventUtils = new PlayerDeathEventUtils();
      playerDeathEventUtils.player = player;

      int deaths = playerDeathEventUtils.getDeaths();

      Inventory gui = Bukkit.createInventory(null, 9, "§cMetrics");

//      ItemStack item = new ItemStack(Material.BEDROCK);
//      ItemMeta meta = item.getItemMeta();
//
//      meta.setDisplayName("§cPlayer Deaths");
//      meta.setLore(Arrays.asList("§7The amount of times you have died.", "§7You have died §c" + deaths + " §7times."));
//
//      item.setItemMeta(meta);
//      gui.setItem(0, item);

      player.openInventory(gui);
      return true;
    }

    if (getCommandName(label).equalsIgnoreCase("craftmetrics")) {
      sender.sendMessage("§cThis command is not yet implemented.");
      return true;
    }

    return false;
  }

}
