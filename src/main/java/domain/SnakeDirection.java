package domain;

public enum SnakeDirection{
    UP,
    RIGHT,
    DOWN,
    LEFT;

    public boolean canSwitch(SnakeDirection next){
        switch (this){
            case UP, DOWN -> {
                return next == LEFT || next == RIGHT;
            }
            case  LEFT, RIGHT -> {
                return  next == UP || next == DOWN;
            }
        }
        return false;
    }
}
