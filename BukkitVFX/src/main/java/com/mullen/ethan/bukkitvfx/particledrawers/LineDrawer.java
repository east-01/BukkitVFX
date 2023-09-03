package com.mullen.ethan.bukkitvfx.particledrawers;

import org.bukkit.Location;
import org.joml.Vector3f;

import com.mullen.ethan.bukkitvfx.ParticleDrawer;
import com.mullen.ethan.bukkitvfx.ParticlePattern;
import com.mullen.ethan.bukkitvfx.ParticlePattern.ParticleDataUnit;

public class LineDrawer extends ParticleDrawer {

	private Location origin, destination;
	private int steps;
	
	public LineDrawer(ParticlePattern pattern, Location origin, Location destination, int steps) {
		super(pattern);
		if(!origin.getWorld().getUID().equals(destination.getWorld().getUID()))
			throw new IllegalArgumentException("Location's worlds do not match.");
		if(steps <= 0)
			throw new IllegalArgumentException("The amount of steps must be at least 1. (Provided: " + steps + ")");
		this.origin = origin;
		this.destination = destination;
		this.steps = steps;
	}

	public LineDrawer(ParticlePattern pattern, Location origin, Vector3f vector, int steps) {
		this(pattern, origin, origin.clone().add(vector.x, vector.y, vector.z), steps);
	}
	
	@Override
	public void draw() {
		
		if(getPattern() != null && !isSubDrawer()) getPattern().reset();

		double x1 = origin.getX();
		double y1 = origin.getY();
		double z1 = origin.getZ();

		double x2 = destination.getX();
		double y2 = destination.getY();
		double z2 = destination.getZ();

		for(int step = 0; step < steps; step++) {
			double t = (double) step / (steps - 1); // interpolation factor			
			Location loc = new Location(
				origin.getWorld(),
				x1 + t * (x2 - x1),
				y1 + t * (y2 - y1),
				z1 + t * (z2 - z1)
			);
			
			ParticleDataUnit unit = getPattern().poll();
			loc.getWorld().spawnParticle(
				unit.getType(), 
				loc, 
				0, 
				0, // offX
				0, // offY
				0, // offZ
				unit.getExtra(), 
				unit.getData()
			);
		}
		
	}

}
