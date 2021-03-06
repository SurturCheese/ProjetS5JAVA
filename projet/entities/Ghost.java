package projet.entities;

import java.awt.Color;

import projet.entities.ghoststate.GhostState;

/**
 * Implémentation des fantomes du jeu
 */
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

	/**
	 * Methode appelee quand le sujet performe une action
	 */
	public void action() {
		state.action();
	}
}
