package ports;

import domain.Fruit;
import domain.ScreenSize;
import domain.Snake;

public interface Renderer {
    ScreenSize getScreenSize();
    void drawDebugInfo();

    void drawSnake(Snake snake);

    void drawFruit(Fruit fruit);

    void drawUI(int score);
}
