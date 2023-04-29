package units;

import java.util.ArrayList;

public interface GameInterface {
    void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy);
    String getInfo();
}