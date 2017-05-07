package de.vtrx.maintenance.listener;

import de.vtrx.maintenance.Config;
import de.vtrx.maintenance.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/**
 * Created by thatv on 07.04.2017.
 */
public class PingListener implements Listener {
    private Config cfg = Main.instance.cfg;

    @EventHandler
    public void onPing(ProxyPingEvent e){
        ServerPing conn = e.getResponse();

        if(cfg.System_enabled) {
                conn.setVersion(new ServerPing.Protocol(cfg.System_PingMessage, 2));
                conn.setPlayers(new ServerPing.Players(0, 0, new ServerPing.PlayerInfo[0]));
                if(cfg.System_ChangeMOTD) {
                    conn.setDescription(ChatColor.translateAlternateColorCodes('&', cfg.System_MOTD) + "\n§c§lMAINTENANCEMODE ACTIVE");
                }
        } else {
            conn.setDescription(ChatColor.translateAlternateColorCodes('&', cfg.System_MOTD));
        }
    }





}
