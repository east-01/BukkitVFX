package com.mullen.ethan.bukkitvfx.particledrawers;

import org.bukkit.Location;
import org.joml.Vector3f;

import com.mullen.ethan.bukkitvfx.ParticleDrawer;
import com.mullen.ethan.bukkitvfx.ParticlePattern;

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
		
		this.rotationAxis = rotationAxis.normalize();
		
		
		
		/* Rotation axis vector needs to be normalized
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
		 *  point = u * rcos(t) + w * rsin(w)
		 *  
		 *
		 * 
		 */
		
	}

}
