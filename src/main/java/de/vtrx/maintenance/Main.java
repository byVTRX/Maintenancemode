package de.vtrx.maintenance;

import de.vtrx.maintenance.commands.MaintenanceCMD;
import de.vtrx.maintenance.listener.JoinListener;
import net.craftminecraft.bungee.bungeeyaml.bukkitapi.InvalidConfigurationException;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * Created by thatv on 23.04.2017.
 */
public class Main extends Plugin {
    public static Main instance;
    public Config cfg;

    @Override
    public void onEnable() {
        instance = this;
        cfg = new Config(this);

        try {
            cfg.init();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

        getProxy().getPluginManager().registerCommand(this, new MaintenanceCMD());
        getProxy().getPluginManager().registerListener(this, new JoinListener());

        System.out.println("[Maintenance] enabled");
    }

    @Override
    public void onDisable() {
        try {
            cfg.save();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

        System.out.println("[Maintenance] disabled");


    }
}
