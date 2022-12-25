package de.NilssMiner99.BungeeSystem.Message;

import de.NilssMiner99.BungeeSystem.main.main;
import de.NilssMiner99.mongodb_Bungee.MongoDB.Global_Players;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public enum Message {
	
	NOPERM(main.prefix+"§cDu §chast §ckeine §cRechte §cfür §cdiesen §cBefehl§8.", main.prefix+"§cYou dont have access for this command§8."),
	COMMAND_NOT_EXIST(main.prefix+"§cDer §cBefehl §cexestiert §cnicht.", "§cThis §cCommand §cdoes §cnot §cexist§8."),
	
	MESSAGE_SEITE("Seite", "Page"),
	MESSAGE_LISTE("liste","list"),
	MESSAGE_FREUNDES("Freundes", "friends"),
	MESSAGE_ANFRAGEN("Anfragen", "anfragen"),
	MESSAGE_FILTER("filter", ""),
	
	SYSTEM_ACHTE_AUF_DEINE_WORT_WAHL(main.prefix+"§cBitte §cachte §cauf §cdeine §cWort §cwahl§8.", ""),
	SYSTEM_ES_SIND_SPIELER_ONLINE(main.prefix+"§3Es §3sind §3momentan §e%COUNT% §3Spieler §3auf §3dem §3Netzwerk§8.", "§3There §3are §3corrently §e%COUNT% §3players §3on §3the §3network§8."),
	SYSTEM_DU_BIST_ALLEINE_AUF_DEN_NETZWERK(main.prefix+"§3Du §3bist §3alleine §3auf §3dem §3Netzwerk§8.", "§3You §3are §3corrently §3allone §3on §3the §3network§8."),
	SYSTEM_DU_BIST_NICHT_MEHR_AFK(main.prefix+"§aDu §abist §anun §anicht §amehr §aAFK§8.", "§aYou §aare §ano §alonger §aAFK§8."),
	SYSTEM_DU_BIST_NUN_AFK(main.prefix+"§aDu §abist §anun §aAFK§8.", "§aYou §aare §anow §aAFK§8."),
	SYSTEM_DU_BIST_BEREITS_AUF_DER_LOBBY(main.prefix+"§cDu §cbist §cbereits §cauf §ceiner §cLobby§8.", "§cYou §care §callready §cin §ca §cLobby§8."),
	
	FRIEND_COMMAND_EXESTIERT_NICHT(main.prefix_freunde+"§cDer §cCommand §cexestiert §cnicht§8.", ""),
	FRIEND_SERVER_BETRETEN("§3Server §3betretne§8.", ""),
	FRIEND_OFFLINE("Offline", "Offline"),
	FRIEND_ONLINE_AUF("§aOnline §3auf", ""),
	FRIEND_SPIELER("Spieler", "Player"),
	FRIEND_DER_SPIELER_WAR_NOCH_NIE_AUF_DEN_SERVER(main.prefix_freunde+"§3Dieser §eSpieler §3war §3noch §3nie §3auf §3diesen §eServer§8.", ""),
	FRIEND_SPIELER_HAT_KEINE_ANFRAGE_GESENDET(main.prefix_freunde+"§3Der §eSpieler §3hat §3dir §3keine §3Freundschaftanfrage §3gesendet§8.", ""),
	FRIEND_DU_HAST_DIE_FREUNDSCHAFTSANFRAGE_ANGENOMMEN(main.prefix_freunde+"§3Du hast §e%TARGET% §3Freundschaftanfrage §3angenomen§8.", ""),
	FRIEND_PLAYER_HAT_DIE_FREUNDSCHAFTSANFRAGE_ANGENOMMEN(main.prefix_freunde+"§e%TARGET% §3hat §3die §3Freundschaftanfrage §3angenomen§8.", ""),
	FRIEND_DU_HAST_ALLE_FREUNDSCHAFTSANFRAGEN_ANGENOMMEN(main.prefix_freunde+"§3Du §3hast §3alle §3Freundschaftsanfragen §3angenomen§8.", ""),
	FRIEND_DU_KANNST_DIR_KEINE_EIGENE_FREUNDSCHAFTSANFRAGE_SENDEN(main.prefix_freunde+"§3Du §3kannst §3dir §3keine §3eigene §3Freundschaftsanfrage §3senden§8.", ""),
	FRIEND_SPIELER_NIMMT_KEINE_ANFRAGEN_AN(main.prefix_freunde+"§3Der §3Spieler §3nimmt §3keine §3Freundschaftsanfragen §3an§8.", ""),
	FRIEND_DU_HAST_DEN_SPIELER_SCHON_EINE_FREUNDSCHAFTSANFRAGE_GESENDER(main.prefix_freunde+"§3Du §3hast §3den §3Spieler §e%TARGET% §3schon §3eine §3Freundschaftsanfrage §3gesendet§8.", ""),
	FRIEND_HAT_DEINE_FREUNDSCHAFTSANFRAGEN_ANGENOMMEN(main.prefix_freunde+"§e%TARGET% §3hat §3die §3Freundschaftanfrage §3angenomen§8.", ""),
	FRIEND_DU_BIST_NUN_MIT_PLAYER_BEFREUNDET(main.prefix_freunde+"§3Du §3bist §3nun §3mit §e%TARGET% §3befreundet§8.", ""),
	FRIEND_SPIELER_FREUNDSCHAFTS_ANFRAGE_ANNEHMEN(main.prefix_freunde+"§e%TARGET%'s §3FreundSchaftsanfrage §3anehmen?\n"+main.prefix_freunde, ""),
	FRIEND_NEHME_DIE_FREUNDSCHAFTSANFRAGE_VON_SPIELER_AN("§3Nehme §3die §3Freundschaftanfrage §3von §e%TARGET% §3an§8.", ""),
	FRIEND_LEHNE_DIE_FREUNDSCHAFTSANFRAGE_VON_SPIELER_AB("§3Lehne §3die §3Freundschaftanfrage §3von §e%TARGET% §3ab§8.", ""),
	FRIEND_DU_HAST_DEN_SPIELER_EINE_FREUNDSCHAFTSANFRAGE_GESENDET(main.prefix_freunde+"§3Du §3hast §3den §3Spieler §e%TARGET% §3eine §3Freundeschaftsanfrage §3gesendet§8.", ""),
	FRIEND_DU_BIST_BEREITS_MIT_DEN_SPIELER_BEFREUNDET(main.prefix_freunde+"§3Du §3bist §3bereits §3mit §3diesen §eSpieler §3befreundet§8.", ""),
	FRIEND_FREUNDE_ALLE_LÖSCHEN_CONFIRM(main.prefix_freunde+"§cEs §cwerden §cALLE §cFreunde §cgelöscht§8!\n"+main.prefix_freunde+"§3Bestätigen §3mit§8: §e/Friend §eclear §econfirm", ""),
	FRIEND_DU_BIST_NUN_NICHT_MEHR_MIR_SPIELER_BEFREUNDET(main.prefix_freunde+"§3Du §3bist §3nun §3nicht §3mehr §3mit §e%TARGET% §3befreundet§8.", ""),
	FRIEND_DU_HAST_ALLE_FREUNDE_GELÖSCHT(main.prefix_freunde+"§3Du §3hast §3alle §3Freunde §3gelöscht§8.", ""),
	FRIEND_DU_BIST_MIT_SPIELER_BEFREUNDET(main.prefix_freunde+"§3Du §3bist §3mit §e%TARGET% §3befreundet§8.", ""),
	FRIEND_DU_HAST_DIE_FREUNDSCHAFTSANFRAGE_AN_SPIELER_GELÖSCHT(main.prefix_freunde+"§3Du §3hast §3die §3Freundschaftsanfrage §3an §e%TARGET% §3gelöscht§8.", ""),
	FRIEND_DU_HAST_DEN_SPIELER_NOCH_KEINE_FREUNDSCHAFTSANFRAGE_GESENDET(main.prefix_freunde+"§3Du §3hast §3den §eSpieler §3noch §3keine §3Freundschaftsanfrage §3gesendet§8.", ""),
	FRIEND_DU_HAST_DIE_FREUNDSCHAFTSANFRAGE_AN_SPIELER_ABGELEHNT(main.prefix_freunde+"§3Du hast §e%TARGET% §3Freundschaftanfrage §3abgelehnt§8.", ""),
	FRIEND_HAT_DEINE_FREUNDSCHAFTSANFRAGEN_ABGELEHNT(main.prefix_freunde+"§e%TARGET% §3hat §3die §3Freundschaftanfrage §3abgelehnt§8.", ""),
	FRIEND_DU_HAST_ALLE_FREUNDSCHAFTSANFRAGEN_ABGELEHNT(main.prefix_freunde+"§3Du §3hast §3alle §3Freundschaftsanfragen §3abgelehnt§8.", ""),
	FRIEND_DIE_SEITE_EXESTIERT_NICHT(main.prefix_freunde+"§3Diese §3seite §3exestiert §3nicht§8.", ""),
	FRIEND_BITTE_GEBE_EINE_ZAHL_AN(main.prefix_freunde+"§3Bitte §3gebe §3eine §3Zahl §3an§8.", ""),
	FRIEND_BITTE_GEBE_EINE_ZAHL_ÜBER_0_AN(main.prefix_freunde+"§3Bitte §3gebe §3eine §eZahl §3über §e0 §3an§8.", ""),
	FRIEND_DU_BIST_NUN_NICHT_MEHR_MIT_SPIELER_BEFRUNDET(main.prefix_freunde+"§3Du §3bist §3nun §3nicht §3mehr §3mit §e%TARGET% §3befreundet§8.", ""),
	FRIEND_DU_BIST_NICHT_MIT_DIESEN_SPIELER_BEFRUNDET(main.prefix_freunde+"§3Du §3bist §3nicht §3mit §3diesen §eSpieler §3befreundet§8.", ""),
	
	
	NOTIFY_DU_HAST_SCHON_AKTIVIERT(main.prefix+"§cDu §cerhältst §cbereits §calle §cBenachrichtigungen§8.", "§cDu §cerhältst §cbereits §calle §cBenachrichtigungen§8."),
	NOTIFY_AKTIVIERT(main.prefix+"§aDu §aerhältst §anun §awieder §aalle §aInformationen §azu §aBestrafungen §aund §aRegelbrüchen§8.", "§aDu §aerhältst §anun §awieder §aalle §aInformationen §azu §aBestrafungen §aund §aRegelbrüchen§8."),
	NOTIFY_DEAKTIVIERT(main.prefix+"§aDu §aerhältst §anun §akeine §aInformationen §azu §aBestrafungen §aund §aRegelbrüchen §amehr§8.", "§aDu §aerhältst §anun §akeine §aInformationen §azu §aBestrafungen §aund §aRegelbrüchen §amehr§8."),
	NOTIFY_DU_HAST_SCHON_DEAKTIVIERT(main.prefix+"§cDu §cerhältst §cbereits §ckeine §cBenachritigungen §cmehr§8.", "§cDu §cerhältst §cbereits §ckeine §cBenachritigungen §cmehr§8."),
	
	PARTY_BETRETE_DIE_PARTY_MIT(main.prefix_party+"§3Betrete §3die §3Party §3mit §e/party §ejoin §e%TARGET%§8.", "§3Join §3the §party §3with §e/party §ejoin §e%TARGET%§8."),
	PARTY_DU_WURDEST_IN_DIE_PARTY_VON_SPIELER_EINGELADEN(main.prefix_party+"§3Du §3wurdest §3in §3die §3Party §3von §e%TARGET% §aeingeladen§8.", "§3You §3have §3been §3invitet §3to §3the §3party §3from §e%TARGET%§8."),
	PARTY_DU_HAST_DEN_SPIELER_IN_DEINE_PARTY_EINGELADEN(main.prefix_party+"§aDu §ahast §e%TARGET% §aerfolgreich §ain §adeine §aParty §aeingeladen§8.", "§aYou §asaccessfully §ainvited §e%TARGET% §ato §ayour §aparty§8."),
	PARTY_PARTY_BETRETEN(main.prefix_party+"§e%TARGET%'s §3Party Beitreten§8?\n"+main.prefix_party, "§3Join §3the §3Party §3from §e%TARGET"),
	PARTY_BETRETE_DIE_PARTY_VON_SPIELER("§aBetrete §adie §aParty §avon §e%TARGET%§8.", ""),
	PARTY_LEHNE_DIE_PARTY_VON_SPIELER_AB("§3Lehne §3die §3Party §3von §e%TARGET% §3ab§8.", ""),
	PARTY_DIE_EINLADUNG_VON_SPIELER_IST_ABGELAUFTEN(main.prefix_party+"§3Die §3Einladung §3von §e%TARGET% §3ist §3abgelaufen§8.", ""),
	PARTY_IHRE_EINLADUNG_IST_ABGELAUFTEN(main.prefix_party+"§3Ihre §3Einladung §3ist §3abgelaufen§8.", ""),
	PARTY_DU_HAST_DEN_SPIELER_SCHON_EINGELADEN(main.prefix_party+"§3Du §3hast §3diesen §3Spieler §3schon §3in §3deine §5Party §3eingeladen§8.", ""),
	PARTY_DU_WURDEST_ZU_KEINER_PARTY_EINGELADEN(main.prefix_party+"§3Du §3wurdest §3in §3keine §5Party §3eingeladen§8.", ""),
	PARTY_DER_SPIELER_HAT_DIE_PARTY_ANFRAGE_ABGELEHNT(main.prefix_party+"§3Der §3Spieler §e%TARGET% §3hat §3die §3Einladung §3abgelehnt§8.", ""),
	PARTY_DU_HAST_DIE_PARTY_VON_SPIELER_ABGELEHNT(main.prefix_party+"§3Du §3hast §3die §3Party §3von §e%TARGET% §3Abgelehn§8.", ""),
	PARTY_DER_SPIELER_HAT_DIE_PARTY_BETRETEN(main.prefix_party+"§3Der §3Spieler §e%TARGET% §3hat §3die §5Party §3betreten§8.", ""),
	PARTY_DER_SPIELER_HAT_KEINE_PARTY(main.prefix_party+"§cDer §cSpieler §chat §ckeine §cParty§8.", ""),
	PARTY_DER_SPIELR_IST_NICHT_ONLINE(main.prefix_party+"§cDieser §cSpieler §cist §cnicht §cauf §cdem §cNetzwerk§8.", "EN"),
	PARTY_DU_BIST_SCHON_IN_EINER_PARTY(main.prefix_party+"§cDu §cbist §cbereits §cin §ceiner §5Party§8.", ""),
	PARTY_DU_KANNST_DER_PARTY_NICHT_BETRETEN(main.prefix_party+"§cDu §ckannst §cdie §cParty §cnicht §cbetreten§8.", ""),
	PARTY_IST_BEREITS_IN_EINER_PARTY(main.prefix_party+"§cDer §cSpieler §cist §cbereits §cin §ceiner §5Party§8.", ""),
	PARTY_DER_SPIELER_NIMMT_KEINE_ANFRAGEN_AN(main.prefix_party+"§cDer §cSpieler §cnimmt §ckeine §cParty §ceinladungen §can§8.", ""),
	PARTY_DER_SPISLER_NIMMT_NUR_FREUNDSCHAFTSANFRAGEN_AN(main.prefix_party+"§cDer §cSpieler §cnimmt §cnur §cvon §cFreunde §ceinladungen §can§8.", ""),
	PARTY_DU_KANNST_DICH_NICHT_SELBST_EINLADEN(main.prefix_party+"§cDu §ckannst §cdich §cnicht §cselber §cEinladen§8.", ""),
	PARTY_CREATE_PARTY(main.prefix_party+"§3Du §3hast §3eine §3neue §5Party §3erstellt§8.", ""),
	PARTY_DU_BIST_NICHT_DER_PARTY_LEITER(main.prefix_party+"§cDu §cbist §cnicht §cder §5Party §cLeiter§8.", ""),
	PARTY_DU_HAST_DIE_MAXIMALE_PARTY_GRÖSSE_EREICHT(main.prefix_party+"§cDu §chast §cdie §cmaximale §5Party §cgröße §cereicht§8.", ""),
	PARTY_DU_BIST_IN_KEINER_PARTY(main.prefix_party+"§cDu §cbist §cin §ckeiner §cParty§8.", ""),
	PARTY_NAME_LEITER("Leiter", ""),
	PARTY_NAME_MITGLIEDER("Mitglieder", ""),
	PARTY_NAME_KICKEN("Kicken", ""),
	PARTY_TOGGLE_FRIENDS(main.prefix_party+"§3Nur §3noch §3Freunde §3können §3dir §3eine §3einladungen §3schicken§8.", ""),
	PARTY_TOGGLE_ALLE(main.prefix_party+"§3Du §3kannst §3nun §3wieder §3Party §3einladungen §3bekommen§8.", ""),
	PARTY_TOGGLE_NIEMAND(main.prefix_party+"§3Du §3bekommst §3nun §3keine §3Party §3einladungen §3mehr§8.", ""),
	PARTY_DIE_PARTY_WURDE_WEGEN_ZU_WENIG_MITGLIEDER_AUFGELÖST(main.prefix_party+"§cDie §cParty §cwurde §cwegen §czu §cwenigen §cMitspielern §caufgelöst§8.", ""),
	PARTY_DU_HAST_ALLE_ZU_DIR_GESENDET(main.prefix_party+"§3Du §3hast §3alle §3Spieler §3zu §3dir §3Teleportiert§8.", ""),
	PARTY_DER_PARTY_LEITER_SENDER_DICH_AUF(main.prefix_party+"§3Der §3Party §3Leiter §3sendet §3dich §3auf §3seinen §3Server§8: §e%SERVER%", ""),
	PARTY_DER_PARTYLEITER_MÖCHTE_DICH_AUF_SEINEN_SERVER_SENDEN(main.prefix_party+"§3Der §3Party §3Leiter §3möchte §3dich §3auf §3seinen §3Server §3senden§8.", ""),
	PARTY_DER_SPIELER_IST_NICHT_IN_DEINER_PARTY(main.prefix_party+"§cDer §cSpieler §cist §cnicht §cin §cdeiner §cParty§8.", ""),
	PARTY_DER_PARTYLEITER_GAB_DEN_RANK_AN_PLAYER_AB(main.prefix_party+"§3Der §3Leader §3gab §3den §3Leader §3Rank §3an §e%TARGET% §3ab§8.", ""),
	PARTY_DU_HAST_DEN_RANK_SPIELER_GEGEBEN(main.prefix_party+"§3Du §3hast §3den §3Leader §3Rank §3an §e%TARGET% §3abgegeben§8.", ""),
	PARTY_DU_KANNST_DIE_PARTY_NICHT_VERLASSEN(main.prefix_party+"§3Du §3kannst §3die §3Party §3nicht §3verlassen§8.", ""),
	PARTY_DER_SPIELER_HAT_DIE_PARTY_VERLASSEN(main.prefix_party+"§3Der §3Spieler §e%TARGET% §3hat §3die §3Party §3verlassen§8.", ""),
	PARTY_DU_HAST_DIE_PARTY_VERLASSEN(main.prefix_party+"§3Du §3hast §3die §3Party §3verlassen.", ""),
	PARTY_DU_HAST_DIE_PARTY_GELÖSCHT(main.prefix_party+"§3Du §3hast §3die §3Party §3gelöscht§8.", ""),
	PARTY_DER_NEUE_PARTY_LEITER_IST(main.prefix_party+"§3Der §3neue §3Party §3Leiter §3ist §e%TARGET%§8.", ""),
	PARTY_DU_BIST_NUN_DER_PARTY_LEITER(main.prefix_party+"§3Du §3bist §3nun §3der §3Party §3leiter§8.", ""),
	PARTY_DER_LEITER_HAT_DIE_PARTY_VERLASSEN(main.prefix_party+"§3Der §3Leiter §3hat §3die §3Party §3verlassen§8.", ""),
	PARTY_DU_KANNST_DEN_SPIELER_NICHT_AUS_DER_PARTY_SCHMEISSEN(main.prefix_party+"§3Du §3kannst §3den §3Spieler §3nicht §3aus §3deiner §5Party §3werfen§8.", ""),
	PARTY_DU_WURDEST_AUS_DER_PARTY_GESCHMISSEN(main.prefix_party+"§3Du §3wurdest §3aus §3der §5Party §3geschmissen§8.", ""),
	PARTY_DER_SPIELER_WURDE_AUS_DER_PARTY_GESCHMISSEN(main.prefix_party+"§3Der §3Spieler §e%TARGET% §3wurde §3aus §3der §5Party §3geschmissen§8.", ""),
	PARTY_DU_HAST_DEN_SPIELER_RAUSGEWORFEN(main.prefix_party+"§3Du §3hast §3den §3Spieler §e%TARGET% §3aus §3der §5Party §3rausgeschmissen§8.", ""),
	PARTY_BITTE_GEBE_EINEN_SPIELER_NAMEN_AN(main.prefix_party+"§cBitte §cgebe §ceinen §cSpielernamen §can§8.", "");
	
	public String message_de;
	public String message_en;
	
	private Message(String deutsch, String englisch) {
		this.message_de = deutsch;
		this.message_en = englisch;
	}
	
	public String getMessage(ProxiedPlayer p) {
		Global_Players player = Global_Players.getPlayer(de.NilssMiner99.mongodb_Bungee.main.main.plugin, p.getUniqueId().toString());
		String message = message_de;
		if(player.getLanguage().equalsIgnoreCase("EN")) {
			message = message_en;
		}
		return message;
	}

	public void sendMessage(ProxiedPlayer p) {
		Global_Players player = Global_Players.getPlayer(de.NilssMiner99.mongodb_Bungee.main.main.plugin, p.getUniqueId().toString());
		if(player.getLanguage().equalsIgnoreCase("DE")) {
			p.sendMessage(new TextComponent(message_de));
		} else {
			p.sendMessage(new TextComponent(message_en));
		}
	}
	
	public void sendMessageReplace(ProxiedPlayer p, String get, String to) {
		Global_Players player = Global_Players.getPlayer(de.NilssMiner99.mongodb_Bungee.main.main.plugin, p.getUniqueId().toString());
		if(player.getLanguage().equalsIgnoreCase("DE")) {
			p.sendMessage(new TextComponent(message_de.replaceAll(get, to)));
		} else {
			p.sendMessage(new TextComponent(message_en.replaceAll(get, to)));
		}
	}
}