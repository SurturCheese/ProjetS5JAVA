package projet.blocs;

import projet.PacManGame;

/**
 * Super classe abstraite pour factoriser la declaration des pacgommes
 */
public abstract class Pellet extends Element {

    protected Pellet(int posX, int posY, PacManGame game) {
        super(posX, posY, game);

    }

}
