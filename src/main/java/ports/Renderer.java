package ports;

import domain.Fruit;
import domain.Obstacle;
import domain.ScreenSize;
import domain.Snake;
import domain.UI.Button;

import java.util.List;

public interface Renderer {
    ScreenSize getScreenSize();
    void drawDebugInfo();

    void drawSnake(Snake snake);

    void drawFruit(Fruit fruit);

    void drawUI(int score);
    void drawBoard(List<Obstacle> obstacles);

    void drawButton(Button button);
}
