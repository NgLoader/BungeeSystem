package de.NilssMiner99.BungeeSystem.Commands_Party;

import de.NilssMiner99.BungeeSystem.Manager.PartyManager;
import de.NilssMiner99.BungeeSystem.Manager.PlayerParty;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Message.Message;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Accept extends SubCommand {
	
	public Accept() {
		super("Nimmt eine Anfrage an", "", "<Spieler>", "accept");
	}
	
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(args.length == 0) {
			Message.PARTY_BITTE_GEBE_EINEN_SPIELER_NAMEN_AN.sendMessage(p);
			return;
		}
		
		if(PartyManager.getParty(p) != null) {
			Message.PARTY_DU_BIST_SCHON_IN_EINER_PARTY.sendMessage(p);
			return;
		}
		
		ProxiedPlayer pl = BungeeCord.getInstance().getPlayer(args[0]);
		
		if(pl == null) {
			Message.PARTY_DER_SPIELR_IST_NICHT_ONLINE.sendMessage(p);
			return;
		}
		
		if(PartyManager.getParty(pl) == null) {
			Message.PARTY_DER_SPIELER_HAT_KEINE_PARTY.sendMessage(p);
			return;
		}
		
		PlayerParty party = PartyManager.getParty(pl);

//		if(!(MySQL_RECHTE_Owner.hatrechte(p) == true ||
//				MySQL_RECHTE_Developer.hatrechte(p) == true ||
//				MySQL_RECHTE_Moderator.hatrechte(p) == true ||
//				MySQL_RECHTE_Supporter.hatrechte(p) == true ||
//				MySQL_RECHTE_Architekt.hatrechte(p) == true ||
//				MySQL_RECHTE_YouTuber.hatrechte(p) == true ||
//				MySQL_RECHTE_Elite.hatrechte(p) == true ||
//				MySQL_RECHTE_Premium.hatrechte(p) == true)) {
//			if(party.getPlayers().size() == 5 || party.getPlayers().size() >= 5) {
//				p.sendMessage(new TextComponent(main.prefix_party + "§cDie §5Party §chat §cdie §cmaximale §5Party §cgröße §cereicht."));
//				return;
//			}
//		}
		
		if(party.addPlayer(p)) {
			for(ProxiedPlayer pp : party.getPlayers()) {
				Message.PARTY_DER_SPIELER_HAT_DIE_PARTY_BETRETEN.sendMessageReplace(pp, "%TARGET%", p.getName());
			}
			Message.PARTY_DER_SPIELER_HAT_DIE_PARTY_BETRETEN.sendMessageReplace(party.getLeader(), "%TARGET%", p.getName());
			return;
		} else {
			Message.PARTY_DU_KANNST_DER_PARTY_NICHT_BETRETEN.sendMessage(p);
			return;
		}
 	}

}
