package de.NilssMiner99.BungeeSystem.Listeners;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerKickEvent_Listener implements Listener {
	
	@EventHandler
	public void onDisconnect(ServerDisconnectEvent e) {
		ServerInfo minserver = null;
		int minplayerserver = 0;
		for(ServerInfo si : ProxyServer.getInstance().getServers().values()) {
			if(si != null) {
				if(si.getName().contains("lobby") && si.getName() != e.getPlayer().getServer().getInfo().getName()) {
					if(minserver == null && minplayerserver == 0) {
						minserver = si;
						minplayerserver = si.getPlayers().size();
					} else {
						if(minplayerserver >= si.getPlayers().size()) {
							minserver = si;
							minplayerserver = si.getPlayers().size();
						}
					}
				}
			}
		}
		if(minserver != null) {
			e.getPlayer().connect(minserver);
		}
	}
}