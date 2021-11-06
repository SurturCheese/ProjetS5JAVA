package projetS5;

import java.util.ArrayList;
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
	private boolean bonusLifeGiven;

	public PacManGame() {
		
		bonusLifeGiven = false;
		score = 0;
		listPellet = new ArrayList<>();
		map = new Map(Map.DEFAULT);
		pacman = new PacMan(map.getSpawnPacmanX(),map.getSpawnPacmanY());
		ghost1 = new Ghost(Color.RED,map.getSpawnGhostX(),map.getSpawnGhostY());
		ghost2 = new Ghost(Color.WHITE,map.getSpawnGhostX(),map.getSpawnGhostY());
		ghost3 = new Ghost(Color.ORANGE,map.getSpawnGhostX(),map.getSpawnGhostY());
		ghost4 = new Ghost(Color.BLUE,map.getSpawnGhostX(),map.getSpawnGhostY());
		int[][] temp = map.getMap();
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				int valCase = temp[i][j];
				switch (valCase) {
				case 2:
					listPellet.add(new Pellet(Color.BLUE,j,i) );
					break;
				case 3:
					listPellet.add(new Pellet(Color.MAGENTA,j,i) );
					break;
				case 4:
					listPellet.add(new Pellet(Color.ORANGE,j,i) );
					break;
				case 5: 
					listPellet.add(new Pellet(Color.GREEN,j,i) );
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

	public ArrayList<Pellet> getListPellet() {
		return listPellet;
	}

	public Map getMap() {
		return map;
	}
	
	public String getScore() {
		return String.valueOf(score);
	}

	public void checkBonusLife() {
		if (score >= 5000 && !bonusLifeGiven) {
			pacman.lifeUp();
		}
	}

}
