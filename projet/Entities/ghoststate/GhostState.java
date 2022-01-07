package projet.Entities.ghoststate;

import java.util.Objects;
import java.util.Random;

import projet.PacManGame;
import projet.Entities.Character;
import projet.Entities.Ghost;

public abstract class GhostState {
    protected Ghost ghost;
    protected PacManGame context;
    private Random random;

    protected GhostState(PacManGame context, Ghost ghost) {
        this.context = context;
        this.ghost = ghost;
        random = new Random();
    }

    public abstract void action();

    protected void move() {
        switch (ghost.getDirection()) {
            case Character.UP:
                ghost.setPosY(ghost.getPosY() - 1);
                break;
            case Character.DOWN:
                ghost.setPosY(ghost.getPosY() + 1);
                break;
            case Character.RIGHT:
                ghost.setPosX(ghost.getPosX() + 1);
                break;
            case Character.LEFT:
                ghost.setPosX(ghost.getPosX() - 1);
                break;
        }
    }

    protected boolean changeDirectionStraight() {
        int up = context.checkerUp(ghost.getPosX(), ghost.getPosY());
        int down = context.checkerDown(ghost.getPosX(), ghost.getPosY());
        int right = context.checkerRight(ghost.getPosX(), ghost.getPosY());
        int left = context.checkerLeft(ghost.getPosX(), ghost.getPosY());
        if (up != 1 && down != 1 && right == 1 && left == 1) {
            if (ghost.getDirection().equals(Character.UP)) {
                move();
                return true;
            } else {
                ghost.setDirection(Character.DOWN);
                move();
                return true;
            }
        } else if (up == 1 && down == 1 && right != 1 && left != 1) {
            if (ghost.getDirection().equals(Character.RIGHT)) {
                move();
                return true;
            } else {
                ghost.setDirection(Character.LEFT);
                move();
                return true;
            }
        }
        return false;
    }

    protected void changeDirectionAngle() {
        int up = context.checkerUp(ghost.getPosX(), ghost.getPosY());
        int down = context.checkerDown(ghost.getPosX(), ghost.getPosY());
        int east = context.checkerRight(ghost.getPosX(), ghost.getPosY());
        int left = context.checkerLeft(ghost.getPosX(), ghost.getPosY());
        int sens = random.nextInt(2);
        if (up == 1 && down != 1 && east != 1 && left == 1) {
            if (sens == 0) {
                ghost.setDirection(Character.DOWN);
                move();
            } else {
                ghost.setDirection(Character.RIGHT);
                move();
            }
        } else if (up == 1 && down != 1 && east == 1 && left != 1) {
            if (sens == 0) {
                ghost.setDirection(Character.DOWN);
                move();
            } else {
                ghost.setDirection(Character.LEFT);
                move();
            }
        } else if (up != 1 && down == 1 && east == 1 && left != 1) {
            if (sens == 0) {
                ghost.setDirection(Character.UP);
                move();
            } else {
                ghost.setDirection(Character.LEFT);
                move();
            }
        } else if (up != 1 && down == 1 && east != 1 && left == 1) {
            if (sens == 0) {
                ghost.setDirection(Character.UP);
                move();
            } else {
                ghost.setDirection(Character.RIGHT);
                move();
            }
        }
    }

    protected void changeDirectionTjunction() {
        int up = context.checkerUp(ghost.getPosX(), ghost.getPosY());
        int down = context.checkerDown(ghost.getPosX(), ghost.getPosY());
        int right = context.checkerRight(ghost.getPosX(), ghost.getPosY());
        int left = context.checkerLeft(ghost.getPosX(), ghost.getPosY());
        int sens = random.nextInt(3);
        if (up == 1 && down != 1 && right != 1 && left != 1) {
            if (Objects.equals(ghost.getDirection(), Character.RIGHT)
                    || Objects.equals(ghost.getDirection(), Character.LEFT)) {
                move();
            } else {

                switch (sens) {
                    case 0:
                        ghost.setDirection(Character.LEFT);
                        move();
                        break;
                    case 1:
                        ghost.setDirection(Character.RIGHT);
                        move();
                        break;
                    case 2:
                        ghost.setDirection(Character.DOWN);
                        move();
                        break;
                }
            }
        } else if (up != 1 && down == 1 && right != 1 && left != 1) {
            if (Objects.equals(ghost.getDirection(), Character.RIGHT)
                    || Objects.equals(ghost.getDirection(), Character.LEFT)) {
                move();
            } else {
                switch (sens) {
                    case 0:
                        ghost.setDirection(Character.LEFT);
                        move();
                        break;
                    case 1:
                        ghost.setDirection(Character.RIGHT);
                        move();
                        break;
                    case 2:
                        ghost.setDirection(Character.UP);
                        move();
                        break;
                }
            }
        } else if (up != 1 && down != 1 && right == 1 && left != 1) {
            if (Objects.equals(ghost.getDirection(), Character.UP)
                    || Objects.equals(ghost.getDirection(), Character.DOWN)) {
                move();
            } else {
                switch (sens) {
                    case 0:
                        ghost.setDirection(Character.LEFT);
                        move();
                        break;
                    case 1:
                        ghost.setDirection(Character.UP);
                        move();
                        break;
                    case 2:
                        ghost.setDirection(Character.DOWN);
                        move();
                        break;
                }
            }
        } else if (up != 1 && down != 1 && right != 1 && left == 1) {
            if (Objects.equals(ghost.getDirection(), Character.UP)
                    || Objects.equals(ghost.getDirection(), Character.DOWN)) {
                move();
            } else {
                switch (sens) {
                    case 0:
                        ghost.setDirection(Character.UP);
                        move();
                        break;
                    case 1:
                        ghost.setDirection(Character.RIGHT);
                        move();
                        break;
                    case 2:
                        ghost.setDirection(Character.DOWN);
                        move();
                        break;
                }
            }
        }
    }

    protected void changeDirectionDeadend() {
        int up = context.checkerUp(ghost.getPosX(), ghost.getPosY());
        int down = context.checkerDown(ghost.getPosX(), ghost.getPosY());
        int right = context.checkerRight(ghost.getPosX(), ghost.getPosY());
        int left = context.checkerLeft(ghost.getPosX(), ghost.getPosY());
        if (up == 1 && down == 1 && right == 1 && left != 1) {
            ghost.setDirection(Character.LEFT);
            move();
        } else if (up == 1 && down == 1 && right != 1 && left == 1) {
            ghost.setDirection(Character.RIGHT);
            move();
        } else if (up != 1 && down == 1 && right == 1 && left == 1) {
            ghost.setDirection(Character.UP);
            move();
        } else if (up == 1 && down != 1 && right == 1 && left == 1) {
            ghost.setDirection(Character.DOWN);
            move();
        }
    }

    protected void changeDirectionCross() {
        int up = context.checkerUp(ghost.getPosX(), ghost.getPosY());
        int down = context.checkerDown(ghost.getPosX(), ghost.getPosY());
        int right = context.checkerRight(ghost.getPosX(), ghost.getPosY());
        int left = context.checkerLeft(ghost.getPosX(), ghost.getPosY());
        if (up != 1 && down != 1 && right != 1 && left != 1) 
            move();
    }

}
