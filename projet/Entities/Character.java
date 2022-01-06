package projet.entities;

import java.awt.Color;

public abstract class Character {
    public static final String UP = "UP";
    public static final String RIGHT = "RIGHT";
    public static final String DOWN = "DOWN";
    public static final String LEFT = "LEFT";
    protected String state;
    protected Color color;
    protected String direction;
    protected int posX;
    protected int posY;

	public String getState() {
		return state;
	}

	public void setColor(Color color) {
		this.color = color;
	}

    public Color getColor() {
		return color;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
    }

    public void teleport(int x, int y) {
		posX = x;
		posY = y;
	}

    public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getDirection() {
		return direction;
	}

}
