package jav.units;

import jav.Position;

public class Spearman extends Soldiers {
    private int spear;

    public int getSpear() {
        return spear;
    }

    public void setSpear(int spear) {
        this.spear = spear;
    }

    public Spearman(String name, Position position) {
        super(150, name, position, 20, new int[] { 15, 20 }, 85, 8);
        // spear = 10;
    }
    @Override
    public String getInfo() {
        return "Spearman ";
    }
}