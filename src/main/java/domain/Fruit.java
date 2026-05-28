package domain;

public class Fruit {
    private Position position;
    private int timeToLive;
    //TODO: Callback para destruir quando o tempo acabar

    public Fruit(Position position, int timeToLive) {
        this.position = position;
        this.timeToLive = timeToLive;
    }

    public Position getPosition() {
        return position;
    }
}
