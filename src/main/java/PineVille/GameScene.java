package PineVille;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;

public class GameScene {

    //------------------------------------------------------------------------------------
// Program main entry point
//------------------------------------------------------------------------------------
    static Tree[] trees;
    public static void main(String[] s)
    {
        // Initialization
        //--------------------------------------------------------------------------------------
        int screenWidth = 1920;
        int screenHeight = 1080;

        Player player = new Player(new Jaylib.Vector2(100,100), WHITE);
        Shop shop = new Shop(new Jaylib.Vector2(100,100), WHITE, player);

        Sell sell = new Sell(player);
        Debug debug = new Debug(player, sell);

        InitWindow(screenWidth, screenHeight, "Pine-Ville");
        Texture texPlayer = LoadTexture("resources/wabbit_alpha.png");
        Texture texTree = LoadTexture("resources/SpriteTree.png");
        Texture texShop = LoadTexture("resources/SpriteShop.png");

        SetExitKey(KEY_NULL);

        boolean exitWindowRequested = false;
        boolean exitWindow = false;

        initializeTrees();

        ToggleFullscreen();

        SetTargetFPS(75);               // Set our game to run at 60 frames-per-second
        //--------------------------------------------------------------------------------------

        // Main game loop
        while (!WindowShouldClose()) {

            // Update

            player.Move(7.0f);

            Debug.Commands();

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

            DrawTexturePro(texShop, new Jaylib().Rectangle(0, 0, texShop.width(), texShop.height()),
                    new Jaylib().Rectangle(1100, 200, texShop.width() * 7, texShop.height() * 7),
                    new Jaylib.Vector2(0, 0), 0, WHITE);

            for (Tree tree : trees) {
                tree.draw();
            }

            player.drawPlayer(texPlayer);

            //Shop
            if (IsKeyPressed(KEY_LEFT)) {
                shop.isShopUI = !shop.isShopUI;
            }
            if (shop.isShopUI) shop.ShopUi();

            //Player ui
            DrawText("Wood: " + player.wood, 20, 20, 30, DARKBROWN);
            DrawText("Gold: " + player.gold, 20, 50, 30, GOLD);
            DrawText("Axe Tier: " + player.axeTier, 20, 80, 30, GRAY);

            if (exitWindowRequested)
            {
                DrawRectangle(0, 0, screenWidth, screenHeight, BLACK);
                DrawText("Are you sure you want to exit Pine-Ville? [Y/N]", 350, 500, 50, WHITE);
            }

            if(IsKeyPressed(KEY_GRAVE))
            {
                /*Debug.Load();*/
                Debug.debug = !Debug.debug;
            }

            if (Debug.debug) Debug.Load();
            EndDrawing();
        }

//        UnloadTexture(texPlayer);
        // De-Initialization
        //--------------------------------------------------------------------------------------
        CloseWindow();        // Close window and OpenGL context
        //--------------------------------------------------------------------------------------

        return;
    }

    private static void initializeTrees() {
        trees = new Tree[15];
        for (int i = 0; i < trees.length; i++) {
            float x = GetRandomValue(0, 700 - 1);
            float y = GetRandomValue(0, 1080 - 3);
            trees[i] = new Tree(x, y);
        }
    }
}
