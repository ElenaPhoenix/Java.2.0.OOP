package java.org.example;

import java.org.example.units.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static ArrayList<BaseHero> holyTeam = new ArrayList<>();
    static ArrayList<BaseHero> darkTeam = new ArrayList<>();
    static ArrayList<BaseHero> allTeam = new ArrayList<>();

    public static void main(String[] args) {
        Additionally.getList(holyTeam, 1);// вызов статического метода, обращаемся к классу!
        // holyTeam.forEach(n -> System.out.println(n.getInfo() + " " + n.getName() + "
        // (здоровье " + n.getHp() + ")"));
        Additionally.getList(darkTeam, 10);
        // darkTeam.forEach(n -> System.out.println(n.getInfo() + " " + n.getName() + "
        // (здоровье " + n.getHp() + ")"));
        allTeam.addAll(holyTeam);
        allTeam.addAll(darkTeam);
        allTeam.sort(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero o1, BaseHero o2) {
                if (o1.getPriority() == o2.getPriority()) {
                    return (int) (o1.getHp() / o1.getMaxHp() - o2.getHp() / o2.getMaxHp());
                }
                return o1.getPriority() - o2.getPriority();
            }
        });
        Scanner scanner = new Scanner(System.in);
        while (true) {
            View.view();
            for (BaseHero hero : allTeam) {
                if (holyTeam.contains(hero))
                    hero.step(holyTeam, darkTeam);
                else {
                    hero.step(darkTeam, holyTeam);
                }
            }
            scanner.nextLine();
        }
    }
}