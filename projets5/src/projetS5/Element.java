package projetS5;

import java.awt.Color;

abstract class Element {
    protected int posX;
    protected int posY;
	protected Color color;

    protected Element(int posX, int posY) {
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

}
