package com.rexythedev.worldborder.Listeners;

import com.rexythedev.worldborder.Main;
import com.rexythedev.worldborder.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Setup implements Listener {
    public Main plugin;
    public Setup(Main plugin){
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        if (plugin.getConfig().get("World-Center.X") == null) {
            p.sendMessage(Utils.chat("&7(&c&l!&7) &ePlease set a world center by using &a&l/Center &eto begin!"));
            p.sendTitle(Utils.chat("&cTo Begin Use"), Utils.chat("&e/Center!"), 1, 100, 1);
        } else {
            return;
        }
    }


}
