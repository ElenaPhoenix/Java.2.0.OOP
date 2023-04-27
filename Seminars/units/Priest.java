package units;

import java.util.ArrayList;

import spells.Spells;

public class Priest extends BaseHero{
    protected int mana;
    protected ArrayList<Spells> spellsBook;

    public Priest(String name) {
        super (100, name, "монах", 6, 2, 8, new int[] {5, 8});
        mana=100;
        // spellsBook.add(new Spells("Hill"));
    }
}


// import units.BaseHero;

// public class Priest extends BaseHero {

//     private int elixir;
//     private int maxElixir;

//     public Priest() {
//         super(String.format("Hero_Priest #%d", ++Magician.number),
//                 Magician.r.nextInt(100, 200));
//         this.maxElixir = Magician.r.nextInt(50, 150);
//         this.elixir = maxElixir;
//     }
    
//     public String getInfo() {
//         return String.format("%s  Elixir: %d", super.getInfo(), this.elixir);
//     }
// }
