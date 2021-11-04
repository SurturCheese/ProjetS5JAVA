package projetS5;

import java.util.ArrayList;

public class PacManGame {
	private PacMan pacman;
	private Ghost ghost1;
	private Ghost ghost2;
	private Ghost ghost3;
	private ArrayList<Pellet> listPellet;
	private Map map;

	public PacManGame() {

		pacman = new PacMan();
		ghost1 = new Ghost();
		ghost2 = new Ghost();
		ghost3 = new Ghost();
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

	public ArrayList<Pellet> getListPellet() {
		return listPellet;
	}

	public Map getMap() {
		return map;
	}

}
