package java.org.example.units;

import java.util.ArrayList;

import java.org.example.Position;

public class Peasant extends BaseHero {

    public Peasant(String name, Position position) {
        super(50, name, position, 0, new int[]{0, 0}, 20, 2);
    }

    @Override
    public void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy) {
        //System.out.println("Ходит " + getInfo() + " " + getName());
        if (state == State.dead) return;
        state = State.stand;
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
                " Dmg: 0 " +
                " " + state;
    }}