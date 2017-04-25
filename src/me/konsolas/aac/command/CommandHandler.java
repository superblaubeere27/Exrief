package me.konsolas.aac.command;

import me.konsolas.aac.AAC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Marco on 31.01.2017.
 */
public class CommandHandler {

    private static List<ICommand> commands = new ArrayList<>();

    public static void registerCommand(ICommand iCommand) {
        commands.add(iCommand);

        if(Arrays.asList(iCommand.getClass().getInterfaces()).contains(Listener.class)) {
            Bukkit.getPluginManager().registerEvents((Listener) iCommand, AAC.getInstance());
        }
    }

    public static boolean executeCommand(Player player, String command) {
    	String rawCommand = command.substring(1); // Raw command: Command: *help RawCommand: help
        String[] args = rawCommand.split(" ");

        for(ICommand iCommand : commands) {
            if(rawCommand.split(" ")[0].equalsIgnoreCase(iCommand.getName())) {
                iCommand.execute(player, args);
                return true;
            }
        }
        return false;
    }

    public static List<ICommand> getCommands() {
        return commands;
    }
}