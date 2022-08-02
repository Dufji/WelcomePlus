package com.dufji.invadedwelcome.Commands;

import com.dufji.invadedwelcome.InvadedWelcome;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class resetCounterCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Plugin plugin = InvadedWelcome.getPlugin(InvadedWelcome.class);
        Player player = (Player) sender;

        if (player.hasPermission("invadedwelcome.reset")) {
            plugin.getConfig().set("amount-joined", 1);
            plugin.saveConfig();
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "The counter has been reset! Check the config file to see if it worked!");
        }else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
        }
        return true;
    }
}