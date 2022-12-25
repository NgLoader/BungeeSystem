package de.NilssMiner99.BungeeSystem.Commands_Party;

import de.NilssMiner99.BungeeSystem.Manager.PartyManager;
import de.NilssMiner99.BungeeSystem.Manager.PlayerParty;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Message.Message;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Kick extends SubCommand {
	
	public Kick() {
		super("Kickt einen Spieler aus der Party", "", "<Spieler>", "kick");
	}
	
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(args.length == 0) {
			Message.PARTY_BITTE_GEBE_EINEN_SPIELER_NAMEN_AN.sendMessage(p);
			return;
		}
		
		if(PartyManager.getParty(p) == null) {
			Message.PARTY_DU_BIST_IN_KEINER_PARTY.sendMessage(p);
			return;
		}
		
		PlayerParty party = PartyManager.getParty(p);
		
		if(!party.isLeader(p)) {
			Message.PARTY_DU_BIST_NICHT_DER_PARTY_LEITER.sendMessage(p);
			return;
		}
		
		ProxiedPlayer pl = BungeeCord.getInstance().getPlayer(args[0]);
		
		if(pl == null) {
			Message.PARTY_DER_SPIELR_IST_NICHT_ONLINE.sendMessage(p);
			return;
		}
		
		if(party.removePlayer(pl)) {
			Message.PARTY_DU_HAST_DEN_SPIELER_RAUSGEWORFEN.sendMessageReplace(p, "%TARGET%", pl.getName());
			for(ProxiedPlayer pp : party.getPlayers()) {
				Message.PARTY_DER_SPIELER_WURDE_AUS_DER_PARTY_GESCHMISSEN.sendMessageReplace(pp, "%TARGET%", pl.getName());
			}
			Message.PARTY_DU_WURDEST_AUS_DER_PARTY_GESCHMISSEN.sendMessage(pl);
			return;
		} else {
			Message.PARTY_DU_KANNST_DEN_SPIELER_NICHT_AUS_DER_PARTY_SCHMEISSEN.sendMessage(p);
			return;
		}
	}

}
