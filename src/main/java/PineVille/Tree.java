package PineVille;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;
class Tree {
    float treeX ;
    float treeY;
    private int health;
    private Texture texTree;
    private Texture texLog;

    public Tree(float treeX, float treeY) {
        this.treeX = treeX;
        this.treeY = treeY;
        this.health = 100;
        this.texTree = LoadTexture("resources/SpriteTree.png");
        this.texLog = LoadTexture("resources/SpriteTreeStump.png");
    }

    public void draw() {
        if (health > 0) {
//            DrawTexture(texTree, (int) treeX, (int) treeY, WHITE);
            DrawTexturePro(texTree, new Jaylib().Rectangle(0, 0, texTree.width(), texTree.height()),
                    new Jaylib().Rectangle(treeX, treeY, texTree.width() * 4, texTree.height() * 4),
                    new Jaylib.Vector2(0, 0), 0, WHITE);
        } else {
//            DrawTexture(texLog, (int) treeX, (int) treeY, WHITE);
            DrawTexturePro(texLog, new Jaylib().Rectangle(0, 0, texTree.width(), texTree.height()),
                    new Jaylib().Rectangle(treeX, treeY, texTree.width() * 4, texTree.height() * 4),
                    new Jaylib.Vector2(0, 0), 0, WHITE);
        }
    }
}


