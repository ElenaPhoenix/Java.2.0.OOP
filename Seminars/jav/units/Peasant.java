package jav.units;

import java.util.ArrayList;

import jav.Position;

public class Peasant extends BaseHero {

    public Peasant(String name, Position position) {
        super(50, name, position, 0, new int[] { 0, 0 }, 20, 2);
    }


    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allies) {
        super.step(enemies,allies);
        if (this.state!=State.dead) 
        state = State.ready;
    }

    @Override
   
    public String getInfo() {
        return "Peasant ";
    }

    @Override
    public String toString() {
        return name +
                " \u2665: :" + Math.round(hp) +
                " \u1F6E1: " + armor +
                " \u1F5E1: " + attack +
                " \u2694: " + " 0 " +
                " \u1F6B6: " + state;
    }
}