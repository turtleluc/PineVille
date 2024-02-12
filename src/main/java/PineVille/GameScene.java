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

        int wood = 0;
        int gold = 0;

        InitWindow(screenWidth, screenHeight, "Pine-Ville");


        SetTargetFPS(60);               // Set our game to run at 60 frames-per-second
        //--------------------------------------------------------------------------------------

        // Main game loop
        while (!WindowShouldClose())    // Detect window close button or ESC key
        {
            // Update
            //----------------------------------------------------------------------------------
                if (IsKeyPressed(KEY_UP))
                {
                    wood++;
                }

                if (IsKeyPressed(KEY_DOWN))
                {
                    gold++;
                }

                if (IsKeyDown(KEY_W))
                {
                    DrawText("U R 2 Dumb To Code Movement U Silly", screenWidth/4, screenHeight/3, 60, RED);
                }
                if (IsKeyDown(KEY_S))
                {
                    DrawText("Noh", screenWidth/2 - 10, 712, 60, RED);
                }

            //----------------------------------------------------------------------------------

            // Draw
            //----------------------------------------------------------------------------------
            BeginDrawing();

            ClearBackground(RAYWHITE);

            DrawText("Wood: " + wood, 20, 20, 30, DARKBROWN);
            DrawText("Gold: " + gold, 20, 50, 30, GOLD);

            DrawCircle(screenWidth/2, screenHeight/2, 35, GREEN);

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
