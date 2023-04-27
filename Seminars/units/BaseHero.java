//  Создать абстрактный класс персонажей
package units;

import weapons.Weapons;

public abstract class BaseHero { //это абстрактный класс, не может содержать объекты этого класса, противоположность final
    public String name;
    protected String className;
    protected int x, y; // координаты на карте
    // private final int atk; // атака
    // private final int def; // защита
    protected float hp,maxHp;

    protected int armor;
    protected int[] damage;
    protected Weapons weapons;

    @Override
    public String toString() {
        return name+" "+className+" здоровье: "+hp+" броня: "+armor+" ";
    }

/**
 * Конструктор базового персонажа. Конструктор должен быть public и ничего не возвращать
 * @param hp здоровье
 * @param name имя
 * @param className название класса
 * @param x координата на местности х
 * @param y координата на местности y
 * @param armor броня
 * @param damage урон
 */
    public BaseHero(float hp, String name, String className, int x, int y, int armor, int[] damage) {
        this.hp = hp;
        this.name = name;
        this.className=className;
        this.x = x;
        this.y = y;
        this.armor = armor;
        this.damage = damage;
    }

    // protected int getInt(){
    //     return 1;
    // }
}



// import java.util.Random;

// public class BaseHero {
//     protected static int number;
//     protected static Random r;

//     protected String name;
//     protected int hp;
//     protected int maxHp;

//     static {
//         BaseHero.number = 0;
//         BaseHero.r = new Random();
//     }
//     public BaseHero(String name, int hp) {
//         this.name = name;
//         this.hp = hp;
//         this.maxHp = hp;
//     }
//     public BaseHero() {
//         this(String.format("Hero_Priest #%d", ++BaseHero.number),
//         BaseHero.r.nextInt(100, 200));
//     }
//     public String getInfo() {
//         return String.format("Name: %s  Hp: %d  Type: %s",
//                 this.name, this.hp, this.getClass().getSimpleName());
//     }
//     public void healed(int Hp) {
//         this.hp = Hp + this.hp > this.maxHp ? this.maxHp : Hp + this.hp;
//     }
//     public void GetDamage(int damage) {
//         if (this.hp - damage > 0) {
//             this.hp -= damage;
//         }
//         // else { die(); }
//     }
// public void Attack(BaseHero target) {
//     int damage = BaseHero.r.nextInt(10, 20);
//     target.GetDamage(damage);
// }
// }
