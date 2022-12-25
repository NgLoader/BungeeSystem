package de.NilssMiner99.BungeeSystem.Commands_ETC;

import java.util.UUID;

import de.NilssMiner99.BungeeSystem.Manager.GruppenManager;
import de.NilssMiner99.BungeeSystem.Manager.NotifyManager;
import de.NilssMiner99.BungeeSystem.Manager.UUIDFeature;
import de.NilssMiner99.BungeeSystem.main.main;
import de.NilssMiner99.mongodb_Bungee.MongoDB.Global_Players;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_Kick extends Command {

	public COMMAND_Kick(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!sender.hasPermission("liveplays.kick")) {
			sender.sendMessage(new TextComponent(main.noperm));
			return;
		}
		if(args.length >= 2) {
			if(UUIDFeature.getUUID(args[0]) != null) {
				if(ProxyServer.getInstance().getPlayer(UUID.fromString(UUIDFeature.getUUID(args[0]))) != null) {
					String text = "";
					for(int i = 1; i < args.length; i++) {
						text = text+args[i]+" ";
					}
					if(sender instanceof ProxiedPlayer) {
						String target = UUIDFeature.getUUID(args[0]);
						if(GruppenManager.hasPermissons(target, "liveplays.admin")) {
							sender.sendMessage(new TextComponent(main.prefix+"§cDu kannst den §4Spieler §3"+UUIDFeature.getName(target)+" §cnicht §4kicken§c."));
							return;
						} else {
							if(GruppenManager.hasPermissons(target, "liveplays.team")) {
								sender.sendMessage(new TextComponent(main.prefix+"§cDu kannst den §4Spieler §3"+UUIDFeature.getName(target)+" §cnicht §4kicken§c."));
								return;
							}
						}
					}
					ProxiedPlayer pp = ProxyServer.getInstance().getPlayer(UUIDFeature.getName(UUIDFeature.getUUID(args[0])));
					Global_Players pplayer = Global_Players.getPlayer(de.NilssMiner99.mongodb_Bungee.main.main.plugin, pp.getUniqueId().toString());
					if(pplayer.getLanguage().equalsIgnoreCase("DE")) {
						pp.disconnect(new TextComponent("§cDu §cwurdest §cvom §cNetzwerk §cgekickt§8!"
								+ "\n\n§cGrund§8: §e"+text.replaceAll(" ", " §e")));
					} else {
						pp.disconnect(new TextComponent("§cYou §chave §cbeen §ckicked §cfrom §cthe §cNetwork"
								+ "\n\n§cReason§8: §e"+text.replaceAll(" ", " §e")));
					}
					for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
						if(player.hasPermission("liveplays.team")&& (!(NotifyManager.notify.contains(player.getUniqueId().toString())))) {
							player.sendMessage(new TextComponent("§8[]§7----------------- §4Kick §7-----------------§8[]"));
							player.sendMessage(new TextComponent("§3Spieler§8: §e"+UUIDFeature.getName(UUIDFeature.getUUID(args[0]))));
							String banner = sender.getName().equalsIgnoreCase("console") ? "CONSOLE" : UUIDFeature.getName(UUIDFeature.getUUID(sender.getName()));
							player.sendMessage(new TextComponent("§3Gekick vom§8: §e"+banner));
							player.sendMessage(new TextComponent("§3Grund§8: §e"+text.replaceAll(" ", " §e")));
							player.sendMessage(new TextComponent("§8[]§7----------------- §4Kick §7-----------------§8[]"));
						}
					}
					sender.sendMessage(new TextComponent(main.prefix+"§eDu hast den §3Spieler §9"+pp.getName()+" §3gekickt§e."));
					return;
				}
				sender.sendMessage(new TextComponent(main.prefix+"§eDer §3Spieler §9"+UUIDFeature.getName(UUIDFeature.getUUID(args[0]))+" §eist nicht §3Online§e."));
				return;
			}
			sender.sendMessage(new TextComponent(main.prefix+"§eDieser §3Spieler §ewar noch nie auf diesen §3Server§e."));
			return;
		}
		sender.sendMessage(new TextComponent(main.prefix+"§3Verwendung§8: §e/kick §e<Spieler> §e<Grund>"));
		return;
	}
}