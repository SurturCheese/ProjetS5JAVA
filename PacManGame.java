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
	private int lives;
	private boolean bonusLifeGiven;
	
	public PacManGame() {
		lives = 3;
		bonusLifeGiven = false;
		score = 0;
		listPellet = new ArrayList<>();
		map = new Map(Map.GOOGLE);
		pacman = new PacMan(map.getSpawnPacmanX(),map.getSpawnPacmanY());
		ghost1 = new Ghost(Color.RED,map.getSpawnGhostX(),map.getSpawnGhostY(),this);
		ghost2 = new Ghost(Color.WHITE,map.getSpawnGhostX(),map.getSpawnGhostY(),this);
		ghost3 = new Ghost(Color.ORANGE,map.getSpawnGhostX(),map.getSpawnGhostY(),this);
		ghost4 = new Ghost(Color.CYAN,map.getSpawnGhostX(),map.getSpawnGhostY(),this);
		int[][] temp = map.getMap();
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				int valCase = temp[i][j];
				switch (valCase) {
				case 2:
					listPellet.add(new Pellet(Color.BLUE,i,j) );
					break;
				case 3:
					listPellet.add(new Pellet(Color.MAGENTA,i,j) );
					break;
				case 4:
					listPellet.add(new Pellet(Color.ORANGE,i,j) );
					break;
				case 5: 
					listPellet.add(new Pellet(Color.GREEN,i,j) );
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
		ghost1.moveRandom();
		ghost2.moveRandom();
		ghost3.moveRandom();
		ghost4.moveRandom();
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
		if (score >= 5000 && !bonusLifeGiven) 
			lives++;
	}

	public void lifeDown() {
		lives = lives - 1;
	}
	
	public int getLives() {
		return lives;
	}
	
	public void swapMap() {
		map.swapMap();
		pacman = new PacMan(map.getSpawnPacmanX(),map.getSpawnPacmanY());
		ghost1 = new Ghost(Color.RED,map.getSpawnGhostX(),map.getSpawnGhostY(),this);
		ghost2 = new Ghost(Color.WHITE,map.getSpawnGhostX(),map.getSpawnGhostY(),this);
		ghost3 = new Ghost(Color.ORANGE,map.getSpawnGhostX(),map.getSpawnGhostY(),this);
		ghost4 = new Ghost(Color.CYAN,map.getSpawnGhostX(),map.getSpawnGhostY(),this);
		listPellet = new ArrayList<>();
		int[][] temp = map.getMap();
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				int valCase = temp[i][j];
				switch (valCase) {
				case 2:
					listPellet.add(new Pellet(Color.BLUE,i,j) );
					break;
				case 3:
					listPellet.add(new Pellet(Color.MAGENTA,i,j) );
					break;
				case 4:
					listPellet.add(new Pellet(Color.ORANGE,i,j) );
					break;
				case 5: 
					listPellet.add(new Pellet(Color.GREEN,i,j) );
					break;
				}
			}
		}
	}
	
	public int checkerNorth(int posX, int posY) {
		int[][] temp = map.getMap();
		return temp[posX/PacManView.TILESIZE][posY/PacManView.TILESIZE - 1]; 
	}
	
	public int checkerSouth(int posX, int posY) {
		int[][] temp = map.getMap();
		return temp[posX/PacManView.TILESIZE][posY/PacManView.TILESIZE + 1]; 
	}
	
	public int checkerEast(int posX, int posY) {
		int[][] temp = map.getMap();
		return temp[posX/PacManView.TILESIZE + 1][posY/PacManView.TILESIZE ]; 
	}
	
	public int checkerWest(int posX, int posY) {
		int[][] temp = map.getMap();
		return temp[posX/PacManView.TILESIZE - 1][posY/PacManView.TILESIZE ]; 
	}

}
