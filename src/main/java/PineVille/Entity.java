package PineVille;

import com.raylib.Raylib;
/*import com.raylib.Raylib.Texture2D;*/
import com.raylib.Raylib.Vector2;

import static com.raylib.Jaylib.WHITE;
import static com.raylib.Raylib.DrawTexture;


public class Entity {

    private Vector2 position;
    private Raylib.Color color;

    protected Raylib.Rectangle rectangle;
    public void draw(Raylib.Texture texture) {
        DrawTexture(texture, (int) position.x(), (int) position.y(), color);
    }
}

