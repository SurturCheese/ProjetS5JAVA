package projet;

import projet.Entities.*;
import projet.Blocs.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;

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

	private void setGame() {
		pacman = new PacMan(map.getSpawnPacmanX(), map.getSpawnPacmanY(), this);
		listGhost = new ArrayList<>();
		listGhost.add(new Ghost(new Color(252, 37, 2), map.getSpawnGhostX(), map.getSpawnGhostY(), this));
		listGhost.add(new Ghost(new Color(249, 163, 0), map.getSpawnGhostX(), map.getSpawnGhostY(), this));
		listGhost.add(new Ghost(new Color(254, 179, 177), map.getSpawnGhostX(), map.getSpawnGhostY(), this));
		listGhost.add(new Ghost(new Color(1, 221, 225), map.getSpawnGhostX(), map.getSpawnGhostY(), this));
		listPellet = new ArrayList<>();
		listElement = new ArrayList<>();
		int[][] temp = map.getMap();
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				int valCase = temp[i][j];
				switch (valCase) {
					case 2:
						listPellet.add(new BluePellet(i, j));
						break;
					case 3:
						listPellet.add(new VioletPellet(i, j));
						break;
					case 4:
						listPellet.add(new OrangePellet(i, j));
						break;
					case 5:
						listPellet.add(new GreenPellet(i, j));
						break;
					case 8:
						listElement.add(new TeleportPoint(i, j));
						break;
					default:
						break;
				}
			}
		}
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

	public void step() {
		pacman.move();
		checkCase();
		for (Ghost ghost : listGhost)
			ghost.move();
		if (score >= 5000 && !bonusLifeGiven) {
			lives++;
			bonusLifeGiven = true;
		}
		if (powerTime > 0)
			powerTime--;
		if (powerTime == 0) {
			pacman.setStateNormal();
			for (Ghost ghost : listGhost)
				ghost.setStateNormal();
		}
		if (lives == 0)
			lose();
		checkGhostContact();
		if(listPellet.isEmpty()) 
			win();
	}

	public int checkerNorth(int posX, int posY) {
		return map.getMap()[posX][posY - 1];
	}

	public int checkerSouth(int posX, int posY) {
		return map.getMap()[posX][posY + 1];
	}

	public int checkerEast(int posX, int posY) {
		return map.getMap()[posX + 1][posY];
	}

	public int checkerWest(int posX, int posY) {
		return map.getMap()[posX - 1][posY];
	}

	private void checkCase() {
		for (Iterator<Pellet> it = listPellet.iterator(); it.hasNext();) {
			Pellet pellet = it.next();
			if (pacman.getPosX() == pellet.getPosX() && pacman.getPosY() == pellet.getPosY()) {
				score += pellet.getPoints();
				if (pellet instanceof VioletPellet) {
					pacman.setStateInvisible();
					powerTime = 40;
				} else if (pellet instanceof OrangePellet) {
					pacman.setStateSuperpacman();
					powerTime = 20;
					for (Ghost ghost : listGhost)
						ghost.setStateScared();
				} else if (pellet instanceof GreenPellet) {
					if(!mapChanged) {
						map.swapMap();
						view.swapMap();
						setGame();
						mapChanged = true;
					}
				}
				it.remove();
			}
		}
		for (Element element : listElement) {
			if (element instanceof TeleportPoint) {
				if (pacman.getPosX() == element.getPosX() && pacman.getPosY() == element.getPosY()) {
					int[] pos = map.getTeleportPoint(pacman.getPosX(), pacman.getPosY());
					pacman.teleport(pos[0], pos[1]);
					pacman.move();
				}
				for (Ghost ghost : listGhost) {
					if (ghost.getPosX() == element.getPosX() && ghost.getPosY() == element.getPosY()) {
						int[] pos = map.getTeleportPoint(ghost.getPosX(), ghost.getPosY());
						ghost.teleport(pos[0], pos[1]);
						ghost.move();
					}
				}
			}
		}
	}

	private void checkGhostContact() {
		if (!(pacman.getState().equals(PacMan.INVISIBLE))) {
			int pacmanPosX = pacman.getPosX();
			int pacmanPosY = pacman.getPosY();
			boolean damage = false;
			for (Ghost ghost : listGhost) {
				int ghostposX = ghost.getPosX();
				int ghostposY = ghost.getPosY();
				if ((pacmanPosX == ghostposX && pacmanPosY == ghostposY)
						|| (pacmanPosX == ghostposX && pacmanPosY - 1 == ghostposY && isOpposed(ghost))
						|| (pacmanPosX == ghostposX && pacmanPosY + 1 == ghostposY && isOpposed(ghost))
						|| (pacmanPosX - 1 == ghostposX && pacmanPosY == ghostposY && isOpposed(ghost))
						|| (pacmanPosX + 1 == ghostposX && pacmanPosY == ghostposY && isOpposed(ghost))) {
					if (pacman.getState().equals(PacMan.SUPERPACMAN))
						ghost.teleport(map.getSpawnGhostX(), map.getSpawnGhostY());
					else
						damage = true;
				}
			}
			if (damage) {
				lives--;
				pacman.teleport(map.getSpawnPacmanX(), map.getSpawnPacmanY());
				for (Ghost ghost : listGhost) {
					ghost.teleport(map.getSpawnGhostX(), map.getSpawnGhostY());
				}
			}
		}
	}

	private boolean isOpposed(Ghost ghost) {
		return (Objects.equals(pacman.getDirection(), projet.Entities.Character.UP) && Objects.equals(ghost.getDirection(), projet.Entities.Character.DOWN)) ||
				(Objects.equals(pacman.getDirection(), projet.Entities.Character.DOWN) && Objects.equals(ghost.getDirection(), projet.Entities.Character.UP)) ||
				(Objects.equals(pacman.getDirection(), projet.Entities.Character.RIGHT) && Objects.equals(ghost.getDirection(), projet.Entities.Character.LEFT)) ||
				(Objects.equals(pacman.getDirection(), projet.Entities.Character.LEFT) && Objects.equals(ghost.getDirection(), projet.Entities.Character.RIGHT));
	}

	private void lose() {
		pacman.setDead();
		JOptionPane.showMessageDialog(null, "Perdu! (>_<) Score : " + getScore());
		System.exit(0);
	}

	private void win() {
		JOptionPane.showMessageDialog(null, "Gagné! (^-^) Score : " + getScore());
		System.exit(0);
	}

}