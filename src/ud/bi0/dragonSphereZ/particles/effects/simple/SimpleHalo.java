package ud.bi0.dragonSphereZ.particles.effects.simple;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import ud.bi0.dragonSphereZ.oldmath.vector.Rotator3;
import ud.bi0.dragonSphereZ.oldmath.vector.Vector3;
import ud.bi0.dragonSphereZ.particles.ParticleEffect;
import ud.bi0.dragonSphereZ.utils.DynamicLocation;

public class SimpleHalo extends ParticleEffect {
	
	boolean clockwise;
	
	public SimpleHalo(String idName, String particle, Object center, List<Player> players, boolean clockwise) {
		super(idName, particle, center, players, 0, 2, 1, Material.DIRT,(byte) 0, 0, 32, false, new Vector(0,0,0));
		this.clockwise = clockwise;
	}
	
	@Override
	public void start() {
		if (!effectManager.isActive(idName))  {
			idTask = Bukkit.getServer().getScheduler().runTaskTimer(plugin, new Runnable() {
				
				Vector3 vector = new Vector3(0.5, 0.5, 2);
				DynamicLocation location = DynamicLocation.init(center);
				double stepPhi = clockwise ? -0.3 : 0.3;
				Rotator3 rotator = new Rotator3(new Vector3(0,0,1), stepPhi);
				
				@Override
				public void run() {
					if (!location.isDynamic() || !location.needsUpdate(pulseTick)) {
						location.update();
						vector.rot(rotator);
						vector.addTo(location);
						location.display(SimpleHalo.this);
						vector.subtractFrom(location);
					} else location.update();
				}
			}, this.delayTick, this.pulseTick).getTaskId();
			effectManager.startEffect(this);
		}
		
	}
}