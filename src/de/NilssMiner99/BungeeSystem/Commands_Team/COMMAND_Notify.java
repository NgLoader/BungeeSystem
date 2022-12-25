package de.NilssMiner99.BungeeSystem.Commands_Team;

import de.NilssMiner99.BungeeSystem.Manager.NotifyManager;
import de.NilssMiner99.BungeeSystem.Message.Message;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_Notify extends Command {

	public COMMAND_Notify(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender.hasPermission("liveplays.notify"))) {
			sender.sendMessage(new TextComponent(main.noperm));
			Message.NOPERM.sendMessage((ProxiedPlayer)sender);
			return;
		}
		if(!(sender instanceof ProxiedPlayer)) {
			sender.sendMessage(new TextComponent(main.prefix+"§cDu §cmusst §cein §cSpieler §csein§8."));
			return;
		}
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("on")) {
				if(!(NotifyManager.notify.contains(p.getUniqueId().toString()))) {
					Message.NOTIFY_DU_HAST_SCHON_AKTIVIERT.sendMessage(p);
					return;
				}
				NotifyManager.remove(p.getUniqueId().toString());
				Message.NOTIFY_AKTIVIERT.sendMessage(p);
				return;
			} else if(args[0].equalsIgnoreCase("off")) {
				if(NotifyManager.notify.contains(p.getUniqueId().toString())) {
					Message.NOTIFY_DU_HAST_SCHON_DEAKTIVIERT.sendMessage(p);
					return;
				}
				NotifyManager.add(p.getUniqueId().toString());
				Message.NOTIFY_DEAKTIVIERT.sendMessage(p);
				return;
			}
		}
		p.sendMessage(new TextComponent("§8[]§7----------------- §4NotifySystem §7-----------------§8[]"));
		p.sendMessage(new TextComponent(" "));
		p.sendMessage(new TextComponent("§e/Notify §eon"));
		p.sendMessage(new TextComponent("§e/Notify §eoff"));
		p.sendMessage(new TextComponent(" "));
		p.sendMessage(new TextComponent("§8[]§7----------------- §4NotifySystem §7-----------------§8[]"));
	}
}