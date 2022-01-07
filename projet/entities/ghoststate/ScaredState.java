package projet.entities.ghoststate;

import java.awt.Color;

import projet.PacManGame;
import projet.entities.Ghost;

/**
 * Representation de l'etat "scared" des fantomes dans le patron State
 */

public class ScaredState extends GhostState {
    private boolean skipTurn;

    public ScaredState(PacManGame context, Ghost ghost) {
        super(context, ghost);
        skipTurn = false;
        ghost.setColor(new Color(25, 25, 166));
    }

    /**
     * Methode appelee quand le sujet performe une action
     */
    @Override
    public void action() {
        if (skipTurn) {
            if (context.getMap().isTeleportPoint(ghost.getPosX(), ghost.getPosY()))
                move();
            else if (!directionStraight())
                if (!changeDirectionAngle())
                    if (!changeDirectionDeadend())
                        if (!changeDirectionTjunction())
                            changeDirectionCross();
        }
        skipTurn = !skipTurn;
    }
}
