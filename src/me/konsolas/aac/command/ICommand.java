package me.konsolas.aac.command;

import org.bukkit.entity.Player;

/**
 * Created by Marco on 31.01.2017.
 */
public interface ICommand {
    public String getName();
    public void execute(Player player, String[] args);
}