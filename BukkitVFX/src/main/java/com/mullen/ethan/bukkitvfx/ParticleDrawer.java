package com.mullen.ethan.bukkitvfx;

public abstract class ParticleDrawer {

	protected ParticlePattern pattern;
	/** A boolean that tracks if this ParticleDrawer is a smaller 
	 *    part of a larger ParticleDrawer. For example, if a
	 *    LineDrawer is a part of a PathDrawer this value
	 *    will be set to true. */
	private boolean isSubDrawer;
	
	public ParticleDrawer(ParticlePattern pattern) {
		this.pattern = pattern;
	}

	protected abstract void draw();
	/** Called whenever a pattern change happens */
	protected void patternChange() {}
	
	public ParticlePattern getPattern() { return pattern; }
	public void setPattern(ParticlePattern pattern) { 
		this.pattern = pattern; 
		patternChange();
	}
	
	public boolean isSubDrawer() { return isSubDrawer; }
	public void setSubDrawer(boolean subDrawer) { this.isSubDrawer = subDrawer; }
	
}
