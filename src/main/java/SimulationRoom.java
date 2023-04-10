
import java.util.Scanner;

public class SimulationRoom {
    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {
       Game game = new Game();
       game.setTeams(4);
       game.setTurnOrder();
       View view = new View(game);
       view.view();
       System.out.println("'1' - НАЧАТЬ СРАЖЕНИЕ\n'2' - МИРНО РАЗОЙТИСЬ");
       while (myScanner.nextLine().equals("1")) {
           game.gameTurn();
           game.setTurnOrder();
           game.turnCount++;
           view.view();
           System.out.println("'1' - СЛЕДУЮЩИЙ ХОД\n'2' - ЗАКОНЧИТЬ");
       }
        System.out.println("конец...");
    }

}
