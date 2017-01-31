package me.konsolas.aac.schedulers;

import me.konsolas.aac.AAC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.Random;

/**
 * Created by Marco on 31.01.2017.
 */
public class MatrixScheduler {

    public static void registerScheduler() {
        Bukkit.getScheduler().runTaskTimer(AAC.getInstance(), new Runnable() {
            @Override
            public void run() {
                if(!AAC.getInstance().isMatrixEnabled())
                    return;

                // Generate matrix
                Random random = AAC.getInstance().random;

                String numbers = "";
                for(int i = 0; i < 7; i++)
                    numbers += String.valueOf(random.nextInt(2));

                String matrix = ChatColor.GREEN + numbers + " §c§lYOUR SERVER WAS HACKED " + ChatColor.DARK_GREEN + numbers;

                // Broadcast matrix
                Bukkit.broadcastMessage(matrix);
            }
        }, 0, 1);
    }
}