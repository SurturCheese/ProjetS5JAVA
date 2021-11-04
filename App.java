package projetS5;

import javax.swing.JFrame;

public class App {

	private static final int FRAME_LOCATION_X = 100;
	private static final int FRAME_LOCATION_Y = 100;
	public final static int WIDTH = 500;
	public final static int HEIGHT = 500;
	
	
	public static void main(String[] args) {
		PacManView view = new PacManView(new PacMan());
		JFrame frame = new JFrame("Pacman");
		frame.add(view);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(FRAME_LOCATION_X, FRAME_LOCATION_Y);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
