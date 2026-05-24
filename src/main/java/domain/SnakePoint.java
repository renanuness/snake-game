package domain;

import java.util.ArrayDeque;
import java.util.Deque;

public class SnakePoint{
    private SnakeDirection direction;
    private Position position;
    private Deque<TurningPoint> turningPoints;

    public SnakePoint(Position position, SnakeDirection direction) {
        this.direction = direction;
        this.position = position;
        this.turningPoints = new ArrayDeque<>();
    }

    public SnakeDirection getDirection(){
        return direction;
    }

    public void addTurningPoint(TurningPoint turningPoint){
        this.turningPoints.add(turningPoint);
    }

    public void move(){
        if(turningPoints.size() > 0 && position.equal(turningPoints.getFirst().getPosition())){
            var turningPoint = turningPoints.pop();
            direction = turningPoint.getDirection();
        }

        position.move(direction);
    }

    public Position getPosition() {
        return position;
    }
}
