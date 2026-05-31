package infrastructure;

import static com.raylib.Raylib.*;

import com.raylib.Colors;
import domain.Fruit;
import domain.Obstacle;
import domain.ScreenSize;
import domain.Snake;
import domain.UI.Button;
import ports.Renderer;

import java.util.List;

public class RaylibRenderer implements Renderer {
    private ScreenSize screenSize;
    private int squareSize;
    private final ApplicationMode applicationMode;

    public RaylibRenderer(ApplicationMode mode){
        this.applicationMode = mode;
        screenSize = new ScreenSize(GetScreenWidth(), GetScreenHeight());
        squareSize = screenSize.width() / 60;
    }

    public ScreenSize getScreenSize(){
        return screenSize;
    }

    @Override
    public void drawDebugInfo(){
        var screenSize = getScreenSize();

        DrawText("Square size: "+squareSize, 5, 10, 22,Colors.BLACK);
        DrawText("Screen size: "+screenSize.width() +"x"+screenSize.height(), 5, 80, 22,Colors.BLACK);

        var horizontalLines = screenSize.width()/squareSize;
        for(var i = 0; i < screenSize.width()/squareSize; i++){
            DrawLine(0+(i*squareSize),0, 0+(i*squareSize), screenSize.height(), Colors.BLUE );
        }

        var verticalLines = screenSize.height()/squareSize;
        for(var i = 0; i < horizontalLines; i++){
            DrawLine(0,0+(i*squareSize), screenSize.width(), 0+(i*squareSize), Colors.BLUE );
        }
    }

    @Override
    public void drawSnake(Snake snake) {
        var screenSize = getScreenSize();

        for(var snakePoint: snake.getBody().getBody()){
            var pos = snakePoint.getPosition();
            DrawRectangle(pos.x*squareSize, pos.y*squareSize, squareSize, squareSize, Colors.RED);
        }

        if(applicationMode == ApplicationMode.DEBUG){
            DrawText("Snake Position: ("+snake.getPosition().x+","+snake.getPosition().y+")", 5, 36, 22,Colors.BLACK);
        }
    }

    @Override
    public void drawFruit(Fruit fruit) {
        var screenSize = getScreenSize();

        var pos = fruit.getPosition();
        DrawCircle(pos.x*squareSize+(squareSize/2), pos.y*squareSize+(squareSize/2), squareSize/4, Colors.DARKPURPLE);


        if(applicationMode == ApplicationMode.DEBUG){
            DrawText("Snake Position: ("+fruit.getPosition().x+","+fruit.getPosition().y+")", 5, 60, 22,Colors.BLACK);
        }
    }

    @Override
    public void drawUI(int score) {
        DrawText("Points "+score, screenSize.width()/2 , 11, 22,Colors.BLACK);
    }

    @Override
    public void drawBoard(List<Obstacle> obstacles){
        for(var obstacle: obstacles){
            var pos = obstacle.getPosition();
            DrawRectangle(pos.x*20, pos.y*squareSize, squareSize, squareSize, Colors.BLACK);
        }
    }

    //region UI ELEMENTS

    @Override
    public void drawButton(Button button) {
        var pos = button.getPosition();
        DrawRectangleLines(pos.x*20, pos.y*squareSize, squareSize, squareSize, Colors.BLACK);
    }

    //endregion
}

