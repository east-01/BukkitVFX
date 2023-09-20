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

	@Override
	public CircleDrawer setPattern(ParticlePattern pattern) { 
		super.setPattern(pattern);
		return this;
	}
	
	public Location getOrigin() { return origin; }
	public CircleDrawer setOrigin(Location origin) {
		this.origin = origin;
		return this;
	}

	public Vector3f getRotationAxis() { return rotationAxis; }
	public CircleDrawer setRotationAxis(Vector3f rotationAxis) {
		this.rotationAxis = rotationAxis;
		return this;
	}

	public double getRadius() { return radius; }
	public CircleDrawer setRadius(double radius) {
		this.radius = radius;
		return this;
	}

	public int getAmount() { return amount; }
	public CircleDrawer setAmount(int amount) {
		this.amount = amount;
		return this;
	}

}
