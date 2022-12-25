package de.NilssMiner99.BungeeSystem.Commands_Freunde;

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

public class FreundeCommand extends Command {

	private List<SubCommand> cmds = new ArrayList<SubCommand>();
	private List<SubCommand> cmds_2 = new ArrayList<SubCommand>();
	
	public FreundeCommand() {
		super("friend");
		cmds.add(new Add());
		cmds.add(new de.NilssMiner99.BungeeSystem.Commands_Freunde.List());
		cmds.add(new Remove());
		cmds.add(new Delinvite());
		/* jump */
		/* msg */

		cmds_2.add(new Clear());
		cmds_2.add(new Requests());
		cmds_2.add(new Accept());
		cmds_2.add(new Deny());
		cmds_2.add(new AcceptAll());
		cmds_2.add(new DenyAll());
		/* toggle */
		/* togglenotify */
		/* togglemessage */
		/* togglejump */
		/* toggleparty */
	}
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof ProxiedPlayer)) {
			sender.sendMessage(new TextComponent(main.prefix_freunde+" §cDu §cmusst §cein §4Spieler §csein§8!"));
			return;
		}
		
		ProxiedPlayer p = (ProxiedPlayer)sender;
		
		if(args.length == 0) {
			sender.sendMessage(new TextComponent("§8[]§7----------------- §4Freunde §7-----------------§8[]"));
			sender.sendMessage(new TextComponent(" "));
			sender.sendMessage(new TextComponent("§e/Friend §e2"));
			for(SubCommand sc : cmds) {
				p.sendMessage(new TextComponent("§e/Friend "+aliases(sc).replaceAll(" ", " §e")+ " " + sc.getUsage().replaceAll(" ", " §e") + " §8| §3"+sc.getMessage(p).replaceAll(" ", " §3").replaceAll("Seite", Message.MESSAGE_SEITE.getMessage(p)).replaceAll("Spieler", Message.FRIEND_SPIELER.getMessage(p))+"§8."));
			}
			sender.sendMessage(new TextComponent(" "));
			sender.sendMessage(new TextComponent("§8[]§7----------------- §4Freunde §7-----------------§8[]"));
			return;
		} else if(args.length == 1) {
			if(args[0].equalsIgnoreCase("2")) {
				sender.sendMessage(new TextComponent("§8[]§7----------------- §4Freunde §7-----------------§8[]"));
				sender.sendMessage(new TextComponent(" "));
				for(SubCommand sc : cmds_2) {
					p.sendMessage(new TextComponent("§e/Friend "+aliases(sc).replaceAll(" ", " §e")+ " " + sc.getUsage().replaceAll(" ", " §e") + " §8| §3"+sc.getMessage(p).replaceAll(" ", " §3").replaceAll("Seite", Message.MESSAGE_SEITE.getMessage(p)).replaceAll("Spieler", Message.FRIEND_SPIELER.getMessage(p))+"§8."));
				}
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§8[]§7----------------- §4Freunde §7-----------------§8[]"));
				return;
			}
		}
		
		SubCommand sc = getCommand(args[0]);
		
		if(sc == null) {
			Message.COMMAND_NOT_EXIST.sendMessage(p);
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
		for(SubCommand sc : cmds_2) {
			if(sc.getClass().getSimpleName().equalsIgnoreCase(name)) return sc;
			for(String alias : sc.getAliases()) if(alias.equalsIgnoreCase(name)) return sc;
		}
		return null;
	}
}
