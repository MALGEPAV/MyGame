import Units.*;
import java.util.ArrayList;
import java.util.Random;

public class SimulationRoom {
    public static void main(String[] args) {
       Game game = new Game();
       game.setTeams();
       game.showTeams();
        for (BaseHero unit :
                game.team1) {
            if (unit instanceof RangeAttackUnit)
                System.out.println("Ближайший живой враг к стрелку "+unit.getInfo()+" это "+unit.nearestAliveEnemy(game.team2).getInfo());
        }
    }
}
