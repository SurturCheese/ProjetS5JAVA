package projet.Entities.ghoststate;

import projet.PacManGame;
import projet.Entities.Ghost;

public class NormalState extends GhostState {

    public NormalState(PacManGame game, Ghost ghost) {
        super(game, ghost);
        ghost.setColor(ghost.getBaseColor());
    }

    @Override
    public void action() {
        if (context.getMap().isTeleportPoint(ghost.getPosX(), ghost.getPosY()))
            move();
        else {
            if (!changeDirectionStraight()) {
                changeDirectionAngle();
                changeDirectionDeadend();
                changeDirectionTjunction();
                changeDirectionCross();
            }
        }
    }

}
