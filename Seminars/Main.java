import units.BaseHero;
import units.Magician;
import units.Sniper;
import units.Spearman;
import units.Arbalester;
import units.Priest;
import units.Thief;
import units.Peasant;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) { // public - модификатор видимости, static - java запишет в память класс и у даст ему адрес, по адресу метод можно вызвать

        ArrayList<BaseHero> hero = new ArrayList<>();
        hero.add(new Arbalester("Беркут"));
        hero.add(new Magician("Рассеиватель Мрака"));
        hero.add(new Spearman("Разящий"));
        hero.add(new Peasant("Добряк"));

        hero.add(new Sniper("Сокол"));
        hero.add(new Priest("Темный Лорд"));
        hero.add(new Thief("Лис"));
        hero.add(new Peasant("Раб"));

        hero.forEach(n -> System.out.println(n));

    }
}