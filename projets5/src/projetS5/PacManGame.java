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
	private int powerTime;
	public static final int TILESIZE = 30;

	public PacManGame() {
		lives = 3;
		bonusLifeGiven = false;
		score = 0;
		map = new Map(Map.DEFAULT);
		setGame();
	}


	private void setGame() {
		pacman = new PacMan(map.getSpawnPacmanX(), map.getSpawnPacmanY(), this);
		listGhost = new Ghost[4];
		listGhost[0] = new Ghost(Color.RED, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
		listGhost[1] = new Ghost(Color.ORANGE, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
		listGhost[2] = new Ghost(Color.MAGENTA, map.getSpawnGhostX(), map.getSpawnGhostY(), this);
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
	
	public PacMan getPacman() {
		return pacman;
	}

	public Ghost[] getGhost() {
		return listGhost;
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

	private void checkBonusLive() {
		if (score >= 5000 && !bonusLifeGiven) {
			lives++;
			bonusLifeGiven = true;
		}
	}

	public int getLives() {
		return lives;
	}

	public void step() {
		pacman.move();
		for (Ghost ghost : listGhost)
			ghost.move();
		checkCase(pacman.getPosX(), pacman.getPosY());
		checkBonusLive();
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
	}

	private void swapMap() {
		map.swapMap();
		setGame();
		}

	public int checkerNorth(int posX, int posY) {
		return map.getMap()[posX / TILESIZE][posY / TILESIZE - 1];
	}

	public int checkerSouth(int posX, int posY) {
		return map.getMap()[posX / TILESIZE][posY / TILESIZE + 1];
	}

	public int checkerEast(int posX, int posY) {
		return map.getMap()[posX / TILESIZE + 1][posY / TILESIZE];
	}

	public int checkerWest(int posX, int posY) {
		return map.getMap()[posX / TILESIZE - 1][posY / TILESIZE];
	}


//Fonction à refaire
	public void checkCase(int posX, int posY) {
		int[][] temp = map.getMap();
		switch (temp[posX / TILESIZE][posY / TILESIZE]) {
		case 2:
			/* blue pellet */
			if (existPellet(posX / TILESIZE, posY / TILESIZE)) {
				score += 100;
				deletePellet(posX / TILESIZE, posY / TILESIZE);
			}

			break;
		case 3:
			/* magenta pellet */
			if (existPellet(posX / TILESIZE, posY / TILESIZE)) {
				score += 300;
				pacman.setStateInvisible();
				powerTime = 20;
				deletePellet(posX / TILESIZE, posY / TILESIZE);
			}
			break;
		case 4:
			/* orange pellet */
			if (existPellet(posX / TILESIZE, posY / TILESIZE)) {
				score += 500;
				pacman.setStateSuperpacman();
				for (Ghost ghost : listGhost)
					ghost.setStateScared();
				powerTime = 15;
				deletePellet(posX / TILESIZE, posY / TILESIZE);
			}
			break;
		case 5:
			/* green pellet */
			score += 1000;
			deletePellet(posX / TILESIZE, posY / TILESIZE);
			swapMap();
			break;
		case 8:
			/* wrap around */
			if (map.getType().equals(Map.DEFAULT)) {
				if (pacman.getPosX() * TILESIZE == 0) {
					pacman.teleport(26, 14);
				} else {
					pacman.teleport(1, 14);
				}
			}
			if (map.getType().equals(Map.GOOGLE)) {
				if ((pacman.getPosX() * TILESIZE) == 0) {
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
			int pacmanPosX = pacman.getPosX() / TILESIZE;
			int pacmanPosY = pacman.getPosY() / TILESIZE;
			boolean damage = false;
			for(Ghost ghost : listGhost) {
				int ghostposX = ghost.getPosX() / TILESIZE;
				int ghostposY = ghost.getPosY() / TILESIZE;
				if ((pacmanPosX == ghostposX && pacmanPosY == ghostposY)
					|| (pacmanPosX == ghostposX && pacmanPosY - 1 == ghostposY)
					|| (pacmanPosX == ghostposX && pacmanPosY + 1 == ghostposY)
					|| (pacmanPosX - 1 == ghostposX && pacmanPosY == ghostposY)
					|| (pacmanPosX + 1 == ghostposX && pacmanPosY == ghostposY)) {
				if (pacman.getState().equals(PacMan.SUPERPACMAN)) {
					ghost.setPosX(map.getSpawnGhostX() * TILESIZE);
					ghost.setPosY(map.getSpawnGhostY() * TILESIZE);
				} else
					damage = true;
				}
				if (damage) {
				lives = lives--;
				pacman.setPosX(map.getSpawnPacmanX() * TILESIZE);
				pacman.setPosY(map.getSpawnPacmanY() * TILESIZE);
				}
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

	private void lose() {
		pacman.setDead();
		JOptionPane.showMessageDialog(null, "Perdu! (>_<) Score : " + getScore());
		System.exit(0);
	}
}