package projetS5;

import java.awt.Color;

public class PacMan implements Runnable {
	private String state; //normal, invisible, superpacman
	public static final String NORMAL = "NORMAL";
	public static final String INVISIBLE = "INVISIBLE";
	public static final String SUPERPACMAN = "SUPERPACMAN";
	private Color color; //yellow, lightyellow, orange
	private int lifes;
	
	public PacMan() {
		state = NORMAL;
		color = Color.YELLOW;
		lifes = 3;
	}
	
	public void normal() {
		state = NORMAL;
		color = Color.YELLOW;
	}
	
	public void invisible() {
		state = INVISIBLE;
		color = Color.WHITE;
	}
	
	public void superpacman() {
		state = SUPERPACMAN;
		color = Color.ORANGE;
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

	public String getState() {
		return state;
	}

	public Color getColor() {
		return color;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
