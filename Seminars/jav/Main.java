package jav;

import java.util.Scanner;

public class Main {
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        Additionally additionally = new Additionally();
        additionally.setTeams(10);
        additionally.setTurnOrder();
        View view = new View(additionally);

        view.view();
        System.out.println("'1' - START\n'2' - GO OUT");
        while (myScanner.nextLine().equals("1")) {
            additionally.gameTurn();

            additionally.setTurnOrder();
            additionally.turnCount++;
            view.view();
            if (additionally.teamOneDead()) {
                System.out.println("LightSide WINS");
                break;
            }
            if (additionally.teamTwoDead()) {
                System.out.println("DarkSide WINS");
                break;
            }
            System.out.println("'1' - NEXT\n'2' - EXIT");
        }
        System.out.println("THE END...");
    }

}
