package de.NilssMiner99.BungeeSystem.Commands_Freunde;

import java.util.UUID;

import de.NilssMiner99.BungeeSystem.Manager.FreundeManager;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Manager.UUIDFeature;
import de.NilssMiner99.BungeeSystem.Message.Message;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Accept extends SubCommand {

	public Accept() {
		super("Nehme eine Anfrage an", "", "<Spieler>", "accpet");
	}
	
	@Override
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(args.length == 1) {
			String uuid = p.getUniqueId().toString();
			String target = UUIDFeature.getUUID(args[0]);
			if(target != null) {
				if(FreundeManager.hasInvite(uuid, target)) {
					FreundeManager.removeInvite(uuid, target);
					FreundeManager.removeInvite(target, uuid);
					FreundeManager.addFreund(uuid, target);
					FreundeManager.addFreund(target, uuid);
					ProxiedPlayer targetplayer = ProxyServer.getInstance().getPlayer(UUID.fromString(target));
					if(targetplayer != null) {
						if(FreundeManager.Settings_Nachrichten(target) == true) {
							Message.FRIEND_PLAYER_HAT_DIE_FREUNDSCHAFTSANFRAGE_ANGENOMMEN.sendMessageReplace(targetplayer, "%TARGET%", p.getName());
						}
					}
					Message.FRIEND_DU_HAST_DIE_FREUNDSCHAFTSANFRAGE_ANGENOMMEN.sendMessageReplace(p, "%TARGET%", targetplayer.getName());
					return;
				}
				Message.FRIEND_SPIELER_HAT_KEINE_ANFRAGE_GESENDET.sendMessage(p);
				return;
			}
			Message.FRIEND_DER_SPIELER_WAR_NOCH_NIE_AUF_DEN_SERVER.sendMessage(p);
			return;
		}
		p.sendMessage(new TextComponent(main.prefix_freunde+"§e/Friend §eaccpet §e<"+Message.FRIEND_SPIELER.getMessage(p)+">"));
		return;
	}
}