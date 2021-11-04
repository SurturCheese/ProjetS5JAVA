package projetS5;

import java.util.ArrayList;

public class PacManGame {
	private PacMan pacman;
	private Ghost ghost1;
	private Ghost ghost2;
	private Ghost ghost3;
	private ArrayList<Pellet> listPellet;

	public PacManGame() {

		pacman = new PacMan();
		ghost1 = new Ghost();
		ghost2 = new Ghost();
		ghost3 = new Ghost();
		listPellet = new ArrayList<>();
	}

}
