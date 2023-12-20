package jav;

import java.util.ArrayList;
import jav.units.BaseHero;

public interface GameInterface {
    void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy);

    String getInfo();
}