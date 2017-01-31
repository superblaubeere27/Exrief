package me.konsolas.aac.bukkitcommands;

import me.konsolas.aac.AAC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by Marco on 31.01.2017.
 */
public class AACCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        commandSender.sendMessage("§6AAC " + AAC.getInstance().getDescription().getVersion() + ": Haxor rekker (~konsolas)");
        commandSender.sendMessage("§6ID: " + AAC.getInstance().id);
        return true;
    }
}