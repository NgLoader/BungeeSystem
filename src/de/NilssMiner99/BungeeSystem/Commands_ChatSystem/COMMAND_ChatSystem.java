package de.NilssMiner99.BungeeSystem.Commands_ChatSystem;

import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_ChatSystem extends Command {

	public COMMAND_ChatSystem(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		sender.sendMessage(new TextComponent("§8[]§7----------------- §4ChatSystem §7-----------------§8[]"));
		sender.sendMessage(new TextComponent(" "));
		sender.sendMessage(new TextComponent(main.prefix_cs+"§cDieses "));
		sender.sendMessage(new TextComponent(" "));
		sender.sendMessage(new TextComponent("§8[]§7----------------- §4ChatSystem §7-----------------§8[]"));
	}
}