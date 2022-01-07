package projet.Entities.pacmanstate;

import projet.PacManGame;
import projet.Entities.State;

public abstract class PacmanState extends State{

    protected PacmanState(PacManGame game) {
        super(game);

    }

    public abstract void action();
    
}
