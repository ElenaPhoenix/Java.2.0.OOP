package units;

public class Sniper extends Shooters {
    public Sniper(String name, Position position) {
        super(150, name, position, 10, new int[]{10, 13}, 70, 70, 10, 10);
    }
}