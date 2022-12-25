package de.NilssMiner99.BungeeSystem.Commands_Team;

import de.NilssMiner99.BungeeSystem.Message.Message;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_AFK extends Command {

	public COMMAND_AFK(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] cmd) {
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer p = (ProxiedPlayer) sender;
			if(main.afk.contains(p.getUniqueId().toString())) {
				main.afk.remove(p.getUniqueId().toString());
				Message.SYSTEM_DU_BIST_NICHT_MEHR_AFK.sendMessage(p);
				return;
			} else {
				main.afk.add(p.getUniqueId().toString());
				Message.SYSTEM_DU_BIST_NUN_AFK.sendMessage(p);
				return;
			}
		}
		sender.sendMessage(new TextComponent(main.prefix+"§cDu §cmust §cein §cSpieler §csein§8."));
		return;
	}
}