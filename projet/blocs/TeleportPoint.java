package projet.blocs;

import projet.PacManGame;
import projet.entities.Ghost;

public class TeleportPoint extends Element {

    public TeleportPoint(int posX, int posY, PacManGame game) {
        super(posX, posY, game);
    }
    

    @Override
    public void action() {
        if (game.getPacman().getPosX() == posX && game.getPacman().getPosY() == posY) {
            int[] position = game.getMap().getTeleportPoint(game.getPacman().getPosX(), game.getPacman().getPosY());
            game.getPacman().teleport(position[0], position[1]);
            game.getPacman().action();
        }
        for (Ghost ghost : game.getGhost()) {
            if (ghost.getPosX() == posX && ghost.getPosY() == posY) {
                int[] position = game.getMap().getTeleportPoint(ghost.getPosX(), ghost.getPosY());
                ghost.teleport(position[0], position[1]);
                ghost.action();
            }
        }
    }
}
