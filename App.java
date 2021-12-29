package projetS5;

import java.awt.Color;
import javax.swing.JFrame;

public class App {

	private static final int FRAME_LOCATION_X = 100;
	private static final int FRAME_LOCATION_Y = 100;
	static final int FRAMES_PER_SECOND = 3;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Pacman");
		PacManGame game = new PacManGame(); 
		PacManView view = new PacManView(game);
		frame.add(view);
		frame.setLocation(FRAME_LOCATION_X, FRAME_LOCATION_Y);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		while(game.getPacman().isAlive()) {
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
