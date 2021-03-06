package projet.blocs;

import java.awt.Color;

import projet.PacManGame;
import projet.entities.Ghost;

/**
 * Representation du pacgomme orange avec ses actions
 * Herite de la super classe Pellet
 */
public class OrangePellet extends Pellet {

    public OrangePellet(int posX, int posY, PacManGame game) {
        super(posX, posY, game);
        this.color = Color.ORANGE;
    }

    /**
	 * Methode appelee quand le sujet performe une action
	 */
    @Override
    public void action() {
        game.addPoints(500);
        game.getPacman().setState(new projet.entities.pacmanstate.SuperPacmanState(game, game.getPacman()));
        game.setPowerTime(20);
        for (Ghost ghost : game.getGhost())
            ghost.setState(new projet.entities.ghoststate.ScaredState(game,ghost));
    }

}
