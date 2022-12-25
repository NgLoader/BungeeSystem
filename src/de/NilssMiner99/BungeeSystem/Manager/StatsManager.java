package de.NilssMiner99.BungeeSystem.Manager;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.scheduler.ScheduledTask;

public class StatsManager {
	
	public static ScheduledTask ts;
	
	public static void startPlayTimeCounter() {
		if(ts != null) {
			ts.cancel();
			ts = null;
		}
		ts = ProxyServer.getInstance().getScheduler().schedule(main.plugin, new Runnable() {
			
			@Override
			public void run() {
				for(ProxiedPlayer online : ProxyServer.getInstance().getPlayers()) {
					if(!(main.afk.contains(online.getUniqueId().toString()))) {
						addPlayTime(online.getUniqueId().toString(), 1L);
					}
				}
			}
		}, 0, 1, TimeUnit.SECONDS);
	}
	
	public static String getOldNames(String uuid) {
		String s = "";
		try {
			File f = new File("plugins/BungeeSystem/Stats_PlayerNames/"+uuid+".yml");
			if(f.exists()) {
				Scanner sc = new Scanner(f);
				while(sc.hasNextLine()) {
					String string = sc.nextLine();
					try {
						s = string;
					} catch(Exception ex) {
						ProxyServer.getInstance().broadcast(new TextComponent("§4Fehler in den PlayerNames datei:§c"+f));
					}
				}
				sc.close();
			}
		} catch(Exception ex) {
		}
		return s;
	}
	
	public static String getLastLoginDate(String uuid) {
		String s = "";
		try {
			File f = new File("plugins/BungeeSystem/Stats_LastLogin/"+uuid+".yml");
			if(f.exists()) {
				Scanner sc = new Scanner(f);
				while(sc.hasNextLine()) {
					String string = sc.nextLine();
					try {
						s = string;
					} catch(Exception ex) {
						ProxyServer.getInstance().broadcast(new TextComponent("§4Fehler in den PlayerNames datei:§c"+f));
					}
				}
				sc.close();
			}
		} catch(Exception ex) {
		}
		return s;
	}
	
	public static String getCreateDate(String uuid) {
		String s = "";
		try {
			File f = new File("plugins/BungeeSystem/Stats_CreateDate/"+uuid+".yml");
			if(f.exists()) {
				Scanner sc = new Scanner(f);
				while(sc.hasNextLine()) {
					String string = sc.nextLine();
					try {
						s = string;
					} catch(Exception ex) {
						ProxyServer.getInstance().broadcast(new TextComponent("§4Fehler in den PlayerNames datei:§c"+f));
					}
				}
				sc.close();
			}
		} catch(Exception ex) {
		}
		return s;
	}
	
	public static String getPlayTime(String uuid) {
		File f = new File("plugins/BungeeSystem/OnlineTime/"+uuid+".yml");
		long sec = 0;
		long min = 0;
		long hour = 0;
		long day = 0;
		long week = 0;
		long monat = 0;
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				try {
					sec = Long.valueOf(sc.nextLine());
				} catch(Exception ex) {
				}
			}
			sc.close();
		} catch(Exception ex) {
		}
		
		while(sec >= 60 || sec == 60) {
			sec-=60;
			min++;
		}
		while(min >= 60 || min == 60) {
			min-=60;
			hour++;
		}
		while(hour >= 24 || hour == 24) {
			hour-=24;
			day++;
		}
		while(day >= 7 || day == 7) {
			day-=7;
			week++;
		}
		while(week >= 7 || week == 7) {
			week-=7;
			monat++;
		}
		return (monat != 0 ? "§e"+monat+" §3Monat(e) " : "")
		+ (week != 0 ? "§e"+week+" §3Woche(n) " : "")
		+ (day != 0 ? "§e"+day+" §3Tag(e) " : "")
		+ (hour != 0 ? "§e"+hour+" §3Stunde(n) " : "")
		+ (min != 0 ? "§e"+min+" §3Minute(n) " : "")
		+ (sec != 0 ?  "§e"+sec+" §3Sekunde(n) " : "");
	}
	
	public static void addOldNames(String uuid, String name) {
		String oldnames = getOldNames(uuid);
		if(!(oldnames.contains(name))) {
			try {
				File f = new File("plugins/BungeeSystem/Stats_PlayerNames/"+uuid+".yml");
				if(!f.exists()) {
					f.createNewFile();
				}
				FileWriter fw = new FileWriter(f);
				fw.write(oldnames+name+" ");
				fw.close();
			} catch(Exception ex) {
			}
		}
	}
	
	public static void setLastLogin(String uuid) {
		try {
			File f = new File("plugins/BungeeSystem/Stats_LastLogin/"+uuid+".yml");
			if(!f.exists()) {
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			fw.write(main.plugin.getDateFormat().format(new Date()));
			fw.close();
		} catch(Exception ex) {
		}
	}
	
	public static void setCreateDate(String uuid) {
		try {
			File f = new File("plugins/BungeeSystem/Stats_CreateDate/"+uuid+".yml");
			if(!f.exists()) {
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			fw.write(main.plugin.getDateFormat().format(new Date()));
			fw.close();
		} catch(Exception ex) {
		}
	}
	
	public static void addPlayTime(String uuid, Long sec) {
		File f = new File("plugins/BungeeSystem/OnlineTime/"+uuid+".yml");
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			long havsec = 0;
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				try {
					havsec = Long.valueOf(sc.nextLine());
				} catch(Exception ex) {
				}
			}
			sc.close();
			FileWriter fw = new FileWriter(f);
			havsec = havsec+sec;
			fw.write(""+havsec);
			fw.close();
		} catch(Exception ex) {
		}
	}
}