package projetS5;

import java.awt.Graphics;
import javax.swing.JComponent;

public class PacManView extends JComponent {

	
	private static final long serialVersionUID = 1L;
	private final PacManGame game;
	private final static int WIDTH = 500;
	private final static int HEIGHT = 500;

	public PacManView(PacManGame game) {
		super();
		this.game = game;
		addKeyListener(new PacManKeyListener(game, this));
		setFocusable(true);
		requestFocusInWindow();
		setOpaque(true);
		setSize(WIDTH, HEIGHT);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

}
