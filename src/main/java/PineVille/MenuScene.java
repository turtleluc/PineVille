
package PineVille;

import com.raylib.Jaylib;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;

public class MenuScene {



    //------------------------------------------------------------------------------------
// Program main entry point
//------------------------------------------------------------------------------------
    public static void main(String[] s)
    {
        // Initialization
        //--------------------------------------------------------------------------------------
        int screenWidth = 1920;
        int screenHeight = 1080;

        ToggleFullscreen();

        boolean play = false;
        boolean quit = false;

        InitWindow(screenWidth, screenHeight, "Pine-Ville Main Menu");


        SetTargetFPS(60);               // Set our game to run at 60 frames-per-second
        //--------------------------------------------------------------------------------------

        // Main game loop
        while (!WindowShouldClose())    // Detect window close button or ESC key
        {
            // Update
            //----------------------------------------------------------------------------------
                if(IsKeyPressed(KEY_DOWN))
                {
                    
                }

            //----------------------------------------------------------------------------------

            // Draw
            //----------------------------------------------------------------------------------
            BeginDrawing();

            ClearBackground(RAYWHITE);
            GuiSetStyle(DEFAULT, TEXT_SIZE, 60);

            DrawText("Pine-Ville", 725, 200, 100, GOLD);


            play = GuiButton(new Jaylib.Rectangle(screenWidth/2 - 250, screenHeight/2, 500, 150 ), "Play");
            quit = GuiButton(new Jaylib.Rectangle(screenWidth/2 - 250, screenHeight/2 + 300, 500, 150 ), "Quit");

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
