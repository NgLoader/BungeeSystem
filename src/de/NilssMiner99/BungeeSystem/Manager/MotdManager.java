package de.NilssMiner99.BungeeSystem.Manager;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.PlayerInfo;
import net.md_5.bungee.api.chat.TextComponent;

public class MotdManager {

	public static String name_DE = "";
	public static String description_DE = "";
	public static PlayerInfo[] sampel_DE;

	public static String wartung_name_DE = "";
	public static String wartung_description_DE = "";
	public static PlayerInfo[] wartung_sampel_DE;

	public static String name_EN = "";
	public static String description_EN = "";
	public static PlayerInfo[] sampel_EN;

	public static String wartung_name_EN = "";
	public static String wartung_description_EN = "";
	public static PlayerInfo[] wartung_sampel_EN;

	public static void load() {
		load_DE();
		load_EN();
	}
	
	public static void load_DE() {
		
		File f = new File("plugins/BungeeSystem/MOTD_Config_DE.yml");
		try {
			if(!f.exists()) {
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				fw.write("Name=LivePlays.net");
				fw.write("\nDescripton=LivePlays.net");
				fw.write("\nPing1=Hallo");
				fw.write("\nPing2=Das");
				fw.write("\nPing3=ist ein");
				fw.write("\nPing4=Test");
				fw.write("\n\n");
				fw.write("\nWartung_Name=LivePlays.net");
				fw.write("\nWartung_Descripton=LivePlays.net");
				fw.write("\nWartung_Ping1=Hallo");
				fw.write("\nWartung_Ping2=Das");
				fw.write("\nWartung_Ping3=ist ein");
				fw.write("\nWartung_Ping4=Test");
				fw.close();
			}
			ArrayList<String> sampels = new ArrayList<>();
			ArrayList<String> wartung_sampels = new ArrayList<>();
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String s = sc.nextLine();
				try {
					if(s.startsWith("Name=")) {
						name_DE = s.replaceFirst("Name=", "").replaceAll("&", "§");
					} else if(s.startsWith("Descripton=")) {
						description_DE = s.replaceFirst("Descripton=", "").replaceAll("&", "§");
					} else if(s.startsWith("Ping")) {
						sampels.add(s.replaceFirst(s.split("=")[0]+"=", "").replaceAll("&", "§"));
					}
					if(s.startsWith("Wartung_Name=")) {
						wartung_name_DE = s.replaceFirst("Wartung_Name=", "").replaceAll("&", "§");
					} else if(s.startsWith("Wartung_Descripton=")) {
						wartung_description_DE = s.replaceFirst("Wartung_Descripton=", "").replaceAll("&", "§");
					} else if(s.startsWith("Wartung_Ping")) {
						wartung_sampels.add(s.replaceFirst(s.split("=")[0]+"=", "").replaceAll("&", "§"));
					}
				} catch(Exception ex) {
					ProxyServer.getInstance().broadcast(new TextComponent(main.prefix+"§4Fehler bei in der MOTD Config DE:"+s));
				}
			}
			sc.close();
			Integer max = sampels.size();
			if(max == 0) {
				sampel_DE = null;
			} else if(max == 1) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID())
				};
			} else if(max == 2) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID())
				};
			} else if(max == 3) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID())
				};
			} else if(max == 4) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID())
				};
			} else if(max == 5) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID())
				};
			} else if(max == 6) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
				};
			} else if(max == 7) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID())
				};
			} else if(max == 8) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID())
				};
			} else if(max == 9) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID())
				};
			} else if(max == 10) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID())
				};
			} else if(max == 11) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID())
				};
			} else if(max == 12) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID())
				};
			} else if(max == 13) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID())
				};
			} else if(max == 14) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID())
				};
			} else if(max == 15) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID())
				};
			} else if(max == 16) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID())
				};
			} else if(max == 17) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID())
				};
			} else if(max == 18) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID())
				};
			} else if(max == 19) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(18), UUID.randomUUID())
				};
			} else if(max == 20) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(19), UUID.randomUUID())
				};
			} else if(max == 21) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(19), UUID.randomUUID())
				};
			} else if(max == 22) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(20), UUID.randomUUID())
				};
			} else if(max == 23) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(21), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(22), UUID.randomUUID())
				};
			} else if(max == 24) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(21), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(22), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(23), UUID.randomUUID())
				};
			} else if(max == 25) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(20), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(21), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(22), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(23), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(24), UUID.randomUUID())
				};
			} else if(max >= 25) {
				sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(20), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(21), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(22), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(23), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(24), UUID.randomUUID())
				};
			}
			
			Integer wartung_max = wartung_sampels.size();
			if(wartung_max == 0) {
				wartung_sampel_DE = null;
			} else if(wartung_max == 1) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID())
				};
			} else if(wartung_max == 2) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID())
				};
			} else if(wartung_max == 3) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID())
				};
			} else if(wartung_max == 4) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID())
				};
			} else if(wartung_max == 5) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID())
				};
			} else if(wartung_max == 6) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
				};
			} else if(wartung_max == 7) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID())
				};
			} else if(wartung_max == 8) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID())
				};
			} else if(wartung_max == 9) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID())
				};
			} else if(wartung_max == 10) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID())
				};
			} else if(wartung_max == 11) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID())
				};
			} else if(wartung_max == 12) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID())
				};
			} else if(wartung_max == 13) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID())
				};
			} else if(wartung_max == 14) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID())
				};
			} else if(wartung_max == 15) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID())
				};
			} else if(wartung_max == 16) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID())
				};
			} else if(wartung_max == 17) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID())
				};
			} else if(wartung_max == 18) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID())
				};
			} else if(wartung_max == 19) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(18), UUID.randomUUID())
				};
			} else if(wartung_max == 20) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(19), UUID.randomUUID())
				};
			} else if(wartung_max == 21) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(19), UUID.randomUUID())
				};
			} else if(wartung_max == 22) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(20), UUID.randomUUID())
				};
			} else if(wartung_max == 23) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(21), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(22), UUID.randomUUID())
				};
			} else if(wartung_max == 24) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(21), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(22), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(23), UUID.randomUUID())
				};
			} else if(wartung_max == 25) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(20), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(21), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(22), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(23), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(24), UUID.randomUUID())
				};
			} else if(wartung_max >= 25) {
				wartung_sampel_DE = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(20), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(21), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(22), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(23), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(24), UUID.randomUUID())
				};
			}
		} catch(Exception ex) {
		}
	}
	
	public static void load_EN() {
		File f = new File("plugins/BungeeSystem/MOTD_Config_EN.yml");
		try {
			if(!f.exists()) {
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				fw.write("Name=LivePlays.net");
				fw.write("\nDescripton=LivePlays.net");
				fw.write("\nPing1=Hallo");
				fw.write("\nPing2=Das");
				fw.write("\nPing3=ist ein");
				fw.write("\nPing4=Test");
				fw.write("\n\n");
				fw.write("\nWartung_Name=LivePlays.net");
				fw.write("\nWartung_Descripton=LivePlays.net");
				fw.write("\nWartung_Ping1=Hallo");
				fw.write("\nWartung_Ping2=Das");
				fw.write("\nWartung_Ping3=ist ein");
				fw.write("\nWartung_Ping4=Test");
				fw.close();
			}
			ArrayList<String> sampels = new ArrayList<>();
			ArrayList<String> wartung_sampels = new ArrayList<>();
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String s = sc.nextLine();
				try {
					if(s.startsWith("Name=")) {
						name_EN = s.replaceFirst("Name=", "").replaceAll("&", "§");
					} else if(s.startsWith("Descripton=")) {
						description_EN = s.replaceFirst("Descripton=", "").replaceAll("&", "§");
					} else if(s.startsWith("Ping")) {
						sampels.add(s.replaceFirst(s.split("=")[0]+"=", "").replaceAll("&", "§"));
					}
					if(s.startsWith("Wartung_Name=")) {
						wartung_name_EN = s.replaceFirst("Wartung_Name=", "").replaceAll("&", "§");
					} else if(s.startsWith("Wartung_Descripton=")) {
						wartung_description_EN = s.replaceFirst("Wartung_Descripton=", "").replaceAll("&", "§");
					} else if(s.startsWith("Wartung_Ping")) {
						wartung_sampels.add(s.replaceFirst(s.split("=")[0]+"=", "").replaceAll("&", "§"));
					}
				} catch(Exception ex) {
					ProxyServer.getInstance().broadcast(new TextComponent(main.prefix+"§4Fehler bei in der MOTD Config EN:"+s));
				}
			}
			sc.close();			Integer max = sampels.size();
			if(max == 0) {
				sampel_EN = null;
			} else if(max == 1) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID())
				};
			} else if(max == 2) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID())
				};
			} else if(max == 3) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID())
				};
			} else if(max == 4) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID())
				};
			} else if(max == 5) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID())
				};
			} else if(max == 6) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
				};
			} else if(max == 7) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID())
				};
			} else if(max == 8) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID())
				};
			} else if(max == 9) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID())
				};
			} else if(max == 10) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID())
				};
			} else if(max == 11) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID())
				};
			} else if(max == 12) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID())
				};
			} else if(max == 13) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID())
				};
			} else if(max == 14) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID())
				};
			} else if(max == 15) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID())
				};
			} else if(max == 16) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID())
				};
			} else if(max == 17) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID())
				};
			} else if(max == 18) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID())
				};
			} else if(max == 19) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(18), UUID.randomUUID())
				};
			} else if(max == 20) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(19), UUID.randomUUID())
				};
			} else if(max == 21) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(19), UUID.randomUUID())
				};
			} else if(max == 22) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(20), UUID.randomUUID())
				};
			} else if(max == 23) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(21), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(22), UUID.randomUUID())
				};
			} else if(max == 24) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(21), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(22), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(23), UUID.randomUUID())
				};
			} else if(max == 25) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(20), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(21), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(22), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(23), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(24), UUID.randomUUID())
				};
			} else if(max >= 25) {
				sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(20), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(21), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(22), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(23), UUID.randomUUID()),
						new ServerPing.PlayerInfo(sampels.get(24), UUID.randomUUID())
				};
			}
			
			Integer wartung_max = wartung_sampels.size();
			if(wartung_max == 0) {
				wartung_sampel_EN = null;
			} else if(wartung_max == 1) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID())
				};
			} else if(wartung_max == 2) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID())
				};
			} else if(wartung_max == 3) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID())
				};
			} else if(wartung_max == 4) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID())
				};
			} else if(wartung_max == 5) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID())
				};
			} else if(wartung_max == 6) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
				};
			} else if(wartung_max == 7) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID())
				};
			} else if(wartung_max == 8) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID())
				};
			} else if(wartung_max == 9) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID())
				};
			} else if(wartung_max == 10) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID())
				};
			} else if(wartung_max == 11) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID())
				};
			} else if(wartung_max == 12) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID())
				};
			} else if(wartung_max == 13) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID())
				};
			} else if(wartung_max == 14) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID())
				};
			} else if(wartung_max == 15) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID())
				};
			} else if(wartung_max == 16) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID())
				};
			} else if(wartung_max == 17) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID())
				};
			} else if(wartung_max == 18) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID())
				};
			} else if(wartung_max == 19) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(18), UUID.randomUUID())
				};
			} else if(wartung_max == 20) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(19), UUID.randomUUID())
				};
			} else if(wartung_max == 21) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(19), UUID.randomUUID())
				};
			} else if(wartung_max == 22) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(20), UUID.randomUUID())
				};
			} else if(wartung_max == 23) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(21), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(22), UUID.randomUUID())
				};
			} else if(wartung_max == 24) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(21), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(22), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(23), UUID.randomUUID())
				};
			} else if(wartung_max == 25) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(20), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(21), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(22), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(23), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(24), UUID.randomUUID())
				};
			} else if(wartung_max >= 25) {
				wartung_sampel_EN = new ServerPing.PlayerInfo[] {
						new ServerPing.PlayerInfo(wartung_sampels.get(0), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(1), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(2), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(3), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(4), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(5), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(6), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(7), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(8), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(9), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(10), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(11), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(12), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(13), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(14), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(15), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(16), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(17), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(18), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(19), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(20), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(21), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(22), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(23), UUID.randomUUID()),
						new ServerPing.PlayerInfo(wartung_sampels.get(24), UUID.randomUUID())
				};
			}
		} catch(Exception ex) {
		}
	}
}