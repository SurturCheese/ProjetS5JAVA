package projet.entities.ghoststate;

import projet.PacManGame;
import projet.entities.Ghost;

/**
 * Representation de l'etat "normal" des fantomes dans le patron State
 */

public class NormalState extends GhostState {

    public NormalState(PacManGame context, Ghost ghost) {
        super(context, ghost);
        ghost.setColor(ghost.getBaseColor());
    }

    /**
     * Performe le deplacement du fantome
     */
    @Override
    public void action() {
        if (context.getMap().isTeleportPoint(ghost.getPosX(), ghost.getPosY()))
            move();
        else if (!directionStraight())
            if (!changeDirectionAngle())
                if (!changeDirectionDeadend())
                    if (!changeDirectionTjunction())
                        changeDirectionCross();

    }
}
