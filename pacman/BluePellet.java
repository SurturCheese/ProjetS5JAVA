package projetS5;

import java.awt.Color;

public class BluePellet extends Pellet {

  public BluePellet(int posX, int posY) {
    super(posX, posY);
    this.color = Color.BLUE;
    points = 100;
  }
}
