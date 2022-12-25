package de.NilssMiner99.BungeeSystem.Commands_LobbySystem;

import de.NilssMiner99.BungeeSystem.Message.Message;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Command_Hub extends Command {

	public Command_Hub(String name) {
		super(name);
	}
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof ProxiedPlayer)) {
			sender.sendMessage(new TextComponent(main.prefix+"§cDu §cmusst §cein §4Spieler §csein!"));
			return;
		}
		ProxiedPlayer p = (ProxiedPlayer)sender;
		if(p.getServer().getInfo().getName().startsWith("Lobby") || p.getServer().getInfo().getName().contains("fallback")) {
			Message.SYSTEM_DU_BIST_BEREITS_AUF_DER_LOBBY.sendMessage(p);
			return;
		}
		ServerInfo minserver = null;
		int minplayerserver = 0;
		for(ServerInfo si : ProxyServer.getInstance().getServers().values()) {
			if(si != null) {
				if(si.getName().startsWith("Lobby") && si.getName() != p.getServer().getInfo().getName()) {
					if(si.getPlayers().size() <= 29) {
						if(minserver == null && minplayerserver == 0) {
							minserver = si;
							minplayerserver = si.getPlayers().size();
						} else {
							if(minplayerserver >= si.getPlayers().size()) {
								minserver = si;
								minplayerserver = si.getPlayers().size();
							}
						}
					}
				}
			}
		}
		if(minserver != null) {
			p.connect(minserver);
		}
		return;
	}
}