package de.NilssMiner99.BungeeSystem.Commands_ETC;

import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_Jump extends Command {

	public COMMAND_Jump(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender.hasPermission("liveplays.jump"))) {
			sender.sendMessage(new TextComponent(main.noperm));
			return;
		}
		if(!(sender instanceof ProxiedPlayer)) {
			sender.sendMessage(new TextComponent(main.prefix+"§cDu §cmusst §cein §cSpieler §csein§8."));
			return;
		}
		if(args.length == 1) {
			ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
			if(target != null) {
				((ProxiedPlayer)sender).connect(target.getServer().getInfo());
				sender.sendMessage(new TextComponent(main.prefix+"§3Du §3hast §3den §3Server §e"+target.getServer().getInfo().getName()+"§8."));
				return;
			}
			sender.sendMessage(new TextComponent(main.prefix+"§cDer §cSpieler §cist §cnicht §conline§8."));
			return;
		}
		sender.sendMessage(new TextComponent(main.prefix+"§e/Jump §e<Spieler>"));
		return;
	}
}