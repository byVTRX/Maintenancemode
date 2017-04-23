package de.vtrx.maintenance.commands;

import de.vtrx.maintenance.Config;
import de.vtrx.maintenance.Main;
import net.craftminecraft.bungee.bungeeyaml.bukkitapi.InvalidConfigurationException;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created by thatv on 23.04.2017.
 */
public class MaintenanceCMD extends Command {
    public Config cfg = Main.instance.cfg;
    private String prefix = ChatColor.translateAlternateColorCodes('&', cfg.System_prefix);

    public MaintenanceCMD() {
        super(Main.instance.cfg.System_command);
    }


    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("system.maintenance.toggle")) {
            if (cfg.System_enabled) {
                cfg.System_enabled = false;
                saveConfig();
                sender.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', cfg.System_disable));
            } else {
                cfg.System_enabled = true;
                saveConfig();
                for (ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
                    if (!all.hasPermission("system.maintenance.join")) {
                        all.disconnect(ChatColor.translateAlternateColorCodes('&', cfg.System_kickMSG));
                    } else {
                        all.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', cfg.System_notify));
                    }
                }


            }


        } else {
            sender.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', cfg.System_noperms));
        }

    }


    public void saveConfig() {
        try {
            cfg.save();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }
}
