package domain;

public class MouseClick {
    private int button;
    private Position position;


    public MouseClick(int button, Position position) {
        this.button = button;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
