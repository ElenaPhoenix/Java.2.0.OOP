package jav.units;

import jav.Position;

public class Priest extends Mags {

    public Priest(String name, Position position) {
        super(100, name, position, 0, new int[] { 5, 8 }, 50, 55, 6);
    }
    @Override
public String getInfo() {
    return "Priest ";
}
}
