package PineVille;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;

public class GameScene {



    //------------------------------------------------------------------------------------
// Program main entry point
//------------------------------------------------------------------------------------
    public static void main(String[] s)
    {
        // Initialization
        //--------------------------------------------------------------------------------------
        int screenWidth = 1920;
        int screenHeight = 1080;

        Player player = new Player();

        int circleX = screenWidth / 2;
        int circleY = screenHeight / 2;
        float moveSpeed = 7.0f;



        InitWindow(screenWidth, screenHeight, "Pine-Ville");


        ToggleFullscreen();

        SetTargetFPS(60);               // Set our game to run at 60 frames-per-second
        //--------------------------------------------------------------------------------------

        // Main game loop
        while (!WindowShouldClose())    // Detect window close button or ESC key
        {
            // Update
            //----------------------------------------------------------------------------------
                if (IsKeyPressed(KEY_UP))
                {
                    player.wood++;
                }

                if (IsKeyPressed(KEY_DOWN))
                {
                    player.gold++;
                }

            float moveX = 0;
            float moveY = 0;

            if (IsKeyDown(KEY_D)) {
                moveX += moveSpeed;
            }
            if (IsKeyDown(KEY_A)) {
                moveX -= moveSpeed;
            }
            if (IsKeyDown(KEY_S)) {
                moveY += moveSpeed;
            }
            if (IsKeyDown(KEY_W)) {
                moveY -= moveSpeed;
            }

            // Normalize diagonal movement
            if (moveX != 0 && moveY != 0) {
                moveX /= Math.sqrt(2);
                moveY /= Math.sqrt(2);
            }

            circleX += (int) moveX;
            circleY += (int) moveY;

            //----------------------------------------------------------------------------------

            // Draw
            //----------------------------------------------------------------------------------
            BeginDrawing();

            ClearBackground(RAYWHITE);

            DrawText("Wood: " + player.wood, 20, 20, 30, DARKBROWN);
            DrawText("Gold: " + player.gold, 20, 50, 30, GOLD);

            DrawCircle(circleX, circleY, 35, GREEN);

            EndDrawing();
            //----------------------------------------------------------------------------------
        }

        // De-Initialization
        //--------------------------------------------------------------------------------------
        CloseWindow();        // Close window and OpenGL context
        //--------------------------------------------------------------------------------------

        return;
    }
}
