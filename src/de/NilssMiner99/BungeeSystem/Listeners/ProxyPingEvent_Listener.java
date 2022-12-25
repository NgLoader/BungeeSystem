package de.NilssMiner99.BungeeSystem.Listeners;

import de.NilssMiner99.BungeeSystem.Manager.MotdManager;
import de.NilssMiner99.BungeeSystem.Manager.UUIDFeature;
import de.NilssMiner99.BungeeSystem.Manager.WartungManager;
import de.NilssMiner99.mongodb_Bungee.MongoDB.Global_Players;
import de.NilssMiner99.mongodb_Bungee.main.main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ProxyPingEvent_Listener implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPing(ProxyPingEvent e) {
		String uuid = UUIDFeature.getUUIDByAdress(e.getConnection().getAddress().getAddress().getHostAddress());
		if(uuid != null) {
			Global_Players gplayer = Global_Players.getPlayer(main.plugin, uuid);
			if(gplayer.getLanguage().equalsIgnoreCase("DE")) {
				if(WartungManager.wartung == true) {
					ServerPing ping = e.getResponse();
					ServerPing.Players players = ping.getPlayers();
					ServerPing.Protocol version = ping.getVersion();
					version.setName(MotdManager.wartung_name_DE);
					version.setProtocol(version.getProtocol());
					players.setOnline(ProxyServer.getInstance().getOnlineCount());
					players.setMax(ProxyServer.getInstance().getConfig().getPlayerLimit());
					players.setSample(MotdManager.wartung_sampel_DE);
					ping.setPlayers(players);
					ping.setVersion(version);
					String motd = ChatColor.translateAlternateColorCodes('&', MotdManager.wartung_description_DE);
					motd = motd.replace("{newline}", "\n");
					ping.setDescription(motd);
				} else {
					ServerPing ping = e.getResponse();
					ServerPing.Players players = ping.getPlayers();
					ServerPing.Protocol version = ping.getVersion();
					version.setName(MotdManager.name_DE);
					version.setProtocol(version.getProtocol());
					players.setOnline(ProxyServer.getInstance().getOnlineCount());
					players.setMax(ProxyServer.getInstance().getConfig().getPlayerLimit());
					players.setSample(MotdManager.sampel_DE);
					ping.setPlayers(players);
					ping.setVersion(version);
					String motd = ChatColor.translateAlternateColorCodes('&', MotdManager.description_DE);
					motd = motd.replace("{newline}", "\n");
					ping.setDescription(motd);
				}
			} else {
				if(WartungManager.wartung == true) {
					ServerPing ping = e.getResponse();
					ServerPing.Players players = ping.getPlayers();
					ServerPing.Protocol version = ping.getVersion();
					version.setName(MotdManager.wartung_name_EN);
					version.setProtocol(version.getProtocol());
					players.setOnline(ProxyServer.getInstance().getOnlineCount());
					players.setMax(ProxyServer.getInstance().getConfig().getPlayerLimit());
					players.setSample(MotdManager.wartung_sampel_EN);
					ping.setPlayers(players);
					ping.setVersion(version);
					String motd = ChatColor.translateAlternateColorCodes('&', MotdManager.wartung_description_EN);
					motd = motd.replace("{newline}", "\n");
					ping.setDescription(motd);
				} else {
					ServerPing ping = e.getResponse();
					ServerPing.Players players = ping.getPlayers();
					ServerPing.Protocol version = ping.getVersion();
					version.setName(MotdManager.name_EN);
					version.setProtocol(version.getProtocol());
					players.setOnline(ProxyServer.getInstance().getOnlineCount());
					players.setMax(ProxyServer.getInstance().getConfig().getPlayerLimit());
					players.setSample(MotdManager.sampel_EN);
					ping.setPlayers(players);
					ping.setVersion(version);
					String motd = ChatColor.translateAlternateColorCodes('&', MotdManager.description_EN);
					motd = motd.replace("{newline}", "\n");
					ping.setDescription(motd);
				}
			}
		} else {
			if (WartungManager.wartung == true) {
				ServerPing ping = e.getResponse();
				ServerPing.Players players = ping.getPlayers();
				ServerPing.Protocol version = ping.getVersion();
				version.setName(MotdManager.wartung_name_DE);
				version.setProtocol(version.getProtocol());
				players.setOnline(ProxyServer.getInstance().getOnlineCount());
				players.setMax(ProxyServer.getInstance().getConfig().getPlayerLimit());
				players.setSample(MotdManager.wartung_sampel_DE);
				ping.setPlayers(players);
				ping.setVersion(version);
				String motd = ChatColor.translateAlternateColorCodes('&', MotdManager.wartung_description_DE);
				motd = motd.replace("{newline}", "\n");
				ping.setDescription(motd);
			} else {
				ServerPing ping = e.getResponse();
				ServerPing.Players players = ping.getPlayers();
				ServerPing.Protocol version = ping.getVersion();
				version.setName(MotdManager.name_DE);
				version.setProtocol(version.getProtocol());
				players.setOnline(ProxyServer.getInstance().getOnlineCount());
				players.setMax(ProxyServer.getInstance().getConfig().getPlayerLimit());
				players.setSample(MotdManager.sampel_DE);
				ping.setPlayers(players);
				ping.setVersion(version);
				String motd = ChatColor.translateAlternateColorCodes('&', MotdManager.description_DE);
				motd = motd.replace("{newline}", "\n");
				ping.setDescription(motd);
			}
		}
	}
}