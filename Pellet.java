package projetS5;

import java.awt.Color;

public class Pellet implements Element {
	private Color color;
	private int points;
	private int posX;
	private int posY;

	public Pellet(Color color, int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.color = color;
		if (color == Color.BLUE)
			points = 100;
		else if (color == Color.MAGENTA)
			points = 300;
		else if (color == Color.ORANGE)
			points = 500;
		else if (color == Color.GREEN)
			points = 1000;
	}

	public Color getColor() {
		return color;
	}

	public int getPoints() {
		return points;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

}
