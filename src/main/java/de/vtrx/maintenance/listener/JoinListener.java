package de.vtrx.maintenance.listener;

import de.vtrx.maintenance.Config;
import de.vtrx.maintenance.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/**
 * Created by thatv on 23.04.2017.
 */
public class JoinListener implements Listener{
    private Config cfg = Main.instance.cfg;







    @EventHandler
    public void onJoin(ServerConnectEvent e){
        ProxiedPlayer p = e.getPlayer();
        if(cfg.System_enabled){
            if(!p.hasPermission("system.maintenance.join")){
                e.setCancelled(true);
                p.disconnect(ChatColor.translateAlternateColorCodes('&', cfg.System_kickMSG));
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', cfg.System_notify));
            }

        }

    }


}
