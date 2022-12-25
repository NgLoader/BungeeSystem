package de.NilssMiner99.BungeeSystem.main;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TimeZone;

import de.NilssMiner99.BungeeSystem.Commands_BanSystem.COMMAND_Ban;
import de.NilssMiner99.BungeeSystem.Commands_BanSystem.COMMAND_TempBan;
import de.NilssMiner99.BungeeSystem.Commands_BanSystem.COMMAND_UnBan;
import de.NilssMiner99.BungeeSystem.Commands_ChatSystem.COMMAND_ChatSystem;
import de.NilssMiner99.BungeeSystem.Commands_ChatSystem.COMMAND_Wartung;
import de.NilssMiner99.BungeeSystem.Commands_ETC.COMMAND_BungeeSystem;
import de.NilssMiner99.BungeeSystem.Commands_ETC.COMMAND_Check;
import de.NilssMiner99.BungeeSystem.Commands_ETC.COMMAND_Glist;
import de.NilssMiner99.BungeeSystem.Commands_ETC.COMMAND_Jump;
import de.NilssMiner99.BungeeSystem.Commands_ETC.COMMAND_Kick;
import de.NilssMiner99.BungeeSystem.Commands_ETC.COMMAND_setRank;
import de.NilssMiner99.BungeeSystem.Commands_Freunde.FreundeCommand;
import de.NilssMiner99.BungeeSystem.Commands_LobbySystem.Command_Help;
import de.NilssMiner99.BungeeSystem.Commands_LobbySystem.Command_Hub;
import de.NilssMiner99.BungeeSystem.Commands_MuteSystem.COMMAND_Mute;
import de.NilssMiner99.BungeeSystem.Commands_MuteSystem.COMMAND_UnMute;
import de.NilssMiner99.BungeeSystem.Commands_Party.PartyCommand;
import de.NilssMiner99.BungeeSystem.Commands_Team.COMMAND_AFK;
import de.NilssMiner99.BungeeSystem.Commands_Team.COMMAND_Notify;
import de.NilssMiner99.BungeeSystem.Commands_Team.COMMAND_Team;
import de.NilssMiner99.BungeeSystem.Listeners.ChatEvent_Listener;
import de.NilssMiner99.BungeeSystem.Listeners.PlayerDisconnectEvent_Listener;
import de.NilssMiner99.BungeeSystem.Listeners.PostLoginEvent_Listener;
import de.NilssMiner99.BungeeSystem.Listeners.ProxyPingEvent_Listener;
import de.NilssMiner99.BungeeSystem.Listeners.ServerKickEvent_Listener;
import de.NilssMiner99.BungeeSystem.Listeners.ServerSwitchEvent_Listener;
import de.NilssMiner99.BungeeSystem.Manager.BlackList;
import de.NilssMiner99.BungeeSystem.Manager.MotdManager;
import de.NilssMiner99.BungeeSystem.Manager.NotifyManager;
import de.NilssMiner99.BungeeSystem.Manager.RangTemplates;
import de.NilssMiner99.BungeeSystem.Manager.ServerManager;
import de.NilssMiner99.BungeeSystem.Manager.StatsManager;
import de.NilssMiner99.BungeeSystem.Manager.Templates;
import de.NilssMiner99.BungeeSystem.Manager.WartungManager;
import de.NilssMiner99.BungeeSystem.Manager.WhitelistManager;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;

public class main extends Plugin {
	
	public static ArrayList<String> afk = new ArrayList<>();

	public static String prefix = "§5»§cSystem§5« ";
	public static String prefix_bs = "§5»§4Ban§cSystem§5« ";
	public static String prefix_cs = "§5»§4Chat§cSystem§5« ";
	public static String prefix_ms = "§5»§4Mute§cSystem§5« ";
	public static String prefix_party = "§5»§4Party§5« ";
	public static String prefix_wartung = "§5»§4Wartung§5« ";
	public static String prefix_tc = "§5»§4TeamChat§5« ";
	public static String prefix_freunde = "§5»§4Freunde§5« ";
	public static String noperm = "§5»§4System§5« §cDu hast keine §4Rechte §cdas zu machen.";
	
	SimpleDateFormat dateFormat;
	
	public static main plugin;
	
	/*
	 * 
	 * Permissons:
	 * 
	 * bansystem.ban
	 * bansystem.check
	 * bansystem.unban
	 * bansystem.tempban
	 * bansystem.check
	 * 
	 * 
	 * Danke fürs zuschauen :D
	 * 
	 */
	
	@SuppressWarnings("static-access")
	public void onEnable() {
		
		this.plugin = this;
		
		/* RegisterTemplates */
		RegisterTemplates();
		
		/* RegisterTemplates */
		RegisterPlayTime();
		
		/* RegisterConfig */
		RegisterConfig();
		
		/* RegisterListeners */
		RegisterListeners();
		
		/* RegisterCommands */
		RegisterCommands();
		
		/* RegisterDateManager */
		RegisterDateManager();
		
		ProxyServer.getInstance().getConsole().sendMessage(new TextComponent("§3Plugin§7: §6BungeeSystem §9| §3By§7: §6NilssMiner99 §9| §3Version§7: §6"+getDescription().getVersion()+" §9| §3Status§7: §aAktiviert"));
	}
	
	public void onDisable() {
		ProxyServer.getInstance().getConsole().sendMessage(new TextComponent("§3Plugin§7: §6BungeeSystem §9| §3By§7: §6NilssMiner99 §9| §3Version§7: §6"+getDescription().getVersion()+" §9| §3Status§7: §cDeaktiviert"));
	}
	
	public static void RegisterConfig() {
		File f = new File("plugins/BungeeSystem/Config.yml");
		try {
			if(!f.exists()) {
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				fw.write("Prefix=§5»§cSystem§5«");
				fw.write("\nPrefix_Ban=§5»§4Ban§cSystem§5«");
				fw.write("\nPrefix_Mute=§5»§4Mute§cSystem§5«");
				fw.write("\nPrefix_ChatSystem=§5»§4Chat§cSystem§5«");
				fw.write("\nPrefix_Party=§5»§4Party§5«");
				fw.write("\nPrefix_Wartung=§5»§4Wartung§5«");
				fw.write("\nPrefix_Teamchat=§5»§4TeamChat§5« ");
				fw.write("\nPrefix_Freunde=§5»§4Freunde§5« ");
				fw.write("\nNoPerm=§5»§4System§5« §cDu hast keine §4Rechte §cdas zu machen.");
				fw.close();
			}
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()) {
				String s = sc.nextLine();
				if(s.contains("Prefix=")) {
					main.prefix = s.split("=")[1].replaceAll("&", "§")+" ";
				} else if(s.contains("NoPerm=")) {
					main.noperm = s.split("=")[1].replaceAll("&", "§");
				} else if(s.contains("Prefix_Ban=")) {
					main.prefix_bs = s.split("=")[1].replaceAll("&", "§")+" ";
				} else if(s.contains("Prefix_ChatSystem=")) {
					main.prefix_cs = s.split("=")[1].replaceAll("&", "§")+" ";
				} else if(s.contains("Prefix_Mute=")) {
					main.prefix_ms = s.split("=")[1].replaceAll("&", "§")+" ";
				} else if(s.contains("Prefix_Party=")) {
					main.prefix_party = s.split("=")[1].replaceAll("&", "§")+" ";
				} else if(s.contains("Prefix_Teamchat=")) {
					main.prefix_tc = s.split("=")[1].replaceAll("&", "§")+" ";
				} else if(s.contains("Prefix_Wartung=")) {
					main.prefix_wartung = s.split("=")[1].replaceAll("&", "§")+" ";
				} else if(s.contains("Prefix_Freunde=")) {
					main.prefix_freunde = s.split("=")[1].replaceAll("&", "§")+" ";
				}
			}
			sc.close();
		} catch(Exception ex) {
		}
	}
	
	private void RegisterListeners() {
		ProxyServer.getInstance().getPluginManager().registerListener(main.plugin, new PostLoginEvent_Listener());
		ProxyServer.getInstance().getPluginManager().registerListener(main.plugin, new ChatEvent_Listener());
		ProxyServer.getInstance().getPluginManager().registerListener(main.plugin, new PlayerDisconnectEvent_Listener());
		ProxyServer.getInstance().getPluginManager().registerListener(main.plugin, new ServerKickEvent_Listener());
		ProxyServer.getInstance().getPluginManager().registerListener(main.plugin, new ServerSwitchEvent_Listener());
		ProxyServer.getInstance().getPluginManager().registerListener(main.plugin, new ProxyPingEvent_Listener());
	}
	
	private void RegisterCommands() {
		/* TeamCommands */
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_Notify("notify"));
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_Team("team"));
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_AFK("afk"));
		/* EtcCommands */
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_BungeeSystem("bungeesystem"));
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_Check("check"));
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_Kick("kick"));
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_Wartung("wartung"));
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_setRank("setrank"));
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_Glist("glist"));
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_Glist("list"));
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_Jump("jump"));
		/* BanSystemCommands */
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_UnBan("unban"));
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_UnBan("pardon"));
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_Ban("ban"));
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_TempBan("tempban"));
		/* MuteSystemCommands */
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_Mute("mute"));
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_UnMute("unmute"));
		/* ChatSystemCommands */
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_ChatSystem("chatsystem"));
		ProxyServer.getInstance().getPluginManager().registerCommand(main.plugin, new COMMAND_ChatSystem("cs"));
		/* LobbySystemCommands */
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new Command_Hub("lobby"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new Command_Hub("hub"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new Command_Hub("leave"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new Command_Hub("l"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new Command_Hub("quit"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new Command_Hub("h"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new Command_Help("help"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new Command_Help("info"));
		/* PartySystemCommands */
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new PartyCommand());
		/* FreundeSystemCommands */
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new FreundeCommand());
	}
	
	private void RegisterTemplates() {
		WhitelistManager.load();
		ServerManager.load();
		NotifyManager.load();
		RangTemplates.load();
		BlackList.load();
		WartungManager.load();
		MotdManager.load();
		Templates.load();
	}
	
	private void RegisterDateManager() {
		dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
	}
	
	private void RegisterPlayTime() {
		StatsManager.startPlayTimeCounter();
	}
	
	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}
}