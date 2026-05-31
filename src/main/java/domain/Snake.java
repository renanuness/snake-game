package domain;

import java.util.*;

public class Snake {
    private SnakeBody body;

    public Snake(Position initialPosition, SnakeDirection initialDirection, int bodySize){
        body = new SnakeBody(initialPosition, initialDirection, bodySize);
    }

    public boolean walk(){
        return body.walk();
    }

    public void addDirectionChange(SnakeDirection direction){
        body.addDirectionChange(direction);
    }

    public void addBody(){
        body.grow();
    }
    private boolean wouldCollideIfWalk(){
        return body.wouldCollideIfWalk();
    }

    //region Getters & Setters
    public SnakeDirection getDirection(){ return body.getDirection(); }
    public Position getPosition(){return body.getPosition(); }

    public SnakeBody getBody() {
        return body;
    }
    //endregion
}
