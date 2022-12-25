package de.NilssMiner99.BungeeSystem.Manager;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;

public class RangTemplates {
	
	public static HashMap<String, String> templates = new HashMap<>();
	
	public static void load() {
		templates.clear();
		try {
			File f = new File("plugins/BungeeSystem/Templates_Rank/");
			if(f.list().length == 0) {
				FileWriter fw = new FileWriter(new File("plugins/BungeeSystem/Templates_Rank/admin.yml"));
				fw.write("liveplays.admin");
				fw.write("\nliveplays.team");
				fw.close();
			}
			for(String filename : f.list()) {
				String name = "";
				String perms = "";
				Scanner sc = new Scanner(new File("plugins/BungeeSystem/Templates_Rank/"+filename));
				try {
					name = filename.replace(".yml", "");
					while(sc.hasNextLine()) {
						String s = sc.nextLine();
						perms = perms+s+"//";
					}
					if(name != "" && perms != "") {
						templates.put(name, perms);
					}
				} catch(Exception ex) {
					ProxyServer.getInstance().broadcast(new TextComponent(main.prefix+"§cFehler §cbeim §claden §cder §cRank §cTemplats §8:§e"+filename));
				}
				sc.close();
			}
		} catch(Exception ex) {
		}
	}
}