package PineVille;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import static com.raylib.Jaylib.*;
import static com.raylib.Raylib.*;
public class Axe {
    protected String name;
    int damage;
    float price;

    public Axe (String name, int damage, float price)
    {
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

}
