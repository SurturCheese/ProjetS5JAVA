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
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("VK_RIGHT Pressed");
		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("VK_LEFT Pressed");
		}

		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("VK_DOWN Pressed");
		}

		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("VK_UP Pressed");
		}
		// view.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("VK_RIGHT Released");
		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("VK_LEFT Released");
		}

		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("VK_DOWN Released");
		}

		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("VK_UP Released");
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("VK_RIGHT Typed");
		}

		else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("VK_LEFT Typed");
		}

		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("VK_DOWN Typed");
		}

		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("VK_UP Typed");
		}

	}

}
