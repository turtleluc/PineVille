package PineVille;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;

public class Shop extends Entity {
    private Raylib.Vector2 position;
    private Raylib.Color color;

    public boolean isShopUI;

    int screenWidth = 1920;
    int screenHeight = 1080;

    Player player;


    public Shop(Raylib.Vector2 position, Raylib.Color color, Player player) {
        this.position = position;
        this.color = color;
        this.player = player;

    }

    public void ShopUi() {
        DrawRectangle(0, 0, screenWidth, screenHeight, BROWN);

        // Calculate starting x position for the row of buttons
        int totalButtonWidth = 4 * 100; // Total width of all buttons (4 buttons each with width 100)
        int totalSpacing = 3 * 50; // Total spacing between buttons (3 spaces between 4 buttons)
        int startX = (screenWidth - (totalButtonWidth + totalSpacing)) / 2;

        // Adjust the starting x position to center the buttons
        startX -= 75;

        // Draw buttons
        if (GuiButton(new Jaylib.Rectangle(startX, screenHeight/2, 100, 50), "Buy")) {
            if (player.gold >= 100 && player.axeTier <= 1) {
                player.gold -= 100;
                player.axeTier = 2;
            }
        }
        DrawText("Tier 2 (100 gold)", startX, screenHeight/2 - 50, 20, WHITE);

        if (GuiButton(new Jaylib.Rectangle(startX + 200, screenHeight/2, 100, 50), "Buy")) {
            if (player.gold >= 300 && player.axeTier <= 2) {
                player.gold -= 300;
                player.axeTier = 3;
            }
        }
        DrawText("Tier 3 (300 gold)", startX + 200, screenHeight/2 - 50, 20, WHITE);

        if (GuiButton(new Jaylib.Rectangle(startX + 400, screenHeight/2, 100, 50), "Buy")) {
            if (player.gold >= 750 && player.axeTier <= 3) {
                player.gold -= 750;
                player.axeTier = 4;
            }
        }
        DrawText("Tier 4 (750 gold)", startX + 400, screenHeight/2 - 50, 20, WHITE);

        if (GuiButton(new Jaylib.Rectangle(startX + 600, screenHeight/2, 100, 50), "Buy")) {
            if (player.gold >= 1500 && player.axeTier <= 4) {
                player.gold -= 1500;
                player.axeTier = 5;
            }
        }
        DrawText("Tier 5 (1500 gold)", startX + 600, screenHeight/2 - 50, 20, WHITE);

        if (GuiButton(new Jaylib.Rectangle(1800, 20, 50, 50), "X")) {
            isShopUI = !isShopUI;
        }
    }


}
