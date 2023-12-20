package jav.units;

import jav.Position;

public class Magician extends Mags {

    public Magician(String name, Position position) {
        super(100, name, position, 0, new int[] { 0, 0 }, 45, 50, 6);
    }

@Override
public String getInfo() {
    return "Magician ";
}}