package jav.units;

import java.util.ArrayList;
import java.util.Random;

import jav.Position;

public abstract class Shooters extends BaseHero {
    protected int arrows = 10, maxArrows; // количество стрел
    protected int accuracy;


    public Shooters(float hp, String name, Position position, int attack, int[] damage, int armor, int accuracy,
            int arrows, int priority) {
        super(hp, name, position, attack, damage, armor, priority);
        this.maxArrows = 10;
        this.arrows = arrows;
        this.accuracy=accuracy;
    }

    protected abstract void attackTarget();

    @Override
    public void step(ArrayList<BaseHero> arrayEnemy, ArrayList<BaseHero> arrayFriend) {
        super.step(arrayEnemy, arrayFriend);
        if (this.state==State.dead) return;
        if (this.arrows == 0) {
            System.out.println(this.name + " has nothing to shoot with...");
            return;
        }
        this.targetHero = this.nearestAliveEnemy(arrayEnemy);
        this.attackTarget();
        this.arrows--;
        for (BaseHero Friend :
                arrayFriend) {
            if ((Friend instanceof Peasant) && (Friend.state==State.ready)) {
                this.arrows++;
                System.out.println(this.getInfo()+" "+this.name+" receives a projectile from "+Friend.getInfo()+" "+Friend.name);
                State busy;
                break;
            }
        }
    }
    
    // public void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy) { // Описание возможных ходов
    //     System.out.println("Ходит " + getInfo() + " " + getName());
    //     if (state == State.dead)
    //         return;
    //     for (BaseHero friend : arrayFriend) { // Ходы своей команды
    //         if (friend.getClass().getSimpleName().equals("Peasant") && friend.getState().equals(State.stand)) { // крестьянин
    //                                                                                                             // прибавляет
    //                                                                                                             // 1
    //                                                                                                             // стрелу
    //             friend.state = State.busy;
    //             arrows++;
    //             System.out.println("Нашел крестьянина, стрел стало " + arrows);
    //             break;
    //         }
    //     }

    //     if (arrows > 0) { // При наличии у стрелка стрел атака ближайшего врага
    //         BaseHero nearEnemy = findNearPerson(arrayEnemy);
    //         // .out.println("Найден ближайший противник: " + nearEnemy.getInfo() + " " +
    //         // getName());
    //         if (nearEnemy.getHp() > 0) {
    //             Random r = new Random();
    //             nearEnemy.getDamage(r.nextInt(damage[0], damage[1] + 1)); // урон противника
    //             arrows--;
    //         }
    //     }
    // }

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