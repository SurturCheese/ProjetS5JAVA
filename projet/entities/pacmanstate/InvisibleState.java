package projet.entities.pacmanstate;

import java.awt.Color;

import projet.PacManGame;
import projet.entities.PacMan;

/**
 * Representation de l'etat "invisible" de pacman dans le patron State
 */
public class InvisibleState extends PacmanState {

    public InvisibleState(PacManGame context, PacMan pacman) {
        super(context, pacman);
        pacman.setColor(new Color(255,255,210,255));
    }
    
    /**
	 * Methode appelee quand le sujet performe une action
	 */
    @Override
    public void action() {
        move();
    }

}
