package de.NilssMiner99.BungeeSystem.Commands_ETC;

import de.NilssMiner99.BungeeSystem.Manager.BlackList;
import de.NilssMiner99.BungeeSystem.Manager.MotdManager;
import de.NilssMiner99.BungeeSystem.Manager.NotifyManager;
import de.NilssMiner99.BungeeSystem.Manager.RangTemplates;
import de.NilssMiner99.BungeeSystem.Manager.ServerManager;
import de.NilssMiner99.BungeeSystem.Manager.Templates;
import de.NilssMiner99.BungeeSystem.Manager.WartungManager;
import de.NilssMiner99.BungeeSystem.Manager.WhitelistManager;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_BungeeSystem extends Command {

	public COMMAND_BungeeSystem(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender.hasPermission("liveplays.admin"))) {
			sender.sendMessage(new TextComponent(main.noperm));
			return;
		}
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("reloadconfig")) {
				main.RegisterConfig();
				Templates.load();
				WartungManager.load();
				MotdManager.load();
				BlackList.load();
				RangTemplates.load();
				NotifyManager.load();
				ServerManager.load();
				WhitelistManager.load();
				sender.sendMessage(new TextComponent(main.prefix+"§3Du §3hast §3die §3Configs §3neu §3geladen§8."));
				return;
			} else if(args[0].equalsIgnoreCase("reload")) {
				main.RegisterConfig();
				Templates.load();
				WartungManager.load();
				MotdManager.load();
				BlackList.load();
				RangTemplates.load();
				NotifyManager.load();
				ServerManager.load();
				WhitelistManager.load();
				sender.sendMessage(new TextComponent(main.prefix+"§3Du §3hast §3alles §3neu §3geladen§8."));
				return;
			}
		}
		sender.sendMessage(new TextComponent("§8[]§7----------------- §4BungeeSystem §7-----------------§8[]"));
		sender.sendMessage(new TextComponent(" "));
		sender.sendMessage(new TextComponent("§e/Bungeesystem reload §8| §3Um §3alles §3neu §3zu §3laden§8."));
		sender.sendMessage(new TextComponent("§e/Bungeesystem reloadconfig §8| §3Um §3die §3Configs §3neu §3zu §3laden§8."));
		sender.sendMessage(new TextComponent(" "));
		sender.sendMessage(new TextComponent("§8[]§7----------------- §4BungeeSystem §7-----------------§8[]"));
	}
}