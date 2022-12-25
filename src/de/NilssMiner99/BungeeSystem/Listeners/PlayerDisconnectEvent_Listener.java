package de.NilssMiner99.BungeeSystem.Listeners;

import de.NilssMiner99.BungeeSystem.Manager.PartyManager;
import de.NilssMiner99.BungeeSystem.Manager.PlayerParty;
import de.NilssMiner99.BungeeSystem.Manager.StatsManager;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerDisconnectEvent_Listener implements Listener {
	
	@EventHandler
	public void onQuit(PlayerDisconnectEvent e) {
		StatsManager.setLastLogin(e.getPlayer().getUniqueId().toString());
		if(PartyManager.getParty(e.getPlayer()) != null) {
			PlayerParty party = PartyManager.getParty(e.getPlayer());
			if(party.isLeader(e.getPlayer())) {
				if(party.getPlayers().size() != 0) {
					for(ProxiedPlayer pp : party.getPlayers()) {
						pp.sendMessage(new TextComponent(main.prefix_party + "§3Der §3Leiter §3hat §3die §3Party §3verlassen§8."));
					}
					ProxiedPlayer pl = party.getPlayers().get(0);
					party.setLeader(pl);
					party.removePlayer(e.getPlayer());
					pl.sendMessage(new TextComponent(main.prefix_party+"§3Du §3bist §3nun §3der §3Party §3leiter§8."));
					for(ProxiedPlayer partyplayers : party.getPlayers()) {
						partyplayers.sendMessage(new TextComponent(main.prefix_party+"§3Der §3neue §3Party §3Leiter §3ist §e"+pl.getName()+"§8."));
					}
				} else {
					for(ProxiedPlayer pp : party.getPlayers()) {
						pp.sendMessage(new TextComponent(main.prefix_party + "§3Der §3Leiter §3hat §3die §3Party §3verlassen§8."));
					}
					e.getPlayer().sendMessage(new TextComponent(main.prefix_party + "§3Du §3hast §3die §3Party §3gelöscht§8."));
					PartyManager.deleteParty(party);
					return;
				}
			} else {
				party.removePlayer(e.getPlayer());
				for(ProxiedPlayer p : party.getPlayers()) {
					p.sendMessage(new TextComponent(main.prefix_party + "§3Der §3Spieler §6"+e.getPlayer().getName()+" §3hat §3die §3Party §3verlassen."));
				}
				party.getLeader().sendMessage(new TextComponent(main.prefix_party + "§3Der §3Spieler §6"+e.getPlayer().getName()+" §3hat §3die §3Party §3verlassen."));
			}
		}
	}
}