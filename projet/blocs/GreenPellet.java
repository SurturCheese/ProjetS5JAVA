package projet.blocs;

import java.awt.Color;

import projet.PacManGame;

public class GreenPellet extends Pellet {

    public GreenPellet(int posX, int posY, PacManGame game) {
        super(posX, posY,game);
        this.color = Color.GREEN;
    }

    /**
	 * Methode appelee quand le sujet performe une action
	 */
    @Override 
    public void action() {
        game.addPoints(1000);
        if (!game.getMapChanged()) {
            game.getMap().swapMap();
            game.getView().swapMap();
            game.setGame();
            game.setMapChanged();
        }
    }
}
