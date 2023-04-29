import units.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) { // public - модификатор видимости, static - java запишет в память класс и у даст ему адрес, по адресу метод можно вызвать

        ArrayList<BaseHero> hero = new ArrayList<>();
        for (int i = 0; i <10;i++) {
            switch (new Random().nextInt(7)) {
                case 0:
                    hero.add(new Arbalester(""));
                    break;
                case 1:
                    hero.add(new Magician(""));
                    break;
                case 2:
                    hero.add(new Spearman(""));
                    break;
                case 3:
                    hero.add(new Peasant(""));
                    break;
                case 4:
                    hero.add(new Sniper(""));
                    break;
                case 5:
                    hero.add(new Priest(""));
                    break;
                default:
                    hero.add(new Thief(""));
            }
    }
    hero.forEach((n) -> System.out.println(n.name+" "+n.getInfo()));
}
}