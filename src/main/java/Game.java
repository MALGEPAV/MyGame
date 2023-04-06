import Aux.Pos;
import Units.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Game {
     private ArrayList<BaseHero> team1;
     private ArrayList<BaseHero> team2;
     private PriorityQueue<BaseHero> turnOrder;
     private int turnCount;

    private void setTeams(){
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
    private void showTeams(){
        System.out.println("-".repeat(20));
        System.out.println("TEAM1:");
        this.team1.forEach(n -> System.out.println(n));
        System.out.println("-".repeat(20));
        System.out.println("TEAM2:");
        this.team2.forEach(n -> System.out.println(n));
        System.out.println("-".repeat(20));
    }
    private void setTurnOrder(){
        this.turnOrder = new PriorityQueue<>(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero h1, BaseHero h2) {
                if (h1.initiative==h2.initiative) {
                    if (h2.getStrPerc()>h1.getStrPerc()) return 1;
                    else return -1;
                }
            return h2.initiative-h1.initiative;
            }
        });
        this.turnOrder.addAll(this.team1);
        this.turnOrder.addAll(this.team2);
    }
    private void gameTurn(){
         while (!this.turnOrder.isEmpty()){
             if (this.team1.contains(this.turnOrder.peek()))
                 this.turnOrder.poll().turn(this.team2, this.team1);
             else this.turnOrder.poll().turn(this.team1, this.team2);
         }
    }

    public void play(){
         this.setTeams();
         this.showTeams();
         this.setTurnOrder();
         this.gameTurn();
         this.showTeams();
    }

    private String getName(){
        return Names.values()[new Random().nextInt(Names.values().length)].toString();
    }
}
