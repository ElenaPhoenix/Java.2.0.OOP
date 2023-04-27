package units;

public class Peasant extends BaseHero {
    int giveArrows;
    int chance;

    public Peasant(String name) {
        super(80, name, "крестьянин", 4, 6, 0, new int[]{0, 0});
        giveArrows=1;
        chance=90;
    }
}