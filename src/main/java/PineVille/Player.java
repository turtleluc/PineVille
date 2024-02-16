
package PineVille;

import com.raylib.Jaylib;
import com.raylib.Raylib.Vector2;
import com.raylib.Raylib.Color;
import com.raylib.Raylib.Texture;

import static com.raylib.Raylib.*;
import static com.raylib.Raylib.ToggleFullscreen;

public class Player extends Entity {

    int screenWidth = 1920;
    int screenHeight = 1080;
    private Vector2 position;
    private Color color;

    int wood = 0;
    int gold = 0;

    float playerX = screenWidth / 2;
    float playerY = screenHeight / 2;
    float moveSpeed;

    public Player(Vector2 position, Color color) {
        this.position = position;
        this.color = color;
    }

    public void Move(float moveSpeed)
    {
        this.moveSpeed = moveSpeed;

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
    }

    public void drawPlayer(Texture texture)
    {
    DrawTexturePro(texture, new Jaylib().Rectangle(0, 0,texture.width(), texture.height()),
            new Jaylib().Rectangle(playerX, playerY, texture.width() * 2, texture.height() * 2),
            new Jaylib.Vector2(0, 0), 0, Jaylib.WHITE);
    }



    // Getter methods if needed
}
