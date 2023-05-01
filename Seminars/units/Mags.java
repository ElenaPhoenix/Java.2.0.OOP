package units;

import java.util.ArrayList;
import java.util.Random;

public class Mags extends BaseHero {
    protected int manna;
        public Mags(float hp, String name, Position position, int attack, int[] damage, int armor, int manna, int priority) {
            super(hp, name, position, attack, damage, armor, priority);
            this.manna = manna;
        }
        public void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy) {
            BaseHero nearOwn = findNearPerson(arrayFriend);
            if (nearOwn.getHp() > 0 & nearOwn.getHp() < nearOwn.getMaxHp()) {
                Random r = new Random();
                nearOwn.takeHealth(r.nextInt(damage[0], damage[1] + 1));
                manna -= 1;
            }
    
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