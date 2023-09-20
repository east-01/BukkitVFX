package com.mullen.ethan.bukkitvfx.particledrawers;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.joml.Vector3f;

import com.mullen.ethan.bukkitvfx.ParticleDrawer;
import com.mullen.ethan.bukkitvfx.ParticlePattern;

public class SphereDrawer extends ParticleDrawer {

	private Location origin;
	private Vector3f rotationAxis;
	private double radius;
	private int amount;
		
	@Override
	public void draw() {
				
		if(getPattern() != null && !isSubDrawer()) getPattern().reset();

		Vector3f up = new Vector3f(0, 1, 0);
		double threshold = 0.008d;
		
		for(int i = 0; i <= amount; i++) {
			
			// https://www.desmos.com/calculator/jzak45irgn
			double progress = ((double)i/(double)amount);
			if(progress <= threshold) progress = threshold;
			if(progress >= 1-threshold) progress = 1-threshold;
			
			double currRadius = Math.sqrt(Math.pow(radius, 2) - Math.pow(2*radius*progress - radius, 2));

			double yOff = 2*radius*progress - radius;
			
			new CircleDrawer()
			.setOrigin(origin.clone()
			.add(0, yOff, 0))
			.setRotationAxis(up)
			.setRadius(currRadius)
			.setAmount(amount)
			.setPattern(getPattern())
			.draw();
			
		}
			
	}

	public void drawAround(Entity entity) {
		double padding = 0.5d;
		setRadius((entity.getHeight()+padding)/2d);
		setOrigin(entity.getLocation().clone().add(0, getRadius()-(padding/2d), 0));
		draw();
	}
	
	@Override
	public SphereDrawer setPattern(ParticlePattern pattern) { 
		super.setPattern(pattern);
		return this;
	}

	public Location getOrigin() { return origin; }
	public SphereDrawer setOrigin(Location origin) {
		this.origin = origin;
		return this;
	}

	public Vector3f getRotationAxis() { return rotationAxis; }
	public SphereDrawer setRotationAxis(Vector3f rotationAxis) {
		this.rotationAxis = rotationAxis;
		return this;
	}

	public double getRadius() { return radius; }
	public SphereDrawer setRadius(double radius) {
		this.radius = radius;
		return this;
	}

	public int getAmount() { return amount; }
	public SphereDrawer setAmount(int amount) {
		this.amount = amount;
		return this;
	}
	
}
