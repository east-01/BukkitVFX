package com.mullen.ethan.bukkitvfx.particledrawers;

import org.bukkit.Location;

import com.mullen.ethan.bukkitvfx.ParticleDrawer;
import com.mullen.ethan.bukkitvfx.ParticlePattern;

public class PathDrawer extends ParticleDrawer {

	private Location[] path;
	private LineDrawer[] lineDrawers;
	private int stepsPerSegment;

	@Override
	public void draw() {
		
		if(getPattern() != null && !isSubDrawer()) getPattern().reset();
		if(path.length < 2) return;
		
		if(lineDrawers == null || lineDrawers.length != path.length - 1) {
			this.lineDrawers = new LineDrawer[path.length - 1];
			for(int i = 0; i < path.length - 1; i++) {
				lineDrawers[i] = new LineDrawer(getPattern(), path[i], path[i+1], stepsPerSegment);	
				lineDrawers[i].setSubDrawer(true);
			}
		}
		
		for(int i = 0; i < lineDrawers.length; i++) {
			lineDrawers[i].draw();
		}
		
	}
	
	@Override
	public void patternChange() {
		this.lineDrawers = null;
	}

	@Override
	public PathDrawer setPattern(ParticlePattern pattern) { 
		super.setPattern(pattern);
		return this;
	}

	public Location[] getPath() { return path; }
	public PathDrawer setPath(Location[] path) {
		this.path = path;
		this.lineDrawers = null;
		return this;
	}

	public PathDrawer appendLocation(Location toAppend) {
		Location[] newArr = new Location[path.length + 1];
	    for (int i = 0; i < path.length; i++) {
	        newArr[i] = path[i];
	    }		
	    newArr[newArr.length-1] = toAppend;
	    this.path = newArr;
	    this.lineDrawers = null;
	    return this;
	}

	public int getStepsPerSegment() { return stepsPerSegment; }
	public PathDrawer setStepsPerSegment(int stepsPerSegment) {
		this.stepsPerSegment = stepsPerSegment;
		this.lineDrawers = null; // Invalidate the lineDrawers so we create new ones with correct info
		return this;
	}
	
}
