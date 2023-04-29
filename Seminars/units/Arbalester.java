package units;

import weapons.Weapons;

public class Arbalester extends Shooter {
    // int arrows; // количество болтов
    // int accuracy; // меткость

    public Arbalester(String name) {
        super(150, 6, 1, 10, new int[]{14, 17});
        // arrows = 10;
        // accuracy = 60; // %
    }
    @Override
    public String getInfo() {
        return "арбалетчик";
    }
}