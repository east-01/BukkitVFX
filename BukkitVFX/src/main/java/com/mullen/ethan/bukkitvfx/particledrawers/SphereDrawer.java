package com.mullen.ethan.bukkitvfx.particledrawers;

import org.bukkit.Location;
import org.joml.Vector3f;

import com.mullen.ethan.bukkitvfx.ParticleDrawer;
import com.mullen.ethan.bukkitvfx.ParticlePattern;

public class SphereDrawer extends ParticleDrawer {

	private Location origin;
	private Vector3f rotationAxis;
	private double radius;
	private int amount;
		
	public SphereDrawer(ParticlePattern pattern, Location origin, double radius, int amount) {
		super(pattern);
		if(amount <= 0)
			throw new IllegalArgumentException("The amount of particles must be at least 1. (Provided: " + amount + ")");
		this.origin = origin;
		this.radius = radius;
		this.amount = amount;
	}

	@Override
	public void draw() {
				
		if(getPattern() != null && !isSubDrawer()) getPattern().reset();

		Vector3f up = new Vector3f(0, 1, 0);
		
		for(int i = 0; i < amount; i++) {
			
		}
		
		
	}

}
