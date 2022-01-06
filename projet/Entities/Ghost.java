package projet.Entities;

import projet.PacManGame;
import java.awt.Color;
import java.util.Objects;

public class Ghost extends Character {

	public static final String NORMAL = "NORMAL";
	public static final String SCARED = "SCARED";
	private PacManGame game;
	private Color baseColor;
	private boolean skipTurn;

	public Ghost(Color color, int posX, int posY, PacManGame game) {
		this.game = game;
		this.posX = posX;
		this.posY = posY;
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
		color = new Color(25, 25, 166);
		state = SCARED;
	}

	private void moving() {
		switch (direction) {
			case UP:
				posY--;
				break;
			case DOWN:
				posY++;
				break;
			case RIGHT:
				posX++;
				break;
			case LEFT:
				posX--;
				break;
			default:
				break;
		}
	}

	public void move() {
		if (!(Objects.equals(state, SCARED) && skipTurn) || Objects.equals(state, NORMAL)) {
			if (game.getMap().isTeleportPoint(posX, posY)) {
				if (Objects.equals(direction, UP) && game.checkerNorth(posX, posY) != 1)
					posY--;
				else if (Objects.equals(direction, DOWN) && game.checkerSouth(posX, posY) != 1)
					posY++;
				else if (Objects.equals(direction, RIGHT) && game.checkerEast(posX, posY) != 1)
					posX++;
				else if (Objects.equals(direction, LEFT) && game.checkerWest(posX, posY) != 1)
					posX--;
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
			int sens = 1 + (int) (Math.random() * ((2 - 1) + 1));
			switch (sens) {
				case 1:
					direction = DOWN;
					moving();
					break;
				case 2:
					direction = RIGHT;
					moving();
					break;
			}
		} else if (north == 1 && south != 1 && east == 1 && west != 1) {
			int sens = 1 + (int) (Math.random() * ((2 - 1) + 1));
			switch (sens) {
				case 1:
					direction = DOWN;
					moving();
					break;
				case 2:
					direction = LEFT;
					moving();
					break;
			}
		} else if (north != 1 && south == 1 && east == 1 && west != 1) {
			int sens = 1 + (int) (Math.random() * ((2 - 1) + 1));
			switch (sens) {
				case 1:
					direction = UP;
					moving();
					break;
				case 2:
					direction = LEFT;
					moving();
					break;
			}
		} else if (north != 1 && south == 1 && east != 1 && west == 1) {
			int sens = 1 + (int) (Math.random() * ((2 - 1) + 1));
			switch (sens) {
				case 1:
					direction = UP;
					moving();
					break;
				case 2:
					direction = RIGHT;
					moving();
					break;
			}

		}
	}

	private void changeDirectionTjunction() {
		int north = game.checkerNorth(posX, posY);
		int south = game.checkerSouth(posX, posY);
		int east = game.checkerEast(posX, posY);
		int west = game.checkerWest(posX, posY);
		if (north == 1 && south != 1 && east != 1 && west != 1) {
			if (Objects.equals(direction, RIGHT) || Objects.equals(direction, LEFT)) {
				moving();
			} else {
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
			}
		} else if (north != 1 && south == 1 && east != 1 && west != 1) {
			if (Objects.equals(direction, RIGHT) || Objects.equals(direction, LEFT)) {
				moving();
			} else {
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
			}
		} else if (north != 1 && south != 1 && east == 1 && west != 1) {
			if (Objects.equals(direction, UP) || Objects.equals(direction, DOWN)) {
				moving();
			} else {
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
			}
		} else if (north != 1 && south != 1 && east != 1 && west == 1) {
			if (Objects.equals(direction, UP) || Objects.equals(direction, DOWN)) {
				moving();
			} else {
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
			moving();
		}
	}
}