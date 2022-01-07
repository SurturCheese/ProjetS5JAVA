package projet.entities.pacmanstate;

import java.awt.Color;

import projet.PacManGame;
import projet.entities.PacMan;


public class InvisibleState extends PacmanState {

    public InvisibleState(PacManGame context, PacMan pacman) {
        super(context, pacman);
        pacman.setColor(new Color(255,255,210,255));
    }

    @Override
    public void action() {
        move();
    }

}
