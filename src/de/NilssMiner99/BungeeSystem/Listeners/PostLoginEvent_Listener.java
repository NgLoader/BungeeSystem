package de.NilssMiner99.BungeeSystem.Listeners;

import java.io.File;
import java.io.FileWriter;

import de.NilssMiner99.BungeeSystem.Manager.BanSystem;
import de.NilssMiner99.BungeeSystem.Manager.GruppenManager;
import de.NilssMiner99.BungeeSystem.Manager.RangTemplates;
import de.NilssMiner99.BungeeSystem.Manager.StatsManager;
import de.NilssMiner99.BungeeSystem.Manager.UUIDFeature;
import de.NilssMiner99.BungeeSystem.Manager.WartungManager;
import de.NilssMiner99.BungeeSystem.main.main;
import de.NilssMiner99.mongodb_Bungee.MongoDB.Global_Players;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PostLoginEvent_Listener implements Listener {
	
	@EventHandler
	public void Isbanned(ServerConnectEvent e) {
		ProxiedPlayer p = e.getPlayer();
		Global_Players gplayer = Global_Players.getPlayer(de.NilssMiner99.mongodb_Bungee.main.main.plugin, p.getUniqueId().toString());
		gplayer.create(p.getName());
		try {
			UUIDFeature.updateAdresse(p.getUniqueId().toString(), p.getAddress().getAddress().getHostAddress());
		} catch(Exception ex) {
		}
		try {
			File f = new File("plugins/BungeeSystem/PlayerData_UUID/"+p.getUniqueId()+".yml");
			if(!f.exists()) {
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			fw.write(p.getName());
			fw.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		try {
			File f = new File("plugins/BungeeSystem/PlayerData_Name/"+p.getName().toLowerCase()+".yml");
			if(!f.exists()) {
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			fw.write(p.getUniqueId().toString());
			fw.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		try {
			File f = new File("plugins/BungeeSystem/Stats_CreateDate/"+p.getUniqueId().toString()+".yml");
			if(!f.exists()) {
				StatsManager.setCreateDate(p.getUniqueId().toString());
			}
		} catch(Exception ex) {
		}
		try {
			StatsManager.addOldNames(p.getUniqueId().toString(), p.getName());
		} catch(Exception ex) {
		}
		if(RangTemplates.templates.containsKey(gplayer.getGroup().getDatabaseName())) {
			for(String perm : RangTemplates.templates.get(gplayer.getGroup().getDatabaseName()).split("//")) {
				if(perm != null && perm != "") {
					p.setPermission(perm, true);
				}
			}
		}
		for(String perm : GruppenManager.getPermissons(p.getUniqueId().toString())) {
			if(perm != null && perm != "") {
				p.setPermission(perm, true);
			}
		}
		if(WartungManager.wartung == true) {
			if(!(p.hasPermission("liveplays.team"))) {
				if(!(WartungManager.whitelist.contains(p.getUniqueId().toString()))) {
					if(gplayer.getLanguage().equalsIgnoreCase("DE")) {
						e.getPlayer().disconnect(new TextComponent(WartungManager.KickMessage_DE));
					} else {
						e.getPlayer().disconnect(new TextComponent(WartungManager.KickMessage_EN));
					}
					e.setCancelled(true);
					return;
				}
			}
		}
		if(BanSystem.isBanned(p.getUniqueId().toString()) == true) {
			e.getPlayer().disconnect(new TextComponent(BanSystem.getBanMessage(p.getUniqueId().toString())));
			e.setCancelled(true);
			return;
		}
		StatsManager.setLastLogin(p.getUniqueId().toString());
		ServerInfo minserver = null;
		int minplayerserver = 0;
		for(ServerInfo si : ProxyServer.getInstance().getServers().values()) {
			if(si != null) {
				if(si.getName().startsWith("Lobby")) {
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
		if(minserver != null && e.getTarget().getName() != minserver.getName() && (!(e.getTarget().getName().startsWith("Lobby")))) {
			e.getPlayer().connect(minserver);
		}
		if(main.afk.contains(p.getUniqueId().toString())) {
			main.afk.remove(p.getUniqueId().toString());
			p.sendMessage(new TextComponent(main.prefix+"§3Du §3bist §3nun §3nicht §3mehr §3AFK§8."));
		}
	}
}