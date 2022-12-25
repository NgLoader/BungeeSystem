package de.NilssMiner99.BungeeSystem.Commands_Freunde;

import java.util.UUID;

import de.NilssMiner99.BungeeSystem.Manager.FreundeManager;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Manager.UUIDFeature;
import de.NilssMiner99.BungeeSystem.Message.Message;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Requests extends SubCommand {

	public Requests() {
		super("Zeigt alle Anfragen an", "", "<Seite>", "requests");
	}

	@Override
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(args.length == 0) {
			p.sendMessage(new TextComponent("§8[]§7----------------- §4"+Message.MESSAGE_FREUNDES.getMessage(p)+" §4"+Message.MESSAGE_ANFRAGEN.getMessage(p)+" §7-----------------§8[]"));
			p.sendMessage(new TextComponent(" "));
			int max = FreundeManager.getInvites(p.getUniqueId().toString()).size()-1;
			for(int i = 0; i < 10; i++) {
				if(i >= max && i == max) {
					UUID uuid = FreundeManager.getInvites(p.getUniqueId().toString()).get(i);
					TextComponent tc = new TextComponent();
					tc.setText("          §8- §e"+UUIDFeature.getName(uuid.toString())+"  ");
					TextComponent tc2 = new TextComponent();
					tc2.setText("§a✔§a");
					tc2.setBold(true);
					tc2.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/friend add "+UUIDFeature.getName(uuid.toString())));
					tc2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Message.FRIEND_NEHME_DIE_FREUNDSCHAFTSANFRAGE_VON_SPIELER_AN.getMessage(p).replaceAll("%TARGET%", UUIDFeature.getName(uuid.toString()))).create()));
					tc.addExtra(tc2);
					tc.addExtra("  §8/  ");
					TextComponent tc3 = new TextComponent();
					tc3.setText("§c✘");
					tc3.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/friend deny "+UUIDFeature.getName(uuid.toString())));
					tc3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Message.FRIEND_LEHNE_DIE_FREUNDSCHAFTSANFRAGE_VON_SPIELER_AB.getMessage(p).replaceAll("%TARGET%", UUIDFeature.getName(uuid.toString()))).create()));
					tc.addExtra(tc3);
					p.sendMessage(tc);
				}
			}
			p.sendMessage(new TextComponent(" "));
			p.sendMessage(new TextComponent("§8[]§7----------------- §4"+Message.MESSAGE_FREUNDES.getMessage(p)+" §4"+Message.MESSAGE_ANFRAGEN.getMessage(p)+" §7-----------------§8[]"));
			return;
		} else if(args.length == 1) {
			int page = 0;
			try {
				page = Integer.valueOf(args[0]);
				if(page <= 0 || page == 0) {
					Message.FRIEND_BITTE_GEBE_EINE_ZAHL_ÜBER_0_AN.sendMessage(p);
					return;
				}
			} catch(NumberFormatException ex) {
				Message.FRIEND_BITTE_GEBE_EINE_ZAHL_AN.sendMessage(p);
				return;
			}
			int max = FreundeManager.getFreunde(p.getUniqueId().toString()).size()-1;
			if(max <= page*10 && page != 1) {
				Message.FRIEND_DIE_SEITE_EXESTIERT_NICHT.sendMessage(p);
				return;
			}
			p.sendMessage(new TextComponent("§8[]§7----------------- §4"+Message.MESSAGE_FREUNDES.getMessage(p)+" §4"+Message.MESSAGE_ANFRAGEN.getMessage(p)+" §7-----------------§8[]"));
			p.sendMessage(new TextComponent(" "));
			for(int i = page != 1 ? page*10-1 : 0; i < 10; i++) {
				if(i >= max && i == max) {
					UUID uuid = FreundeManager.getInvites(p.getUniqueId().toString()).get(i);
					TextComponent tc = new TextComponent();
					tc.setText("          §8- §e"+UUIDFeature.getName(uuid.toString())+"     ");
					TextComponent tc2 = new TextComponent();
					tc2.setText("§a✔§a");
					tc2.setBold(true);
					tc2.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/friend add "+UUIDFeature.getName(uuid.toString())));
					tc2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Message.FRIEND_NEHME_DIE_FREUNDSCHAFTSANFRAGE_VON_SPIELER_AN.getMessage(p).replaceAll("%TARGET%", UUIDFeature.getName(uuid.toString()))).create()));
					tc.addExtra(tc2);
					tc.addExtra("  §8/  ");
					TextComponent tc3 = new TextComponent();
					tc3.setText("§c✘");
					tc3.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/friend deny "+UUIDFeature.getName(uuid.toString())));
					tc3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Message.FRIEND_LEHNE_DIE_FREUNDSCHAFTSANFRAGE_VON_SPIELER_AB.getMessage(p).replaceAll("%TARGET%", UUIDFeature.getName(uuid.toString()))).create()));
					tc.addExtra(tc3);
					p.sendMessage(tc);
				}
			}
			p.sendMessage(new TextComponent(" "));
			p.sendMessage(new TextComponent("§8[]§7----------------- §4"+Message.MESSAGE_FREUNDES.getMessage(p)+" §4"+Message.MESSAGE_ANFRAGEN.getMessage(p)+" §7-----------------§8[]"));
			return;
		}
		p.sendMessage(new TextComponent(main.prefix_freunde+"§e/Friend §erequests §e<Seite>"));
		return;
	}
}