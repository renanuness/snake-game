package domain;

public class Position{
    public int x;
    public int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Position copy(Position pos){
        return new Position(x,y);
    }
    public void moveUp(){y++;}
    public void moveDown(){y--;}
    public void moveRight(){x++;}
    public void moveLeft(){x--;}

    public void move(SnakeDirection direction){
        switch (direction){
            case RIGHT -> moveRight();
            case LEFT -> moveLeft();
            case UP -> moveUp();
            case DOWN -> moveDown();
        }
    }

    public boolean equal(Position pos){
        return pos.x == x && pos.y == y;
    }
}
