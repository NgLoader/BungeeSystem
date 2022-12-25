package de.NilssMiner99.BungeeSystem.Manager;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import de.NilssMiner99.mongodb_Bungee.MongoDB.Global_Players;
import de.NilssMiner99.mongodb_Bungee.Values.Groups;
import de.NilssMiner99.mongodb_Bungee.main.main;

public class GruppenManager {
	
	public static ArrayList<String> getPermissons(String uuid) {
		ArrayList<String> perms = new ArrayList<>();
		try {
			Global_Players gplayer = Global_Players.getPlayer(main.plugin, uuid);
			if(RangTemplates.templates.containsKey(gplayer.getGroup().getDatabaseName())) {
				for(String perm : RangTemplates.templates.get(gplayer.getGroup().getDatabaseName()).split("//")) {
					if(perm != null && perm != "") {
						perms.add(perm);
					}
				}
			}
			File f = new File("plugins/BungeeSystem/PlayerData_Permissons/"+uuid+".yml");
			if(f.exists()) {
				Scanner sc = new Scanner(f);
				try {
					while(sc.hasNextLine()) {
						perms.add(sc.nextLine());
					}
				} catch(Exception ex) {
				}
				sc.close();
			}
		} catch(Exception ex) {
		}
		return perms;
	}
	
	public static Boolean hasPermissons(String uuid, String permissons) {
		try {
			Global_Players gplayer = Global_Players.getPlayer(main.plugin, uuid);
			if(RangTemplates.templates.containsKey(gplayer.getGroup().getDatabaseName())) {
				for(String perm : RangTemplates.templates.get(gplayer.getGroup().getDatabaseName()).split("//")) {
					if(perm.equalsIgnoreCase(permissons)) {
						return true;
					}
				}
			}
			File f = new File("plugins/BungeeSystem/PlayerData_Permissons/"+uuid+".yml");
			if(f.exists()) {
				Scanner sc = new Scanner(f);
				try {
					while(sc.hasNextLine()) {
						if(sc.nextLine().equalsIgnoreCase(permissons)) {
							sc.close();
							return true;
						}
					}
				} catch(Exception ex) {
				}
				sc.close();
			}
		} catch(Exception ex) {
		}
		return false;
	}
	
	public static void addPermissons(String uuid, String permissons) {
		try {
			ArrayList<String> perms = getPermissons(uuid);
			File f = new File("plugins/BungeeSystem/PlayerData_Permissons/"+uuid+".yml");
			if(!f.exists()) {
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			try {
				for(String perm : perms) {
					if(!(permissons.equalsIgnoreCase(perm))) {
						fw.write(perm+"\n");
					}
				}
				fw.write(permissons);
			} catch(Exception ex) {
			}
			fw.close();
		} catch(Exception ex) {
		}
	}
	
	public static void setPermissons(String uuid, String template) {
		try {
			
			Global_Players gplayer = Global_Players.getPlayer(main.plugin, uuid);
			gplayer.setGroup(Groups.valueOf(template));
			
//			if(ProxyServer.getInstance().getPlayer(UUID.fromString(uuid)) != null) {
//				ProxiedPlayer p = ProxyServer.getInstance().getPlayer(UUID.fromString(uuid));
//				for(String s : getPermissons(uuid)) {
//					p.setPermission(s, false);
//				}
//			}
//			
//			File f = new File("plugins/BungeeSystem/PlayerData_Permissons/"+uuid+".yml");
//			if(!f.exists()) {
//				f.createNewFile();
//			}
//			FileWriter fw = new FileWriter(f);
//			try {
//				if(ProxyServer.getInstance().getPlayer(UUID.fromString(uuid)) != null) {
//					ProxiedPlayer p = ProxyServer.getInstance().getPlayer(UUID.fromString(uuid));
//					for(String perm : RangTemplates.templates.get(template).split("//")) {
//						if(!(perm.equalsIgnoreCase("") && perm.equalsIgnoreCase(" "))) {
//							p.setPermission(perm, true);
//							fw.write(perm+"\n");
//						}
//					}
//				} else {
//					for(String perm : RangTemplates.templates.get(template).split("//")) {
//						if(!(perm.equalsIgnoreCase("") && perm.equalsIgnoreCase(" "))) {
//							fw.write(perm+"\n");
//						}
//					}
//				}
//			} catch(Exception ex) {
//			}
//			fw.close();
		} catch(Exception ex) {
		}
	}
}