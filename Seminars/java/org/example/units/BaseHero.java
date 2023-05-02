//  Создать абстрактный класс персонажей
package java.org.example.units;

import java.util.ArrayList;

import java.org.example.GameInterface;
import java.org.example.Position;

public abstract class BaseHero implements GameInterface { // это абстрактный класс, не может содержать объекты этого
                                                          // класса, противоположность final
    // protected static int count;
    protected String name;
    protected Position position; // координаты на карте
    protected float hp, maxHp;

    protected int attack;
    protected int armor;
    protected int[] damage;
    // protected Weapons weapons;
    protected int priority;

    protected enum State {
        stand, busy, dead
    };

    protected State state;

    public State getState() {
        return state;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public Float getHp() {
        return hp;
    }

    // public void setHp(Float hp) {
    // this.hp = hp;
    // }

    public Float getMaxHp() {
        return maxHp;
    }

    // public void setMaxHp(Float maxHp) {
    // this.maxHp = maxHp;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public int getAttack() {
    // return attack;
    // }

    // public void setAttack(int attack) {
    // this.attack = attack;
    // }

    // public int getArmor() {
    // return armor;
    // }

    // public void setArmor(int armor) {
    // this.armor = armor;
    // }

    public BaseHero(float hp, String name, Position position, int attack, int[] damage, int armor, int priority) {
        this.hp = hp;
        this.maxHp = hp;
        this.name = name;
        this.position = position;
        this.attack = attack;
        this.damage = damage;
        this.armor = armor;
        this.priority = priority;
        this.state = State.stand;
    }

    @Override
    public abstract void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> teamPerson);

    @Override
    public String getInfo() {
        return this.getClass().getSimpleName();
    }

    /*
     * находит и возвращает ближайшего врага, принимает список*
     * 
     * @param teamPerson
     * 
     * @return
     */
    public BaseHero findNearPerson(ArrayList<BaseHero> teamPerson) { // Метод поиска ближайшего врага
        BaseHero nearPerson = teamPerson.get(0);
        double distance = position.distance(teamPerson.get(0).position);
        double minDistance = distance;
        for (int i = 1; i < teamPerson.size(); i++) {
            if (teamPerson.get(i).hp <= 0)
                continue; // если неживой
            distance = position.distance(teamPerson.get(i).position);
            if (minDistance > distance) {
                minDistance = distance;
                nearPerson = teamPerson.get(i);
            }
        }
        return nearPerson;
    }

    protected void getDamage(float damage) { // Метод нанесения урона
        hp -= damage;
        if (hp <= 0) {
            state = State.dead;
        }
    }

    protected void takeHealth(float damage) {
        hp += damage;
        if (hp >= maxHp) {
            hp = maxHp;
        }
    }

    public int[] getCoords() {
        return new int[] { position.getX(), position.getY() };
    }

//     @Override
//     public String toString() {
//         return name +
//                 " \u2665: " + Math.round(hp) +
//                 " \u1F6E1: " + armor +
//                 " \u1F5E1: " + attack +
//                 " \u2694: " + Math.round(Math.abs((damage[0] + damage[1]) / 2)) +
//                 " \u1F6B6: " + state;
//     }
}