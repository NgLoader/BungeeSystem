package de.NilssMiner99.BungeeSystem.Listeners;

import de.NilssMiner99.BungeeSystem.Manager.PartyManager;
import de.NilssMiner99.BungeeSystem.Manager.PlayerParty;
import de.NilssMiner99.BungeeSystem.main.main;
import de.NilssMiner99.mongodb_Bungee.MongoDB.Global_Players;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerSwitchEvent_Listener implements Listener {
	
	@EventHandler
	public void onServerSwitch(ServerSwitchEvent e) {
		ProxiedPlayer p = e.getPlayer();
		Global_Players gplayer = Global_Players.getPlayer(de.NilssMiner99.mongodb_Bungee.main.main.plugin, p.getUniqueId().toString());
		if(gplayer.getLanguage().equalsIgnoreCase("DE")) {
			TextComponent[] text1 = {new TextComponent("§eL§3ive§eP§3lays§8 §8- §3Dein §eGaming §eNetzwerk\n")};
			TextComponent[] text2 = {new TextComponent("\n§3Du §3bist §3auf §3den §3Server§8: §e"+p.getServer().getInfo().getName()),
					new TextComponent("\n\n§4Administrator §cDeveloper §9SrModerator\n§3Moderator §bSupporter\n§2Builder\n§5YouTuber §6Premium\n§7Member")};
			p.setTabHeader(text1, text2);
		} else {
			TextComponent[] text1 = {new TextComponent("§eL§3ive§eP§3lays§8 §8- §3Your §eGaming §eNetwork\n")};
			TextComponent[] text2 = {new TextComponent("\n§3You're §3on §3Server§8: §e"+p.getServer().getInfo().getName()),
					new TextComponent("\n\n§4Administrator §cDeveloper §9SrModerator\n§3Moderator §bSupporter\n§2Builder\n§5YouTuber §6Premium\n§7Member")};
			p.setTabHeader(text1, text2);
		}
		if (PartyManager.getParty(p) != null && PartyManager.getParty(p).getLeader() == p) {
			PlayerParty party = PartyManager.getParty(p);
			ServerInfo si = p.getServer().getInfo();
			for(ProxiedPlayer partyp : party.getPlayers()) {
				if(partyp.getServer().getInfo().getName().startsWith("Lobby")) {
					partyp.sendMessage(new TextComponent(main.prefix_party+"§3Der §3Party-Leiter §3betritt §3den §3Server §e"+party.getServer().getName()));
				} else {
					partyp.connect(si);
					p.sendMessage(new TextComponent(main.prefix_party+"§3Du §3betritst §3den §3Server §e"+si.getName()));
				}
				return;
			}
		}
	}
}