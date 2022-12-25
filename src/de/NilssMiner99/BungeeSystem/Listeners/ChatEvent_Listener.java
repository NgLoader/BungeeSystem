package de.NilssMiner99.BungeeSystem.Listeners;

import de.NilssMiner99.BungeeSystem.Manager.BlackList;
import de.NilssMiner99.BungeeSystem.Manager.MuteSystem;
import de.NilssMiner99.BungeeSystem.Manager.NotifyManager;
import de.NilssMiner99.BungeeSystem.Manager.PartyManager;
import de.NilssMiner99.BungeeSystem.Manager.PlayerParty;
import de.NilssMiner99.BungeeSystem.Manager.ServerManager;
import de.NilssMiner99.BungeeSystem.Manager.Templates;
import de.NilssMiner99.BungeeSystem.Manager.WhitelistManager;
import de.NilssMiner99.BungeeSystem.Message.Message;
import de.NilssMiner99.BungeeSystem.main.main;
import de.NilssMiner99.mongodb_Bungee.MongoDB.Global_Players;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ChatEvent_Listener implements Listener {
	
	@EventHandler
	public static void Chat(ChatEvent e) {
		if(e.getSender() instanceof ProxiedPlayer) {
			ProxiedPlayer player = (ProxiedPlayer) e.getSender();
			if (PartyManager.getParty(player) != null) {
				PlayerParty party = PartyManager.getParty(player);
				if (e.getMessage().split(" ")[0].equalsIgnoreCase("/p")) {
					e.setCancelled(true);
					for (ProxiedPlayer p : party.getPlayers()) {
						if (p != player) {
							p.sendMessage(new TextComponent("§8[§5Party§8] §8" + player.getName() + " §8>>§7"
									+ e.getMessage().replaceFirst("/p", "").replaceAll(" ", " §7")));
						}
					}
					if (party.getLeader() != player) {
						party.getLeader().sendMessage(new TextComponent("§8[§5Party§8] §8" + player.getName()
								+ " §8>>§7" + e.getMessage().replaceFirst("/p", "").replaceAll(" ", " §7")));
					}
					player.sendMessage(new TextComponent("§8[§5Party§8] §8" + player.getName() + " §8>>§7"
							+ e.getMessage().replaceFirst("/p", "").replaceAll(" ", " §7")));
				}
			}
			ProxiedPlayer p = (ProxiedPlayer) e.getSender();
			for(String name : ServerManager.ab) {
				if(e.getMessage().equalsIgnoreCase("/"+name)) {
					if(p.hasPermission(ServerManager.abkürzung.get(name)) || p.hasPermission("liveplays.admin")) {
						try {
							if(p.getServer().getInfo().getName().equalsIgnoreCase(ServerManager.server.get(name))) {
								p.sendMessage(new TextComponent(main.prefix+"§3Du §3bist §3schon §3auf §3den §3angegebenen §3Server§8."));
								e.setCancelled(true);
								return;
							}
							p.connect(ProxyServer.getInstance().getServerInfo(ServerManager.server.get(name)));
							p.sendMessage(new TextComponent(main.prefix+"§3Du §3betritst §3nun §3den §3Server: §e"+ServerManager.server.get(name)));
						} catch(Exception ex) {
							p.sendMessage(new TextComponent(main.prefix+"§3Dieser §3Server §3ist §3derzeitung §4offline§8."));
						}
						e.setCancelled(true);
						return;
					}
				}
			}
			if(e.getMessage().startsWith("~") && p.hasPermission("liveplays.team")) {
				e.setCancelled(true);
				for (ProxiedPlayer team : ProxyServer.getInstance().getPlayers()) {
					if(team.hasPermission("liveplays.team") && (!(NotifyManager.notify.contains(p.getUniqueId().toString())))) {
						if(e.getMessage().replaceFirst("~", "").equalsIgnoreCase("") ||
								e.getMessage().replaceFirst("~", "").equalsIgnoreCase("")) {
							
						}
						team.sendMessage(new TextComponent(main.prefix_tc+"§3"+p.getName()+"§8: §7"+e.getMessage().replaceFirst("!", "").replaceAll(" ", " §7")));
					}
				}
				return;
			}
			if(MuteSystem.isMutened(p.getUniqueId().toString())) {
				for(String wlw : WhitelistManager.whitelistwords) {
					if(e.getMessage().startsWith(wlw)) {
						return;
					}
				}
				String uuid = p.getUniqueId().toString();
				e.setCancelled(true);
				Global_Players gplayer = Global_Players.getPlayer(de.NilssMiner99.mongodb_Bungee.main.main.plugin, p.getUniqueId().toString());
				if(gplayer.getLanguage().equalsIgnoreCase("DE")) {
					p.sendMessage(new TextComponent("§8[]§7----------------- §4Mute §7-----------------§8[]"));
					p.sendMessage(new TextComponent(" "));
					if (!(MuteSystem.getData(uuid).get(4).equalsIgnoreCase("perma"))) {
						p.sendMessage(new TextComponent(
								"§cDu wurdest für " + MuteSystem.getMuteTime(uuid) + " §caus dem Chat gebannt§8!"));
						p.sendMessage(new TextComponent("§3Grund§8: §e" + MuteSystem.getData(uuid).get(1)));
						p.sendMessage(new TextComponent("§3Verbleibende Zeit§8: §e" + MuteSystem.getRemainingTime(uuid)));
					} else {
						p.sendMessage(new TextComponent("§cDu wurdest §4PERMANEN §caus dem Chat gebannt§8!"));
						p.sendMessage(new TextComponent("§3Grund§8: §e" + MuteSystem.getData(uuid).get(1)));
					}
					p.sendMessage(new TextComponent(" "));
					p.sendMessage(new TextComponent("§8[]§7----------------- §4Mute §7-----------------§8[]"));
					return;
				} else {
					p.sendMessage(new TextComponent("§8[]§7----------------- §4Mute §7-----------------§8[]"));
					p.sendMessage(new TextComponent(" "));
					if(!(MuteSystem.getData(uuid).get(4).equalsIgnoreCase("perma"))) {
						p.sendMessage(new TextComponent("§cYou §chave §cbeen banned from the chat for "+MuteSystem.getMuteTime(uuid)+"§8!"));
						p.sendMessage(new TextComponent("§3Reason§8: §e"+MuteSystem.getData(uuid).get(1)));
						p.sendMessage(new TextComponent("§3Remaining time§8: §e"+MuteSystem.getRemainingTime(uuid)));
					} else {
						p.sendMessage(new TextComponent("§cYou have been permanently banned from the Chat§8!"));
						p.sendMessage(new TextComponent("§3Reason§8: §e"+MuteSystem.getData(uuid).get(1)));
					}
					p.sendMessage(new TextComponent(" "));
					p.sendMessage(new TextComponent("§8[]§7----------------- §4Mute §7-----------------§8[]"));
					return;
				}
			}

			for (String blackword : BlackList.blacklistword_hard.keySet()) {
				String last = null;
				for (String args : e.getMessage().toLowerCase().split(" ")) {
					if (args.contains(blackword)) {
						e.setCancelled(true);
						Templates.mutetemplate(null, p.getUniqueId().toString(), BlackList.blacklistword_hard.get(blackword));
						return;
					}
					last = last + args;
					if(last.contains(blackword)) {
						e.setCancelled(true);
						Templates.mutetemplate(null, p.getUniqueId().toString(), BlackList.blacklistword_hard.get(blackword));
						return;
					} else {
						String m = last;
						m = m.replace("!", "")
						.replace("~", "")
						.replace("+", "")
						.replace("'", "")
						.replace("#", "")
						.replace("*", "")
						.replace("-", "")
						.replace("_", "")
						.replace("|", "");
				if(m.contains(blackword)) {
					e.setCancelled(true);
					Templates.mutetemplate(null, p.getUniqueId().toString(), BlackList.blacklistword_hard.get(blackword));
					return;
				}
				String m2 = last;
				m2 = m2.replaceAll("!", "i");
				if(m2.contains(blackword)) {
					e.setCancelled(true);
					Templates.mutetemplate(null, p.getUniqueId().toString(), BlackList.blacklistword_hard.get(blackword));
					return;
				}
			}
				}
			}
			for (String blackword : BlackList.blacklistword) {
				String last = null;
				for (String args : e.getMessage().toLowerCase().split(" ")) {
					if (args.contains(blackword)) {
						sendmuteinfo(p, e.getMessage());
						e.setCancelled(true);
						Message.SYSTEM_ACHTE_AUF_DEINE_WORT_WAHL.sendMessage(p);
						return;
					}
					last = last+args;
					if(last.contains(blackword)) {
						sendmuteinfo(p, e.getMessage());
						e.setCancelled(true);
						Message.SYSTEM_ACHTE_AUF_DEINE_WORT_WAHL.sendMessage(p);
						return;
					} else if (last.contains(blackword)) {
						sendmuteinfo(p, e.getMessage());
						e.setCancelled(true);
						Message.SYSTEM_ACHTE_AUF_DEINE_WORT_WAHL.sendMessage(p);
						return;
					} else {
						String m = last;
						m = m.replace("!", "")
						.replace("~", "")
						.replace("+", "")
						.replace("'", "")
						.replace("#", "")
						.replace("*", "")
						.replace("-", "")
						.replace("_", "")
						.replace("|", "");
						if(m.contains(blackword)) {
							sendmuteinfo(p, e.getMessage());
							e.setCancelled(true);
							Message.SYSTEM_ACHTE_AUF_DEINE_WORT_WAHL.sendMessage(p);
							return;
						}
						String m2 = last;
						m2 = m2.replaceAll("!", "i");
						if(m2.contains(blackword)) {
							sendmuteinfo(p, e.getMessage());
							e.setCancelled(true);
							Message.SYSTEM_ACHTE_AUF_DEINE_WORT_WAHL.sendMessage(p);
							return;
						}
					}
				}
			}
		}
	}
	
	public static void sendmuteinfo(ProxiedPlayer p, String message) {
		for (ProxiedPlayer team : ProxyServer.getInstance().getPlayers()) {
			if (team.hasPermission("liveplays.team") && (!(NotifyManager.notify.contains(p.getUniqueId().toString())))) {
				team.sendMessage(new TextComponent("§8[]§7----------------- §4Chat"+Message.MESSAGE_FILTER.getMessage(p)+" §7-----------------§8[]"));
				team.sendMessage(new TextComponent(" "));
				team.sendMessage(new TextComponent("§cSpieler§8: §e"+p.getName()+"§8."));
				team.sendMessage(new TextComponent(" "));
				team.sendMessage(new TextComponent("§3Nachricht§8: §e"+message.replaceAll(" ", " §e")));
				team.sendMessage(new TextComponent(" "));
				TextComponent tc = new TextComponent();
				tc.setText("§3Templates§8:");
				tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§3Zeigt die Templates an§8.").create()));
				for (String s : Templates.MUTE_kurzzeichen.keySet()) {
					TextComponent tc2 = new TextComponent();
					tc2.setText(" §8- §3" + s + " ");
					tc2.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/mute "+p.getName() + " " + s + ""));
					tc2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§3"+Templates.MUTE_banngrund.get(s)).create()));
					tc.addExtra(tc2);
				}
				team.sendMessage(tc);
				team.sendMessage(new TextComponent(" "));
				team.sendMessage(new TextComponent("§8[]§7----------------- §4Chat"+Message.MESSAGE_FILTER.getMessage(p)+" §7-----------------§8[]"));
				break;
			}
		}
	}
}