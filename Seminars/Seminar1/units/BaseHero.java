//  Создать абстрактный класс персонажей
package org.example.units;

public abstract class BaseHero { //это абстрактный класс, не может содержать объекты этого класса, противоположность final
    float hp,maxHp;
    String name;
    int x, y; // координаты на карте
    int atk; // атака
    int def; // защита
    int[] damage;

    public BaseHero(float hp, String name, int x, int y, int atk, int def, int[] damage) {
        this.hp = hp;
        this.maxHp = hp;
        this.name = name;
        this.x = x;
        this.y = y;
        this.atk = atk;
        this.def = def;
        this.damage = damage;
    }

    // protected int getInt(){
    //     return 1;
    // }


}
