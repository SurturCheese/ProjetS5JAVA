package projetS5;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class PacManGame {

	private PacMan pacman;
	private Ghost[] listGhost;
	private ArrayList<Pellet> listPellet;
	private Map map;
	private int score;
	private int lives;
	private boolean bonusLifeGiven;
	private PacManView view;
	private int powerTime;

	public PacManGame() {
		lives = 3;
		bonusLifeGiven = false;
		score = 0;
		listPellet = new ArrayList<>();
		listGhost = new Ghost[4];
		map = new Map(Map.DEFAULT);
		pacman = new PacMan(map.getSpawnPacmanX(), map.getSpawnPacmanY(), this);
		listGhost[0] = new Ghost(Color.RED, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
		listGhost[1] = new Ghost(Color.ORANGE, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
		listGhost[2] = new Ghost(Color.MAGENTA, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
		listGhost[3] = new Ghost(Color.CYAN, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
		int[][] temp = map.getMap();
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				int valCase = temp[i][j];
				switch (valCase) {
				case 2:
					listPellet.add(new Pellet(Color.BLUE, i, j));
					break;
				case 3:
					listPellet.add(new Pellet(Color.MAGENTA, i, j));
					break;
				case 4:
					listPellet.add(new Pellet(Color.ORANGE, i, j));
					break;
				case 5:
					listPellet.add(new Pellet(Color.GREEN, i, j));
					break;
				}
			}
		}

	}

	public PacMan getPacman() {
		return pacman;
	}

	public Ghost[] getGhost() {
		return listGhost;
	}

	public void moveGhost() {
		for (Ghost ghost : listGhost)
			ghost.move();
	}

	public ArrayList<Pellet> getListPellet() {
		return listPellet;
	}

	public Map getMap() {
		return map;
	}

	public String getScore() {
		return String.valueOf(score);
	}

	public void checkBonusLive() {
		if (score >= 5000 && !bonusLifeGiven) {
			lives++;
			bonusLifeGiven = true;
		}
	}

	public void lifeDown() {
		lives = lives - 1;
	}

	public int getLives() {
		return lives;
	}

	public void setView(PacManView view) {
		this.view = view;
	}

	public void step() {
		pacman.move();
		moveGhost();
		checkCase(pacman.getPosX(), pacman.getPosY());
		checkBonusLive();
		if (getPowerTime() > 0)
			downPowerTime();
		if (getPowerTime() == 0) {
			pacman.setStateNormal();
			for (Ghost ghost : listGhost)
				ghost.setStateNormal();
		}
		if (getLives() == 0)
			lose();
		checkGhostContact();
	}

	public void swapMap() {
		map.swapMap();
		pacman = new PacMan(map.getSpawnPacmanX(), map.getSpawnPacmanY(), this);
		listGhost[0] = new Ghost(Color.RED, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
		listGhost[1] = new Ghost(Color.WHITE, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
		listGhost[2] = new Ghost(Color.ORANGE, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
		listGhost[3] = new Ghost(Color.CYAN, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
		listPellet = new ArrayList<>();
		int[][] temp = map.getMap();
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				int valCase = temp[i][j];
				switch (valCase) {
				case 2:
					listPellet.add(new Pellet(Color.BLUE, i, j));
					break;
				case 3:
					listPellet.add(new Pellet(Color.MAGENTA, i, j));
					break;
				case 4:
					listPellet.add(new Pellet(Color.ORANGE, i, j));
					break;
				case 5:
					listPellet.add(new Pellet(Color.GREEN, i, j));
					break;
				}
			}
		}
	}

	public int checkerNorth(int posX, int posY) {
		return map.getMap()[posX / PacManView.TILESIZE][posY / PacManView.TILESIZE - 1];
	}

	public int checkerSouth(int posX, int posY) {
		return map.getMap()[posX / PacManView.TILESIZE][posY / PacManView.TILESIZE + 1];
	}

	public int checkerEast(int posX, int posY) {
		return map.getMap()[posX / PacManView.TILESIZE + 1][posY / PacManView.TILESIZE];
	}

	public int checkerWest(int posX, int posY) {
		return map.getMap()[posX / PacManView.TILESIZE - 1][posY / PacManView.TILESIZE];
	}

	public void checkCase(int posX, int posY) {
		int[][] temp = map.getMap();
		switch (temp[posX / PacManView.TILESIZE][posY / PacManView.TILESIZE]) {
		case 2:
			/* blue pellet */
			if (existPellet(posX / PacManView.TILESIZE, posY / PacManView.TILESIZE)) {
				score += 100;
				deletePellet(posX / PacManView.TILESIZE, posY / PacManView.TILESIZE);
			}

			break;
		case 3:
			/* magenta pellet */
			if (existPellet(posX / PacManView.TILESIZE, posY / PacManView.TILESIZE)) {
				score += 300;
				pacman.setStateInvisible();
				powerTime = 20;
				deletePellet(posX / PacManView.TILESIZE, posY / PacManView.TILESIZE);
			}
			break;
		case 4:
			/* orange pellet */
			if (existPellet(posX / PacManView.TILESIZE, posY / PacManView.TILESIZE)) {
				score += 500;
				pacman.setStateSuperpacman();
				for (Ghost ghost : listGhost)
					ghost.setStateScared();
				powerTime = 15;
				deletePellet(posX / PacManView.TILESIZE, posY / PacManView.TILESIZE);
			}
			break;
		case 5:
			/* green pellet */
			score += 1000;
			deletePellet(posX / PacManView.TILESIZE, posY / PacManView.TILESIZE);
			swapMap();
			view.swapMap();
			break;
		case 8:
			/* wrap around */
			if (map.getType().equals(Map.DEFAULT)) {
				if (pacman.getPosX() * PacManView.TILESIZE == 0) {
					pacman.teleport(26, 14);
				} else {
					pacman.teleport(1, 14);
				}
			}
			if (map.getType().equals(Map.GOOGLE)) {
				if ((pacman.getPosX() * PacManView.TILESIZE) == 0) {
					pacman.teleport(56, 8);
				} else {
					pacman.teleport(1, 8);
				}
				break;
			}
		}

	}

	public void checkGhostContact() {
		if (!(pacman.getState().equals(PacMan.INVISIBLE))) {
			int ghost1PosX = listGhost[0].getPosX() / PacManView.TILESIZE;
			int ghost1PosY = listGhost[0].getPosY() / PacManView.TILESIZE;
			int ghost2PosX = listGhost[1].getPosX() / PacManView.TILESIZE;
			int ghost2PosY = listGhost[1].getPosY() / PacManView.TILESIZE;
			int ghost3PosX = listGhost[2].getPosX() / PacManView.TILESIZE;
			int ghost3PosY = listGhost[2].getPosY() / PacManView.TILESIZE;
			int ghost4PosX = listGhost[3].getPosX() / PacManView.TILESIZE;
			int ghost4PosY = listGhost[3].getPosY() / PacManView.TILESIZE;
			int pacmanPosX = pacman.getPosX() / PacManView.TILESIZE;
			int pacmanPosY = pacman.getPosY() / PacManView.TILESIZE;
			boolean damage = false;
			if ((pacmanPosX == ghost1PosX && pacmanPosY == ghost1PosY)
					|| (pacmanPosX == ghost1PosX && pacmanPosY - 1 == ghost1PosY)
					|| (pacmanPosX == ghost1PosX && pacmanPosY + 1 == ghost1PosY)
					|| (pacmanPosX - 1 == ghost1PosX && pacmanPosY == ghost1PosY)
					|| (pacmanPosX + 1 == ghost1PosX && pacmanPosY == ghost1PosY)) {
				if (pacman.getState().equals(PacMan.SUPERPACMAN)) {
					listGhost[0].setPosX(map.getSpawnGhostX() * PacManView.TILESIZE);
					listGhost[0].setPosY(map.getSpawnGhostY() * PacManView.TILESIZE);
				} else
					damage = true;
			} else if ((pacmanPosX == ghost2PosX && pacmanPosY == ghost2PosY)
					|| (pacmanPosX == ghost2PosX && pacmanPosY - 1 == ghost2PosY)
					|| (pacmanPosX == ghost2PosX && pacmanPosY + 1 == ghost2PosY)
					|| (pacmanPosX - 1 == ghost2PosX && pacmanPosY == ghost2PosY)
					|| (pacmanPosX + 1 == ghost2PosX && pacmanPosY == ghost2PosY)) {
				if (pacman.getState().equals(PacMan.SUPERPACMAN)) {
					listGhost[1].setPosX(map.getSpawnGhostX() * PacManView.TILESIZE);
					listGhost[1].setPosY(map.getSpawnGhostY() * PacManView.TILESIZE);
				} else
					damage = true;
			} else if ((pacmanPosX == ghost3PosX && pacmanPosY == ghost3PosY)
					|| (pacmanPosX == ghost3PosX && pacmanPosY - 1 == ghost3PosY)
					|| (pacmanPosX == ghost3PosX && pacmanPosY + 1 == ghost3PosY)
					|| (pacmanPosX - 1 == ghost3PosX && pacmanPosY == ghost3PosY)
					|| (pacmanPosX + 1 == ghost3PosX && pacmanPosY == ghost3PosY)) {
				if (pacman.getState().equals(PacMan.SUPERPACMAN)) {
					listGhost[2].setPosX(map.getSpawnGhostX() * PacManView.TILESIZE);
					listGhost[2].setPosY(map.getSpawnGhostY() * PacManView.TILESIZE);
				} else
					damage = true;
			} else if ((pacmanPosX == ghost4PosX && pacmanPosY == ghost4PosY)
					|| (pacmanPosX == ghost4PosX && pacmanPosY - 1 == ghost4PosY)
					|| (pacmanPosX == ghost4PosX && pacmanPosY + 1 == ghost4PosY)
					|| (pacmanPosX - 1 == ghost4PosX && pacmanPosY == ghost4PosY)
					|| (pacmanPosX + 1 == ghost4PosX && pacmanPosY == ghost4PosY)) {
				if (pacman.getState().equals(PacMan.SUPERPACMAN)) {
					listGhost[3].setPosX(map.getSpawnGhostX() * PacManView.TILESIZE);
					listGhost[3].setPosY(map.getSpawnGhostY() * PacManView.TILESIZE);
				} else
					damage = true;
			}
			if (damage) {
				lifeDown();
				pacman.setPosX(map.getSpawnPacmanX() * PacManView.TILESIZE);
				pacman.setPosY(map.getSpawnPacmanY() * PacManView.TILESIZE);
			}
		}
	}

	public void deletePellet(int posX, int posY) {
		for (Iterator<Pellet> it = listPellet.iterator(); it.hasNext();) {
			Pellet pellet = it.next();
			if (pellet.getPosX() == posX && pellet.getPosY() == posY)
				it.remove();
		}
	}

	public boolean existPellet(int posX, int posY) {
		for (Pellet pellet : listPellet) {
			if (pellet.getPosX() == posX && pellet.getPosY() == posY)
				return true;
		}
		return false;
	}

	public int getPowerTime() {
		return powerTime;
	}

	public void downPowerTime() {
		powerTime--;
	}

	public void lose() {
		pacman.setDead();
		JOptionPane.showMessageDialog(null, "Perdu! (>_<) Score : " + getScore());
		System.exit(0);
	}
}
