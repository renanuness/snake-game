package domain;

public class Board {
    private int horizontalSquares;
    private int verticalSquares;

    public Board(ScreenSize screenSize, int squareSize){
        horizontalSquares = screenSize.width()/ squareSize;
        verticalSquares = screenSize.height()/ squareSize;
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
        return true;
    }
}
