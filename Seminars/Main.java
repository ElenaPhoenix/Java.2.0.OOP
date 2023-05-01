import units.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.text.View;

public class Main {
    static ArrayList<BaseHero> teamOwn = new ArrayList<>();
    static ArrayList<BaseHero> teamEnemy = new ArrayList<>();
    static ArrayList<BaseHero> teamAll = new ArrayList<>();

    public static void main(String[] args) { // public - модификатор видимости, static - java запишет в память класс и
                                             // даст ему адрес, по адресу метод можно вызвать

        Additionally.getList(teamOwn, 1); // вызов статического метода, обращаемся к классу!
        teamOwn.forEach(n -> System.out.println(n.getInfo() + " " + n.getName() + " здоровье: " + n.getHp()));
        System.out.println("===========");
        Additionally.getList(teamEnemy, 10);
        teamEnemy.forEach(n -> System.out.println(n.getInfo() + " " + n.getName() + " здоровье: " + n.getHp()));

        teamAll.addAll(teamOwn);
        teamAll.addAll(teamEnemy);

        teamAll.sort(new Comparator<BaseHero>() { // сортировка по приоритету
            @Override
            public int compare(BaseHero o1, BaseHero o2) {
                if (o1.getPriority() == o2.getPriority()) {
                    return (int) (o1.getHp() / o1.getMaxHp() - o2.getHp() / o2.getMaxHp());
                }
                return o1.getPriority() - o2.getPriority();
            }
        });
    }

    Scanner scanner = new Scanner(System.in);{
    while (true) {
    for(BaseHero hero:teamAll){
        if (teamOwn.contains(hero)) hero.step(teamOwn, teamEnemy);
        else hero.step(teamEnemy, teamOwn);
        }
        scanner.nextLine();
        }
        }