package de.NilssMiner99.BungeeSystem.Manager;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WhitelistManager {
	
	public static ArrayList<String> whitelistwords = new ArrayList<>();
	
	public static void load() {
		whitelistwords.clear();
		File f = new File("plugins/BungeeSystem/WhiteListMuteWords.yml");
		try {
			if(!f.exists()) {
				FileWriter fw = new FileWriter(f);
				fw.write("/party");
				fw.write("\n/help");
				fw.write("\n/hub");
				fw.write("\n/l");
				fw.write("\n/leave");
				fw.write("\n/h");
				fw.write("\n/quit");
				fw.write("\n/lobby");
				fw.write("\n/report");
				fw.write("\n/cs");
				fw.write("\n/mute");
				fw.write("\n/unmute");
				fw.write("\n/ban");
				fw.write("\n/unban");
				fw.write("\n/wartung");
				fw.write("\n/check");
				fw.write("\n/pardon");
				fw.write("\n/bungeesystem");
				fw.write("\n/info");
				fw.write("\n/p");
				fw.write("\n/notify");
				fw.write("\n/spawn");
				fw.write("\n/list");
				fw.close();
			}
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				whitelistwords.add(sc.nextLine());
			}
			sc.close();
		} catch(Exception ex) {
		}
	}
}