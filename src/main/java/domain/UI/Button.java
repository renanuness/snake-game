package domain.UI;

import domain.Position;

import java.util.function.Supplier;

public class Button{
    private String text;
    private int color;
    private Position position;

    public int getWidht() {
        return widht;
    }

    public int getHeight() {
        return height;
    }

    private int height;
    private int widht;

    private Supplier<Void> onClick;

    public Button(String text, int color, Position position, Supplier<Void> onClick) {
        this.text = text;
        this.color = color;
        this.position = position;
        this.onClick = onClick;
        this.height = 40;
        this.widht = 80;
    }

    public Position getPosition() {
        return position;
    }

    public void click(){
        onClick.get();
    }
}