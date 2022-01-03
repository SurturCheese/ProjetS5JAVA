package projetS5;

import java.awt.Color;

public class Ghost implements NPC{

	private PacManGame game;
	private String state;
	public static final String NORMAL = "NORMAL";
	public static final String SCARED = "SCARED";
	private Color color;
	private Color baseColor;
	private String direction;
	private final String UP = "UP";
	private final String RIGHT = "RIGHT";
	private final String DOWN = "DOWN";
	private final String LEFT = "LEFT";
	private int posX;
	private int posY;
	private int skip;

	public Ghost(Color color, int posX, int posY, PacManGame game) {
		this.game = game;
		this.state = NORMAL;
		this.color = color;
		this.baseColor = color;
		this.posX = posX * PacManView.TILESIZE;
		this.posY = posY * PacManView.TILESIZE;
		this.direction = UP;
	}

	public Color getColor() {
		return color;
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

	public void setStateNormal() {
		color = baseColor;
		state = NORMAL;
	}

	public void setStateScared() {
		color = Color.BLUE;
		state = SCARED;
	}

	private void moveEast() {
		posX = posX + PacManView.TILESIZE;
	}

	private void moveWest() {
		posX = posX - PacManView.TILESIZE;
	}

	private void moveSouth() {
		posY = posY + PacManView.TILESIZE;
	}

	private void moveNorth() {
		posY = posY - PacManView.TILESIZE;
	}

	public void move() {
		boolean play = true;
		if (state == SCARED && skip % 2 == 0) {
			play = false;
		}
		skip++;
		if (play) {
			boolean tp = false;
			int[][] temp = game.getMap().getMap();
			int tile = temp[posX / PacManView.TILESIZE][posY / PacManView.TILESIZE];
			if (tile == 8) {
				if (game.getMap().getType().equals(Map.DEFAULT)) {
					if (posX * PacManView.TILESIZE == 0) {
						posX = 26 * PacManView.TILESIZE;
						posY = 14 * PacManView.TILESIZE;
					} else {
						posX = 1 * PacManView.TILESIZE;
						posY = 14 * PacManView.TILESIZE;
					}
				}
				if (game.getMap().getType().equals(Map.GOOGLE)) {
					if (posX * PacManView.TILESIZE == 0) {
						posX = 56 * PacManView.TILESIZE;
						posY = 8 * PacManView.TILESIZE;
					} else {
						posX = 1 * PacManView.TILESIZE;
						posY = 8 * PacManView.TILESIZE;
					}
				}
			}

			if (!tp) {
				int north = game.checkerNorth(posX, posY);
				int south = game.checkerSouth(posX, posY);
				int east = game.checkerEast(posX, posY);
				int west = game.checkerWest(posX, posY);
				if (north != 1 && south != 1 && east == 1 && west == 1) {
					if (direction.equals(UP))
						moveNorth();
					else
						moveSouth();
				} else if (north == 1 && south == 1 && east != 1 && west != 1) {
					if (direction.equals(RIGHT))
						moveEast();
					else
						moveWest();
				} else if (north != 1 && south != 1 && east != 1 && west != 1) {
					int sens = 1 + (int) (Math.random() * ((4 - 1) + 1));
					switch (sens) {
					case 1:
						moveNorth();
						direction = UP;
						break;
					case 2:
						moveEast();
						direction = RIGHT;
						break;
					case 3:
						moveSouth();
						direction = DOWN;
						break;
					case 4:
						moveWest();
						direction = LEFT;
						break;
					}
				} else if (north == 1 && south != 1 && east != 1 && west != 1) {
					int sens = 1 + (int) (Math.random() * ((3 - 1) + 1));
					switch (sens) {
					case 1:
						moveWest();
						direction = LEFT;
						break;
					case 2:
						moveEast();
						direction = RIGHT;
						break;
					case 3:
						moveSouth();
						direction = DOWN;
						break;
					}
				} else if (north != 1 && south == 1 && east != 1 && west != 1) {
					int sens = 1 + (int) (Math.random() * ((3 - 1) + 1));
					switch (sens) {
					case 1:
						moveWest();
						direction = LEFT;
						break;
					case 2:
						moveEast();
						direction = RIGHT;
						break;
					case 3:
						moveNorth();
						direction = UP;
						break;
					}
				} else if (north != 1 && south != 1 && east == 1 && west != 1) {
					int sens = 1 + (int) (Math.random() * ((3 - 1) + 1));
					switch (sens) {
					case 1:
						moveWest();
						direction = LEFT;
						break;
					case 2:
						moveNorth();
						direction = UP;
						break;
					case 3:
						moveSouth();
						direction = DOWN;
						break;
					}
				} else if (north != 1 && south != 1 && east != 1 && west == 1) {
					int sens = 1 + (int) (Math.random() * ((3 - 1) + 1));
					switch (sens) {
					case 1:
						moveNorth();
						direction = UP;
						break;
					case 2:
						moveEast();
						direction = RIGHT;
						break;
					case 3:
						moveSouth();
						direction = DOWN;
						break;
					}
				} else if (north == 1 && south != 1 && east != 1 && west == 1) {
					int sens = 1 + (int) (Math.random() * ((2 - 1) + 1));
					switch (sens) {
					case 1:
						moveSouth();
						direction = DOWN;
						break;
					case 2:
						moveEast();
						direction = RIGHT;
						break;
					}
				} else if (north == 1 && south != 1 && east == 1 && west != 1) {
					int sens = 1 + (int) (Math.random() * ((2 - 1) + 1));
					switch (sens) {
					case 1:
						moveSouth();
						direction = DOWN;
						break;
					case 2:
						moveWest();
						direction = LEFT;
						break;
					}
				} else if (north != 1 && south == 1 && east == 1 && west != 1) {
					int sens = 1 + (int) (Math.random() * ((2 - 1) + 1));
					switch (sens) {
					case 1:
						moveNorth();
						direction = UP;
						break;
					case 2:
						moveWest();
						direction = LEFT;
						break;
					}
				} else if (north != 1 && south == 1 && east != 1 && west == 1) {
					int sens = 1 + (int) (Math.random() * ((2 - 1) + 1));
					switch (sens) {
					case 1:
						moveNorth();
						direction = UP;
						break;
					case 2:
						moveEast();
						direction = RIGHT;
						break;
					}

				} else if (north == 1 && south == 1 && east == 1 && west != 1) {
					moveWest();
					direction = LEFT;
				} else if (north == 1 && south == 1 && east != 1 && west == 1) {
					moveEast();
					direction = RIGHT;
				}

			}

		}
	}
}