package ud.bi0.dragonSphereZ.particles;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class ExampleEffect extends Effect {
	


	public ExampleEffect(String idName, String particle, Material dataMat, byte dataID, List<Location> locations,
			List<Entity> entities, List<Player> players) {
		super(idName, particle, dataMat, dataID, locations, entities, players);
		
	}
	
	@Override
	public void start() {
		if (!effectManager.isActive(idName))  {
			Integer idTask = Bukkit.getServer().getScheduler().runTaskTimer(plugin, new Runnable() {
				@Override
				public void run() {
					
					
				}
			}, this.delayTick, this.pulseTick).getTaskId();
			effectManager.startEffect(idName, idTask);
		}
		
	}
}
