package de.NilssMiner99.BungeeSystem.Manager;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BlackList {

	public static ArrayList<String> blacklistword = new ArrayList<>();
	public static HashMap<String, String> blacklistword_hard = new HashMap<>();
	
	public static void load() {
		blacklistword.clear();
		blacklistword_hard.clear();
		try {
			File f = new File("plugins/BungeeSystem/BlackListWords.yml");
			if(!f.exists()) {
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				fw.write("wixxer");
				fw.close();
			}
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				try {
					blacklistword.add(sc.nextLine());
				} catch(Exception ex) {
				}
			}
			sc.close();
		} catch(Exception ex) {
		}
		try {
			File f = new File("plugins/BungeeSystem/BlackListWords_HARD.yml");
			if(!f.exists()) {
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				fw.write("hurensohn//B");
				fw.close();
			}
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				try {
					String s = sc.nextLine();
					blacklistword_hard.put(s.split("//")[0], s.split("//")[1]);
				} catch(Exception ex) {
				}
			}
			sc.close();
		} catch(Exception ex) {
		}
	}
}