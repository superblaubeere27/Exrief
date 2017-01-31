package me.konsolas.aac.command.commands;

import me.konsolas.aac.command.ICommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Marco on 31.01.2017.
 */
public class InvseeCommand implements ICommand {
    @Override
    public String getName() {
        return "invsee";
    }

    @Override
    public void execute(Player player, String[] args) {
        if(args.length > 1) {
            Player target = Bukkit.getPlayer(args[1]);

            if(target == null || !target.isOnline()) {
                player.sendMessage("§cExrief §7| §cThe target player is not online");
                return;
            }

            player.openInventory(target.getInventory());
            player.sendMessage("§cExrief §7| §c" + target.getName() + " inventory was opened.");
            return;
        }

        player.sendMessage("§cExrief §7| §c*invsee <player>");
    }
}