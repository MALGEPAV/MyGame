
import java.util.Scanner;

public class SimulationRoom {
    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {
       Game game = new Game();
       game.setTeams(2);
       game.setTurnOrder();
       View view = new View(game);

       view.view();
       System.out.println("'1' - НАЧАТЬ СРАЖЕНИЕ\n'2' - МИРНО РАЗОЙТИСЬ");
       while (myScanner.nextLine().equals("1")) {
           game.gameTurn();

           game.setTurnOrder();
           game.turnCount++;
           view.view();
           if (game.teamOneDead()) {
               System.out.println("TEAM2 WINS\nGame Over...");
               break;
           }
           if (game.teamTwoDead()) {
               System.out.println("TEAM1 WINS\nGame Over...");
               break;
           }
           System.out.println("'1' - СЛЕДУЮЩИЙ ХОД\n'2' - ЗАКОНЧИТЬ");
       }
        System.out.println("конец...");
    }


}
