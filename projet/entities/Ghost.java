package projet.entities;

import java.awt.Color;

import projet.entities.ghoststate.GhostState;

public class Ghost extends Character {

	private Color baseColor;
	private GhostState state;

	public Ghost(Color color, int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.color = color;
		baseColor = color;
		direction = UP;
	}

	public void setState(GhostState state) {
		this.state = state;
	}

	public Color getBaseColor() {
		return baseColor;
	}

	public void action() {
		state.action();
	}
}
