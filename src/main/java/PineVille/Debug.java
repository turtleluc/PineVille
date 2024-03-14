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
        DrawText("Debug ", 1550, 10, 30, RED);
        DrawFPS(1550, 50);
        DrawText("Player Position (" + player.playerX + " , " + player.playerY + ")", 1550, 90, 20, LIME);
        DrawText("Player Speed (" + player.moveSpeed + ")", 1550, 130, 20, LIME);

        if (IsWindowState(FLAG_FULLSCREEN_MODE)) DrawText("FullScreen: on", 1550, 170, 20, LIME);
        else DrawText("FullScreen: off", 1550, 170, 20, MAROON);

        DrawText("< to open shop ", 1550, 250, 20, DARKGRAY);
        DrawText("^ to add wood ", 1550, 290, 20, DARKGRAY);
        DrawText("v to add gold ", 1550, 330, 20, DARKGRAY);
        DrawText("> to converte wood to gold", 1550, 370, 20, DARKGRAY);
        DrawText("(" + sell.woodToGoldRate +" gold per wood)", 1550, 450, 20, ORANGE);
        DrawText("([Null]-[Null] wood per tree)", 1550, 490, 20, ORANGE);
    }

    public static void Commands()
    {
        if (IsKeyDown(KEY_UP)) {
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
