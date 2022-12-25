package de.NilssMiner99.BungeeSystem.Commands_Party;

import de.NilssMiner99.BungeeSystem.Manager.PartyManager;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Message.Message;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Create extends SubCommand {
	
	public Create() {
		super("Erstelle eine neue Party", "", "", "create");
	}
	
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(PartyManager.getParty(p) != null) {
			Message.PARTY_DU_BIST_SCHON_IN_EINER_PARTY.sendMessage(p);
			return;
		}
		PartyManager.createParty(p);
		Message.PARTY_CREATE_PARTY.sendMessage(p);
		return;
	}

}