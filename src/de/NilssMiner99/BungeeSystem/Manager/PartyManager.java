package de.NilssMiner99.BungeeSystem.Manager;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class PartyManager {

	private static List<PlayerParty> parties = new ArrayList<PlayerParty>();
	
	public static HashMap<String, Integer> toggel = new HashMap<>();
	
	public static void load() {
		File f = new File("plugins/BungeeSystem/Party_toggle/");
		try {
			for(String filename : f.list()) {
				try {
					int i = 0;
					Scanner sc = new Scanner("plugins/BungeeSystem/Party_toggle/"+filename);
					try {
						i = Integer.valueOf(sc.nextLine());
					} catch(Exception ex) {
					}
					sc.close();
					toggel.put(filename.replace(".yml", ""), i);
				} catch(Exception ex) {
					ProxyServer.getInstance().broadcast(new TextComponent(main.prefix_party+"§cFehler §cin §cder §cParty §ctoggel §cdatei §e: §3"+filename));
				}
			}
		} catch(Exception ex) {
		}
	}
	
	public static void settoggel(String uuid, Integer i) {
		try {
			File f = new File("plugins/BungeeSystem/Party_toggle/"+uuid+".yml");
			FileWriter fw = new FileWriter(f);
			fw.write(i);
			fw.close();
			toggel.put(uuid, i);
		} catch(Exception ex) {
		}
	}
	
	public static boolean isInviting(ProxiedPlayer player) {
		if(PlayerParty.invitations.containsKey(player)) {
			return true;
		}
		return false;
	}
	
	public static PlayerParty getParty(ProxiedPlayer player) {
		for(PlayerParty party : parties) {
			if(party.isInParty(player)) {
				return party;
			}
		}
		return null;
	}
	
	public static PlayerParty denyParty(ProxiedPlayer player) {
		if(isInviting(player)) {
			PlayerParty.deny(player);
		}
		return null;
	}
	
	public static boolean createParty(ProxiedPlayer player) {
		if(getParty(player) == null) {
			parties.add(new PlayerParty(player));
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean deleteParty(ProxiedPlayer player) {
		if(getParty(player) != null) {
			if(getParty(player).isLeader(player)) {
				for(ProxiedPlayer p : getParty(player).getPlayers()) {
					getParty(player).removePlayer(p);
				}
				parties.remove(getParty(player));
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public static List<PlayerParty> getParties() {
		return parties;
	}
	
	public static void deleteParty(PlayerParty party) {
		if(party != null) {
			for(int i = 0; i < party.getPlayers().size(); i++) {
				if(party.getPlayers().get(i) != null) {
					party.getPlayers().remove(i);
				}
			}
			parties.remove(party);
		}
	}
	
}
