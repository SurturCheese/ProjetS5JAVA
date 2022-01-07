package projet.Entities;

import java.awt.Color;

import projet.PacManGame;
import projet.Entities.pacmanstate.InvisibleState;
import projet.Entities.pacmanstate.NormalState;
import projet.Entities.pacmanstate.PacmanState;
import projet.Entities.pacmanstate.SuperPacmanState;

public class PacMan extends Character {

	private PacManGame game;
	private boolean isAlive;
	private PacmanState state;

	public PacMan(int posX, int posY, PacManGame game) {
		this.game = game;
		this.posX = posX;
		this.posY = posY;
		state = new NormalState(game,this);
		color = Color.YELLOW;
		isAlive = true;
	}

	public void setDead() {
		this.isAlive = false;
	}

	public boolean isAlive() {
		return this.isAlive;
	}

	public void action() {
		state.action();
	}

    public void setStateSuperpacman() {
		state = new SuperPacmanState(game,this);
    }

    public void setStateInvisible() {
		state = new InvisibleState(game, this);
    }

	public void setStateNormal() {
		state = new NormalState(game, this);
	}

}
