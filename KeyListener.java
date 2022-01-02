package projetS5;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

	private PacManGame game;

	public KeyListener(PacManGame game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		PacMan pacman = game.getPacman();
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		pacman.setDirection(PacMan.RIGHT);
		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			pacman.setDirection(PacMan.LEFT);
		}

		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			pacman.setDirection(PacMan.DOWN);
		}

		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			pacman.setDirection(PacMan.UP);
		}
		
		
	}

}
