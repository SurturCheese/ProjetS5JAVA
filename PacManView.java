package projetS5;

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class PacManView extends JComponent {

	private static final long serialVersionUID = 1L;
	private final PacManGame game;
	public static final int TILESIZE = 30;
	private Dimension boxSize;

	public PacManView(PacManGame game) {
		super();
		this.game = game;
		Map map = game.getMap();
		if (map.getType().equals(Map.DEFAULT)) {
			boxSize = new Dimension(TILESIZE * map.getLongueur(), TILESIZE * map.getHauteur());
		}
		if (map.getType().equals(Map.GOOGLE)) {
			boxSize = new Dimension(TILESIZE * map.getLongueur(), TILESIZE * map.getHauteur());
		}
		addKeyListener(new PacManKeyListener(game, this));
		setFocusable(true);
		requestFocusInWindow();
		game.setView(this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawMap(g);
		drawPellets(g);
		drawGhosts(g);
		drawPacMan(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("pacManFont", Font.BOLD, TILESIZE));
		g.drawString(game.getScore(), 1, 30);
		g.drawString("Lives : " + String.valueOf(game.getLives()), this.getWidth() / 2 - TILESIZE * 2, TILESIZE);
	}

	@Override
	public Dimension getPreferredSize() {
		return boxSize;
	}

	public void drawPellets(Graphics g) {
		for (Pellet pellet : game.getListPellet()) {
			g.setColor(pellet.getColor());
			g.fillOval((pellet.getPosX() * TILESIZE) + (TILESIZE / 3), (pellet.getPosY() * TILESIZE) + (TILESIZE / 3),
					TILESIZE / 3, TILESIZE / 3);
		}
	}

	public void drawMap(Graphics g) {
		Map map = game.getMap();
		int[][] bloc = map.getMap();
		for (int i = 0; i < bloc.length; i++) {
			for (int j = 0; j < bloc[i].length; j++) {
				if (bloc[i][j] == 1) {
					g.setColor(Color.GRAY);
					g.fillRect(i * TILESIZE, j * TILESIZE, TILESIZE, TILESIZE);
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

	public void swapMap() {
		Map map = game.getMap();
		if (map.getType().equals(Map.DEFAULT)) {
			boxSize = new Dimension(TILESIZE * map.getLongueur(), TILESIZE * map.getHauteur());
		}
		if (map.getType().equals(Map.GOOGLE)) {
			boxSize = new Dimension(TILESIZE * map.getLongueur(), TILESIZE * map.getHauteur());
		}
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
		frame.pack();
	}

}
