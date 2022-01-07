package projet.entities.ghoststate;

import projet.PacManGame;
import projet.entities.Ghost;

public class NormalState extends GhostState {

    public NormalState(PacManGame game, Ghost ghost) {
        super(game, ghost);
        ghost.setColor(ghost.getBaseColor());
    }

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
