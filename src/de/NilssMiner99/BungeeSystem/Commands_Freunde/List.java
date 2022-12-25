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

public class List extends SubCommand {

	public List() {
		super("Zeigt eine Liste aller Freunde", "", "<Seite>", "list");
	}

	@Override
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(args.length == 0) {
			p.sendMessage(new TextComponent("§8[]§7----------------- §4"+Message.MESSAGE_FREUNDES.getMessage(p)+" §4"+Message.MESSAGE_LISTE.getMessage(p)+" §7-----------------§8[]"));
			p.sendMessage(new TextComponent(" "));
			int max = FreundeManager.getFreunde(p.getUniqueId().toString()).size()-1;
			for(int i = 0; i < 10; i++) {
				if(i >= max && i == max) {
					UUID uuid = FreundeManager.getFreunde(p.getUniqueId().toString()).get(i);
					if(ProxyServer.getInstance().getPlayer(uuid) == null) {
						p.sendMessage(new TextComponent("          §8- §e"+UUIDFeature.getName(uuid.toString())+" "+Message.FRIEND_OFFLINE.getMessage(p)));
					} else {
						TextComponent tc = new TextComponent();
						tc.setText("          §8- §e"+UUIDFeature.getName(uuid.toString())+" "+Message.FRIEND_ONLINE_AUF.getMessage(p));
						TextComponent tc2 = new TextComponent();
						tc2.setText(" §e"+ProxyServer.getInstance().getPlayer(uuid).getServer().getInfo().getName()+"§8.");
						tc2.setBold(true);
						tc2.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/jump "+UUIDFeature.getName(uuid.toString())));
						tc2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Message.FRIEND_SERVER_BETRETEN.getMessage(p)).create()));
						tc.addExtra(tc2);
						p.sendMessage(tc);
					}
				}
			}
			p.sendMessage(new TextComponent(" "));
			p.sendMessage(new TextComponent("§8[]§7----------------- §4"+Message.MESSAGE_FREUNDES.getMessage(p)+" §4"+Message.MESSAGE_LISTE.getMessage(p)+" §7-----------------§8[]"));
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
			p.sendMessage(new TextComponent("§8[]§7----------------- §4"+Message.MESSAGE_FREUNDES.getMessage(p)+" §4"+Message.MESSAGE_LISTE.getMessage(p)+" §7-----------------§8[]"));
			p.sendMessage(new TextComponent(" "));
			for(int i = page != 1 ? page*10-1 : 0; i < 10; i++) {
				if(i >= max && i == max) {
					UUID uuid = FreundeManager.getFreunde(p.getUniqueId().toString()).get(i);
					String status = ProxyServer.getInstance().getPlayer(uuid) != null ? Message.FRIEND_ONLINE_AUF.getMessage(p)+" §e"+ProxyServer.getInstance().getPlayer(uuid).getServer().getInfo().getName() : Message.FRIEND_OFFLINE.getMessage(p);
					p.sendMessage(new TextComponent("          §8- §e"+UUIDFeature.getName(uuid.toString())+" "+status));
				}
			}
			p.sendMessage(new TextComponent(" "));
			p.sendMessage(new TextComponent("§8[]§7----------------- §4"+Message.MESSAGE_FREUNDES.getMessage(p)+" §4"+Message.MESSAGE_LISTE.getMessage(p)+" §7-----------------§8[]"));
			return;
		}
		p.sendMessage(new TextComponent(main.prefix_freunde+"§e/Friend §elist §e<"+Message.MESSAGE_SEITE.getMessage(p)+">"));
		return;
	}
}