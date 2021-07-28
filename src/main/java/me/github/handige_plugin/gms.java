package me.github.handige_plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gms implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(p.hasPermission("ap.gms") || p.isOp()) {
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(ChatColor.GREEN+ "you are in survival mode");
                return true;
            }else{
                p.sendMessage(ChatColor.DARK_RED + "you have not permissions to run this command");
                return true;
            }

        }else{
            Bukkit.getLogger().info("you are not player");

        }
        return true;
    }
}
