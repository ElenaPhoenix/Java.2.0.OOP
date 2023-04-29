package units;

public class Peasant extends BaseHero {
    // int giveArrows;
    // int chance;

    public Peasant(String name) {
        super(80, 4, 6, 0, new int[]{0, 0});
        // giveArrows=1;
        // chance=90;
    }
    @Override
    public String getInfo() {
        return "крестьянин";
    }
    @Override
    public void step() {
    }
}