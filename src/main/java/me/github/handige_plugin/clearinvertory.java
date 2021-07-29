package me.github.handige_plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.io.BukkitObjectInputStream;

public class clearinvertory implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            if(sender instanceof Player) {
                Player p = (Player) sender;

                if(p.hasPermission("ap.invclear") || p.isOp()) {
                    p.getInventory().clear();
                    p.sendMessage(ChatColor.GREEN + "you invertory is cleared");

                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cyou have not permissions to run this command"));
                }

            } else {
                Bukkit.getLogger().info("you have to be a player to do that");
            }

        } else {
            if(Bukkit.getPlayerExact(args[0]) != null) {
                Player player = (Player) Bukkit.getPlayerExact(args[0]);
                player.getInventory().clear();
                player.sendMessage(ChatColor.GREEN + "you invertory is cleared by operator");
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    p.sendMessage(ChatColor.GREEN  + "invertory from te Player \"" + args[0] + "\" is cleared");
                } else {
                    Bukkit.getLogger().info("invertory from te Player \"" + args[0] + "\" is cleared");
                }
            } else {
                if(sender instanceof Player) {
                    Player p = (Player) sender;
                    p.sendMessage("Player \"" + args[0] + "\" was not found");
                } else {
                    Bukkit.getLogger().info("Player \"" + args[0] + "\" was not found");
                }
            }
        }
        return true;
    }
}
