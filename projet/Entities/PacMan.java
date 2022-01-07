package projet.Entities;

import java.awt.Color;
import projet.Entities.pacmanstate.PacmanState;

public class PacMan extends Character {

	private boolean isAlive;
	private PacmanState state;

	public PacMan(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		color = Color.YELLOW;
		isAlive = true;
	}

	public void setDead() {
		this.isAlive = false;
	}

	public boolean isAlive() {
		return this.isAlive;
	}

	public void setState(PacmanState state) {
		this.state = state;
	}

	public void action() {
		state.action();
	}

}
