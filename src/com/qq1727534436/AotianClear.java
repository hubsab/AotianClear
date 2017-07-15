package com.qq1727534436;

import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;


public class AotianClear extends JavaPlugin{
	@Override
	public void onEnable() {
		new BukkitRunnable() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				int amount=0;
				for(int i=0;i<getServer().getWorlds().size();i++) {
					for(int j=0;j<getServer().getWorlds().get(i).getEntities().size();j++) {
						if(getServer().getWorlds().get(i).getEntities().get(j).getType().equals(EntityType.DROPPED_ITEM)) {
							getServer().getWorlds().get(i).getEntities().get(j).remove();
							amount++;
						}
					}
				}
				for(int i=0;i<getServer().getOnlinePlayers().length;i++) {
					getServer().getOnlinePlayers()[i].sendMessage("[AotianClear]Clear "+amount+" Drop Item!");
				}
			}
		}.runTaskTimer(this,0, 60*20);
		getLogger().info("Welcome to use AotianClear!Autuor:youkucola(QQ:1727534436)!");
	}
	@Override
	public void onDisable() {
		getLogger().info("AotianClear is disable!Autuor:youkucola(QQ:1727534436)!");
	}
}
