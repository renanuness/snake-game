package domain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SnakeBody {
    private List<SnakePoint> body;
    private Deque<SnakeDirection> directionPoll;

    public SnakeBody(Position initialPosition, SnakeDirection initialDirection, int bodySize){
        directionPoll = new ArrayDeque<>();
        body = new ArrayList<>();

        int dx = 0;
        int dy = 0;
        switch (initialDirection) {
            case RIGHT -> dx = -1;
            case LEFT -> dx = 1;
            case UP -> dy = 1;
            case DOWN -> dy = -1;
        }

        for(int i = 0; i < bodySize; i++){
            Position newPosition = new Position(
                    initialPosition.x + (dx * i),
                    initialPosition.y + (dy * i)
            );
            body.add(new SnakePoint(newPosition, initialDirection));
        }
    }

    public void addDirectionChange(SnakeDirection newDirection){
        directionPoll.add(newDirection);
    }

    public boolean walk(){
        if(directionPoll.size() > 0){
            var newDirection = directionPoll.pop();
            if(getDirection().canSwitch(newDirection)){
                body.forEach(sp->{
                    sp.addTurningPoint(new TurningPoint(getPosition(), newDirection));
                });
            }else{
                System.out.println("Cant move from " + getDirection() + " to " + newDirection);
            }
        }
        if(wouldCollideIfWalk())
        {
            return false;
        }
        body.forEach(sp->{
            sp.move();
        });

        return true;
    }

    public boolean wouldCollideIfWalk(){
        var simulatedMovement = body.getFirst().simulateMovement();
        var result = body.stream().skip(1).anyMatch(sp-> sp.getPosition().equals(simulatedMovement.getPosition()));

        return result;
    }

    public Position getPosition(){
        return new Position(body.getFirst().getPosition());
    }

    public List<SnakePoint> getBody() {
        return body;
    }

    public SnakeDirection getDirection(){
        return body.getFirst().getDirection();
    }

    public void grow() {
        var last = body.getLast();
        var direction = last.getDirection();

        int dx = 0;
        int dy = 0;
        switch (direction) {
            case RIGHT -> dx = -1;
            case LEFT -> dx = 1;
            case UP -> dy = 1;
            case DOWN -> dy = -1;
        }

        var position = new Position(body.getLast().getPosition().x +dx, body.getLast().getPosition().y +dy);
        var newSnakePoint = new SnakePoint(position, direction);
        for(var tp: last.getTurningPoints()) {
            newSnakePoint.addTurningPoint(new TurningPoint(new Position(tp.getPosition()), tp.getDirection()));
        }
        body.addLast(newSnakePoint);
    }
}
