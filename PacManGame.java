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
		pacman = new PacMan();
		ghost1 = new Ghost(Color.RED);
		ghost2 = new Ghost(Color.WHITE);
		ghost3 = new Ghost(Color.ORANGE);
		ghost4 = new Ghost(Color.BLUE);
		listPellet = new ArrayList<>();
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

	public void checkBonusLife() {
		if (score >= 5000 && !bonusLifeGiven ) {
			pacman.lifeUp();
		}
	}
	
}
