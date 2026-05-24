import static com.raylib.Raylib.*;
import static com.raylib.Colors.*;

public class Main {
    public static void main(String[] args){
        int screenWidth = 800;
        int screenHeight = 450;
        InitWindow(screenWidth, screenHeight, "Snake Game");
        SetTargetFPS(60);

        while (!WindowShouldClose()){
            BeginDrawing();

            ClearBackground(RAYWHITE);

            DrawText("Congrats! You created your first window!", 190, 200, 20, LIGHTGRAY);

            EndDrawing();
        }

        CloseWindow();
        System.exit(0);
    }
}
