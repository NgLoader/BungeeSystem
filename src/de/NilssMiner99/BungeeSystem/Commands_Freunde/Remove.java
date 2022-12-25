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

public class Remove extends SubCommand {

	public Remove() {
		super("Entfernt einen Freund", "", "<Spieler>", "remove");
	}

	@Override
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(args.length == 1) {
			String uuid = p.getUniqueId().toString();
			String target = UUIDFeature.getUUID(args[0]);
			if(target != null) {
				if(FreundeManager.hasFreund(uuid, target)) {
					FreundeManager.removeFreund(uuid, target);
					FreundeManager.removeFreund(target, uuid);
					ProxiedPlayer targetplayer = ProxyServer.getInstance().getPlayer(UUID.fromString(target));
					if(targetplayer != null) {
						if(FreundeManager.Settings_Nachrichten(target) == true) {
							Message.FRIEND_DU_BIST_NUN_NICHT_MEHR_MIT_SPIELER_BEFRUNDET.sendMessageReplace(targetplayer, "%TARGET", p.getName());
						}
					}
					Message.FRIEND_DU_BIST_NUN_NICHT_MEHR_MIT_SPIELER_BEFRUNDET.sendMessageReplace(p, "%TARGET", UUIDFeature.getName(target));
					return;
				}
				Message.FRIEND_DU_BIST_NICHT_MIT_DIESEN_SPIELER_BEFRUNDET.sendMessage(p);
				return;
			}
			Message.FRIEND_DER_SPIELER_WAR_NOCH_NIE_AUF_DEN_SERVER.sendMessage(p);
			return;
		}
		p.sendMessage(new TextComponent(main.prefix_freunde+"§e/Friend §eremove §e<"+Message.FRIEND_SPIELER.getMessage(p)+">"));
		return;
	}
}