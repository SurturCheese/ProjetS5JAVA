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

	private void moving() {
		switch (direction) {
			case UP:
				posY = posY - PacManView.TILESIZE;
				break;
			case DOWN:
				posY = posY + PacManView.TILESIZE;
				break;
			case RIGHT:
				posX = posX + PacManView.TILESIZE;
				break;
			case LEFT:
				posX = posX - PacManView.TILESIZE;
				break;
			default:
				break;
		}
	}

	public void move() {
		if (!(Objects.equals(state, SCARED) && skipTurn) || Objects.equals(state, NORMAL)) {
			if (game.getMap().isTeleportPoint(posX / PacManView.TILESIZE, posY / PacManView.TILESIZE)) {
				if (Objects.equals(direction, UP) && game.checkerNorth(posX, posY) != 1)
					posY = posY - PacManView.TILESIZE;
				else if (Objects.equals(direction, DOWN) && game.checkerSouth(posX, posY) != 1)
					posY = posY + PacManView.TILESIZE;
				else if (Objects.equals(direction, RIGHT) && game.checkerEast(posX, posY) != 1)
					posX = posX + PacManView.TILESIZE;
				else if (Objects.equals(direction, LEFT) && game.checkerWest(posX, posY) != 1)
					posX = posX - PacManView.TILESIZE;
			} else {
				if (!changeDirectionStraight()) {
					changeDirectionAngle();
					changeDirectionCross();
					changeDirectionDeadend();
					changeDirectionTjunction();
				}
			}
		}
		skipTurn = !skipTurn;
	}

	private boolean changeDirectionStraight() {
		int north = game.checkerNorth(posX, posY);
		int south = game.checkerSouth(posX, posY);
		int east = game.checkerEast(posX, posY);
		int west = game.checkerWest(posX, posY);
		if (north != 1 && south != 1 && east == 1 && west == 1) {
			if (direction.equals(UP)) {
				moving();
				return true;
			} else {
				direction = DOWN;
				moving();
				return true;
			}
		} else if (north == 1 && south == 1 && east != 1 && west != 1) {
			if (direction.equals(RIGHT)) {
				moving();
				return true;
			} else {
				direction = LEFT;
				moving();
				return true;
			}
		}
		return false;
	}

	private void changeDirectionAngle() {
		int north = game.checkerNorth(posX, posY);
		int south = game.checkerSouth(posX, posY);
		int east = game.checkerEast(posX, posY);
		int west = game.checkerWest(posX, posY);
		if (north == 1 && south != 1 && east != 1 && west == 1) {
			if (Objects.equals(direction, UP)) {
				direction = RIGHT;
				moving();
			} else {
				direction = DOWN;
				moving();
			}
		} else if (north == 1 && south != 1 && east == 1 && west != 1) {
			if (Objects.equals(direction, RIGHT)) {
				direction = DOWN;
				moving();
			} else {
				direction = LEFT;
				moving();
			}
		} else if (north != 1 && south == 1 && east == 1 && west != 1) {
			if (Objects.equals(direction, DOWN)) {
				direction = LEFT;
				moving();
			} else {
				direction = UP;
				moving();
			}
		} else if (north != 1 && south == 1 && east != 1 && west == 1) {
			if (Objects.equals(direction, DOWN)) {
				direction = RIGHT;
				moving();
			} else {
				direction = UP;
				moving();
			}
		}
	}

	private void changeDirectionTjunction() {
		int north = game.checkerNorth(posX, posY);
		int south = game.checkerSouth(posX, posY);
		int east = game.checkerEast(posX, posY);
		int west = game.checkerWest(posX, posY);
		if (north == 1 && south != 1 && east != 1 && west != 1) {
			int sens = 1 + (int) (Math.random() * ((3 - 1) + 1));
			switch (sens) {
				case 1:
					direction = LEFT;
					moving();
					break;
				case 2:
					direction = RIGHT;
					moving();
					break;
				case 3:
					direction = DOWN;
					moving();
					break;
				default:
					break;
			}
		} else if (north != 1 && south == 1 && east != 1 && west != 1) {
			int sens = 1 + (int) (Math.random() * ((3 - 1) + 1));
			switch (sens) {
				case 1:
					direction = LEFT;
					moving();
					break;
				case 2:
					direction = RIGHT;
					moving();
					break;
				case 3:
					direction = UP;
					moving();
					break;
				default:
					break;
			}
		} else if (north != 1 && south != 1 && east == 1 && west != 1) {
			int sens = 1 + (int) (Math.random() * ((3 - 1) + 1));
			switch (sens) {
				case 1:
					direction = LEFT;
					moving();
					break;
				case 2:
					direction = UP;
					moving();
					break;
				case 3:
					direction = DOWN;
					moving();
					break;
				default:
					break;
			}
		} else if (north != 1 && south != 1 && east != 1 && west == 1) {
			int sens = 1 + (int) (Math.random() * ((3 - 1) + 1));
			switch (sens) {
				case 1:
					direction = UP;
					moving();
					break;
				case 2:
					direction = RIGHT;
					moving();
					break;
				case 3:
					direction = DOWN;
					moving();
					break;
				default:
					break;
			}
		}
	}

	private void changeDirectionDeadend() {
		int north = game.checkerNorth(posX, posY);
		int south = game.checkerSouth(posX, posY);
		int east = game.checkerEast(posX, posY);
		int west = game.checkerWest(posX, posY);
		if (north == 1 && south == 1 && east == 1 && west != 1) {
			direction = LEFT;
			moving();
		} else if (north == 1 && south == 1 && east != 1 && west == 1) {
			direction = RIGHT;
			moving();
		} else if (north != 1 && south == 1 && east == 1 && west == 1) {
			direction = UP;
			moving();
		} else if (north == 1 && south != 1 && east == 1 && west == 1) {
			direction = DOWN;
			moving();
		}
	}

	private void changeDirectionCross() {
		int north = game.checkerNorth(posX, posY);
		int south = game.checkerSouth(posX, posY);
		int east = game.checkerEast(posX, posY);
		int west = game.checkerWest(posX, posY);
		if (north != 1 && south != 1 && east != 1 && west != 1) {
			int sens = 1 + (int) (Math.random() * ((4 - 1) + 1));
			switch (sens) {
				case 1:
					direction = UP;
					moving();
					break;
				case 2:
					direction = RIGHT;
					moving();
					break;
				case 3:
					direction = DOWN;
					moving();
					break;
				case 4:
					direction = LEFT;
					moving();
					break;
				default:
					break;
			}
		}
	}
}