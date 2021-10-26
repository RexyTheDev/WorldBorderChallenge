package com.rexythedev.worldborder.Commands;

import com.rexythedev.worldborder.Main;
import com.rexythedev.worldborder.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetCommand implements CommandExecutor {
    public Main plugin;
    public ResetCommand(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("Reset").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        p.sendMessage(Utils.chat("&7(&a&l!&7) &eReseting border size!"));
        p.sendTitle(Utils.chat("&eReseting border size!"), Utils.chat("&eExpanding border."), 1, 100, 1);
        plugin.getConfigFile().delete();
        plugin.reloadConfig();
        plugin.saveDefaultConfig();
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "worldborder set 2999998");
        return false;
    }
}
