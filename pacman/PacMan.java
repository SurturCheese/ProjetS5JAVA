package projetS5;

import java.awt.Color;
import java.util.Objects;

public class PacMan {

  private PacManGame game;
  private String state;
  public static final String NORMAL = "NORMAL";
  public static final String INVISIBLE = "INVISIBLE";
  public static final String SUPERPACMAN = "SUPERPACMAN";
  public static final String UP = "UP";
  public static final String RIGHT = "RIGHT";
  public static final String DOWN = "DOWN";
  public static final String LEFT = "LEFT";
  private String direction;
  private Color color;
  private int posX;
  private int posY;
  private boolean isAlive;

  public PacMan(int posX, int posY, PacManGame game) {
    this.game = game;
    state = NORMAL;
    color = Color.YELLOW;
    this.posX = posX * PacManView.TILESIZE;
    this.posY = posY * PacManView.TILESIZE;
    this.isAlive = true;
    this.direction = "NORD";
  }

  public String getState() {
    return state;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public int getPosX() {
    return posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setDead() {
    this.isAlive = false;
  }

  public boolean isAlive() {
    return this.isAlive;
  }

  public void setStateNormal() {
    state = NORMAL;
    color = Color.YELLOW;
  }

  public void setStateInvisible() {
    state = INVISIBLE;
    color = Color.WHITE;
  }

  public void setStateSuperpacman() {
    state = SUPERPACMAN;
    color = Color.ORANGE;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public void move() {
    if (
      Objects.equals(direction, UP) && game.checkerNorth(posX, posY) != 1
    ) posY = posY - PacManView.TILESIZE; else if (
      Objects.equals(direction, DOWN) && game.checkerSouth(posX, posY) != 1
    ) posY = posY + PacManView.TILESIZE; else if (
      Objects.equals(direction, RIGHT) && game.checkerEast(posX, posY) != 1
    ) posX = posX + PacManView.TILESIZE; else if (
      Objects.equals(direction, LEFT) && game.checkerWest(posX, posY) != 1
    ) posX = posX - PacManView.TILESIZE;
  }

  public void teleport(int x, int y) {
    posX = x;
    posY = y;
  }
}
