package de.NilssMiner99.BungeeSystem.Commands_Party;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import de.NilssMiner99.BungeeSystem.Manager.SubCommand;
import de.NilssMiner99.BungeeSystem.Message.Message;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PartyCommand extends Command {

	private List<SubCommand> cmds = new ArrayList<SubCommand>();
	
	public PartyCommand() {
		super("party");
		cmds.add(new Create());
		cmds.add(new Invite());
		cmds.add(new Accept());
		cmds.add(new Deny());
		cmds.add(new de.NilssMiner99.BungeeSystem.Commands_Party.List());
		cmds.add(new Leave());
		cmds.add(new Kick());
		cmds.add(new Promote());
		cmds.add(new Toggle());
		cmds.add(new Warp());
	}
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof ProxiedPlayer)) {
			sender.sendMessage(new TextComponent(main.prefix_party+" §cDu §cmusst §cein §4Spieler §csein!"));
			return;
		}
		
		ProxiedPlayer p = (ProxiedPlayer)sender;
		
		if(args.length == 0) {
			sender.sendMessage(new TextComponent("§8[]§7----------------- §4Party §7-----------------§8[]"));
			sender.sendMessage(new TextComponent(" "));
			for(SubCommand sc : cmds) {
				p.sendMessage(new TextComponent("§e/party "+aliases(sc)+ " " + sc.getUsage() + " §8| §3"+sc.getMessage(p)+"§8."));
			}
			sender.sendMessage(new TextComponent(" "));
			sender.sendMessage(new TextComponent("§8[]§7----------------- §4Party §7-----------------§8[]"));
			return;
		}
		
		SubCommand sc = getCommand(args[0]);
		
		if(sc == null) {
			p.sendMessage(new TextComponent(main.prefix_party + Message.COMMAND_NOT_EXIST.getMessage(p)));
			return;
		}
		
		Vector<String> a = new Vector<String>(Arrays.asList(args));
		a.remove(0);
		args = a.toArray(new String[a.size()]);
		
		sc.onCommand(p, args);
		return;
	}
	
	private String aliases(SubCommand sc) {
		String fin = "";
		
		for(String a : sc.getAliases()) {
			fin += a + " | ";
		}
		
		return fin.substring(0, fin.lastIndexOf(" | "));
	}
	
	private SubCommand getCommand(String name) {
		for(SubCommand sc : cmds) {
			if(sc.getClass().getSimpleName().equalsIgnoreCase(name)) return sc;
			for(String alias : sc.getAliases()) if(alias.equalsIgnoreCase(name)) return sc;
		}
		return null;
	}
}
