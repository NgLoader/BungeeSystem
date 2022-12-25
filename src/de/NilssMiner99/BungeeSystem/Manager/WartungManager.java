package de.NilssMiner99.BungeeSystem.Manager;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import de.NilssMiner99.mongodb_Bungee.MongoDB.Global_Players;
import de.NilssMiner99.mongodb_Bungee.main.main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class WartungManager {
	
	public static ArrayList<String> whitelist = new ArrayList<>();
	
	public static Boolean wartung = false;

	public static String KickMessage_DE = "";
	public static String KickMessage_EN = "";
	
	public static void load() {
		wartung = false;
		whitelist.clear();
		try {
			File f = new File("plugins/BungeeSystem/Wartung_Config.yml");
			if(!f.exists()) {
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				fw.write("KickMessage_DE=&8[§eLivePlays§8]//§3Wir führen grade §4Wartungsarbeiten §3am Netzwerk durch§8!");
				fw.write("\nKickMessage_EN=&8[§eLivePlays§8]//§3We are corrently on §4Maintenance§8!");
				fw.close();
			}
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String s = sc.nextLine();
				try {
					if(s.startsWith("KickMessage_DE=")) {
						KickMessage_DE = s.replaceFirst("KickMessage_DE=", "").replaceAll("&", "§").replaceAll("//", "\n");
					} else if(s.startsWith("KickMessage_EN=")) {
						KickMessage_EN = s.replaceFirst("KickMessage_EN=", "").replaceAll("&", "§").replaceAll("//", "\n");
					}
				} catch(Exception ex) {
				}
			}
			sc.close();
		} catch(Exception ex) {
		}
		try {
			File f = new File("plugins/BungeeSystem/Wartung_Settings.yml");
			if(!f.exists()) {
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				fw.write("Wartung=false");
				fw.close();
			}
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String s = sc.nextLine();
				try {
					if(s.startsWith("Wartung=")) {
						wartung = Boolean.valueOf(s.replaceFirst("Wartung=", ""));
					}
				} catch(Exception ex) {
				}
			}
			sc.close();
		} catch(Exception ex) {
		}
		File f = new File("plugins/BungeeSystem/Wartung/Whitelist/");
		try {
			for(String filename : f.list()) {
				whitelist.add(filename.replaceAll(".yml", ""));
			}
		} catch(Exception ex) {
		}
	}
	
	public static void setWartung(Boolean b) {
		wartung = b;
		try {
			File f = new File("plugins/BungeeSystem/Wartung_Settings.yml");
			if(!f.exists()) {
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			fw.write("Wartung="+b);
			fw.close();
		} catch(Exception ex) {
		}
	}
	
	public static void remove(String name) {
		if(ProxyServer.getInstance().getPlayer(UUID.fromString(name)) != null) {
			ProxiedPlayer target = ProxyServer.getInstance().getPlayer(UUID.fromString(name));
			if(!(target.hasPermission("liveplays.team"))) {
				Global_Players gplayer = Global_Players.getPlayer(main.plugin, target.getUniqueId().toString());
				if(gplayer.getLanguage().equalsIgnoreCase("DE")) {
					target.disconnect(new TextComponent(WartungManager.KickMessage_DE));
				} else {
					target.disconnect(new TextComponent(WartungManager.KickMessage_EN));
				}
			}
		}
		try {
			File f = new File("plugins/BungeeSystem/Wartung/Whitelist/"+name+".yml");
			if(f.exists()) {
				f.delete();
			}
			if(whitelist.contains(name)) {
				whitelist.remove(name);
			}
		} catch(Exception ex) {
		}
	}
	
	public static void add(String name) {
		try {
			File f = new File("plugins/BungeeSystem/Wartung/Whitelist/"+name+".yml");
			if(!f.exists()) {
				f.createNewFile();
			}
			if(!(whitelist.contains(name))) {
				whitelist.add(name);
			}
		} catch(Exception ex) {
		}
	}
}