package de.NilssMiner99.BungeeSystem.Commands_Party;

import de.NilssMiner99.BungeeSystem.Manager.PartyManager;
import de.NilssMiner99.BungeeSystem.Manager.PlayerParty;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Message.Message;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Warp extends SubCommand {

	public Warp() {
		super("Um alle zum jetzigen Spieler zu teleportieren", "", "", "warp");
	}

	@Override
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(PartyManager.getParty(p) == null) {
			Message.PARTY_DU_BIST_IN_KEINER_PARTY.sendMessage(p);
			return;
		}
		PlayerParty party = PartyManager.getParty(p);
		if(party.getLeader() == p) {
			for(ProxiedPlayer partyplayer : party.getPlayers()) {
				if(partyplayer.getServer().getInfo().getName().startsWith("Lobby") && partyplayer != party.getLeader()) {
					partyplayer.connect(p.getServer().getInfo());
					Message.PARTY_DER_PARTY_LEITER_SENDER_DICH_AUF.sendMessageReplace(partyplayer, "%SERVER%", p.getServer().getInfo().getName());
				} else {
					Message.PARTY_DER_PARTYLEITER_MÖCHTE_DICH_AUF_SEINEN_SERVER_SENDEN.sendMessage(partyplayer);
				}
			}
			Message.PARTY_DU_HAST_ALLE_ZU_DIR_GESENDET.sendMessage(p);
			return;
		}
		Message.PARTY_DU_BIST_NICHT_DER_PARTY_LEITER.sendMessage(p);
		return;
	}
}