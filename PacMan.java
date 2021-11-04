package projetS5;

import java.awt.Color;

public class PacMan implements Runnable {
	private String state; //normal, invisible, superpacman
	private Color color; //yellow, lightyellow, orange
	private int lifes;
	
	public PacMan() {
		this.state = "normal";
		color = color.YELLOW;
		this.lifes = 3;
	}
	
	@Override
	public void run() {
		
	}
	
	public void lifeUp() {
		lifes = getLifes() + 1;
	}
	
	public void lifeDown() {
		lifes = getLifes() - 1;
	}

	public int getLifes() {
		return lifes;
	}

}
