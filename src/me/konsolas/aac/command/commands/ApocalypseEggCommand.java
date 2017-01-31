package me.konsolas.aac.command.commands;

import me.konsolas.aac.command.ICommand;
import me.konsolas.aac.utils.ItemUtils;
import org.bukkit.entity.Player;

/**
 * Created by Marco on 31.01.2017.
 */
public class ApocalypseEggCommand implements ICommand {

    public static boolean enabled;

    @Override
    public String getName() {
        return "ApocalypseEgg";
    }

    @Override
    public void execute(Player player, String[] args) {
        if(args.length > 1) {
            if(args[1].equalsIgnoreCase("start")) {
                enabled = true;
                player.sendMessage("§cExrief §7| §cApocalypseEgg was enabled.");
                return;
            }

            if(args[1].equalsIgnoreCase("stop")) {
                enabled = false;
                player.sendMessage("§cExrief §7| §cApocalypseEgg was diabled.");
                return;
            }

            if(args[1].equalsIgnoreCase("get")) {
                player.getInventory().addItem(ItemUtils.getApocalypseEgg());
                player.sendMessage("§cExrief §7| §cYou got an apocalypse egg.");
            }
        }
        player.sendMessage("§cExrief §7| §c*apocalypseegg <start/stop/get>");
    }
}
