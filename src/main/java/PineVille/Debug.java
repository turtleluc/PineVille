package PineVille;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;

public class Debug {

    static Boolean debug = false;
    static Player player;
    static Sell sell;

    public Debug(Player player, Sell sell) {
        this.player = player;
        this.sell = sell;
    }

    public static void Load() {
        DrawText("Debug ", 1500, 10, 30, RED);
        DrawFPS(1500, 50);
        DrawText("Player Position (" + player.playerX + " , " + player.playerY + ")", 1500, 90, 20, LIME);
        DrawText("Player Speed (" + player.moveSpeed + ")", 1500, 130, 20, LIME);

        if (IsWindowState(FLAG_FULLSCREEN_MODE)) DrawText("FullScreen: on", 1500, 170, 20, LIME);
        else DrawText("FullScreen: off", 1500, 170, 20, MAROON);
    }

    public static void Commands()
    {
        if (IsKeyPressed(KEY_UP)) {
            player.wood++;
        }

        if (IsKeyDown(KEY_DOWN)) {
            player.gold++;
        }

        if (IsKeyDown(KEY_RIGHT)) {
            Sell.sellWood();
        }
    }

}
