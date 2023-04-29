package units;

public class Sniper extends Shooter {
    public Sniper(String name) {
        super(150, 6, 1, 10, new int[]{10, 13});
        // arrows = 10;
        // accuracy = 70; // %
    }
    @Override
    public String getInfo() {
        return "лучник";
    }
}