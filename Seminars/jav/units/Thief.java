package jav.units;

import java.util.ArrayList;
import java.util.Random;

import jav.Position;

public class Thief extends Soldiers {
    int trick; // хитрость
    int chance;

    public Thief(String name, Position position) {
        super(150, name, position, 20, new int[] { 8, 12 }, 75, 8);

        // this.trick=trick;
    }

    @Override
    public String getInfo() {
        return "Thief ";
    }
}