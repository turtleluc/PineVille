package PineVille;

import com.raylib.Jaylib;
import com.raylib.Raylib.Vector2;
import com.raylib.Raylib.Color;
import com.raylib.Raylib.Texture;

import static com.raylib.Raylib.*;
import static com.raylib.Raylib.ToggleFullscreen;
public class Sell {
    static int woodToGoldRate = 3;

     static Player player;

    public Sell(Player player) {
        this.player = player;
    }
    public static void sellWood() {
        if (player.wood > 0) {
            player.gold += woodToGoldRate;
            player.wood--;
        }
    }
}
