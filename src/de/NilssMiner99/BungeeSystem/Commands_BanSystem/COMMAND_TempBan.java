package de.NilssMiner99.BungeeSystem.Commands_BanSystem;

import de.NilssMiner99.BungeeSystem.Manager.BanSystem;
import de.NilssMiner99.BungeeSystem.Manager.GruppenManager;
import de.NilssMiner99.BungeeSystem.Manager.UUIDFeature;
import de.NilssMiner99.BungeeSystem.Manager.Util;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_TempBan extends Command {
	
	public COMMAND_TempBan(String name) {
		super(name);
	}
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!sender.hasPermission("liveplays.tempban")) {
			sender.sendMessage(new TextComponent(main.noperm));
			return;
		}
		if(args.length == 0) {
			sender.sendMessage(new TextComponent(main.prefix_bs+"§3Verwendung: §e/Cban §e<Spieler> §e<Time> §e<Einheit> §e<Grund>"));
			return;
		} else if(args.length >= 3) {
			if(UUIDFeature.getUUID(args[0]) != null) {
				int time;
				try {
					time = Integer.valueOf(args[1]);
					if(time <= 0) {
						sender.sendMessage(new TextComponent(main.prefix_bs+"§cBitte §cgebe §ceine §cZahl §can§8, §cdie §chöher §cals §e0 §cist§8."));
						return;
					}
				} catch(NumberFormatException ex) {
					sender.sendMessage(new TextComponent(main.prefix_bs+"§cBitte §cgebe §ceine §cZahl §can §cdie §chöher §cals §e0 §cist§8."));
					return;
				}
				if(Util.isValue(args[2].toUpperCase()) == true) {
					Util u = Util.valueOf(args[2].toUpperCase());
					String text = "";
					for(int i = 3; i < args.length; i++) {
						text = text+args[i]+" ";
					}
					if(sender instanceof ProxiedPlayer) {
						String target = UUIDFeature.getUUID(args[0]);
						if(GruppenManager.hasPermissons(target, "liveplays.admin")) {
							sender.sendMessage(new TextComponent(main.prefix_bs+"§cDu kannst den Spieler §e"+UUIDFeature.getName(target)+" §cnicht bannen§8."));
							return;
						} else {
							if(GruppenManager.hasPermissons(target, "liveplays.team")) {
								sender.sendMessage(new TextComponent(main.prefix_bs+"§cDu kannst den Spieler §e"+UUIDFeature.getName(target)+" §cnicht §cbannen§8."));
								return;
							}
						}
					}
					String p = UUIDFeature.getUUID(sender.getName());
					long bantime = time+1*u.getToSeconds();
					if(bantime >= Util.MONATE.toSeconds && bantime != Util.MONATE.toSeconds) {
						if(!(GruppenManager.hasPermissons(p, "liveplays.admin"))) {
							if(GruppenManager.hasPermissons(p, "liveplays.team")) {
								sender.sendMessage(new TextComponent(main.prefix_bs+"§cDu §cdarfst §cmaximal §c1 §cMonat §cbannen§e."));
								return;
							}
						}
					}
					if(BanSystem.isBanned(UUIDFeature.getUUID(args[0]))) {
						sender.sendMessage(new TextComponent(main.prefix_bs+"§cDieser §cSpieler §cist §cschon §cgebannt§8."));
						return;
					}
					BanSystem.addBan(UUIDFeature.getUUID(args[0]), bantime, text, sender instanceof ProxiedPlayer ? UUIDFeature.getUUID(sender.getName()) : "CONSOLE", "Nicht angegeben");
					sender.sendMessage(new TextComponent(main.prefix_bs+"§eDu hast den §3Spieler §9"+UUIDFeature.getName(UUIDFeature.getUUID(args[0]))+" §efür §3"+time+" §9"+u.getName()+" §4gebannt§e."));
					return;
				}
				sender.sendMessage(new TextComponent(main.prefix_bs+"§8[]§7----------------- §4Ban §cTemplates §7-----------------§8[]"));
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent(main.prefix_bs+"§4Bitte gebe eine richte Einheit an."));
				sender.sendMessage(new TextComponent(" "));
				for(Util ut : Util.values()) {
					sender.sendMessage(new TextComponent("         §e"+ut.getName()));
				}
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent(main.prefix_bs+"§8[]§7----------------- §4Ban §cTemplates §7-----------------§8[]"));
				return;
				}
			sender.sendMessage(new TextComponent(main.prefix_bs+"§cDieser §cSpieler §cwar §cnoch §cnie §cauf §cdiesen §cServer§8."));
			return;
		}
		sender.sendMessage(new TextComponent(main.prefix_bs+"§3Verwendung§8: §e/Cban §e<Spieler> §e<Time> §e<Einheit> §e<Grund>"));
		return;
	}
}