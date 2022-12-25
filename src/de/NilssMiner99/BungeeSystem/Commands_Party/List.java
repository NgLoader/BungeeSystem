package de.NilssMiner99.BungeeSystem.Commands_Party;

import de.NilssMiner99.BungeeSystem.Manager.PartyManager;
import de.NilssMiner99.BungeeSystem.Manager.PlayerParty;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Message.Message;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class List extends SubCommand {
	
	public List() {
		super("Listet alle Party Mitglieder auf", "", "", "list");
	}
	
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(PartyManager.getParty(p) == null) {
			p.sendMessage(new TextComponent(main.prefix_party + "§cDu §cbist §cin §ckeiner §5Party§8!"));
			return;
		}
		
		PlayerParty party = PartyManager.getParty(p);
		
		String leader = "§4"+Message.PARTY_NAME_LEITER.getMessage(p)+"§8: §c"+party.getLeader().getName();
		String players = "§3"+Message.PARTY_NAME_MITGLIEDER.getMessage(p)+"§8: §e";
		
		p.sendMessage(new TextComponent("§8[]§7----------------- §4Party Liste §7-----------------§8[]"));
		p.sendMessage(new TextComponent(" "));

		p.sendMessage(new TextComponent("       "+leader));
		p.sendMessage(new TextComponent("       "+players));
		
		if(!party.getPlayers().isEmpty()) {
			p.sendMessage(new TextComponent(" "));
			for(ProxiedPlayer pp : party.getPlayers()) {
				TextComponent tc = new TextComponent();
				tc.setText("        §8- §e"+pp.getName()+" ");
				if(p.getName().equalsIgnoreCase(party.getLeader().getName())) {
					TextComponent tc2 = new TextComponent();
					tc2.setText("§c§lX");
					tc2.setBold(true);
					tc2.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/party kick "+pp.getName()));
					tc2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§c§l"+Message.PARTY_NAME_KICKEN.getMessage(p)).create()));
					tc.addExtra(tc2);
				}
				p.sendMessage(tc);
			}
		}
		p.sendMessage(new TextComponent(" "));
		p.sendMessage(new TextComponent("§8[]§7----------------- §4Party Liste §7-----------------§8[]"));
		return;
	}
}
