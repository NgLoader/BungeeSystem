package de.NilssMiner99.BungeeSystem.Commands_Party;

import de.NilssMiner99.BungeeSystem.Manager.PartyManager;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Message.Message;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Deny extends SubCommand {
	
	public Deny() {
		super("Lehne ein Anfrage ab", "", "<Spieler>", "deny");
	}
	
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(PartyManager.getParty(p) != null) {
			if(PartyManager.getParty(p) != null) {
				Message.PARTY_DU_BIST_SCHON_IN_EINER_PARTY.sendMessage(p);
				return;
			}
			PartyManager.denyParty(p);
			return;
		}
		Message.PARTY_DU_WURDEST_ZU_KEINER_PARTY_EINGELADEN.sendMessage(p);
	}

}
