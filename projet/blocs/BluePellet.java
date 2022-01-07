package projet.blocs;

import java.awt.Color;

import projet.PacManGame;

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
