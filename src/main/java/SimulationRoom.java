import Units.*;

import java.util.ArrayList;
import java.util.Random;

public class SimulationRoom {
    public static void main(String[] args) {
        ArrayList<BaseHero> team1 = new ArrayList<>();
        ArrayList<BaseHero> team2 = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            switch (r.nextInt(7)) {
                case 0 -> team1.add(new CrossBowman(getName(), r.nextInt(), r.nextInt()));
                case 1 -> team1.add(new Mage(getName(), r.nextInt(), r.nextInt()));
                case 2 -> team1.add(new Monk(getName(), r.nextInt(), r.nextInt()));
                case 3 -> team1.add(new Peasant(getName(), r.nextInt(), r.nextInt()));
                case 4 -> team1.add(new Raider(getName(), r.nextInt(), r.nextInt()));
                case 5 -> team1.add(new Sniper(getName(), r.nextInt(), r.nextInt()));
                default -> team1.add(new SpearMan(getName(), r.nextInt(), r.nextInt()));
            }
            switch (r.nextInt(7)) {
                case 0 -> team2.add(new CrossBowman(getName(), r.nextInt(), r.nextInt()));
                case 1 -> team2.add(new Mage(getName(), r.nextInt(), r.nextInt()));
                case 2 -> team2.add(new Monk(getName(), r.nextInt(), r.nextInt()));
                case 3 -> team2.add(new Peasant(getName(), r.nextInt(), r.nextInt()));
                case 4 -> team2.add(new Raider(getName(), r.nextInt(), r.nextInt()));
                case 5 -> team2.add(new Sniper(getName(), r.nextInt(), r.nextInt()));
                default -> team2.add(new SpearMan(getName(), r.nextInt(), r.nextInt()));
            }
        }
        System.out.println("TEAM 1:");
        team1.forEach(n -> System.out.println(n.getInfo()));
        System.out.println("-".repeat(20));
        System.out.println("TEAM 2:");
        team2.forEach(n -> System.out.println(n.getInfo()));
    }
    static private String getName(){
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
}
