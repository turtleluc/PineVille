package PineVille;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;
public class Tree extends Entity {
    int health = 0;
    Texture texDown = LoadTexture("resources/SpriteTreeStump.png");
    public void threeDown()
    {
        if ( health <= 0)
        {
            changeTexture(texDown);
        }
    }

}
