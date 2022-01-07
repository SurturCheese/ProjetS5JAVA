package projet.Entities.ghoststate;

import java.awt.Color;

import projet.PacManGame;
import projet.Entities.Ghost;

public class ScaredState extends GhostState {
    private boolean skipTurn;

    public ScaredState(PacManGame game, Ghost ghost) {
        super(game, ghost);
        skipTurn = false;
        ghost.setColor(new Color(25, 25, 166));
    }

    @Override
    public void action() {
        if (skipTurn) {
            if (context.getMap().isTeleportPoint(ghost.getPosX(), ghost.getPosY()))
                move();
            else if (!changeDirectionStraight()) {
                changeDirectionAngle();
                changeDirectionDeadend();
                changeDirectionTjunction();
                changeDirectionCross();
            }
        }
        skipTurn = !skipTurn;
    }
}
