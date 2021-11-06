package projetS5;

import java.awt.Color;

public class PacMan {

	private PacManGame game;
	private String state;
	public static final String NORMAL = "NORMAL";
	public static final String INVISIBLE = "INVISIBLE";
	public static final String SUPERPACMAN = "SUPERPACMAN";
	private Color color;
	private int posX;
	private int posY;

	public PacMan(int posX, int posY, PacManGame game) {
		this.game = game;
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
		if (game.checkerEast(posX, posY) != 1)
			posX = posX + PacManView.TILESIZE;
	}

	public void moveLeft() {
		if (game.checkerWest(posX, posY) != 1)
			posX = posX - PacManView.TILESIZE;
	}

	public void moveDown() {
		if (game.checkerSouth(posX, posY) != 1)
			posY = posY + PacManView.TILESIZE;
	}

	public void moveUp() {
		if (game.checkerNorth(posX, posY) != 1)
			posY = posY - PacManView.TILESIZE;
	}

	public void tp(int x, int y) {
		posX = x * PacManView.TILESIZE;
		posY = y * PacManView.TILESIZE;
	}
}
