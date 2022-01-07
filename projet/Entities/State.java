package projet.Entities;

import projet.PacManGame;

public abstract class State {

    PacManGame context;

    protected State(PacManGame game) {
        context = game;
    }

    public abstract void action();

}
