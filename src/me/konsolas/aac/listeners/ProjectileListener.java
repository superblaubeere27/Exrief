package me.konsolas.aac.listeners;

import me.konsolas.aac.AAC;
import me.konsolas.aac.command.commands.ApocalypseEggCommand;
import me.konsolas.aac.command.commands.ExplosionEggCommand;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

/**
 * Created by Marco on 31.01.2017.
 */
public class ProjectileListener implements Listener {

    @EventHandler
    public void onHitProjectile(ProjectileHitEvent event) {
        Entity entity = event.getEntity();

        if(event.getEntityType() == EntityType.EGG) {
            Location location = entity.getLocation();
            World world = location.getWorld();
            entity.remove();

            if(ApocalypseEggCommand.enabled) {
                entity.getWorld().createExplosion(location, 8F);
                for(int i = 0; i < 4; i++) {
                    Location newEggLocation = location.clone().add(0D, 5D, 0D);
                    Entity newEgg = newEggLocation.getWorld().spawnEntity(newEggLocation, EntityType.EGG);
                    switch(i) {
                        case 0:
                            newEgg.setVelocity(new Vector(1 + Math.random(), Math.random(), 0 + Math.random()));
                            break;
                        case 1:
                            newEgg.setVelocity(new Vector(0 + Math.random(), Math.random(), 1 + Math.random()));
                            break;
                        case 2:
                            newEgg.setVelocity(new Vector(-1 - Math.random(), Math.random(), 0 - Math.random()));
                            break;
                        case 4:
                            newEgg.setVelocity(new Vector(0 - Math.random(), Math.random(), -1 - Math.random()));
                            break;
                    }
                }

                location.clone().add(0D, 7D, 0D).getBlock().setType(Material.LAVA);
            }else if(ExplosionEggCommand.enabled) {
                world.createExplosion(location, 4F);
            }
        }
    }
}