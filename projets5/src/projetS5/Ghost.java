package projetS5;

import java.awt.Color;
import java.util.Objects;

public class Ghost extends Character {

	private PacManGame game;
	public static final String NORMAL = "NORMAL";
	public static final String SCARED = "SCARED";
	private Color baseColor;
	private boolean skipTurn;

	public Ghost(Color color, int posX, int posY, PacManGame game) {
		this.game = game;
		this.posX = posX * PacManView.TILESIZE;
		this.posY = posY * PacManView.TILESIZE;
		this.color = color;
		state = NORMAL;
		baseColor = color;
		direction = UP;
		skipTurn = false;
	}

	public void setStateNormal() {
		color = baseColor;
		state = NORMAL;
	}

	public void setStateScared() {
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
		if (!(Objects.equals(state, SCARED) && skipTurn) || Objects.equals(state, NORMAL)) {
			if (Objects.equals(direction, UP) && game.checkerNorth(posX, posY) != 1)
				posY = posY - PacManView.TILESIZE;
			else if (Objects.equals(direction, DOWN) && game.checkerSouth(posX, posY) != 1)
				posY = posY + PacManView.TILESIZE;
			else if (Objects.equals(direction, RIGHT) && game.checkerEast(posX, posY) != 1)
				posX = posX + PacManView.TILESIZE;
			else if (Objects.equals(direction, LEFT) && game.checkerWest(posX, posY) != 1)
				posX = posX - PacManView.TILESIZE;
			else {
				changeDirection();
			}
		}
		skipTurn = !skipTurn;
	}

	private void changeDirection() {
		int north = game.checkerNorth(posX, posY);
		int south = game.checkerSouth(posX, posY);
		int east = game.checkerEast(posX, posY);
		int west = game.checkerWest(posX, posY);
		if (north != 1 && south != 1 && east == 1 && west == 1) {
			if (direction.equals(UP))
				moveUp();
			else
				moveDown();
		} else if (north == 1 && south == 1 && east != 1 && west != 1) {
			if (direction.equals(RIGHT))
				moveRight();
			else
				moveLeft();
		} else if (north != 1 && south != 1 && east != 1 && west != 1) {
			int sens = 1 + (int) (Math.random() * ((4 - 1) + 1));
			switch (sens) {
				case 1:
					moveUp();
					direction = UP;
					break;
				case 2:
					moveRight();
					direction = RIGHT;
					break;
				case 3:
					moveDown();
					direction = DOWN;
					break;
				case 4:
					moveLeft();
					direction = LEFT;
					break;
				default:
					break;
			}
		} else if (north == 1 && south != 1 && east != 1 && west != 1) {
			int sens = 1 + (int) (Math.random() * ((3 - 1) + 1));
			switch (sens) {
				case 1:
					moveLeft();
					direction = LEFT;
					break;
				case 2:
					moveRight();
					direction = RIGHT;
					break;
				case 3:
					moveDown();
					direction = DOWN;
					break;
				default:
					break;
			}
		} else if (north != 1 && south == 1 && east != 1 && west != 1) {
			int sens = 1 + (int) (Math.random() * ((3 - 1) + 1));
			switch (sens) {
				case 1:
					moveLeft();
					direction = LEFT;
					break;
				case 2:
					moveRight();
					direction = RIGHT;
					break;
				case 3:
					moveUp();
					direction = UP;
					break;
				default:
					break;
			}
		} else if (north != 1 && south != 1 && east == 1 && west != 1) {
			int sens = 1 + (int) (Math.random() * ((3 - 1) + 1));
			switch (sens) {
				case 1:
					moveLeft();
					direction = LEFT;
					break;
				case 2:
					moveUp();
					direction = UP;
					break;
				case 3:
					moveDown();
					direction = DOWN;
					break;
				default:
					break;
			}
		} else if (north != 1 && south != 1 && east != 1 && west == 1) {
			int sens = 1 + (int) (Math.random() * ((3 - 1) + 1));
			switch (sens) {
				case 1:
					moveUp();
					direction = UP;
					break;
				case 2:
					moveRight();
					direction = RIGHT;
					break;
				case 3:
					moveDown();
					direction = DOWN;
					break;
				default:
					break;
			}
		} else if (north == 1 && south != 1 && east != 1 && west == 1) {
			if (Objects.equals(direction, UP)) {
				moveRight();
				direction = RIGHT;
			} else {
				moveDown();
				direction = DOWN;
			}
		} else if (north == 1 && south != 1 && east == 1 && west != 1) {
			if (Objects.equals(direction, RIGHT)) {
				moveDown();
				direction = DOWN;
			} else {
				moveLeft();
				direction = LEFT;
			}
		} else if (north != 1 && south == 1 && east == 1 && west != 1) {
			if (Objects.equals(direction, DOWN)) {
				moveLeft();
				direction = LEFT;
			} else {
				moveUp();
				direction = UP;
			}
		} else if (north != 1 && south == 1 && east != 1 && west == 1) {
			if (Objects.equals(direction, DOWN)) {
				moveRight();
				direction = RIGHT;
			} else {
				moveUp();
				direction = UP;
			}
		} else if (north == 1 && south == 1 && east == 1 && west != 1) {
			moveLeft();
			direction = LEFT;
		} else if (north == 1 && south == 1 && east != 1 && west == 1) {
			moveRight();
			direction = RIGHT;
		}
	}
}