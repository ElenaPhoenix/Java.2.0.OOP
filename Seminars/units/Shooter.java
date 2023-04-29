package units;

public abstract class Shooter extends BaseHero {
    int arrows; // количество стрел
    int accuracy; // меткость

    public Shooter(float hp, int x, int y, int armor, int[] damage) {
        super(hp, x, y, armor, damage);
        this.accuracy=accuracy;
        this.arrows=arrows;
    }

}
