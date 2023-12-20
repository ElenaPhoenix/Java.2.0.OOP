//  Создать абстрактный класс персонажей
package jav.units;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import jav.GameInterface;
import jav.Position;

public abstract class BaseHero implements GameInterface { // это абстрактный класс, не может содержать объекты этого
                                                          // класса, противоположность final
    // protected static int count;
    protected String name;
    public Position position; // координаты на карте
    protected float hp, maxHp;

    protected int attack;
    protected int armor;
    protected int[] damage;
    // protected Weapons weapons;
    public int priority;

    public enum State {
        stand, busy, dead, ready
    };

    public State state;

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



    public Float getMaxHp() {
        return maxHp;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    protected BaseHero targetHero;


    public BaseHero(float hp, String name, Position position, int attack, int[] damage, int armor, int priority) {
        this.hp = hp;
        this.maxHp = hp;
        this.name = name;
        this.position = position;
        this.attack = attack;
        this.damage = damage;
        this.armor = armor;
        this.priority = priority;
        this.state = State.ready;
    }

    @Override
    public void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy){
    if (this.state==State.dead) System.out.println(this.getInfo()+" "+this.name+" is very very dead...");
    }

protected void Die() {
        System.out.println(this.getInfo()+this.name+" dies a horrible death...");
        this.state = State.dead;
    }

    protected void getStrengthDamage(float f) {
        if (f<0) {
            System.out.println(this.getInfo()+this.name+" restores "+Math.min(-f,this.hp)+" ♥️ ");
            this.hp += Math.min(-f,this.hp);

        }else {

            System.out.println(this.getInfo() + this.name + " gets " + Math.min(f, this.hp) + " ♥️ dmg");
            this.hp -= Math.min(f, this.hp);
            if (hp == 0) this.Die();
        }
    }

    protected void getArmorDamage(int armorDmg) {
        System.out.println(this.getInfo()+this.name+" gets "+Math.min(armorDmg, this.armor)+" \uD83D\uDEE1 dmg");
        this.armor -= Math.min(armorDmg, this.armor);
    }

    protected void getHealing(int healPoints) {
        this.hp += Math.min(healPoints, this.hp);
    }

    public BaseHero nearestAliveEnemy(ArrayList<BaseHero> enemies){
        PriorityQueue<BaseHero> aliveEnemies = new PriorityQueue<>(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero h1, BaseHero h2) {
                if (h1.state==State.dead) return 1;
                if (h1.state==State.dead) return -1;
                if (position.distanceFrom(h1.position)>position.distanceFrom(h2.position)) return 1;
                return  -1;
            }
        });
        aliveEnemies.addAll(enemies);
        return aliveEnemies.poll();
    }
    public float getStrPerc(){
        return (float)this.hp/(float)this.maxHp;
    }
    
    private String getStateSymbol(){
        switch (this.state){
            case dead: return "☠️";
            case ready: return "\uD83D\uDC40";
            case busy: return "⏱️";
            default: return "Who am I? Where am I?";
        }
    }

    public void gethpDamage(float max) {
    }
}

