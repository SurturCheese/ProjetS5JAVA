package projetS5;

import java.awt.Color;

public class Ghost implements Runnable{
	
	private String state; //normal, scared
	public static final String NORMAL = "NORMAL";
	public static final String SCARED = "SCARED";
	private Color color; //normal, blue
	private String direction; //north, east, south, west
	
	public Ghost(Color color) {
		state = NORMAL;
		this.color = color;
		//this.direction = ?
		new Thread(this).start();
	}
	
	public void scared() {
		color = Color.BLUE;
	}
	
	@Override
	public void run() {
		
	}
	
	public void spawn() {
		//tp au centre de la map
	}
	
}
