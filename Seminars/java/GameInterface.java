package java;

import java.util.ArrayList;
import java.units.BaseHero;

public interface GameInterface {
    void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy);

    String getInfo();
}