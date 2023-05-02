package java.org.example;

import java.util.ArrayList;
import java.util.Random;

import java.org.example.units.*;

public class Additionally {
    public static ArrayList<BaseHero> getList(ArrayList<BaseHero> arrayList, int y1) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            switch (random.nextInt(7)) {
                case 0 -> arrayList.add(new Arbalester(getRandomName(), new Position(i + 1, y1)));
                case 1 -> arrayList.add(new Magician(getRandomName(), new Position(i + 1, y1)));
                case 2 -> arrayList.add(new Peasant(getRandomName(), new Position(i + 1, y1)));
                case 3 -> arrayList.add(new Priest(getRandomName(), new Position(i + 1, y1)));
                case 4 -> arrayList.add(new Sniper(getRandomName(), new Position(i + 1, y1)));
                case 5 -> arrayList.add(new Spearman(getRandomName(), new Position(i + 1, y1)));
                default -> arrayList.add(new Thief(getRandomName(), new Position(i + 1, y1)));
            }
        }
        return arrayList;
    }

    public static String getRandomName() {
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
}
