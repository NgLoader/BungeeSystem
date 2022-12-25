package de.NilssMiner99.BungeeSystem.Commands_Party;

import de.NilssMiner99.BungeeSystem.Manager.PartyManager;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Message.Message;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Toggle extends SubCommand {

	public Toggle() {
		super("Anfragen erlauben & verbieten ", "", "", "toggle");
	}

	@Override
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(PartyManager.toggel.containsKey(p.getUniqueId().toString())) {
			int toggle = PartyManager.toggel.get(p.getUniqueId().toString());
			if(toggle == 0) {
				PartyManager.settoggel(p.getUniqueId().toString(), 1);
				Message.PARTY_TOGGLE_FRIENDS.sendMessage(p);
			} else if(toggle == 1) {
				Message.PARTY_TOGGLE_NIEMAND.sendMessage(p);
				PartyManager.settoggel(p.getUniqueId().toString(), 2);
			} else {
				Message.PARTY_TOGGLE_ALLE.sendMessage(p);
				PartyManager.settoggel(p.getUniqueId().toString(), 0);
			}
		} else {
			PartyManager.settoggel(p.getUniqueId().toString(), 1);
			Message.PARTY_TOGGLE_FRIENDS.sendMessage(p);
		}
	}
}