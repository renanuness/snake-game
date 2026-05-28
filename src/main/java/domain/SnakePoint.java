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
        if(turningPoints.size() > 0 && position.equals(turningPoints.getFirst().getPosition())){
            var turningPoint = turningPoints.pop();
            if(direction.canSwitch(turningPoint.getDirection()))
                direction = turningPoint.getDirection();
        }

        position.move(direction);
    }

    public SnakePoint simulateMovement(){
        var newDirection = direction;
        if(turningPoints.size() > 0 && position.equals(turningPoints.getFirst().getPosition())){
            var turningPoint = turningPoints.getFirst();
            if(direction.canSwitch(newDirection))
                newDirection = turningPoint.getDirection();
        }

        var newPosition = new Position(position.x, position.y);
        newPosition.move(newDirection);
        return new SnakePoint(newPosition, newDirection);
    }
    public Position getPosition() {
        return position;
    }
}
