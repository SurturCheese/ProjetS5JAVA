package projetS5;

import java.awt.Color;

public class PacMan implements Runnable {
	private String state;
	public static final String NORMAL = "NORMAL";
	public static final String INVISIBLE = "INVISIBLE";
	public static final String SUPERPACMAN = "SUPERPACMAN";
	private Color color;
	private int lifes;
	private int posX;
	private int posY;

	public PacMan() {
		state = NORMAL;
		color = Color.YELLOW;
		lifes = 3;
		posX = 0;
		posY = 0;
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

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public void moveRight() {
		posX = posX + 22;
	}

	public void moveLeft() {
		posX = posX - 22;
	}

	public void moveDown() {
		posY = posY + 22;
	}

	public void moveUp() {
		posY = posY - 22;
	}

}
