
package PineVille;

import com.raylib.Raylib.Vector2;
import com.raylib.Raylib.Color;
import com.raylib.Raylib.Texture;

import static com.raylib.Raylib.DrawTexture;

public class Player extends Entity {
    private Vector2 position;
    private Color color;

    int wood = 0;
    int gold = 0;

    public Player(Vector2 position, Color color) {
        this.position = position;
        this.color = color;

    }



    // Getter methods if needed
}
