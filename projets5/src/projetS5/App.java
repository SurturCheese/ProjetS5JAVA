package projetS5;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class App {

	private static final int FRAMES_PER_SECOND = 3;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Pacman");
		PacManGame game = new PacManGame();
		PacManView view = new PacManView(game);
		game.setView(view);
		frame.add(view);
		frame.setLocation(100, 100);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.requestFocusInWindow();
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_RIGHT:
						game.getPacman().setDirection(PacMan.RIGHT);
						break;
					case KeyEvent.VK_LEFT:
						game.getPacman().setDirection(PacMan.LEFT);
						break;
					case KeyEvent.VK_DOWN:
						game.getPacman().setDirection(PacMan.DOWN);
						break;
					case KeyEvent.VK_UP:
						game.getPacman().setDirection(PacMan.UP);
						break;
					default:
						break;
				}
			}
		});
		while (game.getPacman().isAlive()) {
			game.step();
			view.repaint();
			try {
				Thread.sleep(1000 / FRAMES_PER_SECOND);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
