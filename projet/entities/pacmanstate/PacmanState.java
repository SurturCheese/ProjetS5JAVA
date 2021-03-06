package projet.entities.pacmanstate;

import java.util.Objects;

import projet.PacManGame;
import projet.entities.Character;
import projet.entities.Ghost;
import projet.entities.PacMan;

/**
 * Classe permettant de mettre en place le patron de conception State pour pacman
 */
public abstract class PacmanState {

    protected PacMan pacman;
    protected PacManGame context;

    protected PacmanState(PacManGame context, PacMan pacman) {
        this.context = context;
        this.pacman = pacman;
    }

    /**
     * Methode appelee quand le sujet performe une action
     */
    public abstract void action();

    /**
     * Fait deplacer pacman si possible
     */
    protected void move() {
        if (Objects.equals(pacman.getDirection(), Character.UP)
                && context.checkerUp(pacman.getPosX(), pacman.getPosY()) != 1)
            pacman.setPosY(pacman.getPosY() - 1);
        else if (Objects.equals(pacman.getDirection(), Character.DOWN)
                && context.checkerDown(pacman.getPosX(), pacman.getPosY()) != 1)
            pacman.setPosY(pacman.getPosY() + 1);
        else if (Objects.equals(pacman.getDirection(), Character.RIGHT)
                && context.checkerRight(pacman.getPosX(), pacman.getPosY()) != 1)
            pacman.setPosX(pacman.getPosX() + 1);
        else if (Objects.equals(pacman.getDirection(), Character.LEFT)
                && context.checkerLeft(pacman.getPosX(), pacman.getPosY()) != 1)
            pacman.setPosX(pacman.getPosX() - 1);
    }

    /**
     * Regarde si la direction de pacman et d'un fantome sont opposee
     * 
     * @param ghost le fantome avec lequelle comparer
     * @return true s'il sont oppose false sinon
     */
    protected boolean isOpposed(Ghost ghost) {
        return (Objects.equals(pacman.getDirection(), projet.entities.Character.UP)
                && Objects.equals(ghost.getDirection(), projet.entities.Character.DOWN)) ||
                (Objects.equals(pacman.getDirection(), projet.entities.Character.DOWN)
                        && Objects.equals(ghost.getDirection(), projet.entities.Character.UP))
                ||
                (Objects.equals(pacman.getDirection(), projet.entities.Character.RIGHT)
                        && Objects.equals(ghost.getDirection(), projet.entities.Character.LEFT))
                ||
                (Objects.equals(pacman.getDirection(), projet.entities.Character.LEFT)
                        && Objects.equals(ghost.getDirection(), projet.entities.Character.RIGHT));
    }
}
