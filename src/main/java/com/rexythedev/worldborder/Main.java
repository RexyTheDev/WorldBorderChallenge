package com.rexythedev.worldborder;

import com.rexythedev.worldborder.Commands.CenterCommand;
import com.rexythedev.worldborder.Commands.ResetCommand;
import com.rexythedev.worldborder.Commands.StartCommand;
import com.rexythedev.worldborder.Listeners.Setup;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin implements Listener {
    File configFile = new File(this.getDataFolder(), "config.yml");


    @Override
    public void onEnable() {
        new Setup(this);
        new CenterCommand(this);
        new StartCommand(this);
        new ResetCommand(this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public File getConfigFile() {
        return configFile;
    }
}
