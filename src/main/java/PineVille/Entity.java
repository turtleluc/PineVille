package PineVille;

import com.raylib.Raylib;
/*import com.raylib.Raylib.Texture2D;*/
import com.raylib.Raylib.Vector2;

import static com.raylib.Jaylib.WHITE;
import static com.raylib.Raylib.DrawTexture;


public class Entity {
    protected Raylib.Texture texture;
    protected Vector2 position;
    protected Vector2 size;


    public void draw() {
        DrawTexture(texture, (int)position.x(), (int)position.y(), WHITE);
    }
}

