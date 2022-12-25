package de.NilssMiner99.BungeeSystem.Commands_BanSystem;

import de.NilssMiner99.BungeeSystem.Manager.BanSystem;
import de.NilssMiner99.BungeeSystem.Manager.GruppenManager;
import de.NilssMiner99.BungeeSystem.Manager.Templates;
import de.NilssMiner99.BungeeSystem.Manager.UUIDFeature;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_Ban extends Command {
	
	public COMMAND_Ban(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!sender.hasPermission("liveplays.ban")) {
			sender.sendMessage(new TextComponent(main.noperm));
			return;
		}
		if(args.length == 0) {
			sender.sendMessage(new TextComponent(main.prefix_bs+"§3Verwendung§8: §e/Ban §e<Spieler> §e<Template>"));
			sender.sendMessage(new TextComponent(main.prefix_bs+"§3Verwendung§8: §e/Ban §eTemplates"));
			return;
		} else if(args.length == 1) {
			if(args[0].equalsIgnoreCase("t") || args[0].equalsIgnoreCase("temp") || args[0].equalsIgnoreCase("templates") || args[0].equalsIgnoreCase("tp")) {
				sender.sendMessage(new TextComponent("§8[]§7----------------- §4Ban §cTemplates §7-----------------§8[]"));
				sender.sendMessage(new TextComponent(" "));
				for(String s : Templates.BAN_namen.keySet()) {
					sender.sendMessage(new TextComponent("        §3"+s+" §8- §3"+Templates.BAN_namen.get(s)+" §8- §e"+Templates.BAN_zeiten.get(s).replaceAll(" ", "§8T§e ")));
				}
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§8[]§7----------------- §4Ban §cTemplates §7-----------------§8[]"));
				return;
			}
		} else if(args.length >= 2 && args.length <= 2) {
			if(UUIDFeature.getUUID(args[0]) != null && UUIDFeature.getUUID(args[0]) != "") {
				if(BanSystem.isBanned(UUIDFeature.getUUID(args[0])) == true) {
					sender.sendMessage(new TextComponent(main.prefix_bs+"§cDer §cSpieler §cist §cschon §cgebannt§8."));
					return;
				}
				if(sender instanceof ProxiedPlayer) {
					String target = UUIDFeature.getUUID(args[0]);
					if(!(GruppenManager.hasPermissons(UUIDFeature.getUUID(sender.getName()), "liveplays.admin"))) {
						if(GruppenManager.hasPermissons(target, "liveplays.admin")) {
							sender.sendMessage(new TextComponent(main.prefix_bs+"§cDu kannst den Spieler §e"+UUIDFeature.getName(target)+" §cnicht bannen§8."));
							return;
						} else {
							if(GruppenManager.hasPermissons(target, "liveplays.team")) {
								sender.sendMessage(new TextComponent(main.prefix_bs+"§cDu kannst den Spieler §e"+UUIDFeature.getName(target)+" §cnicht bannen§8."));
								return;
							}
						}
					}
				}
				Templates.bantemplate(sender, UUIDFeature.getUUID(args[0]), args[1]);
//				BanSystem.addBan(UUIDFeature.getUUID(args[0]), -1, text, sender instanceof ProxiedPlayer ? UUIDFeature.getUUID(sender.getName()) : "CONSOLE");
//				sender.sendMessage(new TextComponent(main.prefix_bs+"§cDu hast den §3Spieler §6"+UUIDFeature.getName(UUIDFeature.getUUID(args[0]))+" §4Permanent §3Gebannt§e."));
				return;
			}
			sender.sendMessage(new TextComponent(main.prefix_bs+"§cDieser §cSpieler §cwar §cnoch §cnie §cauf §cdem §cNetzwerk§8."));
			return;
		}
		sender.sendMessage(new TextComponent(main.prefix_bs+"§3Verwendung§8: §e/Ban §e<Spieler> §e<Template>"));
		sender.sendMessage(new TextComponent(main.prefix_bs+"§3Verwendung§8: §e/Ban §eTemplates"));
		return;
	}
}