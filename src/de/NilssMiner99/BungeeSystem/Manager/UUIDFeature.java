package de.NilssMiner99.BungeeSystem.Manager;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class UUIDFeature {
	
	public static String getUUIDByAdress(String adresse) {
		String uuid = null;
		File f = new File("plugins/BungeeSystem/PlayerData_Adressen/"+adresse+".yml");
		try {
			if(f.exists()) {
				Scanner sc = new Scanner(f);
				if(sc.hasNextLine()) {
					uuid = sc.nextLine();
				}
				sc.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return uuid;
	}
	
	public static void updateAdresse(String uuid, String newadresse) {
		String adresse = getAdresse(uuid);
		try {
			if(newadresse != adresse) {
				File f = new File("plugins/BungeeSystem/PlayerData_Adressen/"+adresse+".yml");
				if(f.exists()) {
					f.deleteOnExit();
				}
				File fnew = new File("plugins/BungeeSystem/PlayerData_Adressen/"+newadresse+".yml");
				if(!fnew.exists()) {
					fnew.createNewFile();
				}
				FileWriter fw = new FileWriter(f);
				fw.write(uuid);
				fw.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		try {
			File f = new File("plugins/BungeeSystem/PlayerData_Adressen_UUID/"+uuid+".yml");
			if(!f.exists()) {
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			fw.write(newadresse);
			fw.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static String getAdresse(String uuid) {
		String adresse = null;
		File f = new File("plugins/BungeeSystem/PlayerData_Adressen_UUID/"+uuid+".yml");
		try {
			if(f.exists()) {
				Scanner sc = new Scanner(f);
				if(sc.hasNextLine()) {
					adresse = sc.nextLine();
				}
				sc.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return adresse;
	}
	
	public static String getUUID(String name) {
		File f = new File("plugins/BungeeSystem/PlayerData_Name/"+name.toLowerCase()+".yml");
		String uuid = null;
		try {
			if(f.exists()) {
				Scanner sc = new Scanner(f);
				if(sc.hasNextLine()) {
					uuid = sc.nextLine();
				}
				sc.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return uuid;
	}
	public static String getName(String uuid) {
		File f = new File("plugins/BungeeSystem/PlayerData_UUID/"+uuid+".yml");
		String name = null;
		try {
			if(f.exists()) {
				Scanner sc = new Scanner(f);
				if(sc.hasNextLine()) {
					name = sc.nextLine();
				}
				sc.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return name;
	}
}