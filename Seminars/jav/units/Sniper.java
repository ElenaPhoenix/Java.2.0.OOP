package jav.units;

import java.util.Random;

import jav.Position;

public class Sniper extends Shooters {
    public Sniper(String name, Position position) {
        super(150, name, position, 10, new int[] { 10, 13 }, 70, 70, 10, 10);
    }
    @Override
    public void attackTarget() {
        if (new Random().nextInt(100)+1 <= this.accuracy) {
            if ((float) (this.hp- this.targetHero.armor) / (float) this.targetHero.hp >= 0.5){
                System.out.println(this.getInfo() + " " + this.name +
                        " attacks ♥️ of " + this.targetHero.getInfo() + this.targetHero.name);
                this.targetHero.getStrengthDamage(Math.max(this.hp - this.targetHero.armor, 0));
            }else{
                System.out.println(this.getInfo() + " " + this.name +
                        " attacks \uD83D\uDEE1 of " + this.targetHero.getInfo() + this.targetHero.name);
                // this.targetHero.getArmorDamage(this.armorBreak);
            }
        } else {
            System.out.println(this.getInfo() + this.name + " misses "+
                    "trying to attack "+this.targetHero.getInfo()+" "+this.targetHero.name);
        }

    }
    @Override
    public String getInfo() {
        return "Sniper ";
    }
}