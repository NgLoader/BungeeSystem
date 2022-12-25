package de.NilssMiner99.BungeeSystem.Commands_Team;

import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_Team extends Command {

	public COMMAND_Team(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		sender.sendMessage(new TextComponent("§8[]§7----------------- §4Teammitglieder §4Online §7-----------------§8[]"));
		sender.sendMessage(new TextComponent(" "));
		sender.sendMessage(new TextComponent("          §4Administrator(en)"));
		sender.sendMessage(new TextComponent(" "));
		for(ProxiedPlayer team : ProxyServer.getInstance().getPlayers()) {
			if(team.hasPermission("liveplays.admin") && (!(main.afk.contains(team.getUniqueId().toString())))) {
				sender.sendMessage(new TextComponent("   §8- §e"+team.getName()));
			}
		}
		sender.sendMessage(new TextComponent(" "));
		sender.sendMessage(new TextComponent("          §cDeveloper(s)"));
		sender.sendMessage(new TextComponent(" "));
		for(ProxiedPlayer team : ProxyServer.getInstance().getPlayers()) {
			if(team.hasPermission("liveplays.dev") && (!(main.afk.contains(team.getUniqueId().toString())))) {
				sender.sendMessage(new TextComponent("   §8- §e"+team.getName()));
			}
		}
		sender.sendMessage(new TextComponent(" "));
		sender.sendMessage(new TextComponent("          §9Sr. Moderator(en)"));
		sender.sendMessage(new TextComponent(" "));
		for(ProxiedPlayer team : ProxyServer.getInstance().getPlayers()) {
			if(team.hasPermission("liveplays.srmod") && (!(main.afk.contains(team.getUniqueId().toString())))) {
				sender.sendMessage(new TextComponent("   §8- §e"+team.getName()));
			}
		}
		sender.sendMessage(new TextComponent(" "));
		sender.sendMessage(new TextComponent("          §3Moderator(en)"));
		sender.sendMessage(new TextComponent(" "));
		for(ProxiedPlayer team : ProxyServer.getInstance().getPlayers()) {
			if(team.hasPermission("liveplays.mod") && (!(main.afk.contains(team.getUniqueId().toString())))) {
				sender.sendMessage(new TextComponent("   §8- §e"+team.getName()));
			} else if(team.hasPermission("liveplays.testmod") && (!(main.afk.contains(team.getUniqueId().toString())))) {
				sender.sendMessage(new TextComponent("   §8- §e"+team.getName()));
			}
		}
		sender.sendMessage(new TextComponent(" "));
		sender.sendMessage(new TextComponent("          §2Supporter"));
		sender.sendMessage(new TextComponent(" "));
		for(ProxiedPlayer team : ProxyServer.getInstance().getPlayers()) {
			if(team.hasPermission("liveplays.sup") && (!(main.afk.contains(team.getUniqueId().toString())))) {
				sender.sendMessage(new TextComponent("   §8- §e"+team.getName()));
			}
		}
		sender.sendMessage(new TextComponent(" "));
		sender.sendMessage(new TextComponent("§8[]§7----------------- §4Teammitglieder §4Online §7-----------------§8[]"));
	}
}