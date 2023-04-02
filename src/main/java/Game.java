import Aux.Pos;
import Units.*;

import java.util.ArrayList;
import java.util.Random;

public class Game {
     ArrayList<BaseHero> team1;
     ArrayList<BaseHero> team2;
    public void setTeams(){
        this.team1 = new ArrayList<>();
        this.team2 = new ArrayList<>();

        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            switch (r.nextInt(7)) {
                case 0 -> this.team1.add(new CrossBowman(getName(),new Pos(0,i)));
                case 1 -> this.team1.add(new Mage(getName(), new Pos(0,i)));
                case 2 -> this.team1.add(new Monk(getName(), new Pos(0,i)));
                case 3 -> this.team1.add(new Peasant(getName(), new Pos(0,i)));
                case 4 -> this.team1.add(new Raider(getName(), new Pos(0,i)));
                case 5 -> this.team1.add(new Sniper(getName(), new Pos(0,i)));
                default -> this.team1.add(new SpearMan(getName(),new Pos(0,i)));
            }
            switch (r.nextInt(7)) {
                case 0 -> this.team2.add(new CrossBowman(getName(), new Pos(9,i)));
                case 1 -> this.team2.add(new Mage(getName(),new Pos(9,i)));
                case 2 -> this.team2.add(new Monk(getName(), new Pos(9,i)));
                case 3 -> this.team2.add(new Peasant(getName(), new Pos(9,i)));
                case 4 -> this.team2.add(new Raider(getName(), new Pos(9,i)));
                case 5 -> this.team2.add(new Sniper(getName(), new Pos(9,i)));
                default -> this.team2.add(new SpearMan(getName(), new Pos(9,i)));
            }
        }
    }
    public void showTeams(){
        System.out.println("-".repeat(20));
        System.out.println("TEAM1:");
        this.team1.forEach(n -> System.out.println(n));
        System.out.println("-".repeat(20));
        System.out.println("TEAM2:");
        this.team2.forEach(n -> System.out.println(n));
        System.out.println("-".repeat(20));

    }
    private String getName(){
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
}
