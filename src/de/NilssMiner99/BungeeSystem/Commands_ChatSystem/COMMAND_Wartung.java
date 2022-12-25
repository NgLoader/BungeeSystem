package de.NilssMiner99.BungeeSystem.Commands_ChatSystem;

import de.NilssMiner99.BungeeSystem.Manager.UUIDFeature;
import de.NilssMiner99.BungeeSystem.Manager.WartungManager;
import de.NilssMiner99.BungeeSystem.main.main;
import de.NilssMiner99.mongodb_Bungee.MongoDB.Global_Players;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_Wartung extends Command {

	public COMMAND_Wartung(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender.hasPermission("liveplays.admin"))) {
			sender.sendMessage(new TextComponent(main.noperm));
			return;
		}
		if(args.length == 0) {
			sender.sendMessage(new TextComponent("§8[]§7----------------- §4WartungsSystem §7-----------------§8[]"));
			sender.sendMessage(new TextComponent(" "));
			sender.sendMessage(new TextComponent("§e/Wartung §eon §8| §3Um §3die §3Wartung §3zu §3Aktivieren§8."));
			sender.sendMessage(new TextComponent("§e/Wartung §eoff §8| §3Um §3die §3Wartung §3zu §3Deaktivieren§8."));
			sender.sendMessage(new TextComponent("§e/Wartung §elist §8| §3Listet §3die §3gewhitelistete §3Spieler §3auf§8."));
			sender.sendMessage(new TextComponent("§e/Wartung §eadd §e<Player> §8| §3Einen §3Spieler §3der §3whitelist §3zu §3adden§8."));
			sender.sendMessage(new TextComponent("§e/Wartung §eremove §e<Player> §8| §3Einen §3Spieler §3aus §3der §3whitelist §3zu §3löschen§8."));
			sender.sendMessage(new TextComponent(" "));
			sender.sendMessage(new TextComponent("§8[]§7----------------- §4WartungsSystem §7-----------------§8[]"));
			return;
		} else if(args.length == 1) {
			if(args[0].equalsIgnoreCase("on")) {
				if(WartungManager.wartung == true) {
					sender.sendMessage(new TextComponent(main.prefix_wartung+"§cDie §cWartung §cist §cschon §can§8."));
					return;
				}
				for(ProxiedPlayer target : ProxyServer.getInstance().getPlayers()) {
					if(!(target.hasPermission("liveplays.team"))) {
						if(!(WartungManager.whitelist.contains(target.getUniqueId().toString()))) {
							Global_Players gplayer = Global_Players.getPlayer(de.NilssMiner99.mongodb_Bungee.main.main.plugin, target.getUniqueId().toString());
							if(gplayer.getLanguage().equalsIgnoreCase("DE")) {
								target.disconnect(new TextComponent(WartungManager.KickMessage_DE));
							} else {
								target.disconnect(new TextComponent(WartungManager.KickMessage_EN));
							}
						}
					}
				}
				WartungManager.setWartung(true);
				sender.sendMessage(new TextComponent(main.prefix_wartung+"§3Du §3hast §3die §3Wartung §3Aktiviert§8."));
				return;
			} else if(args[0].equalsIgnoreCase("off")) {
				if(WartungManager.wartung == false) {
					sender.sendMessage(new TextComponent(main.prefix_wartung+"§cDie §cWartung §cist §cschon §caus§8."));
					return;
				}
				WartungManager.setWartung(false);
				sender.sendMessage(new TextComponent(main.prefix_wartung+"§3Du §3hast §3die §3Wartung §3Deaktiviert§8."));
				return;
			} else if(args[0].equalsIgnoreCase("list")) {
				sender.sendMessage(new TextComponent("§8[]§7----------------- §4Wartungs §4liste §7-----------------§8[]"));
				sender.sendMessage(new TextComponent(" "));
				for(String uuid : WartungManager.whitelist) {
					sender.sendMessage(new TextComponent("          §8- §3"+UUIDFeature.getName(uuid)));
				}
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§8[]§7----------------- §4Wartungs §4liste §7-----------------§8[]"));
				return;
			}
		} else if(args.length >= 2 && args.length <= 2) {
			if(args[0].equalsIgnoreCase("add")) {
				if(UUIDFeature.getUUID(args[1]) != null && UUIDFeature.getUUID(args[1]) != "") {
					if(WartungManager.whitelist.contains(UUIDFeature.getUUID(args[1]))) {
						sender.sendMessage(new TextComponent(main.prefix_wartung+"§cDer §cSpieler §cist §cschon §cin §cder §cWhitelist§8."));
						return;
					}
					WartungManager.add(UUIDFeature.getUUID(args[1]));
					sender.sendMessage(new TextComponent(main.prefix_wartung+"§3Du §3hast §3den §3Spieler §e"+UUIDFeature.getName(UUIDFeature.getUUID(args[1]))+" §3in §3die §3Whitelist §3geadded§8."));
					return;
				}
				sender.sendMessage(new TextComponent(main.prefix_wartung+"§cDieser §cSpieler §cwahr §cnoch §cnie §cauf §cdieser §cServer§8."));
				return;
			} else if(args[0].equalsIgnoreCase("remove")) {
				if(UUIDFeature.getUUID(args[1]) != null && UUIDFeature.getUUID(args[1]) != "") {
					if(WartungManager.whitelist.contains(UUIDFeature.getUUID(args[1]))) {
						WartungManager.remove(UUIDFeature.getUUID(args[1]));
						sender.sendMessage(new TextComponent(main.prefix_wartung+"§3Du §3hast §3den §3Spieler §e"+UUIDFeature.getName(UUIDFeature.getUUID(args[1]))+" §3aus §3die §3Whitelist §3gelöscht§8."));
						return;
					}
					sender.sendMessage(new TextComponent(main.prefix_wartung+"§cDer §cSpieler §cist §cnicht §cin §cder §cWhitelist§8."));
					return;
				}
				sender.sendMessage(new TextComponent(main.prefix_wartung+"§cDieser §cSpieler §cwahr §cnoch §cnie §cauf §cdieser §cServer§8."));
				return;
			}
		}
		sender.sendMessage(new TextComponent("§8[]§7----------------- §4WartungsSystem §7-----------------§8[]"));
		sender.sendMessage(new TextComponent(" "));
		sender.sendMessage(new TextComponent("§e/Wartung §eon §8| §3Um §3die §3Wartung §3zu §3Aktivieren§8."));
		sender.sendMessage(new TextComponent("§e/Wartung §eoff §8| §3Um §3die §3Wartung §3zu §3Deaktivieren§8."));
		sender.sendMessage(new TextComponent("§e/Wartung §elist §8| §3Listet §3die §3gewhitelistete §3Spieler §3auf§8."));
		sender.sendMessage(new TextComponent("§e/Wartung §eadd §e<Player> §8| §3Einen §3Spieler §3der §3whitelist §3zu §3adden§8."));
		sender.sendMessage(new TextComponent("§e/Wartung §eremove §e<Player> §8| §3Einen §3Spieler §3aus §3der §3whitelist §3zu §3löschen§8."));
		sender.sendMessage(new TextComponent(" "));
		sender.sendMessage(new TextComponent("§8[]§7----------------- §4WartungsSystem §7-----------------§8[]"));
	}
}