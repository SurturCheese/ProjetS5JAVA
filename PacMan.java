package projetS5;

import java.awt.Color;

public class PacMan implements Runnable {
	private String state; //normal, invisible, superpacman
	private Color color; //yellow, lightyellow, orange
	private int points;
	private int lifes;
	
	public PacMan() {
		this.state = "normal";
		color = color.YELLOW;
		this.points = 0;
		this.lifes = 3;
	}
	
	@Override
	public void run() {
		
	}
	
	public void LifeUp(PacMan pm) {
		if (pm.points >= 5000) pm.lifes++;
	}

}
