package units;

import java.util.ArrayList;
import java.util.Random;

public abstract class Shooter extends BaseHero implements GameInterface {
    protected int accuracy; // меткость
    protected int arrows = 10, maxArrows; // количество стрел

    public int getMaxArrows() {
        return maxArrows;
    }

    public void setMaxArrows(int maxArrows) {
        this.maxArrows = maxArrows;
    }

    public int getArrows() {
        return arrows;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public Shooter(float hp, String name, Position position, int attack, int[] damage, int def, int accuracy,
            int arrows, int priority) {
        super(hp, name, position, attack, damage, def, priority);
        this.accuracy = accuracy;
        this.maxArrows = arrows;
        this.arrows = arrows;
    }

    public void step(ArrayList<BaseHero> arrayFriend, ArrayList<BaseHero> arrayEnemy) {                           // Описание возможных ходов
        System.out.println("Ходит " + getInfo() + " " + getName());
        if (state == State.dead)
            return; // Если мертвое состояние
        for (BaseHero friend : arrayFriend) { // Ходы своей команды
            if (friend.getClass().getSimpleName().equals("Peasant")) {                                  // крестьянин прибавляет 1 стрелу
                if (friend.getState().equals(State.stand)) {
                    friend.state = State.busy;
                    arrows++;
                }
            }
        }
        if (arrows > 0) {                                                                                       // При наличии у стрелка стрел атака ближайшего врага
            BaseHero closestEnemy = findNearEnemy(arrayEnemy);
            System.out.println("Найден ближайший противник: " + closestEnemy.getInfo() + " " + getName());
            shoot(closestEnemy);
        }
        System.out.println("Конец данного хода.");
    }

    private void shoot(BaseHero enemy) {                                                                        // Метод нанесения урона врагу
        Random r = new Random();
        enemy.getDamage(r.nextInt(damage[0], damage[1] + 1)); // урон противника
        arrows--;
    }

    private void checkPeasant() {                                                                               //Метод проверки наличия крестьянина                          
        if (1 > 0) {// если крестьянин есть
            return;
        } else {
            arrows--;
        }
    }
}