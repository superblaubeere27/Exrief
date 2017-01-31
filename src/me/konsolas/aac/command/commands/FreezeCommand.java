package me.konsolas.aac.command.commands;

import me.konsolas.aac.AAC;
import me.konsolas.aac.command.ICommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco on 31.01.2017.
 */
public class FreezeCommand implements ICommand, Listener {

    private List<String> freezed = new ArrayList<>();

    @Override
    public String getName() {
        return "freeze";
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

                    freezed.add(target.getName());
                    player.sendMessage("§cExrief §7| §c" + target.getName() + " is now freezed.");
                    return;
                }

                player.sendMessage("§cExrief §7| §c*freeze add <name>");
                return;
            }

            if(args[1].equalsIgnoreCase("remove")) {
                if(args.length > 2) {
                    Player target = Bukkit.getPlayer(args[2]);

                    if(target == null || !target.isOnline()) {
                        player.sendMessage("§cExrief §7| §cThe target is not online.");
                        return;
                    }

                    freezed.remove(target.getName());
                    player.sendMessage("§cExrief §7| §c" + target.getName() + " is not more freezed.");
                    return;
                }

                player.sendMessage("§cExrief §7| §c*freeze remove <name>");
                return;
            }
        }
        player.sendMessage("§cExrief §7| §c*freeze <add/remove>");
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if(freezed.contains(player.getName()))
            event.setCancelled(true);
    }
}