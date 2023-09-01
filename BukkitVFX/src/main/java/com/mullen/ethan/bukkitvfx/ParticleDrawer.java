package com.mullen.ethan.bukkitvfx;

public abstract class ParticleDrawer {

	private ParticlePattern pattern;
	
	public ParticleDrawer(ParticlePattern pattern) {
		this.pattern = pattern;
	}

	public abstract void draw();
	
	public ParticlePattern getPattern() { return pattern; }
	public void setPattern(ParticlePattern pattern) { this.pattern = pattern; }
	
}
