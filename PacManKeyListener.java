package projetS5;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PacManKeyListener extends KeyAdapter {

	private PacManGame game;
	private PacManView view;

	public PacManKeyListener(PacManGame game, PacManView view) {
		this.game = game;
		this.view = view;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		PacMan pacman = game.getPacman();
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			pacman.moveRight();
			game.moveGhost();
			game.checkCase(pacman.getPosX(), pacman.getPosY());
			game.checkBonusLive();
		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			pacman.moveLeft();
			game.moveGhost();
			game.checkCase(pacman.getPosX(), pacman.getPosY());
			game.checkBonusLive();
		}

		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			pacman.moveDown();
			game.moveGhost();
			game.checkCase(pacman.getPosX(), pacman.getPosY());
			game.checkBonusLive();
		}

		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			pacman.moveUp();
			game.moveGhost();
			game.checkCase(pacman.getPosX(), pacman.getPosY());
			game.checkBonusLive();
		}
			view.repaint();
	}



}
