package com.rexythedev.worldborder.Commands;

import com.rexythedev.worldborder.Main;
import com.rexythedev.worldborder.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {
    public Main plugin;
    public StartCommand(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("Start").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (plugin.getConfig().get("World-Center.X") == null && args.length == 1 && isInt(args[0])) {
            p.sendMessage(Utils.chat("&7(&c&l!&7) &ePlease enter a border size, example &a/Start 100&e!"));
            plugin.getConfig().set("World-Center.X", p.getLocation().getBlockX());
            plugin.getConfig().set("World-Center.Y", p.getLocation().getBlockY());
            plugin.getConfig().set("World-Center.Z", p.getLocation().getBlockZ());
            plugin.saveConfig();
            p.sendMessage(Utils.chat("&7(&a&l!&7) &eWorld center set, setting border!"));
            p.sendTitle(Utils.chat("&aWorld center set!"), Utils.chat("&eShrinking Border"), 1, 100, 1);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "worldborder center " + plugin.getConfig().get("World-Center.X") + " " + plugin.getConfig().get("World-Center.Z"));
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "worldborder set " + args[0]);
        }else{
                p.sendMessage(Utils.chat("&7(&c&l!&7) &ePlease enter a border size, example &a/Start 100&e!"));
        }
        return false;
    }

    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
