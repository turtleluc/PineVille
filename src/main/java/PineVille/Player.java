
package PineVille;

import com.raylib.Raylib.Vector2;
import com.raylib.Raylib.Color;
import com.raylib.Raylib.Texture;

import static com.raylib.Raylib.DrawTexture;

public class Player {
    private Vector2 position;
    private Color color;

    int wood;
    int gold;

    public Player(Vector2 position, Color color) {
        this.position = position;
        this.color = color;

    }

    public void draw(Texture texture) {
        DrawTexture(texture, (int) position.x(), (int) position.y(), color);
    }

    // Getter methods if needed
}
