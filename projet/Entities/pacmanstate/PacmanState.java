package projet.Entities.pacmanstate;

import java.util.Objects;

import projet.PacManGame;
import projet.Entities.Character;
import projet.Entities.Ghost;
import projet.Entities.PacMan;

public abstract class PacmanState {

    protected PacMan pacman;
    protected PacManGame context;

    protected PacmanState(PacManGame game, PacMan pacman) {
        context = game;
        this.pacman = pacman;
    }

    public abstract void action();

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
	 * Regarde si la direction de pacman et d'un fantome soient opposee
     * @param ghost le fantome avec lequelle comparer
     * @return true s'il sont oppose false sinon
	 */
    protected boolean isOpposed(Ghost ghost) {
        return (Objects.equals(pacman.getDirection(), projet.Entities.Character.UP)
                && Objects.equals(ghost.getDirection(), projet.Entities.Character.DOWN)) ||
                (Objects.equals(pacman.getDirection(), projet.Entities.Character.DOWN)
                        && Objects.equals(ghost.getDirection(), projet.Entities.Character.UP))
                ||
                (Objects.equals(pacman.getDirection(), projet.Entities.Character.RIGHT)
                        && Objects.equals(ghost.getDirection(), projet.Entities.Character.LEFT))
                ||
                (Objects.equals(pacman.getDirection(), projet.Entities.Character.LEFT)
                        && Objects.equals(ghost.getDirection(), projet.Entities.Character.RIGHT));
    }
}
