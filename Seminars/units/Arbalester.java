package units;

import weapons.Weapons;

public class Arbalester extends BaseHero {
    int arrows; // количество болтов
    int accuracy; // меткость

    public Arbalester(String name) {
        super(150, name, "арбалетчик", 6, 1, 10, new int[]{14, 17});
        arrows = 10;
        accuracy = 60; // %
    }
}