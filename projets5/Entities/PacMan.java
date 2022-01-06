package projetS5;

import java.awt.Color;
import java.util.Objects;

public class PacMan extends Character {

	public static final String NORMAL = "NORMAL";
	public static final String INVISIBLE = "INVISIBLE";
	public static final String SUPERPACMAN = "SUPERPACMAN";
	private PacManGame game;
	private boolean isAlive;

	public PacMan(int posX, int posY, PacManGame game) {
		this.game = game;
		this.posX = posX;
		this.posY = posY;
		state = NORMAL;
		color = Color.YELLOW;
		isAlive = true;
	}

	public void setStateNormal() {
		state = NORMAL;
		color = Color.YELLOW;
	}

	public void setStateInvisible() {
		state = INVISIBLE;
		color = new Color(255,255,210,255);
	}

	public void setStateSuperpacman() {
		state = SUPERPACMAN;
		color = Color.ORANGE;
	}

	public void setDead() {
		this.isAlive = false;
	}

	public boolean isAlive() {
		return this.isAlive;
	}

	public void move() {
		if (Objects.equals(direction, UP) && game.checkerNorth(posX, posY) != 1)
			posY--;
		else if (Objects.equals(direction, DOWN) && game.checkerSouth(posX, posY) != 1)
			posY++;
		else if (Objects.equals(direction, RIGHT) && game.checkerEast(posX, posY) != 1)
			posX++;
		else if (Objects.equals(direction, LEFT) && game.checkerWest(posX, posY) != 1)
			posX--;
	}
}
