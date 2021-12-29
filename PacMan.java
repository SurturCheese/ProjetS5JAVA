package projetS5;

import java.awt.Color;

public class PacMan {

	private PacManGame game;
	private String state;
	public static final String NORMAL = "NORMAL";
	public static final String INVISIBLE = "INVISIBLE";
	public static final String SUPERPACMAN = "SUPERPACMAN";
	public static final String NORTH = "NORD";
	public static final String EAST = "EAST";
	public static final String SOUTH = "SOUTH";
	public static final String WEST = "WEST";
	private String direction;
	private Color color;
	private int posX;
	private int posY;
	private boolean isAlive;

	public PacMan(int posX, int posY, PacManGame game) {
		this.game = game;
		state = NORMAL;
		color = Color.YELLOW;
		this.posX = posX * PacManView.TILESIZE;
		this.posY = posY * PacManView.TILESIZE;
		this.isAlive = true;
		this.direction = "NORD";
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

	public void setDead() {
		this.isAlive = false;
	}

	public boolean isAlive() {
		return this.isAlive;
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

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void move() {
		if (direction == NORTH)
			if (game.checkerNorth(posX, posY) != 1)
				posY = posY - PacManView.TILESIZE;
		if (direction == SOUTH)
			if (game.checkerSouth(posX, posY) != 1)
				posY = posY + PacManView.TILESIZE;
		if (direction == EAST)
			if (game.checkerEast(posX, posY) != 1)
				posX = posX + PacManView.TILESIZE;
		if (direction == WEST)
			if (game.checkerWest(posX, posY) != 1)
				posX = posX - PacManView.TILESIZE;
	}

	public void tp(int x, int y) {
		posX = x * PacManView.TILESIZE;
		posY = y * PacManView.TILESIZE;
	}
}
