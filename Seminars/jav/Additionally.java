package jav;

import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;
import java.util.PriorityQueue;

import jav.units.*;
import jav.units.BaseHero.State;

public class Additionally {
    public ArrayList<BaseHero> darkSide;
    public ArrayList<BaseHero> lightSide;
    public PriorityQueue<BaseHero> bothTeamsInTurnOrder;
    public int turnCount;
    public int teamSize;

    public void setTeams(int teamSize) {
        this.teamSize = teamSize;
        this.darkSide = new ArrayList<>();
        this.lightSide = new ArrayList<>();

        Random r = new Random();
        for (int i = 1; i <= this.teamSize; i++) {
            switch (r.nextInt(7)) {
                case 0:
                    this.darkSide.add(new Arbalester(getName(), new Position(1, i)));
                    break;
                case 1:
                    this.darkSide.add(new Magician(getName(), new Position(1, i)));
                    break;
                case 2:
                    this.darkSide.add(new Peasant(getName(), new Position(1, i)));
                    break;
                case 3:
                    this.darkSide.add(new Priest(getName(), new Position(1, i)));
                    break;
                case 4:
                    this.darkSide.add(new Spearman(getName(), new Position(1, i)));
                    break;
                case 5:
                    this.darkSide.add(new Sniper(getName(), new Position(1, i)));
                    break;
                default:
                    this.darkSide.add(new Thief(getName(), new Position(1, i)));
            }
            switch (r.nextInt(7)) {
                case 0:
                    this.lightSide.add(new Arbalester(getName(), new Position(this.teamSize, i)));
                    break;
                case 1:
                    this.lightSide.add(new Magician(getName(), new Position(this.teamSize, i)));
                    break;
                case 2:
                    this.lightSide.add(new Peasant(getName(), new Position(this.teamSize, i)));
                    break;
                case 3:
                    this.lightSide.add(new Priest(getName(), new Position(this.teamSize, i)));
                    break;
                case 4:
                    this.lightSide.add(new Spearman(getName(), new Position(this.teamSize, i)));
                    break;
                case 5:
                    this.lightSide.add(new Sniper(getName(), new Position(this.teamSize, i)));
                    break;
                default:
                    this.lightSide.add(new Thief(getName(), new Position(this.teamSize, i)));
            }
        }
    }

    public void setTurnOrder() {
        this.bothTeamsInTurnOrder = new PriorityQueue<>(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero h1, BaseHero h2) {
                if (h1.priority == h2.priority) {
                    if (h2.getStrPerc() > h1.getStrPerc())
                        return 1;
                    else
                        return -1;
                }
                return h2.priority - h1.priority;
            }
        });
        this.bothTeamsInTurnOrder.addAll(this.darkSide);
        this.bothTeamsInTurnOrder.addAll(this.lightSide);
    }

    public void gameTurn() {
        while (!this.bothTeamsInTurnOrder.isEmpty()) {
            if (this.darkSide.contains(this.bothTeamsInTurnOrder.peek()))
                this.bothTeamsInTurnOrder.poll().step(this.lightSide, this.darkSide);
            else
                this.bothTeamsInTurnOrder.poll().step(this.darkSide, this.lightSide);
        }
    }

    public boolean teamOneDead() {
        for (BaseHero hero : this.darkSide) {
            if (hero.state != State.dead)
                return false;
        }
        return true;
    }

    public boolean teamTwoDead() {
        for (BaseHero hero : this.lightSide) {
            if (hero.state != State.dead)
                return false;
        }
        return true;
    }

    private String getName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
}