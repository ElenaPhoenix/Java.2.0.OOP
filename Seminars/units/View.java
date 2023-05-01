// package units;

// public class View {
//     public static void view() {
//         if (step == 1 ){
//             System.out.print(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
//         } else {
//             System.out.print(AnsiColors.ANSI_RED + "Step:" + step + AnsiColors.ANSI_RESET);
//         }
//         step++;
//         ClientCode.teamAll.forEach((v) -> l[0] = Math.max(l[0], v.toString().length()));
//         System.out.print("_".repeat(l[0]*2));
//         System.out.println(" ");
//         System.out.print(top10 + "    ");
//         System.out.print("Blue side");
//         //for (int i = 0; i < l[0]-9; i++)
//         System.out.print(" ".repeat(l[0]-9));
//         System.out.println(":\tGreen side");
//         for (int i = 1; i < 11; i++) {
//             System.out.print(getChar(1, i));
//         }
//         System.out.print("|    ");
//         System.out.print(Main.teamOwn.get(0));
//         tabSetter(ClientCode.teamOwn.get(0).toString().length(), l[0]);
//         System.out.println(ClientCode.teamEnemy.get(0));
//         System.out.println(midl10);

//         for (int i = 2; i < 10; i++) {
//             for (int j = 1; j < 11; j++) {
//                 System.out.print(getChar(i, j));
//             }
//             System.out.print("|    ");
//             System.out.print(ClientCode.teamOwn.get(i-1));
//             tabSetter(ClientCode.teamOwn.get(i-1).toString().length(), l[0]);
//             System.out.println(ClientCode.teamEnemy.get(i-1));
//             System.out.println(midl10);
//         }
//         for (int j = 1; j < 11; j++) {
//             System.out.print(getChar(10, j));
//         }
//         System.out.print("|    ");
//         System.out.print(ClientCode.teamOwn.get(9));
//         tabSetter(ClientCode.teamOwn.get(9).toString().length(), l[0]);
//         System.out.println(ClientCode.teamEnemy.get(9));
//         System.out.println(bottom10);
//     }
// }

    
// }
