package units;

import java.util.ArrayList;

public class Magician extends BaseHero{
    // protected int mana;
    // protected ArrayList<SpellBook> spellsBook;

    public Magician(String name) {
        super (100, 2, 6, 5, new int[] {7, 10});
        // mana=100;
        // spellsBook.add(new Spells("Hill"));
    }
    @Override
    public String getInfo() {
        return "маг";
    }
}
