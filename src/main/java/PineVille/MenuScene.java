package PineVille;

import com.raylib.Jaylib;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;

public class MenuScene {

    // Method to switch to the GameScene
    public static void switchToGameScene() {
        CloseWindow(); // Close the menu window
        GameScene.main(new String[]{}); // Run the GameScene
    }

    // Main entry point
    public static void main(String[] s) {
        int screenWidth = 1920;
        int screenHeight = 1080;

        float logoX = screenWidth / 2;
        float logoY = screenHeight / 2;

        InitWindow(screenWidth, screenHeight, "Pine-Ville Main Menu");

        Texture texLogo = LoadTexture("resources/SpriteLogo.png");

        //ToggleFullscreen();

        SetTargetFPS(60);

        while (!WindowShouldClose()) {
            // Update
            if (GuiButton(new Jaylib.Rectangle(screenWidth/2 - 250, screenHeight/2, 500, 150 ), "Play")) {
                switchToGameScene();
            }
            if (GuiButton(new Jaylib.Rectangle(screenWidth/2 - 250, screenHeight/2 + 300, 500, 150 ), "Quit")) {
                break; // Exit the loop to close the window and quit the game
            }

            // Draw
            BeginDrawing();
            ClearBackground(RAYWHITE);
            GuiSetStyle(DEFAULT, TEXT_SIZE, 60);
            DrawTexturePro(texLogo, new Jaylib().Rectangle(0, 0, texLogo.width(), texLogo.height()),
                    new Jaylib().Rectangle(logoX, logoY, texLogo.width() * 13, texLogo.height() * 13),
                    new Jaylib.Vector2(415, 450), 0, WHITE);
//            DrawText("Pine-Ville", 725, 200, 100, GOLD);
            EndDrawing();
        }

//        UnloadTexture(texPlayer);
        // De-Initialization
        //--------------------------------------------------------------------------------------
        CloseWindow();        // Close window and OpenGL context
        //--------------------------------------------------------------------------------------

        return;
    }
}
