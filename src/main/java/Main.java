import static com.raylib.Raylib.*;
import static com.raylib.Colors.*;

public class Main {
    public static void main(String[] args){
        int screenWidth = 800;
        int screenHeight = 450;
        InitWindow(screenWidth, screenHeight, "Snake Game");
        SetTargetFPS(60);


        //
        Vector2 deltaCircle = new Vector2();

        deltaCircle.x(0);
        deltaCircle.y((float)screenHeight/3.0f);
        var speed = 10.0f;
        float circleRadius = 32.0f;

        while (!WindowShouldClose()){
            //region Draw Setup
            BeginDrawing();
            ClearBackground(RAYWHITE);
            //endregion

            float newX = (GetFrameTime()*6.0f*speed) + deltaCircle.x();
            float newY = (GetFrameTime()*6.0f*speed) + deltaCircle.y();
            deltaCircle.x(newX);
            //deltaCircle.y(newY);

            DrawCircleV(deltaCircle, circleRadius, RED);
            EndDrawing();
        }

        CloseWindow();
        System.exit(0);
    }
}
