package de.NilssMiner99.BungeeSystem.Commands_Party;

import de.NilssMiner99.BungeeSystem.Manager.PartyManager;
import de.NilssMiner99.BungeeSystem.Manager.PlayerParty;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Message.Message;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Leave extends SubCommand {
	
	public Leave() {
		super("Verlässt die Party", "", "", "leave");
	}
	
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(PartyManager.getParty(p) == null) {
			Message.PARTY_DU_BIST_IN_KEINER_PARTY.sendMessage(p);
			return;
		}
		
		PlayerParty party = PartyManager.getParty(p);
		
		if(party.isLeader(p)) {
			if(party.getPlayers().size() != 0) {
				Message.PARTY_DU_HAST_DIE_PARTY_VERLASSEN.sendMessage(p);
				for(ProxiedPlayer pp : party.getPlayers()) {
					Message.PARTY_DER_LEITER_HAT_DIE_PARTY_VERLASSEN.sendMessage(pp);
				}
				ProxiedPlayer pl = party.getPlayers().get(0);
				party.setLeader(pl);
				party.removePlayer(p);
				Message.PARTY_DU_BIST_NUN_DER_PARTY_LEITER.sendMessage(party.getLeader());
				for(ProxiedPlayer partyplayers : party.getPlayers()) {
					Message.PARTY_DER_NEUE_PARTY_LEITER_IST.sendMessageReplace(partyplayers, "%TARGET%", p.getName());
				}
			} else {
				for(ProxiedPlayer pp : party.getPlayers()) {
					Message.PARTY_DER_LEITER_HAT_DIE_PARTY_VERLASSEN.sendMessage(pp);
				}
				Message.PARTY_DU_HAST_DIE_PARTY_GELÖSCHT.sendMessage(p);
				PartyManager.deleteParty(party);
				return;
			}
		} else {
			if(party.removePlayer(p)) {
				Message.PARTY_DU_HAST_DIE_PARTY_VERLASSEN.sendMessage(p);
				for(ProxiedPlayer pp : party.getPlayers()) {
					Message.PARTY_DER_SPIELER_HAT_DIE_PARTY_VERLASSEN.sendMessageReplace(pp, "%TARGET%", p.getName());
				}
				Message.PARTY_DER_SPIELER_HAT_DIE_PARTY_VERLASSEN.sendMessageReplace(party.getLeader(), "%TARGET%", p.getName());
				return;
			} else {
				Message.PARTY_DU_KANNST_DIE_PARTY_NICHT_VERLASSEN.sendMessage(p);
				return;
			}
		}
	}

}
