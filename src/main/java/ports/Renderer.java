package ports;

import domain.Fruit;
import domain.Snake;

public interface Renderer {
    void drawDebugInfo();

    void drawSnake(Snake snake);

    void drawFruit(Fruit fruit);
}
