package de.vtrx.maintenance;

import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;

/**
 * Created by thatv on 23.04.2017.
 */
public class Config extends net.craftminecraft.bungee.bungeeyaml.supereasyconfig.Config {
    public Config (Plugin plugin){
        CONFIG_FILE = new File("plugins//" + "Maintenance", "config.yml");
    }


    public String System_prefix = "&6&lSYSTEM &7| ";
    public boolean System_enabled = false;
    public String System_kickMSG = "&7| &6This server is in maintenance mode. \nPlease try again later.";
    public String System_command = "maintenance";
    public String System_noperms = "&cYou don't have permission for that Command";
    public String System_notify = "&6The Server is in maintenance-mode!\n&6Only people with the permission: system.maintenance.join can join the Server now";
    public String System_disable = "§aMaintenance-mode is disabled!";
    public String System_PingMessage = "&c&lMAINTENANCE";
    public String System_MOTD = "Edit This in your maintenancemode config";
    public boolean System_ChangeMOTD = true;

}
