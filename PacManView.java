package projetS5;

import java.awt.Graphics;
import javax.swing.JComponent;

public class PacManView extends JComponent {

	private static final long serialVersionUID = 1L;
	private final PacManGame game;
	private int WIDTH = 462;
	private int HEIGHT = 462;

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
			g.fillOval(10, 10, 20, 20);
		}
	}

	public void drawMap(Graphics g) {
		Map map = game.getMap();
	}

	public void drawGhosts(Graphics g) {
		Ghost temp = game.getGhost1();
		g.setColor(temp.getColor());
		g.fillOval(temp.getPosX(), temp.getPosY(), 20, 20);
		
		temp = game.getGhost2();
		g.setColor(temp.getColor());
		g.fillOval(temp.getPosX(), temp.getPosY(), 20, 20);
		
		temp = game.getGhost3();
		g.setColor(temp.getColor());
		g.fillOval(temp.getPosX(), temp.getPosY(), 20, 20);
		
		temp = game.getGhost4();
		g.setColor(temp.getColor());
		g.fillOval(temp.getPosX(), temp.getPosY(), 20, 20);
	}

	public void drawPacMan(Graphics g) {
		PacMan pacMan = game.getPacman();
		g.setColor(pacMan.getColor());
		g.fillOval(pacMan.getPosX(), pacMan.getPosY(), 20, 20);
	}

}
