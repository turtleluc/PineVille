package PineVille;

import com.raylib.Jaylib;
import com.raylib.Raylib;

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

        Player player = new Player(new Jaylib.Vector2(100,100), WHITE);

        int circleX = screenWidth / 2;
        int circleY = screenHeight / 2;

        InitWindow(screenWidth, screenHeight, "Pine-Ville");
        Texture texPlayer = LoadTexture("resources/wabbit_alpha.png");
        Texture texTree = LoadTexture("resources/SpriteTree.png");
        Texture texShop = LoadTexture("resources/SpriteShop.png");

        SetExitKey(KEY_NULL);

        boolean exitWindowRequested = false;
        boolean exitWindow = false;

        ToggleFullscreen();

        SetTargetFPS(60);               // Set our game to run at 60 frames-per-second
        //--------------------------------------------------------------------------------------

        // Main game loop
        while (!WindowShouldClose()) {

            // Update

            player.Move(7.0f);

            if (IsKeyPressed(KEY_UP)) {
                player.wood++;
            }

            if (IsKeyPressed(KEY_DOWN)) {
                player.gold++;
            }

            if (WindowShouldClose() || IsKeyPressed(KEY_ESCAPE)) exitWindowRequested = true;

            if (exitWindowRequested)
            {

                if (IsKeyPressed(KEY_Y)) exitWindow = true;
                else if (IsKeyPressed(KEY_N)) exitWindowRequested = false;
            }

            if (exitWindow) CloseWindow();


            // Draw
            BeginDrawing();

            ClearBackground(RAYWHITE);
            DrawTexturePro(texTree, new Jaylib().Rectangle(0, 0, texTree.width(), texTree.height()),
                    new Jaylib().Rectangle(100, 100, texTree.width() * 4, texTree.height() * 4),
                    new Jaylib.Vector2(0, 0), 0, WHITE);

            DrawTexturePro(texShop, new Jaylib().Rectangle(0, 0, texShop.width(), texShop.height()),
                    new Jaylib().Rectangle(1100, 200, texShop.width() * 7, texShop.height() * 7),
                    new Jaylib.Vector2(0, 0), 0, WHITE);

            player.drawPlayer(texPlayer);

            DrawText("Wood: " + player.wood, 20, 20, 30, DARKBROWN);
            DrawText("Gold: " + player.gold, 20, 50, 30, GOLD);

            if (exitWindowRequested)
            {
                DrawRectangle(0, 0, screenWidth, screenHeight, BLACK);
                DrawText("Are you sure you want to exit Pine-Ville? [Y/N]", 350, 500, 50, WHITE);
            }

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
