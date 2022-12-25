package de.NilssMiner99.BungeeSystem.Manager;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class FreundeManager {

	public static Boolean Settings_Invites(String uuid) {
		return getSettingsData(uuid).get(0);
	}
	
	public static Boolean Settings_Nachrichten(String uuid) {
		return getSettingsData(uuid).get(1);
	}
	
	public static Boolean Settings_Teleport(String uuid) {
		return getSettingsData(uuid).get(2);
	}
	
	public static Boolean Settings_Joinmessage(String uuid) {
		return getSettingsData(uuid).get(3);
	}
	
	/*
	 * 0 Invite
	 * 1 Nachrichten
	 * 2 Teleport
	 * 3 Joinmessage
	 */

	public static void ClearallFriends(String uuid) {
		for(UUID friend : FreundeManager.getFreunde(uuid)) {
			FreundeManager.removeFreund(friend.toString(), uuid.toString());
			FreundeManager.removeFreund(uuid, friend.toString());
		}
		File f = new File("plugins/BungeeSystem/FreundeSystem/Freunde/"+uuid+".yml");
		if(f.exists()) {
			f.deleteOnExit();
		}
	}
	
	public static void ClearallFriendRequests(String uuid) {
		for(UUID friend : FreundeManager.getInvites(uuid)) {
			FreundeManager.removeInvite(friend.toString(), uuid.toString());
			FreundeManager.removeInvite(uuid, friend.toString());
		}
		File f = new File("plugins/BungeeSystem/FreundeSystem/Invites/"+uuid+".yml");
		if(f.exists()) {
			f.deleteOnExit();
		}
	}
	
	public static HashMap<Integer, Boolean> getSettingsData(String uuid) {
		HashMap<Integer, Boolean> data = new HashMap<>();
		
		File f = new File("plugins/BungeeSystem/FreundeSystem/Settings/"+uuid+".yml");
		try {
			if(!f.exists()) {
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				fw.write("Invite=true");
				fw.write("\nNachrichten=true");
				fw.write("\nTeleport=true");
				fw.write("\nJoinmessage=true");
				fw.close();
			}
			Scanner sc = new Scanner(f);
			try {
				while(sc.hasNextLine()) {
					String s = sc.nextLine();
					if(s.split("=")[0].equalsIgnoreCase("Invite")) {
						data.put(0, Boolean.valueOf(s.split("=")[1]));
					} else if(s.split("=")[0].equalsIgnoreCase("Nachrichten")) {
						data.put(1, Boolean.valueOf(s.split("=")[1]));
					} else if(s.split("=")[0].equalsIgnoreCase("Teleport")) {
						data.put(2, Boolean.valueOf(s.split("=")[1]));
					} else if(s.split("=")[0].equalsIgnoreCase("Joinmessage")) {
						data.put(3, Boolean.valueOf(s.split("=")[1]));
					}
				}
			} catch(Exception ex) {
				System.out.println("§cFehler §cbeim §cFreundeSystem §cin §cder §cSettings §cdatei§8: §c"+f.getName());
				}
			sc.close();
		} catch(Exception ex) {
		}
		
		return data;
	}
	
	public static Boolean hasFreund(String uuid, String targetuuid) {
		if(getFreunde(uuid).contains(UUID.fromString(targetuuid))) {
			return true;
		}
		return false;
	}
	
	public static Boolean hasInvite(String uuid, String targetuuid) {
		if(getInvites(uuid).contains(UUID.fromString(targetuuid))) {
			return true;
		}
		return false;
	}
	
	public static ArrayList<UUID> getFreunde(String uuid) {
		ArrayList<UUID> friends = new ArrayList<>();
		File f = new File("plugins/BungeeSystem/FreundeSystem/Freunde/"+uuid+".yml");
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			Scanner sc = new Scanner(f);
			try {
				while(sc.hasNextLine()) {
					String target = sc.nextLine();
					if(target != "" && target != " ") {
						friends.add(UUID.fromString(target));
					}
				}
			} catch(Exception ex) {
				System.out.println("§cFehler §cbeim §cFreundeSystem §cin §cder §cFreunde §cdatei§8: §c"+f.getName());
			}
			sc.close();
		} catch(Exception ex) {
		}
		return friends;
	}
	
	public static void addFreund(String uuid, String targetuuid) {
		File f = new File("plugins/BungeeSystem/FreundeSystem/Freunde/"+uuid+".yml");
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			try {
				for(UUID friends : getFreunde(uuid)) {
					fw.write(friends+"\n");
				}
				fw.write(targetuuid+"\n");
			} catch(Exception ex) {
			}
			fw.close();
		} catch(Exception ex) {
		}
	}
	
	public static void removeFreund(String uuid, String targetuuid) {
		File f = new File("plugins/BungeeSystem/FreundeSystem/Freunde/"+uuid+".yml");
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			try {
				for(UUID friends : getFreunde(uuid)) {
					if(friends.toString() != targetuuid) {
						fw.write(friends+"\n");
					}
				}
			} catch(Exception ex) {
			}
			fw.close();
		} catch(Exception ex) {
		}
	}
	
	public static ArrayList<UUID> getInvites(String uuid) {
		ArrayList<UUID> friends = new ArrayList<>();
		File f = new File("plugins/BungeeSystem/FreundeSystem/Invites/"+uuid+".yml");
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			Scanner sc = new Scanner(f);
			try {
				while(sc.hasNextLine()) {
					String target = sc.nextLine();
					friends.add(UUID.fromString(target));
				}
			} catch(Exception ex) {
				System.out.println("§cFehler §cbeim §cFreundeSystem §cin §cder §cInvites §cdatei§8: §c"+f.getName());
			}
			sc.close();
		} catch(Exception ex) {
		}
		return friends;
	}
	
	public static void addInvite(String uuid, String targetuuid) {
		File f = new File("plugins/BungeeSystem/FreundeSystem/Invites/"+uuid+".yml");
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			try {
				for(UUID friends : getFreunde(uuid)) {
					fw.write(friends+"\n");
				}
				fw.write(targetuuid+"\n");
			} catch(Exception ex) {
			}
			fw.close();
		} catch(Exception ex) {
		}
	}
	
	public static void removeInvite(String uuid, String targetuuid) {
		File f = new File("plugins/BungeeSystem/FreundeSystem/Invites/"+uuid+".yml");
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			FileWriter fw = new FileWriter(f);
			try {
				for(UUID friends : getFreunde(uuid)) {
					if(friends.toString() != targetuuid) {
						fw.write(friends+"\n");
					}
				}
			} catch(Exception ex) {
			}
			fw.close();
		} catch(Exception ex) {
		}
	}
}