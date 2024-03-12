package PineVille;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;
public class Axe {
    protected int tier;
    int damage;
    float price;

    public Axe (int tier, int damage, float price)
    {
        this.tier = tier;
        this.damage = damage;
        this.price = price;
    }

}
