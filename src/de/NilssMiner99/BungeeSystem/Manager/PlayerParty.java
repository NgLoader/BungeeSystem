package de.NilssMiner99.BungeeSystem.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import de.NilssMiner99.BungeeSystem.Message.Message;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.scheduler.ScheduledTask;

public class PlayerParty {

	private static ProxiedPlayer leader;
	
	private List<ProxiedPlayer> players;
	
	private ScheduledTask run;
	
	public static HashMap<ProxiedPlayer, ProxiedPlayer> invitations;
	
	@SuppressWarnings("static-access")
	public PlayerParty(ProxiedPlayer leader) {
		this.leader = leader;
		this.players = new ArrayList<ProxiedPlayer>();
		this.invitations = new HashMap<ProxiedPlayer, ProxiedPlayer>();
		if(run == null) {
			run = BungeeCord.getInstance().getScheduler().schedule(main.plugin, new Runnable() {
				public void run() {
					Message.PARTY_DIE_PARTY_WURDE_WEGEN_ZU_WENIG_MITGLIEDER_AUFGELÖST.sendMessage(leader);
					PartyManager.deleteParty(PartyManager.getParty(leader));
				}
			}, 30L, TimeUnit.SECONDS);
		}
	}
	
	public boolean isLeader(ProxiedPlayer player) {
		return leader == player;
	}
	
	public List<ProxiedPlayer> getPlayers() {
		return players;
	}
	
	public ProxiedPlayer getLeader() {
		return leader;
	}
	
	public boolean isInParty(ProxiedPlayer player) {
		if(isLeader(player)) {
			return true;
		}else if(players.contains(player)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean addPlayer(ProxiedPlayer player) {
		if(!players.contains(player) && invitations.containsKey(player)) {
			players.add(player);
			invitations.remove(player);
			if(players.size() != 0) {
				if(run != null) {
					run.cancel();
					run = null;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	public void setLeader(ProxiedPlayer player) {
		if(leader != player) {
			this.players.remove(player);
			this.players.add(leader);
			leader = player;
		}
	}
	
	public boolean removePlayer(ProxiedPlayer player) {
		if(players.contains(player)) {
			players.remove(player);
			if(players.size() == 0) {
				if(run == null) {
					run = BungeeCord.getInstance().getScheduler().schedule(main.plugin, new Runnable() {
						public void run() {
							Message.PARTY_DIE_PARTY_WURDE_WEGEN_ZU_WENIG_MITGLIEDER_AUFGELÖST.sendMessage(leader);
							PartyManager.deleteParty(PartyManager.getParty(leader));
						}
					}, 30L, TimeUnit.SECONDS);
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	public ServerInfo getServer() {
		return leader.getServer().getInfo();
	}
	
	public static void deny(ProxiedPlayer p) {
		if(invitations.containsKey(p)) {
			Message.PARTY_DU_HAST_DIE_PARTY_VON_SPIELER_ABGELEHNT.sendMessageReplace(p, "%TARGET%", leader.getName());
			Message.PARTY_DER_SPIELER_HAT_DIE_PARTY_ANFRAGE_ABGELEHNT.sendMessageReplace(leader, "%TARGET%", p.getName());
			invitations.remove(p);
		} else {
			Message.PARTY_DU_WURDEST_ZU_KEINER_PARTY_EINGELADEN.sendMessage(p);
		}
	}
	
	public void invite(final ProxiedPlayer p) {
		if(invitations.containsKey(p)) {
			Message.PARTY_DU_HAST_DEN_SPIELER_SCHON_EINGELADEN.sendMessage(leader);
			return;
		} else {
			invitations.put(p, leader);
			Message.PARTY_DU_HAST_DEN_SPIELER_IN_DEINE_PARTY_EINGELADEN.sendMessageReplace(leader, "%TARGET%", p.getName());
			Message.PARTY_DU_WURDEST_IN_DIE_PARTY_VON_SPIELER_EINGELADEN.sendMessageReplace(p, "%TARGET%", leader.getName());
			Message.PARTY_BETRETE_DIE_PARTY_MIT.sendMessageReplace(p, "%TARGET%", leader.getName());
			
			TextComponent tc = new TextComponent();
			tc.setText(Message.PARTY_PARTY_BETRETEN.getMessage(p).replaceAll("%TARGET%", leader.getName()));
			
			TextComponent tc2 = new TextComponent();
			tc2.setText("§a✔§a");
			tc2.setBold(true);
			tc2.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/party accept "+leader.getName()));
			tc2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Message.PARTY_BETRETE_DIE_PARTY_VON_SPIELER.getMessage(p).replaceAll("%TARGET%", leader.getName())).create()));
			tc.addExtra(tc2);
			tc.addExtra("  §8/  ");
			TextComponent tc3 = new TextComponent();
			tc3.setText("§c✘");
			tc3.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/party deny "+leader.getName()));
			tc3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Message.PARTY_LEHNE_DIE_PARTY_VON_SPIELER_AB.getMessage(p).replaceAll("%TARGET%", leader.getName())).create()));
			tc.addExtra(tc3);
			p.sendMessage(tc);
			BungeeCord.getInstance().getScheduler().schedule(main.plugin, new Runnable() {
				public void run() {
					if(isInParty(p)) {
						return;
					}
					if(!(isInParty(leader))) {
						return;
					}
					if(invitations.containsKey(p)) {
						invitations.remove(p);
						Message.PARTY_IHRE_EINLADUNG_IST_ABGELAUFTEN.sendMessageReplace(p, "%TARGET%", leader.getName());
						Message.PARTY_DIE_EINLADUNG_VON_SPIELER_IST_ABGELAUFTEN.sendMessageReplace(leader, "%TARGET%", p.getName());
					}
				}
			}, 30L, TimeUnit.SECONDS);
		}
	}
}
