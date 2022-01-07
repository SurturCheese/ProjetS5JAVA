package projet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import projet.blocs.GreenPellet;
import projet.blocs.OrangePellet;
import projet.blocs.Pellet;
import projet.blocs.VioletPellet;
import projet.entities.Ghost;
import projet.entities.PacMan;

public class PacManView extends JComponent {

	private static final long serialVersionUID = 1L;
	private PacManGame game;
	static final int TILESIZE = 30;

	public PacManView(PacManGame game) {
		super();
		this.game = game;
		setPreferredSize(new Dimension(TILESIZE * game.getMap().getLength(), TILESIZE * game.getMap().getHeight()));
	}

	/**
	 * Affichage du jeu
	 * @param g
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawMap(g);
		drawPellets(g);
		drawGhosts(g);
		drawPacMan(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("pacManFont", Font.BOLD, TILESIZE));
		g.drawString("Score : " + game.getScore(), 1, TILESIZE - 1);
		g.drawString("Lives : " + game.getLives(), this.getWidth() / 2 - TILESIZE * 2, TILESIZE - 1);
	}

	/**
	 * Affiche les pacgommes
	 * @param g
	 */
	private void drawPellets(Graphics g) {
		for (Pellet pellet : game.getListPellet()) {
			g.setColor(pellet.getColor());
			if (pellet instanceof VioletPellet || pellet instanceof GreenPellet || pellet instanceof OrangePellet) {
				g.fillOval((pellet.getPosX() * TILESIZE) + (TILESIZE / 4),
						(pellet.getPosY() * TILESIZE) + (TILESIZE / 4),
						TILESIZE / 2, TILESIZE / 2);
			} else
				g.fillOval((pellet.getPosX() * TILESIZE) + (TILESIZE / 3),
						(pellet.getPosY() * TILESIZE) + (TILESIZE / 3),
						TILESIZE / 3, TILESIZE / 3);
		}
	}

	/**
	 * Affiche la carte
	 * @param g 
	 */
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

	/**
	 * Affiche les fantomes
	 * @param g
	 */
	private void drawGhosts(Graphics g) {
		for (Ghost ghost : game.getGhost()) {
			g.setColor(ghost.getColor());
			g.fillOval(ghost.getPosX() * TILESIZE, ghost.getPosY() * TILESIZE, TILESIZE, TILESIZE);
		}
	}

	/**
	 * Affiche le pacman
	 * @param g 
	 */
	private void drawPacMan(Graphics g) {
		PacMan pacMan = game.getPacman();
		g.setColor(pacMan.getColor());
		g.fillOval(pacMan.getPosX() * TILESIZE, pacMan.getPosY() * TILESIZE, TILESIZE, TILESIZE);
	}

	/**
	 * Permet de rafraichir la fenêtre lors d'un changement de map de jeu
	 */
	public void swapMap() {
		setPreferredSize(new Dimension(TILESIZE * game.getMap().getLength(), TILESIZE * game.getMap().getHeight()));
		SwingUtilities.getWindowAncestor(this).pack();
	}
}
