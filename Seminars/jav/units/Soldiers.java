package jav.units;

import java.util.ArrayList;
import java.util.Random;

import jav.Position;

public class Soldiers extends BaseHero {
    public Soldiers(float hp, String name, Position position, int attack, int[] damage, int armor, int priority) {
        super(hp, name, position, attack, damage, armor, priority);
        
    }


    protected void meleeAttack() {
        if ((float) (this.hp - this.targetHero.armor) / (float) this.targetHero.hp >= 0.2){
            System.out.println(this.getInfo() + " " + this.name +
                    " attacks ♥️ of " + this.targetHero.getInfo() + this.targetHero.name);
            this.targetHero.gethpDamage(Math.max(this.hp - this.targetHero.armor, 0));
        }else{
            System.out.println(this.getInfo() + this.name +
                    " attacks \uD83D\uDEE1 of " + this.targetHero.getInfo() + " " + this.targetHero.name);
            // this.targetHero.getArmorDamage(this.armorBreak);
        }
    }
    protected void moveTowardsTarget(ArrayList<BaseHero> allies){
        Position dir = this.position.directionTo(this.targetHero.position);
        Position primaryDestination;
        Position secondaryDestination;
        if (Math.abs(dir.x) > Math.abs(dir.y)) {
            primaryDestination = new Position(this.position.x + (int) Math.signum(dir.x), this.position.y);
            secondaryDestination = new Position(this.position.x, this.position.y + (int) Math.signum(dir.y));
        } else {
            secondaryDestination = new Position(this.position.x + (int) Math.signum(dir.x), this.position.y);
            primaryDestination = new Position(this.position.x, this.position.y + (int) Math.signum(dir.y));
        }
        if (isVacant(primaryDestination, allies)) {
            this.position = primaryDestination;
            System.out.println(this.getInfo()+this.name+" "+"makes a resolute step towards "
                    +this.targetHero.getInfo()+this.targetHero.name);
        }
        else if (isVacant(secondaryDestination, allies)) {
            this.position = secondaryDestination;
            System.out.println(this.getInfo()+this.name+" makes a resolute step towards "
                    +this.targetHero.getInfo()+this.targetHero.name);
        }
        else {
            System.out.println(this.getInfo()+this.name+" is waiting anxiously for the right moment");
        }
    }

    protected boolean isVacant(Position position, ArrayList<BaseHero> arrayFriend){
        for (BaseHero ally :
                arrayFriend) {
            if ((ally.position==position) && (ally.state!=State.dead)) return false;
        }
        return true;
    }

    @Override
    public void step(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allies) {
        super.step(enemies, allies);
        if (this.state!=State.dead) return;
        this.targetHero = this.nearestAliveEnemy(enemies);
        this.moveTowardsTarget(allies);
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