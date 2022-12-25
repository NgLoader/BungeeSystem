package de.NilssMiner99.BungeeSystem.Commands_Freunde;

import de.NilssMiner99.BungeeSystem.Manager.FreundeManager;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Manager.UUIDFeature;
import de.NilssMiner99.BungeeSystem.Message.Message;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Delinvite extends SubCommand {

	public Delinvite() {
		super("Lösche eine gesendete Freundeschaftsangrage", "", "<Spieler>", "delinvite");
	}

	@Override
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(args.length == 1) {
			String uuid = p.getUniqueId().toString();
			String target = UUIDFeature.getUUID(args[0]);
			if(target != null) {
				if(FreundeManager.hasFreund(uuid, target)) {
					Message.FRIEND_DU_BIST_MIT_SPIELER_BEFREUNDET.sendMessageReplace(p, "%TARGET%", UUIDFeature.getName(target));
					return;
				}
				if(FreundeManager.hasInvite(target, uuid)) {
					FreundeManager.removeInvite(target, uuid);
					Message.FRIEND_DU_HAST_DIE_FREUNDSCHAFTSANFRAGE_AN_SPIELER_GELÖSCHT.sendMessageReplace(p, "%TARGET%", UUIDFeature.getName(target));
					return;
				}
				Message.FRIEND_DU_HAST_DEN_SPIELER_NOCH_KEINE_FREUNDSCHAFTSANFRAGE_GESENDET.sendMessageReplace(p, "%TARGET%", UUIDFeature.getName(target));
				return;
			}
			Message.FRIEND_DER_SPIELER_WAR_NOCH_NIE_AUF_DEN_SERVER.sendMessage(p);
			return;
		}
		p.sendMessage(new TextComponent(main.prefix_freunde+"§e/Friend §edelinvite §e<"+Message.FRIEND_SPIELER.getMessage(p)+">"));
		return;
	}
}