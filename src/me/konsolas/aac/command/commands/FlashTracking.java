package me.konsolas.aac.command.commands;

import me.konsolas.aac.command.ICommand;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco on 23.02.2017.
 */
public class FlashTracking implements ICommand, Listener {
    
    private List<String> players = new ArrayList<>();
    
    @Override
    public String getName() {
        return "flashtracking";
    }
    
    @Override
    public void execute(Player player, String[] args) {
        if(args.length > 1) {
            if(args[1].equalsIgnoreCase("add")) {
                if(args.length > 2) {
                    Player target = Bukkit.getPlayer(args[2]);
                
                    if(target == null || !target.isOnline()) {
                        player.sendMessage("§cExrief §7| §cThe target is not online.");
                        return;
                    }
                
                    players.add(target.getName());
                    player.sendMessage("§cExrief §7| §c" + target.getName() + " is now tracked.");
                    return;
                }
            
                player.sendMessage("§cExrief §7| §c*flashtracking add <name>");
                return;
            }
        
            if(args[1].equalsIgnoreCase("remove")) {
                if(args.length > 2) {
                    Player target = Bukkit.getPlayer(args[2]);
                
                    if(target == null || !target.isOnline()) {
                        player.sendMessage("§cExrief §7| §cThe target is not online.");
                        return;
                    }
                
                    players.remove(target.getName());
                    player.sendMessage("§cExrief §7| §c" + target.getName() + " is not more tracked.");
                    return;
                }
            
                player.sendMessage("§cExrief §7| §c*flashtracking remove <name>");
                return;
            }
        }
        player.sendMessage("§cExrief §7| §c*flashtracking <add/remove>");
    }
    
    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        
        if(players.contains(player.getName())) {
            World world = player.getWorld();
            
            world.strikeLightningEffect(player.getLocation());
        }
    }
}