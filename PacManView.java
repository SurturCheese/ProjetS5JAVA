package projetS5;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
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
		boxSize = new Dimension(TILESIZE * map.getLongueur(), TILESIZE * map.getHauteur());
		addKeyListener(new KeyAdapter() {
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
				}
			}
		});
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

	private void drawPellets(Graphics g) {
		for (Pellet pellet : game.getListPellet()) {
			g.setColor(pellet.getColor());
			g.fillOval((pellet.getPosX() * TILESIZE) + (TILESIZE / 3), (pellet.getPosY() * TILESIZE) + (TILESIZE / 3),
					TILESIZE / 3, TILESIZE / 3);
		}
	}

	private void drawMap(Graphics g) {
		int[][] map = game.getMap().getMap();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1) {
					g.setColor(Color.GRAY);
					g.fillRect(i * TILESIZE, j * TILESIZE, TILESIZE, TILESIZE);
				}
			}
		}
	}

	private void drawGhosts(Graphics g) {
		for (Ghost ghost : game.getGhost()) {
			g.setColor(ghost.getColor());
			g.fillOval(ghost.getPosX(), ghost.getPosY(), TILESIZE, TILESIZE);
		}
	}

	private void drawPacMan(Graphics g) {
		PacMan pacMan = game.getPacman();
		g.setColor(pacMan.getColor());
		g.fillOval(pacMan.getPosX(), pacMan.getPosY(), TILESIZE, TILESIZE);
	}

	public void swapMap() {
		Map map = game.getMap();
		boxSize = new Dimension(TILESIZE * map.getLongueur(), TILESIZE * map.getHauteur());
		SwingUtilities.getWindowAncestor(this).pack();
	}

}
