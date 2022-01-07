package projet.Entities;

import java.awt.Color;

import projet.PacManGame;
import projet.Entities.ghoststate.GhostState;
import projet.Entities.ghoststate.NormalState;
import projet.Entities.ghoststate.ScaredState;

public class Ghost extends Character {

	private PacManGame game;
	private Color baseColor;
	private GhostState state;

	public Ghost(Color color, int posX, int posY, PacManGame game) {
		this.game = game;
		this.posX = posX;
		this.posY = posY;
		this.color = color;
		baseColor = color;
		direction = UP;
		state = new NormalState(game, this);
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

	public void setNormalState() {
		state = new NormalState(game, this);
	}

	public void setStateScared() {
		state = new ScaredState(game, this);
	}
}