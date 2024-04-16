package PineVille;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;
import static com.raylib.Raylib.IsKeyPressed;

public class GameScene {
    //------------------------------------------------------------------------------------
    // Program main entry point
    //------------------------------------------------------------------------------------
    static Tree[] trees;
    static float INTERACTION_RANGE = 80.0f;
    static float INTERACTION_RANGE_SHOP = 150.0f;
    static int CHOP_COOLDOWN = 15; // Cooldown in seconds for tree health regeneration
    static int WOOD_MIN_AMOUNT = 4;
    static int WOOD_MAX_AMOUNT = 10;

    public static void main(String[] s) {
        // Initialization
        //--------------------------------------------------------------------------------------
        int screenWidth = 1920;
        int screenHeight = 1080;

        InitWindow(screenWidth, screenHeight, "Pine-Ville");
        SetExitKey(KEY_NULL);
        ToggleFullscreen();
        SetTargetFPS(75);

        Player player = new Player(new Jaylib.Vector2(100,100), WHITE);
        Shop shop = new Shop(new Jaylib.Vector2(100,100), WHITE, player);

        Sell sell = new Sell(player);
        Debug debug = new Debug(player, sell);


        Texture texPlayer = LoadTexture("resources/wabbit_alpha.png");
        Texture texTree = LoadTexture("resources/SpriteTree.png");
        Texture texShop = LoadTexture("resources/SpriteShop.png");
        Texture texSell = LoadTexture("resources/SpriteSell.png");

        boolean exitWindowRequested = false;
        boolean exitWindow = false;

        initializeTrees();

        // Variables to track time for tree health regeneration
        long lastTime = System.currentTimeMillis();

        // Main game loop
        while (!WindowShouldClose()) {

            // Update
            player.Move(7.0f);

            Debug.Commands();
            player.tierUpdate();

            if (IsKeyPressed(KEY_ESCAPE)) exitWindowRequested = true;

            if (exitWindowRequested) {
                if (IsKeyPressed(KEY_Y)) exitWindow = true;
                else if (IsKeyPressed(KEY_N)) exitWindowRequested = false;
            }

            if (exitWindow) CloseWindow();

            // Check interaction with shop
            float shopDistance = calculateDistance(player.playerX, player.playerY, 1350, 300);
            if (shopDistance <= INTERACTION_RANGE_SHOP) {
                if (IsKeyPressed(KEY_E)) {
                    // Add your logic to interact with the shop
                    // For example, display a menu to buy items
                    shop.isShopUI = !shop.isShopUI;
                    System.out.println("Interacting with the shop!");
                }
            }


            // Check interaction with sell point
            float sellDistance = calculateDistance(player.playerX, player.playerY, 1500, 800);
            if (sellDistance <= INTERACTION_RANGE_SHOP) {
                if (IsKeyDown(KEY_E)) {
                    Sell.sellWood();
                }
            }


            // Check interaction with trees
            for (int i = 0; i < trees.length; i++) {
                Tree tree = trees[i];
                float distance = calculateDistance(player.playerX, player.playerY, tree.treeX, tree.treeY);
                if (distance <= INTERACTION_RANGE) {
                    // Player is within range of the tree, add your interaction logic here
                    if (IsMouseButtonPressed(MOUSE_BUTTON_LEFT)) {
                        if (tree.health > 0) {
                            // Decrease health of the tree
                            tree.health -= player.currentDamage; // Adjust health decrease as needed
                            if (tree.health <= 0) {
                                // Chop down the tree and add random wood to player's inventory
                                player.wood += getRandomWoodAmount();
                                System.out.println("Tree chopped down! Wood added to player's inventory.");
                            }
                            System.out.println("Tree health: " + tree.health);
                            lastTime = System.currentTimeMillis(); // Reset lastTime when a chop occurs
                        } else {
                            // Tree is already dead, cannot be chopped further
                            System.out.println("This tree is already dead!");
                        }
                    }
                }
            }

            // Update time since last chop
            long currentTime = System.currentTimeMillis();
            long elapsedTime = (currentTime - lastTime) / 1000; // Convert milliseconds to seconds

            for (int i = 0; i < trees.length; i++) {
                if (trees[i].health < 100) {
                    trees[i].health += elapsedTime / CHOP_COOLDOWN; // Increment health based on elapsed time
                    trees[i].health = Math.min(100, trees[i].health); // Ensure health doesn't exceed maximum
                }
            }

            // Draw
            BeginDrawing();
            ClearBackground(BROWN);

            DrawTexturePro(texShop, new Jaylib().Rectangle(0, 0, texShop.width(), texShop.height()),
                    new Jaylib().Rectangle(1100, 200, texShop.width() * 7, texShop.height() * 7),
                    new Jaylib.Vector2(0, 0), 0, WHITE);

            DrawTexturePro(texSell, new Jaylib().Rectangle(0, 0, texSell.width(), texSell.height()),
                    new Jaylib().Rectangle(1250, 700, texSell.width() * 7, texSell.height() * 7),
                    new Jaylib.Vector2(0, 0), 0, WHITE);

            for (Tree tree : trees) {
                tree.draw();
            }

            player.drawPlayer(texPlayer);

            if (shop.isShopUI) shop.ShopUi();

            //Player ui
            DrawText("Wood: " + player.wood, 20, 20, 30, DARKBROWN);
            DrawText("Gold: " + player.gold, 20, 50, 30, GOLD);
            DrawText("Axe Tier: " + player.axeTier, 20, 80, 30, GRAY);


            if (exitWindowRequested) {
                DrawRectangle(0, 0, screenWidth, screenHeight, BLACK);
                DrawText("Are you sure you want to exit Pine-Ville? [Y/N]", 350, 500, 50, WHITE);
            }

            if (IsKeyPressed(KEY_GRAVE)) Debug.debug = !Debug.debug;

            if (Debug.debug) Debug.Load();


            EndDrawing();
        }

        // De-Initialization
        //--------------------------------------------------------------------------------------
        CloseWindow(); // Close window and OpenGL context
        //--------------------------------------------------------------------------------------

        return;
    }

    private static void initializeTrees() {
        trees = new Tree[25];
        for (int i = 0; i < trees.length; i++) {
            float x = GetRandomValue(0, 700 - 1);
            float y = GetRandomValue(0, 1080 - 1);
            trees[i] = new Tree(x, y);
            System.out.println("Tree " + i + " position: (" + x + ", " + y + ")");
        }
    }

    // Method to calculate distance between two points
    private static float calculateDistance(float x1, float y1, float x2, float y2) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    // Method to get a random amount of wood when a tree is chopped down
    private static int getRandomWoodAmount() {
        return GetRandomValue(WOOD_MIN_AMOUNT, WOOD_MAX_AMOUNT);
    }
}
