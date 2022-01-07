package projet.Entities.ghoststate;

import projet.PacManGame;
import projet.Entities.State;

public abstract class GhostState extends State{

    protected GhostState(PacManGame game) {
        super(game);

    }

    public abstract void action();
    
}
