package de.NilssMiner99.BungeeSystem.Commands_BanSystem;

import de.NilssMiner99.BungeeSystem.Manager.BanSystem;
import de.NilssMiner99.BungeeSystem.Manager.GruppenManager;
import de.NilssMiner99.BungeeSystem.Manager.NotifyManager;
import de.NilssMiner99.BungeeSystem.Manager.UUIDFeature;
import de.NilssMiner99.BungeeSystem.main.main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_UnBan extends Command {
	
	public COMMAND_UnBan(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!sender.hasPermission("liveplays.ban")) {
			sender.sendMessage(new TextComponent(main.noperm));
			return;
		}
		if(args.length >= 2) {
			if(UUIDFeature.getUUID(args[0]) != null && UUIDFeature.getUUID(args[0]) != "") {
				if(BanSystem.isBanned(UUIDFeature.getUUID(args[0]))) {
					String banner = BanSystem.getData(UUIDFeature.getUUID(args[0])).get(2);
					String text = "";
					for(int i = 1; i < args.length; i++) {
						text = text+args[i]+" §e";
					}
					if(!(sender.hasPermission("liveplays.admin"))) {
						if(sender instanceof ProxiedPlayer) {
							if(!(banner.equalsIgnoreCase(((ProxiedPlayer)sender).getUniqueId().toString()))) {
								if(banner.equalsIgnoreCase("console")) {
									sender.sendMessage(new TextComponent(main.prefix_bs+"§cDu kannst diesen Spieler nicht entbannen§8."));
									return;
								} else if(GruppenManager.hasPermissons(banner, "liveplays.team")) {
									sender.sendMessage(new TextComponent(main.prefix_bs+"§cDu kannst diesen Spieler nicht entbannen§8."));
									return;
								}
							}
						}
					}
					BanSystem.unBan(UUIDFeature.getUUID(args[0]));
					for(ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
						if(player.hasPermission("liveplays.team") && (!(NotifyManager.notify.contains(player.getUniqueId().toString())))) {
							player.sendMessage(new TextComponent("§8[]§7----------------- §4Unban §7-----------------§8[]"));
							player.sendMessage(new TextComponent("§3Spieler§8: §e"+UUIDFeature.getName(UUIDFeature.getUUID(args[0]))));
							String entbanner = sender instanceof ProxiedPlayer ?  sender.getName() : "CONSOLE";
							player.sendMessage(new TextComponent("§3Entbannt §3von§8: §e"+entbanner));
							player.sendMessage(new TextComponent("§3Entbannungs §3Grund§8: §e"+text));
							player.sendMessage(new TextComponent("§8[]§7----------------- §4Unban §7-----------------§8[]"));
						}
					}
					return;
				}
				sender.sendMessage(new TextComponent(main.prefix_bs+"§cDieser §cSpieler §cist §cnicht gebannt§8."));
				return;
			}
			sender.sendMessage(new TextComponent(main.prefix_bs+"§cDieser §cSpieler §cwar §cnoch §cnie §cauf §cdem §cNetzwerk§8."));
			return;
		}
		sender.sendMessage(new TextComponent(main.prefix_bs+"§3Verwendung§8:§c/Unban §c<§Spieler§c> §c<§4Grund§c>"));
		return;
	}
}