package de.NilssMiner99.BungeeSystem.Manager;

import de.NilssMiner99.mongodb_Bungee.MongoDB.Global_Players;
import de.NilssMiner99.mongodb_Bungee.main.main;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public abstract class SubCommand {

	private String message_de, message_en, usage;
	private String[] aliases;
	
	public SubCommand(String message_de, String message_en, String usage, String... aliases) {
		this.message_de = message_de;
		this.message_en = message_en;
		this.usage = usage;
		this.aliases = aliases;
	}
	
	public abstract void onCommand(ProxiedPlayer p, String[] args);
	
	public final String getMessage(ProxiedPlayer p) {
		Global_Players gplayer = Global_Players.getPlayer(main.plugin, p.getUniqueId().toString());
		if(gplayer.getLanguage().equalsIgnoreCase("DE")) {
			return message_de;
		}
		return message_en;
	}
	
	public final String getUsage() {
		return usage;
	}
	
	public final String[] getAliases() {
		return aliases;
	}
	
}
