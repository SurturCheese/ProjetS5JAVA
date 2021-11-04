package projetS5;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PacManKeyListener extends KeyAdapter {

	private PacMan game;
	private PacManView view;
	
	public PacManKeyListener(PacMan game, PacManView view) {
		this.game = game;
		this.view = view;
	}
	
	@Override 
	public void keyPressed(KeyEvent e) {
		  System.out.println("keyPressed");
	}
	@Override 
	public void keyReleased(KeyEvent e) {
		  System.out.println("keyReleased");
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	        System.out.println("keyTyped");
	}
	
}
