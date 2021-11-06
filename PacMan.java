package projetS5;

import java.awt.Color;

public class PacMan {
	
	private String state;
	public static final String NORMAL = "NORMAL";
	public static final String INVISIBLE = "INVISIBLE";
	public static final String SUPERPACMAN = "SUPERPACMAN";
	private Color color;
	private int lifes;
	private int posX;
	private int posY;

	public PacMan(int posX, int posY) {
		state = NORMAL;
		color = Color.YELLOW;
		lifes = 3;
		this.posX = posY*PacManView.TILESIZE;
		this.posY = posX*PacManView.TILESIZE;
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

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void moveRight() {
		posX = posX + PacManView.TILESIZE;
	}

	public void moveLeft() {
		posX = posX - PacManView.TILESIZE;
	}

	public void moveDown() {
		posY = posY + PacManView.TILESIZE;
	}

	public void moveUp() {
		posY = posY - PacManView.TILESIZE;
	}

}
