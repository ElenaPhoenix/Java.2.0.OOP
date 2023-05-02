package java.org.example.units;

import java.util.ArrayList;
import java.util.Random;

import java.org.example.Position;

public class Mags extends BaseHero {
    protected int manna;
        public Mags(float hp, String name, Position position, int attack, int[] damage, int armor, int manna, int priority) {
            super(hp, name, position, attack, damage, armor, priority);
            this.manna = manna;
        }
        public void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy) {
            BaseHero nearOwn = findNearPerson(arrayFriend);

            }
    
        
        @Override
        public String getInfo() {
            return this.getClass().getSimpleName();
        }
        @Override
        public String toString() {
            return name +
                    " Hp:" + Math.round(hp) +
                    " Arm:" + armor +
                    " Att:" + attack +
                    " Dmg:" + Math.round(Math.abs((damage[0] + damage[1])/2)) +
                    " Man:" + manna +
                    " " + state;
        }
    }