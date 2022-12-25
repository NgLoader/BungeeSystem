package de.NilssMiner99.BungeeSystem.Commands_ETC;

import java.util.ArrayList;
import java.util.UUID;

import de.NilssMiner99.BungeeSystem.Manager.BanSystem;
import de.NilssMiner99.BungeeSystem.Manager.MuteSystem;
import de.NilssMiner99.BungeeSystem.Manager.StatsManager;
import de.NilssMiner99.BungeeSystem.Manager.UUIDFeature;
import de.NilssMiner99.BungeeSystem.main.main;
import de.NilssMiner99.mongodb_Bungee.MongoDB.Global_Players;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class COMMAND_Check extends Command {
	
	public COMMAND_Check(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender.hasPermission("liveplays.ban") || sender.hasPermission("liveplays.mute"))) {
			sender.sendMessage(new TextComponent(main.noperm));
			return;
		}
		if(args.length == 0) {
			sendHelplist(sender);
			return;
		} else if(args.length >= 3 && args.length <= 3) {
			if(args[0].equalsIgnoreCase("ban")) {
				if(args[1].equalsIgnoreCase("list")) {
					Integer page = 0;
					try {
						page = Integer.valueOf(args[2]);
						if(page <= 0) {
							sender.sendMessage(new TextComponent(main.prefix+"§cBitte §cgeben §cein §eZahl §cüber §e0 §can§8."));
							return;
						}
					} catch(NumberFormatException ex) {
						sender.sendMessage(new TextComponent(main.prefix+"§cBitte §cgeben §cein §cZahl §cüber §e0 §can§8."));
						return;
					}
					int i2 = 1;
					while(i2*20 < BanSystem.getBans().size()) {
						i2++;
					}
					if(page <= i2) {
						sender.sendMessage(new TextComponent("§8[]§7----------------- §4Ban §4Sytem §7-----------------§8[]"));
						sender.sendMessage(new TextComponent(" "));
						if(BanSystem.getBans().size() == 0) {
							sender.sendMessage(new TextComponent(main.prefix+"§3Es §3sind §3keine §3Spieler §egebannt§8."));
						} else {
							Integer max = 20*page;
							Integer min = 20*page-20;
							for(int i = max; i > min; i--) {
								if(BanSystem.getBans().size() >= i) {
									sender.sendMessage(new TextComponent(main.prefix+"§8- §3"+UUIDFeature.getName(BanSystem.getBans().get(i-1))));
								}
							}
						}
						sender.sendMessage(new TextComponent(" "));
						sender.sendMessage(new TextComponent("§8[]§7----------------- §4Ban §4Sytem §7-----------------§8[]"));
						return;
					}
					sender.sendMessage(new TextComponent(main.prefix+"§cDiese §cSeite §cexestiert §cnicht§8."));
					return;
				} else {
					if(UUIDFeature.getUUID(args[1]) != null && UUIDFeature.getUUID(args[1]) != "") {
						Integer page = 0;
						try {
							page = Integer.valueOf(args[2]);
							if(page <= 0) {
								sender.sendMessage(new TextComponent(main.prefix+"§cBitte §cgeben §cein §eZahl §cüber §e0 §can§8."));
								return;
							}
						} catch(NumberFormatException ex) {
							sender.sendMessage(new TextComponent(main.prefix+"§cBitte §cgeben §cein §eZahl §cüber §e0 §can§8."));
							return;
						}
						if(BanSystem.getBanns(UUIDFeature.getUUID(args[1])) >= page && BanSystem.getBanInfo(UUIDFeature.getUUID(args[1]), page) != null) {
							ArrayList<String> data = BanSystem.getBanInfo(UUIDFeature.getUUID(args[1]), page);
							sender.sendMessage(new TextComponent("§8[]§7----------------- §4Ban §4Sytem §7-----------------§8[]"));
							sender.sendMessage(new TextComponent(" "));
							sender.sendMessage(new TextComponent("§3Spieler§8: §e"+args[1]));
							sender.sendMessage(new TextComponent(" "));
							sender.sendMessage(new TextComponent("§3Ban§8: §e"+page));
							sender.sendMessage(new TextComponent(" "));
							String von = data.get(2).equalsIgnoreCase("CONSOLE") ? data.get(2) : UUIDFeature.getName(data.get(2));
							sender.sendMessage(new TextComponent("§3Am§8: §e"+data.get(3)));
							sender.sendMessage(new TextComponent(" "));
							sender.sendMessage(new TextComponent("§3Von§8: §e"+von));
							sender.sendMessage(new TextComponent("§3Grund§8: §e"+data.get(1)));
							sender.sendMessage(new TextComponent("§3Zeitraum§8: §e"+data.get(0)));
							sender.sendMessage(new TextComponent(" "));
							sender.sendMessage(new TextComponent("§8[]§7----------------- §4Ban §4Sytem §7-----------------§8[]"));
							return;
						}
						sender.sendMessage(new TextComponent(main.prefix+"§cDer §cSpieler §chat §e"+BanSystem.getBanns(UUIDFeature.getUUID(args[1]))+" §cBan(s)§8."));
						return;
					}
					sender.sendMessage(new TextComponent(main.prefix+"§cDieser §cSpieler §cwar §cnoch §cnie §cauf §cdiesen §cServer."));
					return;
				}
			} else if(args[0].equalsIgnoreCase("mute")) {
				if(args[1].equalsIgnoreCase("list")) {
					Integer page = 0;
					try {
						page = Integer.valueOf(args[2]);
						if(page <= 0) {
							sender.sendMessage(new TextComponent(main.prefix+"§cBitte §cgeben §cein §eZahl §cüber §e0 §can§8."));
							return;
						}
					} catch(NumberFormatException ex) {
						sender.sendMessage(new TextComponent(main.prefix+"§cBitte §cgeben §cein §4Zahl §cüber §e0 §can§8."));
						return;
					}
					int i2 = 1;
					while(i2*20 < MuteSystem.getMutes().size()) {
						i2++;
					}
					if(page <= i2) {
						sender.sendMessage(new TextComponent("§8[]§7----------------- §4Mute §4Sytem §7-----------------§8[]"));
						sender.sendMessage(new TextComponent(" "));
						if(MuteSystem.getMutes().size() == 0) {
							sender.sendMessage(new TextComponent(main.prefix+"§3Es §3sind §3keine §eSpieler §3gemutent§8."));
						} else {
							Integer max = 20*page;
							Integer min = 20*page-20;
							for(int i = max; i > min; i--) {
								if(MuteSystem.getMutes().size() >= i) {
									sender.sendMessage(new TextComponent(main.prefix+"§8- §3"+UUIDFeature.getName(MuteSystem.getMutes().get(i-1))));
								}
							}
						}
						sender.sendMessage(new TextComponent(" "));
						sender.sendMessage(new TextComponent("§8[]§7----------------- §4Mute §4Sytem §7-----------------§8[]"));
						return;
					}
					sender.sendMessage(new TextComponent(main.prefix+"§cDiese §cSeite §cexestiert §cnicht§8."));
					return;
				} else {
					if(UUIDFeature.getUUID(args[1]) != null && UUIDFeature.getUUID(args[1]) != "") {
						Integer page = 0;
						try {
							page = Integer.valueOf(args[2]);
							if(page <= 0) {
								sender.sendMessage(new TextComponent(main.prefix+"§cBitte §cgeben §cein §eZahl §cüber §e0 §can§8."));
								return;
							}
						} catch(NumberFormatException ex) {
							sender.sendMessage(new TextComponent(main.prefix+"§cBitte geben ein §eZahl §cüber §e0 §can§8."));
							return;
						}
						if(MuteSystem.getMutens(UUIDFeature.getUUID(args[1])) >= page && MuteSystem.getMuteInfo(UUIDFeature.getUUID(args[1]), page) != null) {
							ArrayList<String> data = MuteSystem.getMuteInfo(UUIDFeature.getUUID(args[1]), page);
							sender.sendMessage(new TextComponent("§8[]§7----------------- §4Mute §4Sytem §7-----------------§8[]"));
							sender.sendMessage(new TextComponent(" "));
							sender.sendMessage(new TextComponent("§3Spieler§8: §e"+args[1]));
							sender.sendMessage(new TextComponent(" "));
							sender.sendMessage(new TextComponent("§3Mute§8: §e"+page));
							sender.sendMessage(new TextComponent(" "));
							String von = data.get(2).equalsIgnoreCase("CONSOLE") ? data.get(2) : UUIDFeature.getName(data.get(2));
							sender.sendMessage(new TextComponent("§3Am§8: §e"+data.get(3)));
							sender.sendMessage(new TextComponent(" "));
							sender.sendMessage(new TextComponent("§3Von§8: §e"+von));
							sender.sendMessage(new TextComponent("§3Grund§8: §e"+data.get(1)));
							sender.sendMessage(new TextComponent("§3Zeitraum§8: §e"+data.get(0)));
							sender.sendMessage(new TextComponent(" "));
							sender.sendMessage(new TextComponent("§8[]§7----------------- §4Mute §4Sytem §7-----------------§8[]"));
							return;
						}
						sender.sendMessage(new TextComponent(main.prefix+"§cDer §cSpieler §chat §e"+MuteSystem.getMutens(UUIDFeature.getUUID(args[1]))+" §cMute(s)§8."));
						return;
					}
					sender.sendMessage(new TextComponent(main.prefix+"§cDieser §cSpieler §cwar §cnoch §cnie §cauf §cdiesen §cServer."));
					return;
				}
			}
		}  else if(args.length >= 2 && args.length <= 2) {
			if(args[0].equalsIgnoreCase("mute")) {
				if(UUIDFeature.getUUID(args[1]) != null && UUIDFeature.getUUID(args[1]) != "") {
					ArrayList<String> data = MuteSystem.getData(UUIDFeature.getUUID(args[1]));
					sender.sendMessage(new TextComponent("§8[]§7----------------- §4Mute §4Sytem §7-----------------§8[]"));
					sender.sendMessage(new TextComponent(" "));
					sender.sendMessage(new TextComponent("§3Spieler§8: §e"+args[1]));
					sender.sendMessage(new TextComponent(" "));
					sender.sendMessage(new TextComponent("§3Mute(s)§8: §e"+MuteSystem.getMutens(UUIDFeature.getUUID(args[1]))));
					if(MuteSystem.isMutened(UUIDFeature.getUUID(args[1])) == true) {
						sender.sendMessage(new TextComponent(" "));
						sender.sendMessage(new TextComponent("§3Die §3jetziegen §3Mute §3infos§8:"));
						String von = data.get(2).equalsIgnoreCase("CONSOLE") ? data.get(2) : UUIDFeature.getName(data.get(2));
						sender.sendMessage(new TextComponent("§3Am§8: §e"+data.get(3)));
						sender.sendMessage(new TextComponent(" "));
						sender.sendMessage(new TextComponent("§3Von§8: §e"+von));
						sender.sendMessage(new TextComponent("§3Grund§8: §e"+data.get(1)));
						sender.sendMessage(new TextComponent("§3Zeitraum§8: §e"+MuteSystem.getRemainingTime(UUIDFeature.getUUID(args[1]))));
					}
					sender.sendMessage(new TextComponent(" "));
					sender.sendMessage(new TextComponent("§8[]§7----------------- §4Mute §4Sytem §7-----------------§8[]"));
					return;
				}
				sender.sendMessage(new TextComponent(main.prefix+"§cDieser §cSpieler §cwar §cnoch §cnie §cauf §cdiesen §cServer§8."));
				return;
			} else if(args[0].equalsIgnoreCase("ban")) {
				if(UUIDFeature.getUUID(args[1]) != null && UUIDFeature.getUUID(args[1]) != "") {
					ArrayList<String> data = BanSystem.getData(UUIDFeature.getUUID(args[1]));
					sender.sendMessage(new TextComponent("§8[]§7----------------- §4Ban §4Sytem §7-----------------§8[]"));
					sender.sendMessage(new TextComponent(" "));
					sender.sendMessage(new TextComponent("§3Spieler§8: §e"+args[1]));
					sender.sendMessage(new TextComponent(" "));
					sender.sendMessage(new TextComponent("§3Ban(s)§8: §e"+BanSystem.getBanns(UUIDFeature.getUUID(args[1]))));
					if(BanSystem.isBanned(UUIDFeature.getUUID(args[1])) == true) {
						sender.sendMessage(new TextComponent(" "));
						sender.sendMessage(new TextComponent("§3Die §3jetziegen §3Ban §3infos§8:"));
						sender.sendMessage(new TextComponent(" "));
						sender.sendMessage(new TextComponent("§3Am§8: §e"+data.get(3)));
						sender.sendMessage(new TextComponent(" "));
						String von = data.get(2).equalsIgnoreCase("CONSOLE") ? data.get(2) : UUIDFeature.getName(data.get(2));
						sender.sendMessage(new TextComponent("§3Von§8: §e"+von));
						sender.sendMessage(new TextComponent("§3Grund§8: §e"+data.get(1)));
						sender.sendMessage(new TextComponent("§3Zeitraum§8: §e"+BanSystem.getRemainingTime(UUIDFeature.getUUID(args[1]))));
					}
					sender.sendMessage(new TextComponent(" "));
					sender.sendMessage(new TextComponent("§8[]§7----------------- §4Ban §4Sytem §7-----------------§8[]"));
					return;
				}
				sender.sendMessage(new TextComponent(main.prefix+"§cDieser §cSpieler §cwar §cnoch §cnie §cauf §cdiesen §cServer§8."));
				return;
			}
		} else if(args.length == 1) {
			if(UUIDFeature.getUUID(args[0]) != null) {
				Global_Players gplayer = Global_Players.getPlayer(de.NilssMiner99.mongodb_Bungee.main.main.plugin, UUIDFeature.getUUID(args[0]).toString());
				sender.sendMessage(new TextComponent("§8[]§7----------------- §4Daten §4Sytem §7-----------------§8[]"));
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§3Spieler§8: §e"+UUIDFeature.getName(UUIDFeature.getUUID(args[0]))));
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§3Rang§8: §e"+gplayer.getGroup().getName()));
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§3Coins§8: §e"+gplayer.getCoins()));
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§3Sprache§8: §e"+gplayer.getLanguage()));
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§3Nicked§8: §e"+gplayer.isNicked()));
				String nickname = gplayer.getNickname() != "" && gplayer.getNickname() != " " && gplayer.getNickname() != null ? "§cKeinen §cNickname §cangegeben§8." : "§e"+gplayer.getNickname();
				sender.sendMessage(new TextComponent("§3Nickname§8: §e"+nickname));
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§3Ban(s)§8: §e"+BanSystem.getBanns(UUIDFeature.getUUID(args[0]))));
				sender.sendMessage(new TextComponent("§3Mute(s)§8: §e"+MuteSystem.getMutens(UUIDFeature.getUUID(args[0]))));
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§3Erster §3Login§8: §e"+StatsManager.getCreateDate(UUIDFeature.getUUID(args[0]))));
				sender.sendMessage(new TextComponent("§3Zuletzt §3online§8: §e"+StatsManager.getLastLoginDate(UUIDFeature.getUUID(args[0]))));
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§3Spielzeit§8: §e"+StatsManager.getPlayTime(UUIDFeature.getUUID(args[0]))));
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§3Spieler §3Namen§8: §e"+StatsManager.getOldNames(UUIDFeature.getUUID(args[0])).replaceAll(" ", "§e")));
				sender.sendMessage(new TextComponent(" "));
				String adresse = UUIDFeature.getAdresse(UUIDFeature.getUUID(args[0])) != null ? "§e"+UUIDFeature.getAdresse(UUIDFeature.getUUID(args[0])) : "§cKonnte §cnicht §cgefunden §cwerden§8.";
				sender.sendMessage(new TextComponent("§3IP §3Adresse§8: §e"+adresse));
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§3UUID§8: §e"+UUIDFeature.getUUID(args[0])));
				sender.sendMessage(new TextComponent(" "));
				String status = ProxyServer.getInstance().getPlayer(UUID.fromString(UUIDFeature.getUUID(args[0]))) != null ? "§3Online §3auf §e"+ProxyServer.getInstance().getPlayer(UUID.fromString(UUIDFeature.getUUID(args[0]))).getServer().getInfo().getName() : "§cOffline";
				sender.sendMessage(new TextComponent("§3Status§8: "+status+"§8."));
				if(MuteSystem.isMutened(UUIDFeature.getUUID(args[0])) == true) {
					ArrayList<String> data = MuteSystem.getData(UUIDFeature.getUUID(args[0]));
					sender.sendMessage(new TextComponent(" "));
					sender.sendMessage(new TextComponent(" "));
					sender.sendMessage(new TextComponent("§3Die §3jetziegen §3Mute §3infos§8:"));
					String von = data.get(2).equalsIgnoreCase("CONSOLE") ? data.get(2) : UUIDFeature.getName(data.get(2));
					sender.sendMessage(new TextComponent("§3Am§8: §e"+data.get(3)));
					sender.sendMessage(new TextComponent(" "));
					sender.sendMessage(new TextComponent("§3Von§8: §e"+von));
					sender.sendMessage(new TextComponent("§3Grund§8: §e"+data.get(1)));
					sender.sendMessage(new TextComponent("§3Zeitraum§8: §e"+MuteSystem.getRemainingTime(UUIDFeature.getUUID(args[0]))));
				}
				if(BanSystem.isBanned(UUIDFeature.getUUID(args[0])) == true) {
					ArrayList<String> data = BanSystem.getData(UUIDFeature.getUUID(args[0]));
					sender.sendMessage(new TextComponent(" "));
					sender.sendMessage(new TextComponent(" "));
					sender.sendMessage(new TextComponent("§3Die §3jetziegen §3Ban §3infos§8:"));
					sender.sendMessage(new TextComponent(" "));
					String von = data.get(2).equalsIgnoreCase("CONSOLE") ? data.get(2) : UUIDFeature.getName(data.get(2));
					sender.sendMessage(new TextComponent("§3Am§8: §e"+data.get(3)));
					sender.sendMessage(new TextComponent(" "));
					sender.sendMessage(new TextComponent("§3Von§8: §e"+von));
					sender.sendMessage(new TextComponent("§3Grund§8: §e"+data.get(1)));
					sender.sendMessage(new TextComponent("§3Zeitraum§8: §e"+BanSystem.getRemainingTime(UUIDFeature.getUUID(args[0]))));
				}
				sender.sendMessage(new TextComponent(" "));
				sender.sendMessage(new TextComponent("§8[]§7----------------- §4Daten §4Sytem §7-----------------§8[]"));
				return;
			}
			sender.sendMessage(new TextComponent(main.prefix+"§cDieser §cSpieler §cwar §cnoch §cnie §cauf §cdiesen §cServer§8."));
			return;
		}
		sendHelplist(sender);
		return;
	}
	
	private void sendHelplist(CommandSender sender) {
		sender.sendMessage(new TextComponent("§8[]§7----------------- §4Ban/Mute §4Sytem §7-----------------§8[]"));
		sender.sendMessage(new TextComponent(" "));
		sender.sendMessage(new TextComponent("§e/Check §eban §elist §e<Page>"));
		sender.sendMessage(new TextComponent("§e/Check §eban §e<Player> §e<Ban>"));
		sender.sendMessage(new TextComponent("§e/Check §emute §elist §e<Page>"));
		sender.sendMessage(new TextComponent("§e/Check §emute §e<Player> §e<Mute>"));
		sender.sendMessage(new TextComponent("§e/Check §e<Player>"));
		sender.sendMessage(new TextComponent(" "));
		sender.sendMessage(new TextComponent("§8[]§7----------------- §4Ban/Mute §4Sytem §7-----------------§8[]"));
		return;
	}
}