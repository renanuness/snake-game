package infrastructure;

import static com.raylib.Raylib.*;

import com.raylib.Colors;
import domain.Snake;
import ports.Renderer;

public class RaylibRenderer implements Renderer {
    @Override
    public void drawSnake(Snake snake) {
        for(var snakePoint: snake.getBody()){
            var pos = snakePoint.getPosition();
            DrawRectangle(pos.x*20, pos.y*20, 20, 20, Colors.RED);
        }

    }
}
