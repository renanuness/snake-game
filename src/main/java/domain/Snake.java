package domain;

import java.util.*;

public class Snake {
    private SnakeDirection direction;
    private Position position;
    private List<SnakePoint> body;


    public Snake(Position initialPosition, SnakeDirection initialDirection, int bodySize){
        position = initialPosition;
        direction = initialDirection;
        body = new ArrayList<>();


        for(int i = 0; i <= bodySize; i++){
            body.add(new SnakePoint(new Position(initialPosition.x, initialPosition.y), initialDirection));
            initialPosition.move(initialDirection);
        }
    }

    public void walk(){
        body.forEach( sp->{
            sp.move();
        });

    }


    public void moveUp(){
        if(direction == SnakeDirection.LEFT || direction == SnakeDirection.RIGHT)
            body.forEach( sp->{
                sp.addTurningPoint(new TurningPoint(getPosition(), SnakeDirection.UP));
            });
    }

    public void moveDown(){
        if(direction == SnakeDirection.LEFT || direction == SnakeDirection.RIGHT)
            body.forEach( sp->{
                sp.addTurningPoint(new TurningPoint(getPosition(), SnakeDirection.DOWN));
            });
    }

    public void moveLeft(){
        if(direction == SnakeDirection.UP || direction == SnakeDirection.DOWN)
            body.forEach( sp->{
                sp.addTurningPoint(new TurningPoint(getPosition(), SnakeDirection.LEFT));
            });
    }

    public void moveRight(){
        if(direction == SnakeDirection.UP || direction == SnakeDirection.DOWN)
            body.forEach( sp->{
                sp.addTurningPoint(new TurningPoint(getPosition(), SnakeDirection.RIGHT));
            });
    }

    //region Getters & Setters
    public SnakeDirection getDirection(){ return body.get(0).getDirection(); }
    public Position getPosition(){return body.get(0).getPosition();}
    //endregion
}
