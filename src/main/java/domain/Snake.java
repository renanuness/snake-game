package domain;

import java.util.*;

public class Snake {
    private SnakeBody newBody;

    public Snake(Position initialPosition, SnakeDirection initialDirection, int bodySize){
        newBody = new SnakeBody(initialPosition, initialDirection, bodySize);
    }

    public boolean walk(){
        if(wouldCollideIfWalk()){
            return false;
        }
        newBody.walk();

        return true;
    }

    public void addDirectionChange(SnakeDirection direction){
        newBody.addDirectionChange(direction);
    }

    private boolean wouldCollideIfWalk(){
        var simulatedMovement = newBody.getBody().getFirst().simulateMovement();
        var result = newBody.getBody().stream().skip(1).anyMatch(sp-> sp.getPosition().equals(simulatedMovement.getPosition()));

        return result;
    }

    //region Getters & Setters
    public SnakeDirection getDirection(){ return newBody.getDirection(); }
    public Position getPosition(){return newBody.getPosition(); }

    public List<SnakePoint> getBody() {
        return newBody.getBody();
    }
    //endregion
}
