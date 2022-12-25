package de.NilssMiner99.BungeeSystem.Manager;

import java.io.File;
import java.util.ArrayList;

public class NotifyManager {
	
	public static ArrayList<String> notify = new ArrayList<>();
	
	public static void load() {
		File f = new File("plugins/BungeeSystem/Notify_List/");
		try {
			for(String filename : f.list()) {
				notify.add(filename.replace(".yml", ""));
			}
		} catch(Exception ex) {
		}
	}
	
	public static void add(String uuid) {
		File f = new File("plugins/BungeeSystem/Notify_List/"+uuid+".yml");
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			if(!(notify.contains(uuid))) {
				notify.add(uuid);
			}
		} catch(Exception ex) {
		}
	}
	
	public static void remove(String uuid) {
		File f = new File("plugins/BungeeSystem/Notify_List/"+uuid+".yml");
		try {
			if(f.exists()) {
				f.delete();
			}
			if(notify.contains(uuid)) {
				notify.remove(uuid);
			}
		} catch(Exception ex) {
		}
	}
}