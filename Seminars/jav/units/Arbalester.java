package jav.units;

import java.util.Random;

import jav.Position;

public class Arbalester extends Shooters {
    public Arbalester(String name, Position position) {
        super(150, name, position, 10, new int[] { 14, 17 }, 70, 60, 10, 10);
    }

    @Override
    public void attackTarget() {
        if (new Random().nextInt(100)+1 <= this.accuracy) {
            if ((float) (this.targetHero.armor) / (float) this.targetHero.hp >= 0.5){
                System.out.println(this.getInfo() + " " + this.name +
                        " attacks ♥️ of " + this.targetHero.getInfo() + this.targetHero.name);
                this.targetHero.getStrengthDamage(Math.max(this.targetHero.armor, 0));
            }else{
                System.out.println(this.getInfo() + " " + this.name +
                        " attacks \uD83D\uDEE1 of " + this.targetHero.getInfo() + " " + this.targetHero.name);
                // this.targetHero.getArmorDamage(this.armorBreak);
            }
        } else {
            System.out.println(this.getInfo() +this.name + " misses trying to attack "
                    +this.targetHero.getInfo()+this.targetHero.name);
        }

    }

    @Override
    public String getInfo() {
        return "Arbalester ";
    }

}