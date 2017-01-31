package me.konsolas.aac.command.commands;

import me.konsolas.aac.command.ICommand;
import me.konsolas.aac.utils.ItemUtils;
import org.bukkit.entity.Player;

/**
 * Created by Marco on 31.01.2017.
 */
public class ExplosionEggCommand implements ICommand {

    public static boolean enabled;

    @Override
    public String getName() {
        return "explosionegg";
    }

    @Override
    public void execute(Player player, String[] args) {
        if(args.length > 1) {
            if(args[1].equalsIgnoreCase("start")) {
                enabled = true;
                player.sendMessage("§cExrief §7| §cExplosionEgg was enabled.");
                return;
            }

            if(args[1].equalsIgnoreCase("stop")) {
                enabled = false;
                player.sendMessage("§cExrief §7| §cExplosionEgg was diabled.");
                return;
            }

            if(args[1].equalsIgnoreCase("get")) {
                player.getInventory().addItem(ItemUtils.getExplosionEgg());
                player.sendMessage("§cExrief §7| §cYou got an explosion egg.");
            }
        }
        player.sendMessage("§cExrief §7| §c*explosionegg <start/stop/get>");
    }
}