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
        });}
    
        
    private static int step = 1;
    private static final int[] l = { 0 };

    private static void tabSetter(int cnt, int max) {
        int dif = max - cnt + 2;
        if (dif > 0)
            System.out.printf("%" + dif + "s", ":\t");
        else
            System.out.print(":\t");
    }
            
    private static String getChar(int x, int y) {
        String out = "| ";
        for (BaseHero human : teamAll) {
            if (human.getCoord()[0] == x && human.getCoord()[1] == y) {
                if (human.getHp() == 0) {
                    out = "|" + human.getInfo().charAt(0);
                    break;
                }
                if (teamOwn.contains(human)) {
                    out = "|" + human.getInfo().charAt(0);
                }
                if (teamEnemy.contains(human)) {
                    out = "|" + human.getInfo().charAt(0);
                    break;
                }
            }
            return out;
        }}
    

    public static void view() {
                        if (step == 1) {
                            System.out.print("First step");
                        } 
                        else {
                            System.out.print("Step:" + step);
                        }
                        step++;
                    
                        teamAll.forEach((v) -> l[0] = Math.max(l[0], v.toString().length()));
                        System.out.print("_".repeat(l[0] * 2));
                        System.out.println(" ");
    
                        System.out.print("Red side");
                        // for (int i = 0; i < l[0]-9; i++)
                        System.out.print(" ".repeat(l[0] - 9));
                        System.out.println(":\tGreen side");
                        for (int i = 1; i < 11; i++) {
                            System.out.print(getChar(1, i));
                        }
                        System.out.print("|    ");
                        System.out.print(teamOwn.get(0));
                        tabSetter(teamOwn.get(0).toString().length(), l[0]);
                        System.out.println(teamEnemy.get(0));
                    
                        for (int i = 2; i < 10; i++) {
                            for (int j = 1; j < 11; j++) {
                            System.out.print(getChar(i, j));
                            }
                        System.out.print("|    ");
                        System.out.print(teamOwn.get(i - 1));
                        tabSetter(teamOwn.get(i - 1).toString().length(), l[0]);
                        System.out.println(teamEnemy.get(i - 1));

                    }
                    for (int j = 1; j < 11; j++) {
                        System.out.print(getChar(10, j));
                    }
                    System.out.print("|    ");
                    System.out.print(teamOwn.get(9));
                    tabSetter(teamOwn.get(9).toString().length(), l[0]);
                    System.out.println(teamEnemy.get(9));
    }
    
        Scanner scanner = new Scanner(System.in);{
            while (true) {
                view();
    
    for(BaseHero hero:teamAll){
        if (teamOwn.contains(hero)) {
            hero.step(teamOwn, teamEnemy);
        } 
        else {
            hero.step(teamEnemy, teamOwn);
        }
    }scanner.nextLine();
            

            }
}