package projet.blocs;

import java.awt.Color;

import projet.PacManGame;

/**
 * Representation du pacgomme bleu avec ses actions
 * Herite de la super classe Pellet
 */
public class BluePellet extends Pellet {

    public BluePellet(int posX, int posY, PacManGame game) {
        super(posX, posY, game);
        this.color = Color.BLUE;
    }

    @Override
    public void action() {
        game.addPoints(100);
    }
}
