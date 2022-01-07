package projet;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

import projet.blocs.BluePellet;
import projet.blocs.Element;
import projet.blocs.GreenPellet;
import projet.blocs.Map;
import projet.blocs.OrangePellet;
import projet.blocs.Pellet;
import projet.blocs.TeleportPoint;
import projet.blocs.VioletPellet;
import projet.entities.Ghost;
import projet.entities.PacMan;

/**
 * Classe qui a pour rôle de mettre en place et connecter les differents elements de jeu pour son fonctionnemment 
 * 
 */
public class PacManGame {

	private PacMan pacman;
	private PacManView view;
	private ArrayList<Ghost> listGhost;
	private ArrayList<Pellet> listPellet;
	private ArrayList<Element> listElement;
	private Map map;
	private int score = 0;
	private int lives = 3;
	private boolean bonusLifeGiven = false;
	private boolean mapChanged = false;
	private int powerTime;

	public PacManGame() {
		map = new Map(Map.DEFAULT);
		setGame();
	}

	public void setView(PacManView view) {
		this.view = view;
	}

	/**
	 * Met en place les parametres du jeu
	 */
	public void setGame() {
		pacman = new PacMan(map.getSpawnPacmanX(), map.getSpawnPacmanY());
		pacman.setState(new projet.entities.pacmanstate.NormalState(this, pacman));
		listGhost = new ArrayList<>();
		listGhost.add(new Ghost(new Color(252, 37, 2), map.getSpawnGhostX(), map.getSpawnGhostY()));
		listGhost.add(new Ghost(new Color(249, 163, 0), map.getSpawnGhostX(), map.getSpawnGhostY()));
		listGhost.add(new Ghost(new Color(254, 179, 177), map.getSpawnGhostX(), map.getSpawnGhostY()));
		listGhost.add(new Ghost(new Color(1, 221, 225), map.getSpawnGhostX(), map.getSpawnGhostY()));
		for (Ghost ghost : listGhost) {
			ghost.setState(new projet.entities.ghoststate.NormalState(this, ghost));
		}
		listPellet = new ArrayList<>();
		listElement = new ArrayList<>();

		for (int i = 0; i < map.getMap().length; i++) {
			for (int j = 0; j < map.getMap()[i].length; j++) {
				switch (map.getMap()[i][j]) {
					case 2:
						listPellet.add(new BluePellet(i, j, this));
						break;
					case 3:
						listPellet.add(new VioletPellet(i, j, this));
						break;
					case 4:
						listPellet.add(new OrangePellet(i, j, this));
						break;
					case 5:
						listPellet.add(new GreenPellet(i, j, this));
						break;
					case 8:
						listElement.add(new TeleportPoint(i, j, this));
						break;
					default:
						break;
				}
			}
		}
	}

	/**
	 * Correspond à un "tour" de jeu.
	 * C'est ici que se trouve le fonctionnemment du jeu et que toutes les actions
	 * des entitées sont déclenchées
	 */
	public void step() {
		pacman.action();
		for (Iterator<Pellet> it = listPellet.iterator(); it.hasNext();) {
			Pellet pellet = it.next();
			if (pacman.getPosX() == pellet.getPosX() && pacman.getPosY() == pellet.getPosY()) {
				pellet.action();
				it.remove();
			}
		}
		for (Ghost ghost : listGhost)
			ghost.action();
		for (Element element : listElement)
			element.action();
		if (score >= 5000 && !bonusLifeGiven) {
			lives++;
			bonusLifeGiven = true;
		}
		if (powerTime > 0)
			powerTime--;
		if (powerTime == 0) {
			pacman.setState(new projet.entities.pacmanstate.NormalState(this, pacman));
			for (Ghost ghost : listGhost)
				ghost.setState(new projet.entities.ghoststate.NormalState(this, ghost));
		}
		if (lives == 0) {
			JOptionPane.showMessageDialog(null, "Perdu! (>_<) Score : " + getScore());
			System.exit(0);
		} else if (listPellet.isEmpty()) {
			view.repaint();
			JOptionPane.showMessageDialog(null, "Gagné! (^-^) Score : " + getScore());
			System.exit(0);
		}
	}

	/**
	 * Verifie ce qu'il y a sur la map sur la case au dessus
	 * 
	 * @param posX position sur l'axe x
	 * @param posY position sur l'axe y
	 * @return l'information stockee sur la map pour la position donnee
	 */
	public int checkerUp(int posX, int posY) {
		return map.getMap()[posX][posY - 1];
	}

	/**
	 * Verifie ce qu'il y a sur la map sur la case en dessous
	 * 
	 * @param posX position sur l'axe x
	 * @param posY position sur l'axe y
	 * @return l'information stockee sur la map pour la position donnee
	 */
	public int checkerDown(int posX, int posY) {
		return map.getMap()[posX][posY + 1];
	}

	/**
	 * Verifie ce qu'il y a sur la map sur la case a droite
	 * 
	 * @param posX position sur l'axe x
	 * @param posY position sur l'axe y
	 * @return l'information stockee sur la map pour la position donnee
	 */
	public int checkerRight(int posX, int posY) {
		return map.getMap()[posX + 1][posY];
	}

	/**
	 * Verifie ce qu'il y a sur la map sur la case a gauche
	 * 
	 * @param posX position sur l'axe x
	 * @param posY position sur l'axe y
	 * @return l'information stocke sur la map pour la position donnee
	 */

	public int checkerLeft(int posX, int posY) {
		return map.getMap()[posX - 1][posY];
	}

	public void addPoints(int nb) {
		score += nb;
	}

	public boolean getMapChanged() {
		return mapChanged;
	}

	public void setMapChanged() {
		mapChanged = true;
	}

	public PacManView getView() {
		return view;
	}

	public void setPowerTime(int nb) {
		powerTime = nb;
	}

	public void subLives() {
		lives--;
	}

	public PacMan getPacman() {
		return pacman;
	}

	public List<Ghost> getGhost() {
		return listGhost;
	}

	public List<Pellet> getListPellet() {
		return listPellet;
	}

	public Map getMap() {
		return map;
	}

	public String getScore() {
		return String.valueOf(score);
	}

	public int getLives() {
		return lives;
	}

}
