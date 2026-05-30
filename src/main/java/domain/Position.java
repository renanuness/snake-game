package domain;

import java.util.Objects;

public class Position{
    public int x;
    public int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Position(Position pos){
        this.x = pos.x;
        this.y = pos.y;
    }

    public Position copy(Position pos){
        return new Position(x,y);
    }
    public void moveUp(){y--;}
    public void moveDown(){y++;}
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

    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        var other = (Position) obj;
        var result = other.x == x && other.y == y;
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
