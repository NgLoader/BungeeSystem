package de.NilssMiner99.BungeeSystem.Commands_ETC;

import de.NilssMiner99.BungeeSystem.Message.Message;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_Glist extends Command {

	public COMMAND_Glist(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(ProxyServer.getInstance().getOnlineCount() == 1) {
			if(sender instanceof ProxiedPlayer) {
				Message.SYSTEM_DU_BIST_ALLEINE_AUF_DEN_NETZWERK.sendMessage((ProxiedPlayer)sender);
				return;
			}
		} else {
			if(sender instanceof ProxiedPlayer) {
				Message.SYSTEM_ES_SIND_SPIELER_ONLINE.sendMessageReplace((ProxiedPlayer)sender, "%COUNT%", ""+ProxyServer.getInstance().getOnlineCount());
				return;
			}
		}
		sender.sendMessage(new TextComponent(main.prefix+"§3Es §3sind §3momentan §e"+ProxyServer.getInstance().getOnlineCount()+" §3Spieler §3auf §3dem §3Netzwerk§8."));
		return;
	}
}