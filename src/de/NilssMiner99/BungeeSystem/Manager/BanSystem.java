package de.NilssMiner99.BungeeSystem.Manager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import de.NilssMiner99.BungeeSystem.main.main;
import de.NilssMiner99.mongodb_Bungee.MongoDB.Global_Players;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class BanSystem {
	
	private static main plugin = main.plugin;
	
	public static Boolean isBanned(String uuid) {
		try {
			File f = new File("plugins/BungeeSystem/Data_Ban/" + uuid + ".yml");
			if (f.exists()) {
				Scanner sc = new Scanner(f);
				Long time = Long.valueOf(sc.nextLine());
				sc.close();
				long current = System.currentTimeMillis();
				long end = time.longValue();
				if (((current < end ? 1 : 0) | (end == -1L ? 1 : 0)) != 0) {
					return true;
				} else {
					unBan(uuid);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void addBan(String uuid, long seconds, String grund, String from, String tage) {
		File f = new File("plugins/BungeeSystem/Data_Ban/"+uuid+".yml");
		long end = 0;
		if(seconds == -1) {
			end = -1;
		} else {
			long current = System.currentTimeMillis();
			long millis = seconds * 1000L;
			end = current + millis;
		}
		try {
			FileWriter fw = new FileWriter(f);
			fw.write(end+"\n"+grund+"\n"+from+"\n"+plugin.getDateFormat().format(new Date())+"\n"+tage);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int i = 0;
		while(new File("plugins/BungeeSystem/Data_Ban_Infos/"+uuid+"_"+i+".yml").exists()) {
			i++;
		}
		try {
			File f2 = new File("plugins/BungeeSystem/Data_Ban_Infos/"+uuid+"_"+i+".yml");
			FileWriter fw = new FileWriter(f2);
			fw.write(getRemainingTime(end, uuid)+"\n"+grund+"\n"+from+"\n"+plugin.getDateFormat().format(new Date())+"\n"+tage);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
			if(player.hasPermission("liveplays.team")&& (!(NotifyManager.notify.contains(player.getUniqueId().toString())))) {
				player.sendMessage(new TextComponent("§8[]§7----------------- §4Ban §7-----------------§8[]"));
				player.sendMessage(new TextComponent("§3Spieler§8: §e"+UUIDFeature.getName(uuid)));
				String banner = from.equalsIgnoreCase("console") ? "CONSOLE" : UUIDFeature.getName(from);
				player.sendMessage(new TextComponent("§3Gebannt §3von§8: §e"+banner));
				player.sendMessage(new TextComponent("§3Grund§8: §e"+grund));
				player.sendMessage(new TextComponent("§8[]§7----------------- §4Ban §7-----------------§8[]"));
			}
		}
		if(ProxyServer.getInstance().getPlayer(UUID.fromString(uuid)) != null) {
			ProxiedPlayer target = ProxyServer.getInstance().getPlayer(UUID.fromString(uuid));
			target.disconnect(new TextComponent(getBanMessage(uuid)));
		}
	}
	
	public static Integer getBanns(String uuid) {
		int i = 0;
		while(new File("plugins/BungeeSystem/Data_Ban_Infos/"+uuid+"_"+i+".yml").exists()) {
			i++;
		}
		return i;
	}
	
	public static ArrayList<String> getBanInfo(String uuid, Integer ban) {
		ArrayList<String> info = new ArrayList<>();
		ban--;
		File f2 = new File("plugins/BungeeSystem/Data_Ban_Infos/"+uuid+"_"+ban+".yml");
		if(f2.exists()) {
			try {
				Scanner s = new Scanner(f2);
				while(s.hasNextLine()) {
					info.add(s.nextLine());
				}
				s.close();
			} catch(Exception ex) {
			}
		}
		return info;
	}
	
	public static String getRemainingTime(Long time, String uuid) {
		try {
			long current = System.currentTimeMillis();
		    long end = time.longValue();
			if (end == -1L) {
				Global_Players gplayer = Global_Players.getPlayer(de.NilssMiner99.mongodb_Bungee.main.main.plugin, uuid);
				if(gplayer.getLanguage().equalsIgnoreCase("DE")) {
					return "§4PERMANENT";
				} else {
					return "§4PERMANENTLY";
				}
			}
			long millis = end - current;
			long seconds = 0L;
			long minutes = 0L;
			long hours = 0L;
			long days = 0L;
			while (millis > 1000L) {
				millis -= 1000L;
				seconds += 1L;
			}
			while (seconds > 60L) {
				seconds -= 60L;
				minutes += 1L;
			}
			while (minutes > 60L) {
				minutes -= 60L;
				hours += 1L;
			}
			while (hours > 24L) {
				hours -= 24L;
				days += 1L;
			}
			Global_Players gplayer = Global_Players.getPlayer(de.NilssMiner99.mongodb_Bungee.main.main.plugin, uuid);
			if(gplayer.getLanguage().equalsIgnoreCase("DE")) {
				return (days == 0 ? "" : "§e"+days+" §3Tag(e) ")
						+(hours == 0 ? "" : "§e"+hours+" §3Stunde(n) ")
						+(minutes == 0 ? "" : "§e"+minutes+" §3Minute(n) ")
						+(seconds == 0 ? "" : "§e"+seconds+" §3Sekunde(n)");
			} else {
				return (days == 0 ? "" : "§e"+days+" §3day(s) ")
						+(hours == 0 ? "" : "§e"+hours+" §3hour(s) ")
						+(minutes == 0 ? "" : "§e"+minutes+" §3minute(s) ")
						+(seconds == 0 ? "" : "§e"+seconds+" §3second(s)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getBanMessage(String uuid) {
		File f = new File("plugins/BungeeSystem/Data_Ban/"+uuid+".yml");
		if(f.exists()) {
			try {
				Scanner sc = new Scanner(f);
				Long time = Long.valueOf(sc.nextLine());
				sc.close();
				long current = System.currentTimeMillis();
			    long end = time.longValue();
				if (end == -1L) {
					ArrayList<String> data = getData(uuid);
					Global_Players gplayer = Global_Players.getPlayer(de.NilssMiner99.mongodb_Bungee.main.main.plugin, uuid);
					if(gplayer.getLanguage().equalsIgnoreCase("DE")) {
						return "§cDu wurdest §4PERMANENT§c vom Netzwerk gebannt§8.\n"
								+ "§3Grund§8: §c"+data.get(1)+"\n"
									+ "\n§aDu kannst auf §eLivePlays.net §aeinen Entbannungsantrag stellen§8.";
					} else {
						return "§cYou §chave §cbeem §4PERMANENTLY§c §cbanned §cfrom §cthe §cNetword§8.\n"
								+ "§3Reason§8: §c"+data.get(1)+"\n"
									+ "\n§aYou can create a Ban appeal on  §eLivePlays.net§8.";
					}
				}
				long millis = end - current;
				long seconds = 0L;
				long minutes = 0L;
				long hours = 0L;
				long days = 0L;
				while (millis > 1000L) {
					millis -= 1000L;
					seconds += 1L;
				}
				while (seconds > 60L) {
					seconds -= 60L;
					minutes += 1L;
				}
				while (minutes > 60L) {
					minutes -= 60L;
					hours += 1L;
				}
				while (hours > 24L) {
					hours -= 24L;
					days += 1L;
				}
				ArrayList<String> data = getData(uuid);
				Global_Players gplayer = Global_Players.getPlayer(de.NilssMiner99.mongodb_Bungee.main.main.plugin, uuid);
				if(gplayer.getLanguage().equalsIgnoreCase("DE")) {
					return "§cDu wurdest für §e"+data.get(4)+" Tag(e) §cvom Netzwerk gebannt§8!\n"
							+ "§3Grund§8: §c"+data.get(1)+"\n"
							+"\n§3Verbleibende Zeit§8: "+(days == 0 ? "" : "§e"+days+" §3Tag(e) ")
							+(hours == 0 ? "" : "§e"+hours+" §3Stunde(n) ")
							+(minutes == 0 ? "" : "§e"+minutes+" §3Minute(n) ")
							+(seconds == 0 ? "" : "§e"+seconds+" §3Sekunde(n)")
							+ "\n\n§aDu kannst auf §eLivePlays.net §aeinen Entbannungsantrag stellen§8.";
				} else {
					return "§cYou §chave §cbeen §cbanned §cfor §e"+data.get(4)+" §cDay(s) §cfrom §cthe §cnetwork§8!\n"
							+ "§3Reason§8: §c"+data.get(1)+"\n"
							+"\n§3Remaining time§8: "+(days == 0 ? "" : "§e"+days+" §cday(s) ")
							+(hours == 0 ? "" : "§e"+hours+" §3hour(s) ")
							+(minutes == 0 ? "" : "§e"+minutes+" §3minute(s) ")
							+(seconds == 0 ? "" : "§e"+seconds+" §3second(s)")
							+ "\n\n§aYou can create a Ban appeal on  §eLivePlays.net§8.";
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	
	public static String getRemainingTime(String uuid) {
		File f = new File("plugins/BungeeSystem/Data_Ban/"+uuid+".yml");
		if(f.exists()) {
			try {
				Scanner sc = new Scanner(f);
				Long time = Long.valueOf(sc.nextLine());
				sc.close();
				long current = System.currentTimeMillis();
			    long end = time.longValue();
				if (end == -1L) {
					Global_Players gplayer = Global_Players.getPlayer(de.NilssMiner99.mongodb_Bungee.main.main.plugin, uuid);
					if(gplayer.getLanguage().equalsIgnoreCase("DE")) {
						return "§4PERMANENT";
					} else {
						return "§4PERMANENTLY";
					}
				}
				long millis = end - current;
				long seconds = 0L;
				long minutes = 0L;
				long hours = 0L;
				long days = 0L;
				while (millis > 1000L) {
					millis -= 1000L;
					seconds += 1L;
				}
				while (seconds > 60L) {
					seconds -= 60L;
					minutes += 1L;
				}
				while (minutes > 60L) {
					minutes -= 60L;
					hours += 1L;
				}
				while (hours > 24L) {
					hours -= 24L;
					days += 1L;
				}
				Global_Players gplayer = Global_Players.getPlayer(de.NilssMiner99.mongodb_Bungee.main.main.plugin, uuid);
				if(gplayer.getLanguage().equalsIgnoreCase("DE")) {
					return (days == 0 ? "" : "§e"+days+" §3Tag(e) ")
							+(hours == 0 ? "" : "§e"+hours+" §3Stunde(n) ")
							+(minutes == 0 ? "" : "§e"+minutes+" §3Minute(n) ")
							+(seconds == 0 ? "" : "§e"+seconds+" §3Sekunde(n)");
				} else {
					return (days == 0 ? "" : "§e"+days+" §3day(s) ")
							+(hours == 0 ? "" : "§e"+hours+" §3hour(s) ")
							+(minutes == 0 ? "" : "§e"+minutes+" §3minute(s) ")
							+(seconds == 0 ? "" : "§e"+seconds+" §3second(s)");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void loadConfig(String uuid) {
		File f = new File("plugins/BungeeSystem/Data_Ban/"+uuid+".yml");
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(f.exists()) {
			try {
				FileWriter fw = new FileWriter(f);
				long end = 0;
				long seconds = 10;
				long current = System.currentTimeMillis();
				long millis = seconds * 1000L;
				end = current + millis;
				fw.write(""+end);
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static ArrayList<String> getData(String uuid) {
		ArrayList<String> data = new ArrayList<>();
		if(isBanned(uuid)) {
			File f = new File("plugins/BungeeSystem/Data_Ban/"+uuid+".yml");
			try {
				Scanner sc = new Scanner(f);
				while(sc.hasNextLine()) {
					data.add(sc.nextLine());
				}
				sc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	public static void unBan(String uuid) {
		File f = new File("plugins/BungeeSystem/Data_Ban/"+uuid+".yml");
		if(f.exists()) {
			f.delete();
		}
	}
	
	public static ArrayList<String> getBans() {
		ArrayList<String> bans = new ArrayList<>();
		File f = new File("plugins/BungeeSystem/Data_Ban/");
		for(String fn : f.list()) {
			if(isBanned(fn.replace(".yml", ""))) {
				bans.add(fn.replace(".yml", ""));
			}
		}
		return bans;
	}
}