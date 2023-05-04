package java.units;

import java.util.ArrayList;
import java.util.Random;

import java.Position;

public class Thief extends Soldiers {
    int trick; // хитрость
    int chance;

    public Thief(String name, Position position) {
        super(150, name, position, 20, new int[] { 8, 12 }, 75, 8);

        // this.trick=trick;
    }

    public void trickStep(ArrayList<BaseHero> arrayEnemy) { // Описание возможных ходов
        System.out.println("Крадется " + getInfo() + " " + getName());
        if (state == State.dead)
            return;
        for (BaseHero enemy : arrayEnemy) { // Ходы своей команды // При наличии у стрелка стрел атака ближайшего врага
            BaseHero nearEnemy = findNearPerson(arrayEnemy);
            System.out.println("Найден ближайший противник: " + nearEnemy.getInfo() + " " + getName());
            // if (nearEnemy.position.distance(this.position) < 2 & nearEnemy.getHp() > 0) {
            // Random random = new Random(10);
            // trick = random.nextInt();
            // if(trick>5) {
            // nearEnemy.getDamage(5);
            // System.out.println(nearEnemy.getInfo() + " " + getName()+" получает скрытый
            // суперудар от разбойника");
            // }
            // }

        }
        return;
    }
}