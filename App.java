package projetS5;

import java.awt.Color;

import javax.swing.JFrame;

public class App {

	private static final int FRAME_LOCATION_X = 100;
	private static final int FRAME_LOCATION_Y = 100;

	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Pacman");
		PacManView view = new PacManView(new PacManGame());
		frame.add(view);
		frame.setLocation(FRAME_LOCATION_X, FRAME_LOCATION_Y);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
