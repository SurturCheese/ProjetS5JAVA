package projetS5;

import java.awt.Color;

public class PacMan {

	private String state;
	public static final String NORMAL = "NORMAL";
	public static final String INVISIBLE = "INVISIBLE";
	public static final String SUPERPACMAN = "SUPERPACMAN";
	private Color color;
	private int posX;
	private int posY;

	public PacMan(int posX, int posY) {
		state = NORMAL;
		color = Color.YELLOW;
		this.posX = posX * PacManView.TILESIZE;
		this.posY = posY * PacManView.TILESIZE;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
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

	public void moveRight() {
		posX = posX + PacManView.TILESIZE;
		System.out.println(posX + " " + posY);
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
