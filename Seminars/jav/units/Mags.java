package jav.units;

import java.util.ArrayList;
import java.util.Random;

import jav.Position;

public class Mags extends BaseHero {
    protected int manna, maxManna;

    public Mags(float hp, String name, Position position, int attack, int[] damage, int armor, int manna,
            int priority) {
        super(hp, name, position, attack, damage, armor, priority);
        this.manna = manna;
        this.maxManna=30;
    }

    public final int mannaCost = 5;

    public void Healing() {
        if (manna < 5) {
            System.out.println(getInfo() + this.name + " can't do anything useful...");
            return;
        }
        System.out.println(getInfo() + this.name + " heals"
                + this.targetHero.getInfo() + this.targetHero.name);
        manna -= mannaCost;

    }

    protected void pickTarget(ArrayList<BaseHero> ArrayEnemy, ArrayList<BaseHero> ArrayFriend) {
    }

    @Override
    public void step(ArrayList<BaseHero> ArrayEnemy, ArrayList<BaseHero> ArrayFriend) {
        super.step(ArrayEnemy, ArrayFriend);
        if (state == State.dead)
            return;
        if (manna < 5) {
            System.out.println(this.getInfo() + this.name + " hasn't got enough mana to cast anything...");
            return;
        }
        this.pickTarget(ArrayEnemy, ArrayFriend);

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
                " \u267B: " + manna + "(" + maxManna + ")" +
                " \u1F6B6: " + state;
    }
}