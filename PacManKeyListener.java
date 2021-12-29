package projetS5;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PacManKeyListener extends KeyAdapter {

	private PacManGame game;

	public PacManKeyListener(PacManGame game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		PacMan pacman = game.getPacman();
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		
		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			
		}

		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			
		}

		else if (e.getKeyCode() == KeyEvent.VK_UP) {
		
		}
		
		
	}

}
