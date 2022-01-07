package projet.Entities.pacmanstate;

import java.awt.Color;

import projet.PacManGame;
import projet.Entities.PacMan;


public class InvisibleState extends PacmanState {

    public InvisibleState(PacManGame game, PacMan pacman) {
        super(game, pacman);
        pacman.setColor(new Color(255,255,210,255));
    }

    @Override
    public void action() {
        move();
    }

}