package projet.entities;

import java.awt.Color;

import projet.entities.pacmanstate.PacmanState;

/**
 * Implémentation du pacman que le joueur controle
 */
public class PacMan extends Character {

	private PacmanState state;

	public PacMan(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		color = Color.YELLOW;
	}

	public void setState(PacmanState state) {
		this.state = state;
	}

	/**
	 * Methode appelee quand le sujet performe une action
	 */
	public void action() {
		state.action();
	}

}
