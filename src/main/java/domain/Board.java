package domain;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int horizontalSquares;
    private int verticalSquares;

    // Obstacles and border
    private List<Obstacle> obstacles;

    public Board(ScreenSize screenSize, int squareSize){
        horizontalSquares = screenSize.width()/ squareSize;
        verticalSquares = screenSize.height()/ squareSize;

        obstacles = new ArrayList<>();
        obstacles.add(new Obstacle(new Position(20,20)));
    }

    public List<Obstacle> getObstacles(){
        return obstacles;
    }

    public boolean checkSnakeCollisions(SnakeBody snakeBody){
        for(var sn: snakeBody.getBody()){
            var newX = sn.getPosition().x;
            var newY = sn.getPosition().y;
            if(sn.getPosition().x >= horizontalSquares){
                newX = 0;
            }
            if(sn.getPosition().x < 0){
                newX = horizontalSquares-1;
            }
            if(sn.getPosition().y >= verticalSquares){
                newY = 0;
            }
            if(sn.getPosition().y < 0){
                newY = verticalSquares-1;
            }
            if(newX != sn.getPosition().x || newY != sn.getPosition().y){
                sn.moveTo(newX, newY);
            }
        }

        for(var obstacle: obstacles){
            if(obstacle.isColliding(snakeBody.getPosition())){
                return false;
            }
        }

        return true;
    }
}
