package de.NilssMiner99.BungeeSystem.Commands_MuteSystem;

import de.NilssMiner99.BungeeSystem.Manager.GruppenManager;
import de.NilssMiner99.BungeeSystem.Manager.MuteSystem;
import de.NilssMiner99.BungeeSystem.Manager.NotifyManager;
import de.NilssMiner99.BungeeSystem.Manager.UUIDFeature;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_UnMute extends Command {
	
	public COMMAND_UnMute(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!sender.hasPermission("liveplays.mute")) {
			sender.sendMessage(new TextComponent(main.noperm));
			return;
		}
		if(args.length >= 2) {
			if(UUIDFeature.getUUID(args[0]) != null && UUIDFeature.getUUID(args[0]) != "") {
				if(MuteSystem.isMutened(UUIDFeature.getUUID(args[0]))) {
					String text = "";
					for(int i = 1; i < args.length; i++) {
						text = text+args[i]+" §e";
					}
					String banner = MuteSystem.getData(UUIDFeature.getUUID(args[0])).get(2);
					if(!(sender.hasPermission("liveplays.admin"))) {
						if(sender instanceof ProxiedPlayer) {
							if(!(banner.equalsIgnoreCase(((ProxiedPlayer)sender).getUniqueId().toString()))) {
								if(banner.equalsIgnoreCase("console")) {
									sender.sendMessage(new TextComponent(main.prefix+"§eDu kannst diesen §3Spieler §enicht §3entmutet§e."));
									return;
								} else if(GruppenManager.hasPermissons(banner, "liveplays.team")) {
									sender.sendMessage(new TextComponent(main.prefix+"§eDu kannst diesen §3Spieler §enicht §3entmutet§e."));
									return;
								}
							}
						}
					}
					MuteSystem.unMute(UUIDFeature.getUUID(args[0]));
					for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
						if(player.hasPermission("liveplays.team")&& (!(NotifyManager.notify.contains(player.getUniqueId().toString())))) {
							player.sendMessage(new TextComponent("§8[]§7----------------- §4Unmute §7-----------------§8[]"));
							player.sendMessage(new TextComponent("§3Spieler§8: §e"+UUIDFeature.getName(UUIDFeature.getUUID(args[0]))));
							String entbanner = sender instanceof ProxiedPlayer ?  sender.getName() : "CONSOLE";
							player.sendMessage(new TextComponent("§3Entmutet §3von§8: §e"+entbanner));
							player.sendMessage(new TextComponent("§3Entmutungs §3Grund§8: §e"+text));
							player.sendMessage(new TextComponent("§8[]§7----------------- §4Unmute §7-----------------§8[]"));
						}
					}
					return;
				}
				sender.sendMessage(new TextComponent(main.prefix+"§cDieser §cSpieler §cist §cnicht §cGemutet§8."));
				return;
			}
			sender.sendMessage(new TextComponent(main.prefix+"§cDieser §cSpieler §cwar §cnoch §cnie §cauf §cdiesen §cServer§8."));
			return;
		}
		sender.sendMessage(new TextComponent(main.prefix+"§c/Unmute §c<§4Spieler§c> §c<§4Grund§c>"));
		return;
	}
}