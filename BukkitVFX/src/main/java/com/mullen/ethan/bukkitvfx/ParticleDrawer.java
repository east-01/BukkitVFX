package com.mullen.ethan.bukkitvfx;

public abstract class ParticleDrawer {

	private ParticlePattern pattern;
	/** A boolean that tracks if this ParticleDrawer is a smaller 
	 *    part of a larger ParticleDrawer. For example, if a
	 *    LineDrawer is a part of a PathDrawer this value
	 *    will be set to true. */
	private boolean isSubDrawer;
	
	public ParticleDrawer() {

	}

	public abstract void draw();
	/** Called whenever a pattern change happens */
	protected void patternChange() {}
	
	public ParticlePattern getPattern() { return pattern; }
	/** Set the pattern, it's important to override this as superclass
	 *   ParticleDrawers so we can follow the ideal programming paradigm. */
	protected ParticleDrawer setPattern(ParticlePattern pattern) { 
		this.pattern = pattern; 
		patternChange();
		return this;
	}
	
	public boolean isSubDrawer() { return isSubDrawer; }
	public ParticleDrawer setSubDrawer(boolean subDrawer) { 
		this.isSubDrawer = subDrawer;
		return this; 
	}
	
}
