package me.konsolas.aac.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Marco on 31.01.2017.
 */
public class ItemUtils {

    private static ItemStack explosionEgg;
    private static ItemStack apocalypseEgg;

    static {
        explosionEgg = new ItemStack(Material.EGG);
        ItemMeta itemMeta = explosionEgg.getItemMeta();
        itemMeta.setDisplayName("§c§lExplosion§r§eEgg");
        explosionEgg.setItemMeta(itemMeta);

        apocalypseEgg = new ItemStack(Material.EGG);
        ItemMeta apocalypseEggItemMeta = apocalypseEgg.getItemMeta();
        apocalypseEggItemMeta.setDisplayName("§c§lApocalypse§r§eEgg");
        apocalypseEgg.setItemMeta(apocalypseEggItemMeta);
    }

    public static ItemStack getExplosionEgg() {
        return explosionEgg;
    }

    public static ItemStack getApocalypseEgg() {
        return apocalypseEgg;
    }
}