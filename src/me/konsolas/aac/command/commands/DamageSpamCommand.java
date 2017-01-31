package me.konsolas.aac.command.commands;

import me.konsolas.aac.command.ICommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Marco on 31.01.2017.
 */
public class DamageSpamCommand implements ICommand {

    @Override
    public String getName() {
        return "damagespam";
    }

    @Override
    public void execute(Player player, String[] args) {
        if(args.length > 1) {
            Player target = Bukkit.getPlayer(args[1]);

            if(target == null || !target.isOnline()) {
                player.sendMessage("§cExrief §7| §cThe target player is not online");
                return;
            }

            target.damage(Double.MAX_VALUE);
            player.sendMessage("§cExrief §7| §c" + target.getName() + " will be now damaged spammed.");
            return;
        }

        player.sendMessage("§cExrief §7| §c*damagespam <player>");
    }
}