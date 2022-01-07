package projet.Blocs;

import java.awt.Color;

import projet.PacManGame;

public class VioletPellet extends Pellet {

    public VioletPellet(int posX, int posY, PacManGame game) {
        super(posX, posY, game);
        this.color = Color.MAGENTA;
    }

    @Override
    public void action() {
        game.addPoints(300);
        game.getPacman().setState(new projet.Entities.pacmanstate.InvisibleState(game, game.getPacman()));
        game.setPowerTime(40);
    }

}
