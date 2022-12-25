package de.NilssMiner99.BungeeSystem.Commands_MuteSystem;

import de.NilssMiner99.BungeeSystem.Manager.GruppenManager;
import de.NilssMiner99.BungeeSystem.Manager.MuteSystem;
import de.NilssMiner99.BungeeSystem.Manager.Templates;
import de.NilssMiner99.BungeeSystem.Manager.UUIDFeature;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_Mute extends Command {
	
	public COMMAND_Mute(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!sender.hasPermission("liveplays.mute")) {
			sender.sendMessage(new TextComponent(main.noperm));
			return;
		}
		if(args.length == 0) {
			sender.sendMessage(new TextComponent(main.prefix_ms+"§3Verwendung§8: §e/Mute §e<Spieler> §e<Template>"));
			sender.sendMessage(new TextComponent(main.prefix_ms+"§3Verwendung§8: §e/Mute §eTemplates"));
			return;
		} else if(args.length == 1) {
			if(args[0].equalsIgnoreCase("t") || args[0].equalsIgnoreCase("temp") || args[0].equalsIgnoreCase("templates") || args[0].equalsIgnoreCase("tp")) {
				sender.sendMessage(new TextComponent("§8[]§7----------------- §4Mute §cTemplates §7-----------------§8[]"));
				sender.sendMessage(new TextComponent(" "));
				for(String s : Templates.MUTE_namen.keySet()) {
					String time = "";
					for(String times : Templates.MUTE_zeiten.get(s).split(" ")) {
						if(!(times.equalsIgnoreCase("perma"))) {
							time = time+(Integer.valueOf(times) >= 24 ? "§e"+(Integer.valueOf(times)/24)+"§8T" : "§e"+times+"§7S")+" ";
						} else {
							time = time+"§ePerma";
						}
					}
					sender.sendMessage(new TextComponent("        §3"+s+" §8- §3"+Templates.MUTE_namen.get(s)+" §8- §3"+time));
				}
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§8[]§7----------------- §4Mute §cTemplates §7-----------------§8[]"));
				return;
			}
		} else if(args.length >= 2 && args.length <= 2) {
			if(UUIDFeature.getUUID(args[0]) != null && UUIDFeature.getUUID(args[0]) != "") {
				if(MuteSystem.isMutened(UUIDFeature.getUUID(args[0])) == true) {
					sender.sendMessage(new TextComponent(main.prefix_ms+"§cDer §cSpieler §cist §cschon §cgemutet§8."));
					return;
				}
				if(sender instanceof ProxiedPlayer) {
					String target = UUIDFeature.getUUID(args[0]);
					if(!(GruppenManager.hasPermissons(UUIDFeature.getUUID(sender.getName()), "liveplays.admin"))) {
						if(GruppenManager.hasPermissons(target, "liveplays.admin")) {
							sender.sendMessage(new TextComponent(main.prefix_ms+"§cDu kannst den §4Spieler §3"+UUIDFeature.getName(target)+" §cnicht §4muten§c."));
							return;
						} else {
							if(GruppenManager.hasPermissons(target, "liveplays.team")) {
								sender.sendMessage(new TextComponent(main.prefix_ms+"§cDu kannst den §4Spieler §3"+UUIDFeature.getName(target)+" §cnicht §4muten§c."));
								return;
							}
						}
					}
				}
				Templates.mutetemplate(sender, UUIDFeature.getUUID(args[0]), args[1]);
//				BanSystem.addBan(UUIDFeature.getUUID(args[0]), -1, text, sender instanceof ProxiedPlayer ? UUIDFeature.getUUID(sender.getName()) : "CONSOLE");
//				sender.sendMessage(new TextComponent(main.prefix_ms+"§cDu hast den §3Spieler §6"+UUIDFeature.getName(UUIDFeature.getUUID(args[0]))+" §4Permanent §3Gebannt§e."));
				return;
			}
			sender.sendMessage(new TextComponent(main.prefix_ms+"§eDieser §3Spieler §ewar §enoch §enie §eauf §ediesen §3Server§e."));
			return;
		}
		sender.sendMessage(new TextComponent(main.prefix_ms+"§3Verwendung§8: §e/Mute §e<Spieler> §e<Template>"));
		sender.sendMessage(new TextComponent(main.prefix_ms+"§3Verwendung§8: §e/Mute §eTemplates"));
		return;
	}
}