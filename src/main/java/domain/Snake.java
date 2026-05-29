package domain;

import java.util.*;

public class Snake {
    private SnakeBody body;

    public Snake(Position initialPosition, SnakeDirection initialDirection, int bodySize){
        body = new SnakeBody(initialPosition, initialDirection, bodySize);
    }

    public boolean walk(){
        if(wouldCollideIfWalk()){
            return false;
        }
        //
        body.walk();

        return true;
    }

    public void addDirectionChange(SnakeDirection direction){
        body.addDirectionChange(direction);
    }

    public void addBody(){
        body.grow();
    }
    private boolean wouldCollideIfWalk(){
        var simulatedMovement = body.getBody().getFirst().simulateMovement();
        var result = body.getBody().stream().skip(1).anyMatch(sp-> sp.getPosition().equals(simulatedMovement.getPosition()));

        return result;
    }

    //region Getters & Setters
    public SnakeDirection getDirection(){ return body.getDirection(); }
    public Position getPosition(){return body.getPosition(); }

    public List<SnakePoint> getBody() {
        return body.getBody();
    }
    //endregion
}
