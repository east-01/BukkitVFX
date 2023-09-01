package com.mullen.ethan.bukkitvfx.patterns;

import com.mullen.ethan.bukkitvfx.ParticlePattern;

public class SolidPattern extends ParticlePattern {

	private ParticleDataUnit unit;
	
	public SolidPattern(ParticleDataUnit unit) {
		this.unit = unit;
	}
	
	@Override
	public ParticleDataUnit poll() {
		return unit;
	}
	
}
