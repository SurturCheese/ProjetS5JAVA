package projet.Blocs;

public abstract class Pellet extends Element {
    protected int points;

    protected Pellet(int posX, int posY) {
        super(posX, posY);

    }

    public int getPoints() {
        return points;
    }
}
