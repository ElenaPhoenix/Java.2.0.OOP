//  Создать абстрактный класс персонажей
package units;

import java.util.ArrayList;

public abstract class BaseHero implements GameInterface { // это абстрактный класс, не может содержать объекты этого
                                                          // класса, противоположность final
    protected static int count;
    protected String name;
    protected static Position position; // координаты на карте
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
    //     this.hp = hp;
    // }

    public Float getMaxHp() {
        return maxHp;
    }

    // public void setMaxHp(Float maxHp) {
    //     this.maxHp = maxHp;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public int getAttack() {
    //     return attack;
    // }

    // public void setAttack(int attack) {
    //     this.attack = attack;
    // }

    // public int getArmor() {
    //     return armor;
    // }

    // public void setArmor(int armor) {
    //     this.armor = armor;
    // }


    public BaseHero(float hp, String name, Position position, int attack, int[] damage, int def, int priority) {
        this.hp = hp;
        this.maxHp = hp;
        this.name = name;
        this.position = position;
        this.attack = attack;
        this.damage = damage;
        this.armor = armor;
        this.damage = damage;
        this.priority = priority;
        this.state = State.stand;
    }

    public BaseHero(int i, int j, int k, int l, int[] ms) {
    }

    @Override
    public abstract void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy);
    @Override
    public String getInfo() {
        return this.getClass().getSimpleName() + " " + hp;
    }
    /*находит и возвращает ближайшего врага, принимает список*
    @param arrayEnemy
    * @return
    */
    public BaseHero findNearEnemy(ArrayList<BaseHero> arrayEnemy) {                                                  //Метод поиска ближайшего врага
    BaseHero nearEnemy = arrayEnemy.get(0);
    double distance = position.distance(arrayEnemy.get(0).position);
    double minDistance = distance;
    for (int i = 1; i < arrayEnemy.size(); i++) {
    if (arrayEnemy.get(i).hp <= 0) continue; // если неживой
    distance = position.distance(arrayEnemy.get(i).position);
    if (minDistance > distance) {
    minDistance = distance;
    nearEnemy = arrayEnemy.get(i);
    }
    }
    return nearEnemy;
    }

    protected void getDamage(float damage) {                                                                        // Метод нанесения урона
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
    public int[] getCoord() {
        return new int[]{position.getX(),position.getY()};
    }
}