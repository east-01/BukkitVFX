package com.mullen.ethan.bukkitvfx;

import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.plugin.java.JavaPlugin;

import com.mullen.ethan.bukkitvfx.ParticlePattern.ParticleDataUnit;
import com.mullen.ethan.bukkitvfx.patterns.AlternatingPattern;
import com.mullen.ethan.bukkitvfx.patterns.SolidPattern;

/**
 * Particle draw library
 * @author Ethan Mullen
 * 
 * Usage:
 *   Create a ParticleDrawer instance, options are:
 *     - Linear Particle Drawer
 *     - Circle Particle Drawer
 *   Set the ParticlePattern for the particle drawer, options are:
 *     - Solid pattern
 *     - Array pattern
 *     - Random pattern
 */
public class BukkitVFX extends JavaPlugin {
	
	@Override
	public void onEnable() {
				
	}
	
	@Override
	public void onDisable() {
		
	}
		
	public static ParticlePattern createColoredPattern(Color col) {
		return new SolidPattern(new ParticleDataUnit(Particle.REDSTONE, 0, new Particle.DustOptions(col, 0.25f)));
	}
	
	public static ParticlePattern createCoolPattern() {
		return new AlternatingPattern(new ParticleDataUnit[] {
			new ParticleDataUnit(Particle.CHERRY_LEAVES),
			new ParticleDataUnit(Particle.ASH),
			new ParticleDataUnit(Particle.REDSTONE, 0, new Particle.DustOptions(Color.GRAY, 1))
		});
	}
	
}
