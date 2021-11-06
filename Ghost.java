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
				if (direction.equals(NORTH))
					moveNorth();
				else
					moveSouth();
			} else if (north == 1 && south == 1 && east != 1 && west != 1) {
				if (direction.equals(EAST))
					moveEast();
				else
					moveWest();
			} else if (north != 1 && south != 1 && east != 1 && west != 1) {
				int sens = 1 + (int) (Math.random() * ((4 - 1) + 1));
				switch (sens) {
				case 1:
					moveNorth();
					direction = NORTH;
					break;
				case 2:
					moveEast();
					direction = EAST;
					break;
				case 3:
					moveSouth();
					direction = SOUTH;
					break;
				case 4:
					moveWest();
					direction = WEST;
					break;
				}
			} else if (north == 1 && south != 1 && east != 1 && west != 1) {
				int sens = 1 + (int) (Math.random() * ((3 - 1) + 1));
				switch (sens) {
				case 1:
					moveWest();
					direction = WEST;
					break;
				case 2:
					moveEast();
					direction = EAST;
					break;
				case 3:
					moveSouth();
					direction = SOUTH;
					break;
				}
			}

			else if (north != 1 && south == 1 && east != 1 && west != 1) {
				int sens = 1 + (int) (Math.random() * ((3 - 1) + 1));
				switch (sens) {
				case 1:
					moveWest();
					direction = WEST;
					break;
				case 2:
					moveEast();
					direction = EAST;
					break;
				case 3:
					moveNorth();
					direction = NORTH;
					break;
				}
			}

			else if (north != 1 && south != 1 && east == 1 && west != 1) {
				int sens = 1 + (int) (Math.random() * ((3 - 1) + 1));
				switch (sens) {
				case 1:
					moveWest();
					direction = WEST;
					break;
				case 2:
					moveNorth();
					direction = NORTH;
					break;
				case 3:
					moveSouth();
					direction = SOUTH;
					break;
				}
			}

			else if (north != 1 && south != 1 && east != 1 && west == 1) {
				int sens = 1 + (int) (Math.random() * ((3 - 1) + 1));
				switch (sens) {
				case 1:
					moveNorth();
					direction = NORTH;
					break;
				case 2:
					moveEast();
					direction = EAST;
					break;
				case 3:
					moveSouth();
					direction = SOUTH;
					break;
				}
			} else if (north == 1 && south != 1 && east != 1 && west == 1) {
				int sens = 1 + (int) (Math.random() * ((2 - 1) + 1));
				switch (sens) {
				case 1:
					moveSouth();
					direction = SOUTH;
					break;
				case 2:
					moveEast();
					direction = EAST;
					break;
				}
			} else if (north == 1 && south != 1 && east == 1 && west != 1) {
				int sens = 1 + (int) (Math.random() * ((2 - 1) + 1));
				switch (sens) {
				case 1:
					moveSouth();
					direction = SOUTH;
					break;
				case 2:
					moveWest();
					direction = WEST;
					break;
				}
			} else if (north != 1 && south == 1 && east == 1 && west != 1) {
				int sens = 1 + (int) (Math.random() * ((2 - 1) + 1));
				switch (sens) {
				case 1:
					moveNorth();
					direction = NORTH;
					break;
				case 2:
					moveWest();
					direction = WEST;
					break;
				}
			} else if (north != 1 && south == 1 && east != 1 && west == 1) {
				int sens = 1 + (int) (Math.random() * ((2 - 1) + 1));
				switch (sens) {
				case 1:
					moveNorth();
					direction = NORTH;
					break;
				case 2:
					moveEast();
					direction = EAST;
					break;
				}

			} else if (north == 1 && south == 1 && east == 1 && west != 1) {
				moveWest();
				direction = WEST;
			}

			else if (north == 1 && south == 1 && east != 1 && west == 1) {
				moveEast();
				direction = EAST;
			}

		}
	}
}
