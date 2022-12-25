package de.NilssMiner99.BungeeSystem.Commands_Freunde;

import java.util.UUID;

import de.NilssMiner99.BungeeSystem.Manager.FreundeManager;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Message.Message;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Clear extends SubCommand {

	public Clear() {
		super("Leert die Freundesliste", "", "", "clear");
	}
	
	@Override
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(args.length == 0) {
			Message.FRIEND_FREUNDE_ALLE_LÖSCHEN_CONFIRM.sendMessage(p);
			return;
		} else if(args.length == 1) {
			if(args[0].equalsIgnoreCase("confirm")) {
				for(UUID uuid : FreundeManager.getFreunde(p.getUniqueId().toString())) {
					ProxiedPlayer friend = ProxyServer.getInstance().getPlayer(uuid);
					if(friend != null) {
						if(FreundeManager.Settings_Nachrichten(uuid.toString())) {
							Message.FRIEND_DU_BIST_NUN_NICHT_MEHR_MIR_SPIELER_BEFREUNDET.sendMessageReplace(friend, "%TARGET%", p.getName());
						}
					}
				}
				FreundeManager.ClearallFriends(p.getUniqueId().toString());
				Message.FRIEND_DU_HAST_ALLE_FREUNDE_GELÖSCHT.sendMessage(p);
				return;
			}
		}
		p.sendMessage(new TextComponent(main.prefix_freunde+"§e/Friend §eclear"));
		return;
	}
}