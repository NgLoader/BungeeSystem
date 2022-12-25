package de.NilssMiner99.BungeeSystem.Commands_Party;

import de.NilssMiner99.BungeeSystem.Manager.PartyManager;
import de.NilssMiner99.BungeeSystem.Manager.PlayerParty;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Message.Message;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Promote extends SubCommand {

	public Promote() {
		super("Neue Leitung der Party definieren", "", "<Spieler>", "promote");
	}

	@Override
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(args.length == 1) {
			if(PartyManager.getParty(p) == null) {
				Message.PARTY_DU_BIST_IN_KEINER_PARTY.sendMessage(p);
				return;
			}
			PlayerParty party = PartyManager.getParty(p);
			if(party.isLeader(p)) {
				ProxiedPlayer pl = BungeeCord.getInstance().getPlayer(args[0]);
				
				if(pl == null) {
					Message.PARTY_DER_SPIELR_IST_NICHT_ONLINE.sendMessage(p);
					return;
				}
				if(party.getPlayers().contains(pl)) {
					party.setLeader(pl);
					Message.PARTY_DU_BIST_NUN_DER_PARTY_LEITER.sendMessage(pl);
					Message.PARTY_DU_HAST_DEN_RANK_SPIELER_GEGEBEN.sendMessageReplace(p, "%TARGET%", pl.getName());
					for(ProxiedPlayer partyplayers : party.getPlayers()) {
						Message.PARTY_DER_PARTYLEITER_GAB_DEN_RANK_AN_PLAYER_AB.sendMessageReplace(partyplayers, "%TARGET%", pl.getName());
					}
					return;
				}
				Message.PARTY_DER_SPIELER_IST_NICHT_IN_DEINER_PARTY.sendMessage(p);
				return;
			}
			Message.PARTY_DU_BIST_NICHT_DER_PARTY_LEITER.sendMessage(p);
			return;
		}
		p.sendMessage(new TextComponent(main.prefix+"§e/Party §eleader §e<Player>"));
		return;
	}
}