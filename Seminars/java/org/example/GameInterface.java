package java.org.example;

import java.util.ArrayList;
import java.org.example.units.BaseHero;

public interface GameInterface {
    void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy);
    String getInfo();
}