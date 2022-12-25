package de.NilssMiner99.BungeeSystem.Commands_Party;

import de.NilssMiner99.BungeeSystem.Manager.FreundeManager;
import de.NilssMiner99.BungeeSystem.Manager.PartyManager;
import de.NilssMiner99.BungeeSystem.Manager.PlayerParty;
import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Message.Message;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Invite extends SubCommand {
	
	public Invite() {
		super("Lädt Spieler in die Party ein", "", "<Spieler>", "invite");
	}
	
	public void onCommand(ProxiedPlayer p, String[] args) {
		if(args.length == 0) {
			Message.PARTY_BITTE_GEBE_EINEN_SPIELER_NAMEN_AN.sendMessage(p);
			return;
		}
		
		ProxiedPlayer pl = BungeeCord.getInstance().getPlayer(args[0]);
		
		if(pl == null) {
			Message.PARTY_DER_SPIELR_IST_NICHT_ONLINE.sendMessage(p);
			return;
		}
		
		if(pl == p) {
			Message.PARTY_DU_KANNST_DICH_NICHT_SELBST_EINLADEN.sendMessage(p);
			return;
		}
//		if(FreundeManager.getParty(pl.getUniqueId().toString()) == 2) {
//			p.sendMessage(new TextComponent(main.prefix_party+"§cDer Spieler §e"+args[0]+" §cnimmt §czurzeit §ckeine §cParty §cAnfragen §can."));
//			return;
//		}
//		if(FreundeManager.getParty(pl.getUniqueId().toString()) == 1) {
//			if(!(FreundeManager.getFreunde(p.getUniqueId().toString()).contains(pl.getUniqueId().toString()))) {
//				p.sendMessage(new TextComponent(main.prefix_party+"§cDer Spieler §e"+args[0]+" §cnimmt §cnur §cvon §cFreunden §cdie §cAnfragen §can."));
//				return;
//			}
//		}
		if(PartyManager.toggel.containsKey(pl.getUniqueId().toString())) {
			int toggle = PartyManager.toggel.get(pl.getUniqueId().toString());
			if(toggle == 1 && FreundeManager.hasFreund(p.getUniqueId().toString(), pl.getUniqueId().toString()) != true) {
				Message.PARTY_DER_SPISLER_NIMMT_NUR_FREUNDSCHAFTSANFRAGEN_AN.sendMessage(p);
				return;
			} else if(toggle == 2) {
				Message.PARTY_DER_SPIELER_NIMMT_KEINE_ANFRAGEN_AN.sendMessage(p);
				return;
			}
		}
		if(PartyManager.getParty(pl) != null) {
			Message.PARTY_IST_BEREITS_IN_EINER_PARTY.sendMessage(p);
			return;
		}
		if(PartyManager.getParty(p) == null) {
			PartyManager.createParty(p);
			Message.PARTY_CREATE_PARTY.sendMessage(p);
		}
		
		PlayerParty party = PartyManager.getParty(p);
		
		if(!party.isLeader(p)) {
			Message.PARTY_DU_BIST_NICHT_DER_PARTY_LEITER.sendMessage(p);
			return;
		}
		if(party.getPlayers().size() == 5 || party.getPlayers().size() >= 5) {
			if(!(p.hasPermission("liveplays.premium"))) {
				Message.PARTY_DU_HAST_DIE_MAXIMALE_PARTY_GRÖSSE_EREICHT.sendMessage(p);
				return;
			} else if(party.getPlayers().size() == 25 || party.getPlayers().size() >= 25) {
				Message.PARTY_DU_HAST_DIE_MAXIMALE_PARTY_GRÖSSE_EREICHT.sendMessage(p);
				return;
			}
		}
		
		party.invite(pl);
	}
}