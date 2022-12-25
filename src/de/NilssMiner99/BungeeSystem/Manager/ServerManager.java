package de.NilssMiner99.BungeeSystem.Manager;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;

public class ServerManager {

	public static HashMap<String, String> abkürzung = new HashMap<>();
	public static HashMap<String, String> server = new HashMap<>();
	public static ArrayList<String> ab = new ArrayList<>();
	
	public static void load() {
		
		try {
			if(new File("plugins/BungeeSystem/Server_Templates/").list().length == 0) {
				new File("plugins/BungeeSystem/Server_Templates/Test.yml").createNewFile();
				FileWriter fw = new FileWriter(new File("plugins/BungeeSystem/Server_Templates/Test.yml"));
				fw.write("Permissons:admin");
				fw.write("\nCommandAbkürung:lb");
				fw.write("\nServers:lobby-1");
				fw.close();
			}
			for(String filename : new File("plugins/BungeeSystem/Server_Templates/").list()) {
				File f = new File("plugins/BungeeSystem/Server_Templates/"+filename);
				Scanner sc = new Scanner(f);
				try {
					String group = null;
					String servers = null;
					String abkürzung = null;
					while(sc.hasNextLine()) {
						String s = sc.nextLine();
						if(s.startsWith("Permissons:")) {
							group = s.replaceFirst("Permissons:", "");
						} else if(s.startsWith("Servers:")) {
							servers = s.replaceFirst("Servers:", "");
						} else if(s.startsWith("CommandAbkürung:")) {
							abkürzung = s.replaceFirst("CommandAbkürung:", "");
						}
					}
					if(group != null && servers != null && abkürzung != null) {
						ServerManager.abkürzung.put(abkürzung, group);
						ServerManager.ab.add(abkürzung);
						ServerManager.server.put(abkürzung, servers);
					} else {
						ProxyServer.getInstance().broadcast(new TextComponent(main.prefix+"§cFehler §cin §cder §cServer §cTemplates §cdatei§c: §e"+filename));
					}
				} catch(Exception ex) {
					ProxyServer.getInstance().broadcast(new TextComponent(main.prefix+"§cFehler §cin §cder §cServer §cTemplates §cdatei§c: §e"+filename));
				}
				sc.close();
			}
		} catch(Exception ex) {
		}
		
		/*
		 * Group Server
		 * 
		 * permisson:
		 * servers:
		 */
	}
}