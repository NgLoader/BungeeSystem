package de.NilssMiner99.BungeeSystem.Manager;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Templates {

	public static HashMap<String, String> BAN_kurzzeichen = new HashMap<>();
	public static HashMap<String, String> BAN_namen = new HashMap<>();
	public static HashMap<String, String> BAN_banngrund = new HashMap<>();
	public static HashMap<String, String> BAN_zeiten = new HashMap<>();
	
	public static HashMap<String, String> MUTE_kurzzeichen = new HashMap<>();
	public static HashMap<String, String> MUTE_namen = new HashMap<>();
	public static HashMap<String, String> MUTE_banngrund = new HashMap<>();
	public static HashMap<String, String> MUTE_zeiten = new HashMap<>();
	
	public static void load() {
		BAN_banngrund.clear();
		BAN_namen.clear();
		BAN_banngrund.clear();
		BAN_zeiten.clear();
		MUTE_banngrund.clear();
		MUTE_namen.clear();
		MUTE_banngrund.clear();
		MUTE_zeiten.clear();
		try {
			File f = new File("plugins/BungeeSystem/Templates_Mute.yml");
			if(!f.exists()) {
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				fw.write("B//Beleidung//Beleidigung eines Spielers//7 30 90 Perma");
				fw.close();
			}
			Scanner sc = new Scanner(f);
			try {
				while(sc.hasNextLine()) {
					String s = sc.nextLine();
					try {
						String kurzzeichen = null;
						String namen = null;
						String banngrund = null;
						String zeiten = null;
						kurzzeichen = s.split("//")[0];
						namen = s.split("//")[1];
						banngrund = s.split("//")[2];
						zeiten = s.split("//")[3];
						if(kurzzeichen != null && namen != null && banngrund != null && zeiten != null) {
							MUTE_kurzzeichen.put(s.split("//")[0], s.split("//")[0]);
							MUTE_namen.put(s.split("//")[0], s.split("//")[1]);
							MUTE_banngrund.put(s.split("//")[0], s.split("//")[2]);
							MUTE_zeiten.put(s.split("//")[0], s.split("//")[3]);
						} else {
							ProxyServer.getInstance().broadcast(new TextComponent(main.prefix_bs+"§4Fehler bei in der Mute datei :"+s));
						}
					} catch(Exception ex) {
						ProxyServer.getInstance().broadcast(new TextComponent(main.prefix_bs+"§4Fehler bei in der Mute datei :"+s));
					}
				}
				sc.close();
			} catch(Exception ex) {
				sc.close();
			}
		} catch(Exception ex) {
		}
		try {
			File f = new File("plugins/BungeeSystem/Templates_Ban.yml");
			if(!f.exists()) {
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				fw.write("H//Hacking//Nutzen einer unerlaubte Modifikation//30 90 Perma");
				fw.close();
			}
			Scanner sc = new Scanner(f);
			try {
				while(sc.hasNextLine()) {
					String s = sc.nextLine();
					try {
						String kurzzeichen = null;
						String namen = null;
						String banngrund = null;
						String zeiten = null;
						kurzzeichen = s.split("//")[0];
						namen = s.split("//")[1];
						banngrund = s.split("//")[2];
						zeiten = s.split("//")[3];
						if(kurzzeichen != null && namen != null && banngrund != null && zeiten != null) {
							BAN_kurzzeichen.put(s.split("//")[0], s.split("//")[0]);
							BAN_namen.put(s.split("//")[0], s.split("//")[1]);
							BAN_banngrund.put(s.split("//")[0], s.split("//")[2]);
							BAN_zeiten.put(s.split("//")[0], s.split("//")[3]);
						} else {
							ProxyServer.getInstance().broadcast(new TextComponent(main.prefix_bs+"§4Fehler bei in der Mute datei :"+s));
						}
					} catch(Exception ex) {
						ProxyServer.getInstance().broadcast(new TextComponent(main.prefix_bs+"§4Fehler bei in der Ban datei :"+s));
					}
				}
				sc.close();
			} catch(Exception ex) {
				sc.close();
			}
		} catch(Exception ex) {
		}
	}
	
	public static void bantemplate(CommandSender sender, String target, String args) {
		for(String s : BAN_kurzzeichen.keySet()) {
			if(s.equalsIgnoreCase(args)) {
				String name = sender instanceof ProxiedPlayer ? UUIDFeature.getUUID(sender.getName()) : "CONSOLE";
				long seconds = 0;
				
				int i = BAN_zeiten.get(s).split(" ").length;
				
				if(i == 1 && BAN_zeiten.get(s).equalsIgnoreCase("perma")) {
					seconds = -1;
				} else if(BanSystem.getBanns(target) > i || BanSystem.getBanns(target) == i || BAN_zeiten.get(s).split(" ")[BanSystem.getBanns(target)].equalsIgnoreCase("perma")) {
					seconds = -1;
					BanSystem.addBan(target, seconds, BAN_banngrund.get(s), name, "perma");
				} else {
					seconds = 60*60*24*Long.valueOf(BAN_zeiten.get(s).split(" ")[BanSystem.getBanns(target)]);
					BanSystem.addBan(target, seconds, BAN_banngrund.get(s), name, BAN_zeiten.get(s).split(" ")[BanSystem.getBanns(target)]);
				}
//				sender.sendMessage(new TextComponent(main.prefix_bs+"§eDu hast den §3Spieler §9"+UUIDFeature.getName(target)+" §3Gebannt§e."));
				return;
			}
		}
		sender.sendMessage(new TextComponent(main.prefix_bs+"§eDas §3Template §e"+args+" §eexestiert nicht."));
		return;
	}
	
	public static void mutetemplate(CommandSender sender, String target, String args) {
		for(String s : MUTE_kurzzeichen.keySet()) {
			if(s.equalsIgnoreCase(args)) {
				String name = sender instanceof ProxiedPlayer ? UUIDFeature.getUUID(sender.getName()) : "CONSOLE";
				long seconds = 0;
				
				int i = MUTE_zeiten.get(s).split(" ").length;
				
				if(i == 1 && MUTE_zeiten.get(s).equalsIgnoreCase("perma")) {
					seconds = -1;
				} else if(MuteSystem.getMutens(target) > i || MuteSystem.getMutens(target) == i || MUTE_zeiten.get(s).split(" ")[MuteSystem.getMutens(target)].equalsIgnoreCase("perma")) {
					seconds = -1;
					MuteSystem.addMute(target, seconds, MUTE_banngrund.get(s), name, "perma");
				} else {
					seconds = 60*60*Long.valueOf(MUTE_zeiten.get(s).split(" ")[MuteSystem.getMutens(target)]);
					MuteSystem.addMute(target, seconds, MUTE_banngrund.get(s), name, MUTE_zeiten.get(s).split(" ")[MuteSystem.getMutens(target)]);
				}
//				sender.sendMessage(new TextComponent(main.prefix_bs+"§eDu hast den §3Spieler §9"+UUIDFeature.getName(target)+" §3Gebannt§e."));
				return;
			}
		}
		sender.sendMessage(new TextComponent(main.prefix_ms+"§eDas §3Template §e"+args+" §eexestiert nicht."));
		return;
	}
}