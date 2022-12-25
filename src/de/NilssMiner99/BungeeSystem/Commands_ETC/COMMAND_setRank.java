package de.NilssMiner99.BungeeSystem.Commands_ETC;

import de.NilssMiner99.BungeeSystem.Manager.GruppenManager;
import de.NilssMiner99.BungeeSystem.Manager.UUIDFeature;
import de.NilssMiner99.BungeeSystem.main.main;
import de.NilssMiner99.mongodb_Bungee.Values.Groups;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_setRank extends Command {

	public COMMAND_setRank(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!sender.hasPermission("liveplays.admin")) {
			sender.sendMessage(new TextComponent(main.noperm));
			return;
		}
		if(args.length >= 2 && args.length <= 2) {
			if(UUIDFeature.getUUID(args[0]) != null && UUIDFeature.getUUID(args[0]) != "") {
				String uuid = UUIDFeature.getUUID(args[0]);
				for(Groups template : Groups.values()) {
					if(template.getDatabaseName().equalsIgnoreCase(args[1])) {
						GruppenManager.setPermissons(uuid, template.getDatabaseName());
						sender.sendMessage(new TextComponent(main.prefix+"§3Du hast den Spieler §e"+UUIDFeature.getName(uuid)+" §3die §3Gruppe §e"+template.getName()+" §3gegeben§8."));
						return;
					}
				}
				sender.sendMessage(new TextComponent(main.prefix+"§cDer §cangegebene §cRang §cTemplate §cexestiert §cnicht§8."));
				return;
			}
			sender.sendMessage(new TextComponent(main.prefix+"§cDieser §cSpieler §cwar §cnoch §cnie §cauf §cdiesen §cServer."));
			return;
		}
		sender.sendMessage(new TextComponent("§8[]§7----------------- §4RankSystem §7-----------------§8[]"));
		sender.sendMessage(new TextComponent(" "));
		sender.sendMessage(new TextComponent(main.prefix+"§e/Setrank <Spieler> <Rank>"));
		sender.sendMessage(new TextComponent(" "));
		sender.sendMessage(new TextComponent("§8[]§7----------------- §4RankSystem §7-----------------§8[]"));
		return;
	}
}