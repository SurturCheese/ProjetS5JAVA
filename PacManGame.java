package projetS5;

import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;

public class PacManGame {

	private PacMan pacman;
	private Ghost ghost1;
	private Ghost ghost2;
	private Ghost ghost3;
	private Ghost ghost4;
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
		map = new Map(Map.DEFAULT);
		pacman = new PacMan(map.getSpawnPacmanX(), map.getSpawnPacmanY(), this);
		ghost1 = new Ghost(Color.RED, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
		ghost2 = new Ghost(Color.WHITE, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
		ghost3 = new Ghost(Color.ORANGE, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
		ghost4 = new Ghost(Color.CYAN, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
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

	public Ghost getGhost1() {
		return ghost1;
	}

	public Ghost getGhost2() {
		return ghost2;
	}

	public Ghost getGhost3() {
		return ghost3;
	}

	public Ghost getGhost4() {
		return ghost4;
	}

	public void moveGhost() {
		ghost1.move();
		ghost2.move();
		ghost3.move();
		ghost4.move();
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

	public void swapMap() {
		map.swapMap();
		pacman = new PacMan(map.getSpawnPacmanX(), map.getSpawnPacmanY(), this);
		ghost1 = new Ghost(Color.RED, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
		ghost2 = new Ghost(Color.WHITE, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
		ghost3 = new Ghost(Color.ORANGE, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
		ghost4 = new Ghost(Color.CYAN, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
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
		int[][] temp = map.getMap();
		return temp[posX / PacManView.TILESIZE][posY / PacManView.TILESIZE - 1];
	}

	public int checkerSouth(int posX, int posY) {
		int[][] temp = map.getMap();
		return temp[posX / PacManView.TILESIZE][posY / PacManView.TILESIZE + 1];
	}

	public int checkerEast(int posX, int posY) {
		int[][] temp = map.getMap();
		return temp[posX / PacManView.TILESIZE + 1][posY / PacManView.TILESIZE];
	}

	public int checkerWest(int posX, int posY) {
		int[][] temp = map.getMap();
		return temp[posX / PacManView.TILESIZE - 1][posY / PacManView.TILESIZE];
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
			score += 300;
			pacman.invisible();
			powerTime = 30;
			deletePellet(posX / PacManView.TILESIZE, posY / PacManView.TILESIZE);
			break;
		case 4:
			/* orange pellet */
			score += 500;
			pacman.superpacman();
			ghost1.scared();
			ghost2.scared();
			ghost3.scared();
			ghost4.scared();
			powerTime = 20;
			deletePellet(posX / PacManView.TILESIZE, posY / PacManView.TILESIZE);
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
					pacman.tp(26, 14);
				} else {
					pacman.tp(1, 14);
				}
			}
			if (map.getType().equals(Map.GOOGLE)) {
				if ((pacman.getPosX() * PacManView.TILESIZE) == 0) {
					pacman.tp(56, 8);
				} else {
					pacman.tp(1, 8);
				}
				break;
			}
		}
	}

	public void checkGhostContact() {
		if (!(pacman.getState().equals(PacMan.INVISIBLE))) {
			int ghost1PosX = ghost1.getPosX() / PacManView.TILESIZE;
			int ghost1PosY = ghost1.getPosY() / PacManView.TILESIZE;
			int ghost2PosX = ghost2.getPosX() / PacManView.TILESIZE;
			int ghost2PosY = ghost2.getPosY() / PacManView.TILESIZE;
			int ghost3PosX = ghost3.getPosX() / PacManView.TILESIZE;
			int ghost3PosY = ghost3.getPosY() / PacManView.TILESIZE;
			int ghost4PosX = ghost4.getPosX() / PacManView.TILESIZE;
			int ghost4PosY = ghost4.getPosY() / PacManView.TILESIZE;
			int pacmanPosX = pacman.getPosX() / PacManView.TILESIZE;
			int pacmanPosY = pacman.getPosY() / PacManView.TILESIZE;
			boolean damage = false;
			if ((pacmanPosX == ghost1PosX && pacmanPosY == ghost1PosY)
					|| (pacmanPosX == ghost1PosX && pacmanPosY - 1 == ghost1PosY)
					|| (pacmanPosX == ghost1PosX && pacmanPosY + 1 == ghost1PosY)
					|| (pacmanPosX - 1 == ghost1PosX && pacmanPosY == ghost1PosY)
					|| (pacmanPosX + 1 == ghost1PosX && pacmanPosY == ghost1PosY)) {
				if (pacman.getState().equals(PacMan.SUPERPACMAN)) {
					ghost1.setPosX(map.getSpawnGhostX() * PacManView.TILESIZE);
					ghost1.setPosY(map.getSpawnGhostY() * PacManView.TILESIZE);
				} else
					damage = true;
			} else if ((pacmanPosX == ghost2PosX && pacmanPosY == ghost2PosY)
					|| (pacmanPosX == ghost2PosX && pacmanPosY - 1 == ghost2PosY)
					|| (pacmanPosX == ghost2PosX && pacmanPosY + 1 == ghost2PosY)
					|| (pacmanPosX - 1 == ghost2PosX && pacmanPosY == ghost2PosY)
					|| (pacmanPosX + 1 == ghost2PosX && pacmanPosY == ghost2PosY)) {
				if (pacman.getState().equals(PacMan.SUPERPACMAN)) {
					ghost2.setPosX(map.getSpawnGhostX() * PacManView.TILESIZE);
					ghost2.setPosY(map.getSpawnGhostY() * PacManView.TILESIZE);
				} else
					damage = true;
			} else if ((pacmanPosX == ghost3PosX && pacmanPosY == ghost3PosY)
					|| (pacmanPosX == ghost3PosX && pacmanPosY - 1 == ghost3PosY)
					|| (pacmanPosX == ghost3PosX && pacmanPosY + 1 == ghost3PosY)
					|| (pacmanPosX - 1 == ghost3PosX && pacmanPosY == ghost3PosY)
					|| (pacmanPosX + 1 == ghost3PosX && pacmanPosY == ghost3PosY)) {
				if (pacman.getState().equals(PacMan.SUPERPACMAN)) {
					ghost3.setPosX(map.getSpawnGhostX() * PacManView.TILESIZE);
					ghost3.setPosY(map.getSpawnGhostY() * PacManView.TILESIZE);
				} else
					damage = true;
			} else if ((pacmanPosX == ghost4PosX && pacmanPosY == ghost4PosY)
					|| (pacmanPosX == ghost4PosX && pacmanPosY - 1 == ghost4PosY)
					|| (pacmanPosX == ghost4PosX && pacmanPosY + 1 == ghost4PosY)
					|| (pacmanPosX - 1 == ghost4PosX && pacmanPosY == ghost4PosY)
					|| (pacmanPosX + 1 == ghost4PosX && pacmanPosY == ghost4PosY)) {
				if (pacman.getState().equals(PacMan.SUPERPACMAN)) {
					ghost4.setPosX(map.getSpawnGhostX() * PacManView.TILESIZE);
					ghost4.setPosY(map.getSpawnGhostY() * PacManView.TILESIZE);
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
			if (pellet.getPosX() == posX && pellet.getPosY() == posY) {
				it.remove();
			}
		}
	}

	public boolean existPellet(int posX, int posY) {
		for (Iterator<Pellet> it = listPellet.iterator(); it.hasNext();) {
			Pellet pellet = it.next();
			if (pellet.getPosX() == posX && pellet.getPosY() == posY) {
				return true;
			}
		}
		return false;
	}

	public int getPowerTime() {
		return powerTime;
	}

	public void downPowerTime(int powerTime) {
		this.powerTime = powerTime--;
	}

}
