package java.org.example.units;

import java.util.ArrayList;

import java.org.example.Position;

public class Peasant extends BaseHero {

    public Peasant(String name, Position position) {
        super(50, name, position, 0, new int[] { 0, 0 }, 20, 2);
    }

    @Override
    public void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy) {
        // System.out.println("Ходит " + getInfo() + " " + getName());
        if (state == State.dead)
            return;
        state = State.stand;
    }

    @Override
    public String getInfo() {
        return this.getClass().getSimpleName();
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