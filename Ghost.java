package projetS5;

import java.awt.Color;

public class Ghost implements Runnable{
	
	private String state; //normal, scared
	private Color color; //normal, blue
	private String direction; //north, east, south, west
	
	public Ghost() {
		this.state = "normal";
		color = Color.BLUE;
		//this.direction = ?
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		
	}
	
	public void spawn() {
		//tp au centre de la map
	}
	
}
