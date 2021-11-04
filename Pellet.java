package projetS5;

import java.awt.Color;

public class Pellet {
	private Color color;
	private int points;

	public Pellet(Color color) {
		this.color = color;
		if (color == Color.BLUE)
			points = 100;
		if (color == Color.MAGENTA)
			points = 300;
		if (color == Color.ORANGE)
			points = 500;
		if (color == Color.GREEN)
			points = 1000;
	}

	public int getPoints() {
		return points;
	}

	public Color getColor() {
		return color;
	}
}
