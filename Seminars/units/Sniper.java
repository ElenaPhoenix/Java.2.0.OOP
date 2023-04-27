package units;

import weapons.Weapons;

public class Sniper extends BaseHero {
    int arrows; // количество стрел
    int accuracy; // меткость

    public Sniper(String name) {
        super(150, name, "лучник", 6, 1, 10, new int[]{10, 13});
        arrows = 10;
        accuracy = 70; // %
    }
}