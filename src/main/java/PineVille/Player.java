package PineVille;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import static com.raylib.Jaylib.WHITE;
import static com.raylib.Raylib.*;

public class Player extends Entity {
    protected int wood;
    protected int gold;

    public Player(Jaylib.Vector2 position, Jaylib.Vector2 size, Raylib.Texture texture) {
        super();
        this.position = position;
        this.size = size;
        this.texture = texture;
//        this.wood = 0;
//        this.gold = 0;
    }

    // Getters and setters for wood and gold counts
    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public void draw() {
        DrawTexture(texture, (int)position.x(), (int)position.y(), WHITE);
        DrawText("Wood: " + wood, (int)position.x() - 40, (int)position.y() - 30, 20, Jaylib.DARKBROWN);
        DrawText("Gold: " + gold, (int)position.x() - 40, (int)position.y() - 10, 20, Jaylib.GOLD);
    }
}
