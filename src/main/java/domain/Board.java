package domain;

public class Board {
    private int horizontalSquares;
    private int verticalSquares;

    public Board(int screenWidth, int screenHeight, int squareSize){
        horizontalSquares = screenWidth/ squareSize;
        verticalSquares = screenHeight/ squareSize;
    }
}
