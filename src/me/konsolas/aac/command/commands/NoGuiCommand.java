package me.konsolas.aac.command.commands;

import me.konsolas.aac.AAC;
import me.konsolas.aac.command.ICommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco on 31.01.2017.
 */
public class NoGuiCommand implements ICommand, Listener {

    private List<String> players = new ArrayList<>();

    public NoGuiCommand() {
        Bukkit.getScheduler().runTaskTimer(AAC.getInstance(), new Runnable() {
            @Override
            public void run() {
                for(String playerName : players) {
                    Player player = Bukkit.getPlayer(playerName);

                    if(player != null) {
                        player.closeInventory();
                    }
                }
            }
        }, 0L, 1L);
    }

    @Override
    public String getName() {
        return "NoGui";
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
                    player.sendMessage("§cExrief §7| §c" + target.getName() + " cant open inventorys anymore.");
                    return;
                }

                player.sendMessage("§cExrief §7| §c*nogui add <name>");
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
                    player.sendMessage("§cExrief §7| §c" + target.getName() + " can now open inventorys.");
                    return;
                }

                player.sendMessage("§cExrief §7| §c*nogui remove <name>");
                return;
            }
        }
        player.sendMessage("§cExrief §7| §c*nogui <add/remove>");
    }
}