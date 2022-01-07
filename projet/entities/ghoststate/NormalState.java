package projet.entities.ghoststate;

import projet.PacManGame;
import projet.entities.Ghost;

public class NormalState extends GhostState {

    public NormalState(PacManGame context, Ghost ghost) {
        super(context, ghost);
        ghost.setColor(ghost.getBaseColor());
    }

    /**
	 * Methode appelee quand le sujet performe une action
	 */
    @Override
    public void action() {
        if (context.getMap().isTeleportPoint(ghost.getPosX(), ghost.getPosY()))
            move();
        else if (!directionStraight()) {
            changeDirectionAngle();
            changeDirectionDeadend();
            changeDirectionTjunction();
            changeDirectionCross();
        }
    }

}
