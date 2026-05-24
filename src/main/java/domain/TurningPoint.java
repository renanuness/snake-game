package domain;

public class TurningPoint{
    private SnakeDirection direction;
    private Position position;

    public TurningPoint(Position position, SnakeDirection direction) {
        this.direction = direction;
        this.position = position;
    }


    public Position getPosition() { return position; }

    public SnakeDirection getDirection() { return direction; }
}
