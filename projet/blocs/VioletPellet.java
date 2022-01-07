package projet.blocs;

import java.awt.Color;

import projet.PacManGame;

public class VioletPellet extends Pellet {

    public VioletPellet(int posX, int posY, PacManGame game) {
        super(posX, posY, game);
        this.color = Color.MAGENTA;
    }
    
    /**
	 * Methode appelee quand le sujet performe une action
	 */
    @Override
    public void action() {
        game.addPoints(300);
        game.getPacman().setState(new projet.entities.pacmanstate.InvisibleState(game, game.getPacman()));
        game.setPowerTime(40);
    }

}
