package projetS5;

import java.awt.Color;

public class Ghost {

	private String state;
	public static final String NORMAL = "NORMAL";
	public static final String SCARED = "SCARED";
	private Color color;
	private Color baseColor;
	private String direction;
	public static final String NORTH = "NORD";
	public static final String EAST = "EAST";
	public static final String SOUTH = "SOUTH";
	public static final String WEST = "WEST";
	private int posX;
	private int posY;

	public Ghost(Color color) {
		state = NORMAL;
		this.color = color;
		baseColor = color;
		// this.direction = ?
	}

	public void scared() {
		color = Color.BLUE;
		state = SCARED;
	}

	public void normal() {
		color = baseColor;
		state = NORMAL;
	}

	public String getState() {
		return state;
	}

	public Color getColor() {
		return color;
	}

	public String getDirection() {
		return direction;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setColor(Color color) {
		this.color=color;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	

}
