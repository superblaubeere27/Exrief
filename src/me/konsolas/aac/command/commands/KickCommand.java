package me.konsolas.aac.command.commands;

import me.konsolas.aac.AAC;
import me.konsolas.aac.command.ICommand;
import me.konsolas.aac.utils.StringUtils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Marco on 31.01.2017.
 */
public class KickCommand implements ICommand {

    @Override
    public String getName() {
        return "kick";
    }

    @Override
    public void execute(Player player, String[] args) {
        if(args.length > 2) {
            Player target = Bukkit.getPlayer(args[1]);

            if(target == null || !target.isOnline()) {
                player.sendMessage("§cExrief §7| §cThe target player is not online");
                return;
            }

            String reason = ChatColor.translateAlternateColorCodes('&', StringUtils.toString(args, 2));
            Bukkit.getScheduler().runTask(AAC.getInstance(), new Runnable() {
                @Override
                public void run() {
                    target.kickPlayer(reason);
                    player.sendMessage("§cExrief §7| §c" + target.getName() + " was kicked for '" + reason + "§c'.");
                }
            });
            return;
        }

        player.sendMessage("§cExrief §7| §c*kick <player> <reason...>");
    }
}