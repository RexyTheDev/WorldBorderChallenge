package com.rexythedev.worldborder.Commands;

import com.rexythedev.worldborder.Main;
import com.rexythedev.worldborder.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CenterCommand implements CommandExecutor {
    public Main plugin;
    public CenterCommand(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("Center").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        p.sendMessage(Utils.chat("&7(&a&l!&7) &eWorld center set!"));
        p.sendTitle(Utils.chat("&aWorld center set!"), Utils.chat("&eShrinking Border"), 1, 100, 1);
        plugin.getConfig().set("World-Center.X", p.getLocation().getBlockX());
        plugin.getConfig().set("World-Center.Y", p.getLocation().getBlockY());
        plugin.getConfig().set("World-Center.Z", p.getLocation().getBlockZ());
        plugin.saveConfig();
        return false;
    }
}
