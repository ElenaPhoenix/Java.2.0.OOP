package java.units;

import java.util.ArrayList;
import java.util.Random;

import java.Position;

public class Mags extends BaseHero {
    protected int manna;

    public Mags(float hp, String name, Position position, int attack, int[] damage, int armor, int manna,
            int priority) {
        super(hp, name, position, attack, damage, armor, priority);
        this.manna = manna;
    }

    public void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy) {
        BaseHero nearOwn = findNearPerson(arrayFriend);
        if (nearOwn.getHp() > 0 & nearOwn.getHp() < nearOwn.getMaxHp()) {
            Random r = new Random();
            nearOwn.takeHealth(r.nextInt(damage[0], damage[1] + 1));
            manna -= 1;
        }
    }

    @Override
    public String getInfo() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return name +
                " \u2665: " + Math.round(hp) +
                " \u1F6E1: " + armor +
                " \u1F5E1: " + attack +
                " \u2694: " + Math.round(Math.abs((damage[0] + damage[1]) / 2)) +
                " \u267B: " + manna +
                " \u1F6B6: " + state;
    }
}