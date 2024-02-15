package PineVille;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;

public class Shop extends Entity {
    private Raylib.Vector2 position;
    private Raylib.Color color;



    public Shop(Raylib.Vector2 position, Raylib.Color color) {
        this.position = position;
        this.color = color;

    }


}
