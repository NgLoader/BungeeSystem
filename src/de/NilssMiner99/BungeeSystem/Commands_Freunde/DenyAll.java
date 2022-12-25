package de.NilssMiner99.BungeeSystem.Commands_Freunde;

import java.util.UUID;

import de.NilssMiner99.BungeeSystem.Manager.FreundeManager;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Message.Message;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class DenyAll extends SubCommand {

	public DenyAll() {
		super("Lehne alle offenen Freundschaftsanfragen ab", "", "", "denyAll");
	}

	@Override
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(args.length == 0) {
			for(UUID uuid : FreundeManager.getInvites(p.getUniqueId().toString())) {
				ProxiedPlayer invite = ProxyServer.getInstance().getPlayer(uuid);
				if(invite != null) {
					Message.FRIEND_HAT_DEINE_FREUNDSCHAFTSANFRAGEN_ABGELEHNT.sendMessageReplace(invite, "%TARGET%", p.getName());
				}
			}
			FreundeManager.ClearallFriendRequests(p.getUniqueId().toString());
			Message.FRIEND_DU_HAST_ALLE_FREUNDSCHAFTSANFRAGEN_ABGELEHNT.sendMessage(p);
			return;
		}
		p.sendMessage(new TextComponent(main.prefix_freunde+"§e/Friend denyAll"));
		return;
	}
}