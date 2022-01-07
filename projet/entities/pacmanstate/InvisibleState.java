package projet.entities.pacmanstate;

import java.awt.Color;

import projet.PacManGame;
import projet.entities.PacMan;


public class InvisibleState extends PacmanState {

    public InvisibleState(PacManGame game, PacMan pacman) {
        super(game, pacman);
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
