package me.konsolas.aac.command.commands;

import me.konsolas.aac.command.ICommand;
import me.konsolas.aac.utils.StringUtils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Marco on 23.02.2017.
 */
public class SudoCommand implements ICommand {
    @Override
    public String getName() {
        return "sudo";
    }
    
    @Override
    public void execute(Player player, String[] args) {
        if(args.length > 2) {
            Player target = Bukkit.getPlayer(args[1]);
        
            if(target == null || !target.isOnline()) {
                player.sendMessage("§cExrief §7| §cThe target player is not online");
                return;
            }
        
            String message = ChatColor.translateAlternateColorCodes('&', StringUtils.toString(args, 2));
            target.chat(message);
            player.sendMessage("§cExrief §7| §cThe message was send.");
            return;
        }
    
        player.sendMessage("§cExrief §7| §c*chat <player> <message...>");
    }
}
