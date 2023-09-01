package com.mullen.ethan.bukkitvfx;

import org.bukkit.Particle;

public abstract class ParticlePattern {
	
	/**
	 * Poll for a new particle data unit. Depending on the pattern used, 
	 *   the next particle might not be the same. This method should only
	 *   be called when you're ACTUALLY calling createParticle()
	 * @return A ParticleDataUnit that will reflect the pattern
	 */
	public abstract ParticleDataUnit poll();
	
	public class ParticleDataUnit {
		private Particle type;
		private double extra;
		private Object data;
		public ParticleDataUnit(Particle type, double extra, Object data) {
			this.type = type;
			this.extra = extra;
			this.data = data;
			if(data != null && !data.getClass().equals(type.getDataType())) 
				throw new IllegalStateException("The provided data doesn't match type.getDataType()! This is illegal.");
		}
		public ParticleDataUnit(Particle type, double extra) {
			this(type, extra, null);
		}
		public ParticleDataUnit(Particle type) {
			this(type, 0, null);
		}
		public Particle getType() {
			return type;
		}
		public void setType(Particle type) {
			this.type = type;
		}
		public double getExtra() {
			return extra;
		}
		public void setExtra(double extra) {
			this.extra = extra;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
	}
}
