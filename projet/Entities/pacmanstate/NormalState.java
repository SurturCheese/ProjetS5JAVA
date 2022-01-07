package projet.entities.pacmanstate;

import java.awt.Color;

import projet.PacManGame;
import projet.entities.Ghost;
import projet.entities.PacMan;

public class NormalState extends PacmanState {

    public NormalState(PacManGame game, PacMan pacman) {
        super(game, pacman);
        pacman.setColor(Color.YELLOW);
    }

    @Override
    public void action() {
        move();
        checkGhostContact();
    }

    /**
	 * Regarde si pacman a un contact avec un fantome et reagit en fonction
	 */
    private void checkGhostContact() {
        int pacmanPosX = pacman.getPosX();
        int pacmanPosY = pacman.getPosY();
        for (Ghost ghost : context.getGhost()) {
            int ghostposX = ghost.getPosX();
            int ghostposY = ghost.getPosY();
            if ((pacmanPosX == ghostposX && pacmanPosY == ghostposY)
                    || (pacmanPosX == ghostposX && pacmanPosY - 1 == ghostposY && isOpposed(ghost))
                    || (pacmanPosX == ghostposX && pacmanPosY + 1 == ghostposY && isOpposed(ghost))
                    || (pacmanPosX - 1 == ghostposX && pacmanPosY == ghostposY && isOpposed(ghost))
                    || (pacmanPosX + 1 == ghostposX && pacmanPosY == ghostposY && isOpposed(ghost))) {
                context.subLives();
                pacman.teleport(context.getMap().getSpawnPacmanX(), context.getMap().getSpawnPacmanY());
                for (Ghost ghostbis : context.getGhost())
                    ghostbis.teleport(context.getMap().getSpawnGhostX(), context.getMap().getSpawnGhostY());
            }
        }
    }
}
