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
		setSize(WIDTH, HEIGHT);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawMap(g);
		drawGhosts(g);
		drawPacMan(g);
		drawPellets(g);

	}

	public void drawPellets(Graphics g) {
		for (Pellet pellet : game.getListPellet()) {
			g.setColor(pellet.getColor());
			 g.fillOval(10,10,10,10);
		}
	}

	public void drawMap(Graphics g) {
		Map map = game.getMap();
	}

	public void drawGhosts(Graphics g) {
		Ghost ghost1 = game.getGhost1();
		Ghost ghost2 = game.getGhost2();
		Ghost ghost3 = game.getGhost3();
	}

	public void drawPacMan(Graphics g) {
		PacMan pacMan = game.getPacman();
	}

}
