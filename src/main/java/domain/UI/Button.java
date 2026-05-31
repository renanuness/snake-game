package domain.UI;

import domain.Position;

public class Button{
    private String text;
    private int color;
    private Position position;
    private int size;

    public Button(String text, int color, Position position) {
        this.text = text;
        this.color = color;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}