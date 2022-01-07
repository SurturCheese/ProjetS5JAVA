package projet.blocs;

import java.awt.Color;

import projet.PacManGame;

public abstract class Element {
	protected int posX;
	protected int posY;
	protected Color color;
	protected PacManGame game;

	protected Element(int posX, int posY, PacManGame game) {
		this.game = game;
		this.posX = posX;
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}

	public Color getColor() {
		return color;
	}

	/**
	 * Methode appelee quand le sujet performe une action
	 */
	public abstract void action();

}
