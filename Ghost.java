package projetS5;

import java.awt.Color;

public class Ghost {

	private PacManGame game;
	private String state;
	public static final String NORMAL = "NORMAL";
	public static final String SCARED = "SCARED";
	private Color color;
	private Color baseColor;
	private String direction;
	public static final String NORTH = "NORD";
	public static final String EAST = "EAST";
	public static final String SOUTH = "SOUTH";
	public static final String WEST = "WEST";
	private int posX;
	private int posY;

	public Ghost(Color color, int posX, int posY, PacManGame game) {
		this.game = game;
		state = NORMAL;
		this.color = color;
		baseColor = color;
		this.posX = posX * PacManView.TILESIZE;
		this.posY = posY * PacManView.TILESIZE;
		this.direction = NORTH;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
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
		color = baseColor;
		state = NORMAL;
	}

	public void scared() {
		color = Color.BLUE;
		state = SCARED;
	}

	private void moveRight() {
		posX = posX + PacManView.TILESIZE;
	}

	private void moveLeft() {
		posX = posX - PacManView.TILESIZE;
	}

	private void moveDown() {
		posY = posY + PacManView.TILESIZE;
	}

	private void moveUp() {
		posY = posY - PacManView.TILESIZE;
	}

	public void move() {
		int north = game.checkerNorth(posX, posY);
		int south = game.checkerSouth(posX, posY);
		int east = game.checkerEast(posX, posY);
		int west = game.checkerWest(posX, posY);
		
		if(north == 1 ) {
			
		}
	}

	public void moveRandom() {
		int direction = 1 + (int) (Math.random() * ((4 - 1) + 1));
		switch (direction) {
		case 1:
			moveUp();
			break;
		case 2:
			moveRight();
			break;
		case 3:
			moveDown();
			break;
		case 4:
			moveLeft();
			break;
		}
	}

}
