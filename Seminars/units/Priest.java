package units;

import java.util.ArrayList;

public class Priest extends BaseHero{
    // protected int mana;
    // protected ArrayList<SpellBook> spellsBook;

    public Priest(String name) {
        super (100, 6, 2, 8, new int[] {5, 8});
        // mana=100;
        // spellsBook.add(new Spells("Hill"));
    }
    @Override
    public String getInfo() {
        return "монах";
    }

    @Override
    public void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy) {

    }
}
