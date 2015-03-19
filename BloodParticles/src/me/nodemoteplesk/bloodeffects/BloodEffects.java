package me.nodemoteplesk.bloodeffects;

import java.util.logging.Logger;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BloodEffects
  extends JavaPlugin
  implements Listener
{
  public final Logger logger = Logger.getLogger("Minecraft");
  public static BloodEffects plugin;
  
  public void onEnable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    getConfig().options().copyDefaults(true);
    saveDefaultConfig();
    
    getServer().getPluginManager().registerEvents(this, this);
    
    this.logger.info("[" + pdfFile.getName() + "] v" + pdfFile.getVersion() + " is now enabled!");
  }
  
  public void onDisable()
  {
    PluginDescriptionFile pdfFile = getDescription();
    this.logger.info("[" + pdfFile.getName() + "]  is now disabled!");
  }
  
  @EventHandler
  public void onPlayerDamage(EntityDamageEvent event)
  {
    if (event.getEntityType().equals(EntityType.PLAYER))
    {
      Player player = (Player)event.getEntity();
      for (int i = 0; i < getConfig().getInt("BloodLevel"); i++) {
        player.getWorld().playEffect(player.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_WIRE);
      }
    }
  }
}

