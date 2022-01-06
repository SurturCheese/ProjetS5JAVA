package projetS5;

import java.awt.Color;
import java.util.Objects;

public class PacMan extends Character {

	private PacManGame game;
	public static final String NORMAL = "NORMAL";
	public static final String INVISIBLE = "INVISIBLE";
	public static final String SUPERPACMAN = "SUPERPACMAN";
	private boolean isAlive;

	public PacMan(int posX, int posY, PacManGame game) {
		this.game = game;
		state = NORMAL;
		color = Color.YELLOW;
		this.posX = posX;
		this.posY = posY;
		this.isAlive = true;
		this.direction = "NORD";
	}

	public void setStateNormal() {
		state = NORMAL;
		color = Color.YELLOW;
	}

	public void setStateInvisible() {
		state = INVISIBLE;
		color = Color.WHITE;
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
			posY = posY - 1;
		else if (Objects.equals(direction, DOWN) && game.checkerSouth(posX, posY) != 1)
			posY = posY + 1;
		else if (Objects.equals(direction, RIGHT) && game.checkerEast(posX, posY) != 1)
			posX = posX + 1;
		else if (Objects.equals(direction, LEFT) && game.checkerWest(posX, posY) != 1)
			posX = posX - 1;
	}
}
