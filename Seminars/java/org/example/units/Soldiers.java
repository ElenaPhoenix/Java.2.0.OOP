package java.org.example.units;

import java.util.ArrayList;
import java.util.Random;

import java.org.example.Position;

public class Soldiers extends BaseHero {
    public Soldiers(float hp, String name, Position position, int attack, int[] damage, int armor, int priority) {
        super(hp, name, position, attack, damage, armor, priority);
    }

    @Override
    public void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy) {
        // System.out.println("Ходит пехота");
        if (state == State.dead)
            return;
        BaseHero nearEnemy = findNearPerson(arrayEnemy);
        if (nearEnemy.position.distance(this.position) < 2 & nearEnemy.getHp() > 0) {
            Random r = new Random();
            nearEnemy.getDamage(r.nextInt(damage[0], damage[1] + 2));
            return;
        }
        int xDis, yDis;
        xDis = (nearEnemy.position.getX() - this.position.getX());
        // System.out.println("enemyX = "+ nearEnemy.position.getX() + "own X " +
        // this.position.getX());
        yDis = (nearEnemy.position.getY() - this.position.getY());
        // System.out.println("enemyY = "+ nearEnemy.position.getY() + " own Y " +
        // this.position.getY());
        boolean flag = false;
        if (Math.abs(xDis) > Math.abs(yDis)) {
            int checkPos = (int) Math.signum(xDis);
            for (BaseHero hero : arrayFriend) {
                if (hero.position.getX() != this.position.getX() + checkPos) {
                    position.setX(checkPos);
                } else
                    flag = true;
            }
        }
        if (Math.abs(xDis) <= Math.abs(yDis) || flag) {
            position.setY((int) Math.signum(yDis));
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
                " \u1F6B6: " + state;
    }
}