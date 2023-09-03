package com.mullen.ethan.bukkitvfx.particledrawers;

import org.bukkit.Location;
import org.joml.Vector3f;

import com.mullen.ethan.bukkitvfx.ParticleDrawer;
import com.mullen.ethan.bukkitvfx.ParticlePattern;
import com.mullen.ethan.bukkitvfx.ParticlePattern.ParticleDataUnit;

public class CircleDrawer extends ParticleDrawer {

	private Location origin;
	private Vector3f rotationAxis;
	private double radius;
	private int amount;
		
	public CircleDrawer(ParticlePattern pattern, Location origin, Vector3f rotationAxis, double radius, int amount) {
		super(pattern);
		if(amount <= 0)
			throw new IllegalArgumentException("The amount of particles must be at least 1. (Provided: " + amount + ")");
		this.origin = origin;
		this.rotationAxis = rotationAxis;
		this.radius = radius;
		this.amount = amount;
	}

	@Override
	public void draw() {
				
		if(getPattern() != null && !isSubDrawer()) getPattern().reset();

		/* Math explanation (thanks Ron):
		 * 
		 * Rotation axis vector needs to be normalized
		 * 
		 * Let v be the rotation axis vector
		 * 
		 * We need to find vector u such that u (dot) v = 0
		 * To find arbitrary u vector (orthogonal to v), we can say
		 *   u = [v2, -v1, 0]
		 * 
		 * We need to find vector w where w = u (cross) v
		 * 
		 * The vectors u and w are our component vectors on the plane
		 *   that is perpendicular to the rotation axis vector.
		 *   
		 * We can find the points on the circle with:
		 * 
		 *  point = u * rcos(t) + w * rsin(t)
		 */
		
		Vector3f v = rotationAxis.normalize();
		Vector3f u = new Vector3f(v.y, -v.x, 0).normalize(); 
		Vector3f w = new Vector3f(u.x, u.y, u.z).cross(v);
	
		for(float t = 0; t <= 360; t += 360f/(float)amount) {
			
			float cosVal = (float) (radius * Math.cos(Math.toRadians(t)));
			float sinVal = (float) (radius * Math.sin(Math.toRadians(t)));
			
			ParticleDataUnit unit = getPattern().poll();
			origin.getWorld().spawnParticle(
				unit.getType(), 
				origin.getX() + u.x*cosVal + w.x*sinVal, // x pos
				origin.getY() + u.y*cosVal + w.y*sinVal, // y pos
				origin.getZ() + u.z*cosVal + w.z*sinVal, // z pos
				0, // count
				0, // offX
				0, // offY 
				0, // offZ
				unit.getExtra(), 
				unit.getData()
			);
			
		}
		
		
	}

}
