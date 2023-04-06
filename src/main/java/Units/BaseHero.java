package Units;
import Aux.Pos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public abstract class BaseHero implements GameInterface {
    public String name;
    protected String state;

    public Pos pos;
    protected int strength, maxStrength;
    protected int armor, maxArmor;
    protected int armorBreak;
    protected BaseHero targetHero;

    public int initiative;

    public BaseHero(String name, Pos pos, int strength, int maxStrength, int armor, int maxArmor, int armorBreak, int initiative) {
        this.name = name;
        this.state = "ready";
        this.pos = pos;
        this.strength = strength;
        this.maxStrength = maxStrength;
        this.armor = armor;
        this.maxArmor = maxArmor;
        this.armorBreak = armorBreak;
        this.targetHero = null;
        this.initiative = initiative;
    }

    protected void Die() {
        System.out.println(this.getInfo() +" "+this.name+" dies a horrible death...");
        this.state = "dead";
    }

    protected void getStrengthDamage(int dmg) {
        System.out.println(this.getInfo()+" "+this.name+" gets "+Math.min(dmg, this.strength)+" str dmg");
        this.strength -= Math.min(dmg, this.strength);
        if (strength == 0) this.Die();
    }

    protected void getArmorDamage(int armorDmg) {
        System.out.println(this.getInfo()+" "+this.name+" gets "+Math.min(armorDmg, this.armor)+" arm dmg");
        this.armor -= Math.min(armorDmg, this.armor);
    }

    protected void getHealing(int healPoints) {
        this.strength += Math.min(healPoints, this.maxStrength - this.strength);
    }

    @Override
    public void turn(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allies) {
        if (this.state.equals("dead")) {
            System.out.println(this.name + " is very very dead...");
            return;
        }
    }

    @Override
    public String toString() {
        return this.getInfo()+" "+this.name+" pos: "+this.pos.toString()+
                " init: "+this.initiative+" Str:"+this.strength+"("+this.maxStrength+")"+
                " Arm:"+this.armor+"("+this.maxArmor+") "+this.state;
    }

    public BaseHero nearestAliveEnemy(ArrayList<BaseHero> enemies){
        PriorityQueue<BaseHero> aliveEnemies = new PriorityQueue<>(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero h1, BaseHero h2) {
                if (h1.state.equals("dead")) return 1;
                if (h2.state.equals("dead")) return -1;
                if (pos.distanceFrom(h1.pos)>pos.distanceFrom(h2.pos)) return 1;
                return  -1;
            }
        });
        aliveEnemies.addAll(enemies);
        return aliveEnemies.poll();
    }
    public float getStrPerc(){
        return (float)this.strength/(float)this.maxStrength;
    }
}
