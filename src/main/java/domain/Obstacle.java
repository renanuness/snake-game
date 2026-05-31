package domain;

public class Obstacle {
    private Position position;

    public Obstacle(Position position){
        this.position = new Position(position);
    }

    public boolean isColliding(Position otherPosition){
        return position.equals(otherPosition);
    }

    public Position getPosition() {
        return position;
    }
}
