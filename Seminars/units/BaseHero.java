//  Создать абстрактный класс персонажей
package units;

import java.util.Random;

import weapons.Weapons;

public abstract class BaseHero implements GameInterface { //это абстрактный класс, не может содержать объекты этого класса, противоположность final
    public String name;
    protected String className;
    protected int x, y; // координаты на карте
    // private final int atk; // атака
    // private final int def; // защита
    protected float hp,maxHp;

    protected int armor;
    protected int[] damage;
    protected Weapons weapons;

/**
 * Конструктор базового персонажа. Конструктор должен быть public и ничего не возвращать
 * @param hp здоровье
 * @param name имя персонажа
 * @param x координата на местности х
 * @param y координата на местности y
 * @param armor броня
 * @param damage урон
 */
    public BaseHero(float hp, int x, int y, int armor, int[] damage) {
        this.hp = hp;
        this.maxHp=hp;
        this.name = getName();
        this.x = x;
        this.y = y;
        this.armor = armor;
        this.damage = damage;
    }

@Override
public String getInfo(){
        return "";
    }

public String getName() {
    return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }

// @Override
// public String toString() {
//     return name+" здоровье: "+hp+" броня: "+armor+" ";
// }
}

