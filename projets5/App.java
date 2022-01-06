package projetS5;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class App {

	private static final int GAME_SPEED = 4;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Pacman");
		PacManGame game = new PacManGame();
		PacManView view = new PacManView(game);
		game.setView(view);
		frame.add(view);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_RIGHT:
						game.getPacman().setDirection(Character.RIGHT);
						break;
					case KeyEvent.VK_LEFT:
						game.getPacman().setDirection(Character.LEFT);
						break;
					case KeyEvent.VK_DOWN:
						game.getPacman().setDirection(Character.DOWN);
						break;
					case KeyEvent.VK_UP:
						game.getPacman().setDirection(Character.UP);
						break;
				}
			}
		});
		frame.setVisible(true);
		while (game.getPacman().isAlive()) {
			game.step();
			view.repaint();
			try {
				Thread.sleep(1000 / GAME_SPEED);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
