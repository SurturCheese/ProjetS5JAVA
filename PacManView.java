package projetS5;

import java.awt.Graphics;
import javax.swing.JComponent;
import java.awt.Color;

public class PacManView extends JComponent {

	private static final long serialVersionUID = 1L;
	private final PacManGame game;
	private int WIDTH;
	private int HEIGHT;
	private int TILESIZE;

	public PacManView(PacManGame game) {
		super();
		this.game = game;
		Map map = game.getMap();
		TILESIZE = 10;
		WIDTH = TILESIZE * map.getLongueur()*2;
		HEIGHT = TILESIZE * map.getHauteur()*2;
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
			g.fillOval(pellet.getPosX() * TILESIZE, pellet.getPosY() * TILESIZE, TILESIZE, TILESIZE);
		}
	}

	public void drawMap(Graphics g) {
		Map map = game.getMap();
		int[][] bloc = map.getMap();
		for (int i = 0; i < bloc.length; i++) {
			for (int j = 0; j < bloc[i].length; j++) {
				if (bloc[i][j] == 1) {
					g.setColor(Color.GRAY);
					g.fillRect(j * TILESIZE, i * TILESIZE, TILESIZE, TILESIZE);
				}
			}
		}
	}

	public void drawGhosts(Graphics g) {
		Ghost temp = game.getGhost1();
		g.setColor(temp.getColor());
		g.fillOval(temp.getPosX(), temp.getPosY(), TILESIZE, TILESIZE);

		temp = game.getGhost2();
		g.setColor(temp.getColor());
		g.fillOval(temp.getPosX(), temp.getPosY(), TILESIZE, TILESIZE);

		temp = game.getGhost3();
		g.setColor(temp.getColor());
		g.fillOval(temp.getPosX(), temp.getPosY(), TILESIZE, TILESIZE);

		temp = game.getGhost4();
		g.setColor(temp.getColor());
		g.fillOval(temp.getPosX(), temp.getPosY(), TILESIZE, TILESIZE);
	}

	public void drawPacMan(Graphics g) {
		PacMan pacMan = game.getPacman();
		g.setColor(pacMan.getColor());
		g.fillOval(pacMan.getPosX(), pacMan.getPosY(), TILESIZE, TILESIZE);
	}

}
