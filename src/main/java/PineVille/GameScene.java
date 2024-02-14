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

        float playerX = screenWidth / 2;
        float playerY = screenHeight / 2;
        float moveSpeed = 7.0f;

        InitWindow(screenWidth, screenHeight, "Pine-Ville");
        Texture texPlayer = LoadTexture("resources/wabbit_alpha.png");
        Texture texTree = LoadTexture("resources/SpriteTree.png");

        ToggleFullscreen();

        SetTargetFPS(60);               // Set our game to run at 60 frames-per-second
        //--------------------------------------------------------------------------------------

        // Main game loop
        while (!WindowShouldClose()) {

            // Update
            if (IsKeyPressed(KEY_UP)) {
                player.wood++;
            }

            if (IsKeyPressed(KEY_DOWN)) {
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

            if (IsKeyPressed(   KEY_TAB)) {
                ToggleFullscreen();
            }

            if (moveX != 0 && moveY != 0) {
                moveX /= Math.sqrt(2);
                moveY /= Math.sqrt(2);
            }

            playerX += moveX;
            playerY += moveY;

            // Draw
            BeginDrawing();

            ClearBackground(RAYWHITE);
            DrawTexturePro(texTree, new Jaylib().Rectangle(0, 0, texTree.width(), texTree.height()),
                    new Jaylib().Rectangle(100, 100, texTree.width() * 4, texTree.height() * 4),
                    new Jaylib.Vector2(0, 0), 0, WHITE);
//            DrawTexture(texPlayer, (int) playerX, (int) playerY, WHITE);

            DrawTexturePro(texPlayer, new Jaylib().Rectangle(0, 0, texPlayer.width(), texPlayer.height()),
                    new Jaylib().Rectangle(playerX, playerY, texPlayer.width() * 2, texPlayer.height() * 2),
                    new Jaylib.Vector2(0, 0), 0, WHITE);
            DrawText("Wood: " + player.wood, 20, 20, 30, DARKBROWN);
            DrawText("Gold: " + player.gold, 20, 50, 30, GOLD);


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
