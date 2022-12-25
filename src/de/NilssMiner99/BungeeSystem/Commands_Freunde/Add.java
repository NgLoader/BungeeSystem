package de.NilssMiner99.BungeeSystem.Commands_Freunde;

import java.util.UUID;

import de.NilssMiner99.BungeeSystem.Manager.FreundeManager;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Manager.UUIDFeature;
import de.NilssMiner99.BungeeSystem.Message.Message;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Add extends SubCommand {

	public Add() {
		super("Füge einen Freund hinzu", "", "<Spieler>", "add");
	}

	@Override
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(args.length == 1) {
			String target = UUIDFeature.getUUID(args[0]);
			String uuid = p.getUniqueId().toString();
			if(target != null) {
				if(target.equalsIgnoreCase(uuid)) {
					Message.FRIEND_DU_KANNST_DIR_KEINE_EIGENE_FREUNDSCHAFTSANFRAGE_SENDEN.sendMessage(p);
					return;
				}
				if(FreundeManager.Settings_Invites(target) != true) {
					Message.FRIEND_SPIELER_NIMMT_KEINE_ANFRAGEN_AN.sendMessage(p);
					return;
				}
				if(FreundeManager.hasFreund(target, uuid) != true) {
					if(FreundeManager.hasInvite(target, uuid)) {
						Message.FRIEND_DU_HAST_DEN_SPIELER_SCHON_EINE_FREUNDSCHAFTSANFRAGE_GESENDER.sendMessageReplace(p, "%TARGET%", UUIDFeature.getName(target));
						return;
					}
					if(FreundeManager.hasInvite(uuid, target) == true) {
						FreundeManager.removeInvite(target, uuid);
						FreundeManager.removeInvite(uuid, target);
						FreundeManager.addFreund(target, uuid);
						FreundeManager.addFreund(uuid, target);
						ProxiedPlayer targetplayer = ProxyServer.getInstance().getPlayer(UUID.fromString(target));
						if(targetplayer != null) {
							if(FreundeManager.Settings_Nachrichten(target) == true) {
								Message.FRIEND_HAT_DEINE_FREUNDSCHAFTSANFRAGEN_ANGENOMMEN.sendMessageReplace(targetplayer, "%TARGET%", p.getName());
							}
						}
						Message.FRIEND_DU_BIST_NUN_MIT_PLAYER_BEFREUNDET.sendMessageReplace(p, "%TARGET%", UUIDFeature.getName(target));
						return;
					}
					FreundeManager.addInvite(target, uuid);
					ProxiedPlayer targetplayer = ProxyServer.getInstance().getPlayer(UUID.fromString(target));
					if(targetplayer != null) {
						if(FreundeManager.Settings_Nachrichten(target) == true) {
							TextComponent tc = new TextComponent();
							tc.setText(Message.FRIEND_SPIELER_FREUNDSCHAFTS_ANFRAGE_ANNEHMEN.getMessage(targetplayer).replaceAll("%TARGET%", UUIDFeature.getName(uuid)));
							TextComponent tc2 = new TextComponent();
							tc2.setText("§a✔§a");
							tc2.setBold(true);
							tc2.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/friend add "+UUIDFeature.getName(uuid)));
							tc2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Message.FRIEND_NEHME_DIE_FREUNDSCHAFTSANFRAGE_VON_SPIELER_AN.getMessage(targetplayer).replaceAll("%TARGET%", UUIDFeature.getName(uuid))).create()));
							tc.addExtra(tc2);
							tc.addExtra("  §8/  ");
							TextComponent tc4 = new TextComponent();
							tc4.setText("§c✘");
							tc4.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/friend deny "+UUIDFeature.getName(uuid)));
							tc4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Message.FRIEND_LEHNE_DIE_FREUNDSCHAFTSANFRAGE_VON_SPIELER_AB.getMessage(targetplayer).replaceAll("%TARGET%", UUIDFeature.getName(uuid))).create()));
							tc.addExtra(tc4);
							targetplayer.sendMessage(tc);
						}
					}
					Message.FRIEND_DU_HAST_DEN_SPIELER_EINE_FREUNDSCHAFTSANFRAGE_GESENDET.sendMessageReplace(p, "%TARGET%", UUIDFeature.getName(target));
					return;
				}
				Message.FRIEND_DU_BIST_BEREITS_MIT_DEN_SPIELER_BEFREUNDET.sendMessage(p);
				return;
			}
			Message.FRIEND_DER_SPIELER_WAR_NOCH_NIE_AUF_DEN_SERVER.sendMessage(p);
			return;
		}
		p.sendMessage(new TextComponent(main.prefix_freunde+"§e/Friend §eadd §e<"+Message.FRIEND_SPIELER.getMessage(p)+">"));
		return;
	}
}