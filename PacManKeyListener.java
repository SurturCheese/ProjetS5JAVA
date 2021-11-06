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
			System.out.println(game.checkerNorth(game.getPacman().getPosX(), game.getPacman().getPosY()));
		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			pacman.moveLeft();
			game.moveGhost();
		}

		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			pacman.moveDown();
			game.moveGhost();
		}

		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			pacman.moveUp();
			game.moveGhost();
		}
		else if (e.getKeyCode() == KeyEvent.VK_M) {
			game.swapMap();
			view.swapMap();
		}
			view.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		PacMan pacman = game.getPacman();
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			pacman.moveRight();
		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			pacman.moveLeft();
		}

		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			pacman.moveDown();
		}

		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			pacman.moveUp();
		}
		view.repaint();
	}

}
