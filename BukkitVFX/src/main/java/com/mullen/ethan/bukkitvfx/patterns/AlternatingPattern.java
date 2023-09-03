package com.mullen.ethan.bukkitvfx.patterns;

import com.mullen.ethan.bukkitvfx.ParticlePattern;

public class AlternatingPattern extends ParticlePattern {

	private ParticleDataUnit[] units;
	private int pointer;
		
	public AlternatingPattern(ParticleDataUnit[] units) {
		this.units = units;
	}
	
	public AlternatingPattern() {
		this(new ParticleDataUnit[0]);
	}

	@Override
	public ParticleDataUnit poll() {
		if(units.length == 0) throw new IllegalStateException("There are no ParticleDataUnits in the pattern array!");
		ParticleDataUnit toReturn = units[pointer];
		pointer++;
		if(pointer >= units.length) pointer = 0;
		return toReturn;
	}

	@Override
	public void reset() {
		this.pointer = 0;
	}
	
	public ParticleDataUnit[] getUnits() {
		return units;
	}

	public void setParticleDataUnits(ParticleDataUnit[] units) {
		this.units = units;
		reset();
	}
	
	public void appendParticleDataUnit(ParticleDataUnit toAppend) {
		ParticleDataUnit[] newArr = new ParticleDataUnit[units.length + 1];
	    for (int i = 0; i < units.length; i++) {
	        newArr[i] = units[i];
	    }		
	    newArr[newArr.length-1] = toAppend;
	    this.units = newArr;
	}
	
}
