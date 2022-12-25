package de.NilssMiner99.BungeeSystem.Commands_LobbySystem;

import java.util.UUID;

import de.NilssMiner99.BungeeSystem.Manager.UUIDFeature;
import de.NilssMiner99.mongodb_Bungee.MongoDB.Global_Players;
import de.NilssMiner99.mongodb_Bungee.main.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Command_Help extends Command {

	public Command_Help(String name) {
		super(name);
	}
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer p = ProxyServer.getInstance().getPlayer(UUID.fromString(UUIDFeature.getUUID(sender.getName())));
			Global_Players player = Global_Players.getPlayer(main.plugin, p.getUniqueId().toString());
			/*
			 * Lobby
			 * Party
			 * Friend
			 * Report
			 * Team
			 * AFK
			 * List
			 * ChatSystem
			 */
			if(player.getLanguage().equalsIgnoreCase("DE")) {
				sender.sendMessage(new TextComponent("§8[]§7----------------- §4Informationen §7-----------------§8[]"));
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§e/Lobby §3Um §3in §3die §3Lobby §3zu §3gelangen§8."));
				sender.sendMessage(new TextComponent("§e/Party §3Um §3mit §3deinen §3§8."));
				sender.sendMessage(new TextComponent("§e/Friend §3Verwalte §3deine §3Freunde§8."));
				sender.sendMessage(new TextComponent("§e/Report §3 §3einen §3Spieler §3zu §3Reporten§8."));
				sender.sendMessage(new TextComponent("§3Weitere §3Infos §3bei §3uns §3im §bForum§3§7: §eLivePlays.net\n"
						+ "§3Infos zu §6Premium §3und §6mehr§7: §eLivePlays.net/shop"));
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§8[]§7----------------- §4Informationen §7-----------------§8[]"));
			} else {
				sender.sendMessage(new TextComponent("§8[]§7----------------- §4Informationen §7-----------------§8[]"));
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§e/Lobby §3Kehrt §3zur §3Haupt-Lobby §3zurück§8."));
				sender.sendMessage(new TextComponent("§e/Party §3Spiele §3mit §3Freunden §3in §3einer Party§8."));
				sender.sendMessage(new TextComponent("§e/Friend §3Verwalte §3deine §3Freunde§8."));
				sender.sendMessage(new TextComponent("§e/Report §3Um §3einen §3Spieler §3zu §3Reporten§8."));
				sender.sendMessage(new TextComponent("§3More §3Info's §3find §3you §3on§7: §eLivePlays.net\n"
						+ "§3Info's to §6Premium §3and §6more§7: §eLivePlays.net/Shop"));
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§8[]§7----------------- §4Informationen §7-----------------§8[]"));
			}
		} else {
			sender.sendMessage(new TextComponent("§8[]§7----------------- §4Informationen §7-----------------§8[]"));
			sender.sendMessage(new TextComponent(" "));
			sender.sendMessage(new TextComponent("§e/Lobby §3Kehrt §3zur §3Haupt-Lobby §3zurück§8."));
			sender.sendMessage(new TextComponent("§e/Party §3Spiele §3mit §3Freunden §3in §3einer Party§8."));
			sender.sendMessage(new TextComponent("§e/Freund §3Verwalte §3deine §3Freunde§8."));
			sender.sendMessage(new TextComponent("§e/Report §3Um §3einen §3Spieler §3zu §3Reporten§8."));
			sender.sendMessage(new TextComponent("§3Weitere §3Infos §3bei §3uns §3im §bForum§3§7: §eLivePlays.net\n"
					+ "§3Infos zu §6Premium §3und §6mehr§7: §eLivePlays.net/shop"));
			sender.sendMessage(new TextComponent(" "));
			sender.sendMessage(new TextComponent("§8[]§7----------------- §4Informationen §7-----------------§8[]"));
		}
		return;
	}
}