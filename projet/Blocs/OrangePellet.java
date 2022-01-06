package projet.Blocs;

import java.awt.Color;

import projet.PacManGame;
import projet.Entities.Ghost;

public class OrangePellet extends Pellet {

    public OrangePellet(int posX, int posY, PacManGame game) {
        super(posX, posY,game);
        this.color = Color.ORANGE;
    }

    @Override
    public void action() {
        game.addPoints(500);
        game.getPacman().setStateSuperpacman();
        game.setPowerTime(20);
        for (Ghost ghost : game.getGhost())
            ghost.setStateScared();
    }

}
