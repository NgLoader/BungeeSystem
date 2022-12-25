package de.NilssMiner99.BungeeSystem.Commands_Freunde;

import java.util.UUID;

import de.NilssMiner99.BungeeSystem.Manager.FreundeManager;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Message.Message;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class AcceptAll extends SubCommand {

	public AcceptAll() {
		super("Nehme Alle offenen Freundschaftsanfragen an", "", "", "accpetAll");
	}

	@Override
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(args.length == 0) {
			for(UUID uuid : FreundeManager.getInvites(p.getUniqueId().toString())) {
				FreundeManager.addFreund(p.getUniqueId().toString(), uuid.toString());
				FreundeManager.addFreund(uuid.toString(), p.getUniqueId().toString());
				ProxiedPlayer invite = ProxyServer.getInstance().getPlayer(uuid);
				if(invite != null) {
					Message.FRIEND_PLAYER_HAT_DIE_FREUNDSCHAFTSANFRAGE_ANGENOMMEN.sendMessageReplace(invite, "%TARGET%", p.getName());
				}
			}
			FreundeManager.ClearallFriendRequests(p.getUniqueId().toString());
			Message.FRIEND_DU_HAST_ALLE_FREUNDSCHAFTSANFRAGEN_ANGENOMMEN.sendMessage(p);
		}
		p.sendMessage(new TextComponent(main.prefix_freunde+"§e/Friend accpetAll"));
		return;
	}
	
}