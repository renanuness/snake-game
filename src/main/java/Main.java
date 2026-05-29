import application.SnakeApplication;
import application.SnakeGame;
import infrastructure.ApplicationMode;
import infrastructure.RaylibClock;
import infrastructure.RaylibInputHandler;
import infrastructure.RaylibRenderer;

import static com.raylib.Colors.RAYWHITE;
import static com.raylib.Raylib.*;

public class Main {
    public static void main(String[] args){
        int screenWidth = 1200;
        int screenHeight = 780;
        //SetConfigFlags(FLAG_WINDOW_RESIZABLE);
        InitWindow(screenWidth, screenHeight, "Snake Game");

        SetTargetFPS(60);
        //
        var clock = new RaylibClock();
        var input = new RaylibInputHandler();
        var render = new RaylibRenderer(ApplicationMode.DEBUG);

        var snakeGame= new SnakeGame(render, clock);
        var app = new SnakeApplication(snakeGame);
        //

        while (!WindowShouldClose()){
            var commands = input.getCommands();
            app.update(commands);

            //region Draw Setup
            BeginDrawing();
            ClearBackground(RAYWHITE);
            //endregion
            app.render();
            EndDrawing();
        }

        CloseWindow();
        System.exit(0);
    }
}
