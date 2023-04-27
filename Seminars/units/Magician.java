package units;

import java.util.ArrayList;

import spells.Spells;

public class Magician extends BaseHero{
    protected int mana;
    protected ArrayList<Spells> spellsBook;

    public Magician(String name) {
        super (100, name, "маг", 2, 6, 5, new int[] {7, 10});
        mana=100;
        // spellsBook.add(new Spells("Hill"));
    }
}



// public class Magician extends BaseHero {

//     private int mana;
//     private int maxMana;

//     public Magician() {
//         super(String.format("Hero_Magician #%d", ++Magician.number),
//                 Magician.r.nextInt(100, 200));
//         this.maxMana = Magician.r.nextInt(50, 150);
//         this.mana = maxMana;
//     }

//     public String getInfo() {
//         return String.format("%s  Mana: %d",super.getInfo(), this.mana);
//     }
// }