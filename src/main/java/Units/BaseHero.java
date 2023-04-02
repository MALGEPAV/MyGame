package Units;
import Aux.Pos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public abstract class BaseHero implements GameInterface {
    public String name;
    protected boolean isDead;

    public Pos pos;
    protected int strength, maxStrength;
    protected int armor, maxArmor;
    protected int armorBreak;
    protected BaseHero targetHero;

    public BaseHero(String name, Pos pos, int strength, int maxStrength, int armor, int maxArmor, int armorBreak) {
        this.name = name;
        this.isDead = false;
        this.pos = pos;
        this.strength = strength;
        this.maxStrength = maxStrength;
        this.armor = armor;
        this.maxArmor = maxArmor;
        this.armorBreak = armorBreak;
        this.targetHero = null;
    }

    protected void Die() {
        System.out.println(this.getInfo() + " dies a horrible death...");
        this.isDead = true;
    }

    protected void getStrengthDamage(int dmg) {
        this.strength -= Math.min(dmg, this.strength);
        if (strength == 0) this.Die();
    }

    protected void getArmorDamage(int armorDmg) {
        this.armor -= Math.min(armorDmg, this.armor);
    }

    protected void getHealing(int healPoints) {
        this.strength += Math.min(healPoints, this.maxStrength - this.strength);
    }

    protected void getArmorMending(int armorPoints) {
        this.armor += Math.min(armorPoints, this.maxArmor - this.armor);
    }

    @Override
    public void turn(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allies) {
    }

    @Override
    public String toString() {
        return this.getInfo()+" "+this.pos.toString();
    }

    public BaseHero nearestAliveEnemy(ArrayList<BaseHero> enemies){
        PriorityQueue<BaseHero> aliveEnemies = new PriorityQueue<>(new Comparator<BaseHero>() {
            @Override
            public int compare(BaseHero h1, BaseHero h2) {
                if (h1.isDead) return 1;
                if (h2.isDead) return -1;
                if (pos.distanceFrom(h1.pos)>pos.distanceFrom(h2.pos)) return 1;
                return  -1;
            }
        });
        aliveEnemies.addAll(enemies);
        return aliveEnemies.poll();
    }
}
