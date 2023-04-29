package units;

public class Arbalester extends Shooter {
    // int arrows; // количество болтов
    // int accuracy; // меткость

    public Arbalester(String name) {
        super(150, name, position, 10, new int[]{14, 17}, 70, 85, 10, 10);
        // arrows = 10;
        // accuracy = 60; // %
    }
    @Override
    public String getInfo() {
        return "арбалетчик";
    }
}