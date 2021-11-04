package projetS5;

import java.awt.Color;

public class Ghost implements Runnable {

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

	public Ghost(Color color) {
		state = NORMAL;
		this.color = color;
		baseColor = color;
		// this.direction = ?
		new Thread(this).start();
	}

	public void scared() {
		color = Color.BLUE;
		state = SCARED;
	}

	public void normal() {
		color = baseColor;
		state = NORMAL;
	}

	@Override
	public void run() {

	}

	public void spawn() {
		// tp au centre de la map
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
		this.color = color;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}
