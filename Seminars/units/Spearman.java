package units;

import java.util.ArrayList;

public class Spearman extends BaseHero {

    public Spearman(String name) {
        super(150, 3, 6, 20, new int[]{15, 20});
    }
    @Override
    public String getInfo() {
        return "копейщик";
    }

    @Override
    public void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy) {

    }
}