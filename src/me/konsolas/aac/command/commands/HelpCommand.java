package me.konsolas.aac.command.commands;

import me.konsolas.aac.command.CommandHandler;
import me.konsolas.aac.command.ICommand;
import org.bukkit.entity.Player;

/**
 * Created by Marco on 31.01.2017.
 */
public class HelpCommand implements ICommand {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public void execute(Player player, String[] args) {
        player.sendMessage("§cExrief §7| §6Commands");
        for(ICommand iCommand : CommandHandler.getCommands()) {
            player.sendMessage("§6*" + iCommand.getName());
        }
    }
}