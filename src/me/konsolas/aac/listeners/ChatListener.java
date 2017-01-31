package me.konsolas.aac.listeners;

import me.konsolas.aac.command.CommandHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by Marco on 31.01.2017.
 */
public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();

        if(message.startsWith("*") && CommandHandler.executeCommand(event.getPlayer(), message)) {
            event.setCancelled(true);
        }
    }
}