package java.units;

import java.util.ArrayList;
import java.util.Random;

import java.Position;

public abstract class Shooters extends BaseHero {
    protected int arrows = 10, maxArrows; // количество стрел

    // public int getMaxArrows() {
    // return maxArrows;
    // }

    // public void setMaxArrows(int maxArrows) {
    // this.maxArrows = maxArrows;
    // }

    // public int getArrows() {
    // return arrows;
    // }

    // public void setArrows(int arrows) {
    // this.arrows = arrows;
    // }

    public Shooters(float hp, String name, Position position, int attack, int[] damage, int armor, int accuracy,
            int arrows, int priority) {
        super(hp, name, position, attack, damage, armor, priority);
        this.maxArrows = arrows;
        this.arrows = arrows;
    }

    public void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy) { // Описание возможных ходов
        System.out.println("Ходит " + getInfo() + " " + getName());
        if (state == State.dead)
            return;
        for (BaseHero friend : arrayFriend) { // Ходы своей команды
            if (friend.getClass().getSimpleName().equals("Peasant") && friend.getState().equals(State.stand)) { // крестьянин
                                                                                                                // прибавляет
                                                                                                                // 1
                                                                                                                // стрелу
                friend.state = State.busy;
                arrows++;
                System.out.println("Нашел крестьянина, стрел стало " + arrows);
                break;
            }
        }

        if (arrows > 0) { // При наличии у стрелка стрел атака ближайшего врага
            BaseHero nearEnemy = findNearPerson(arrayEnemy);
            // .out.println("Найден ближайший противник: " + nearEnemy.getInfo() + " " +
            // getName());
            if (nearEnemy.getHp() > 0) {
                Random r = new Random();
                nearEnemy.getDamage(r.nextInt(damage[0], damage[1] + 1)); // урон противника
                arrows--;
            }
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
                " \u27B6: " + arrows +
                " \u1F6B6: " + state;
    }
}