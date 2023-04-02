package Units;

import Aux.Pos;

import java.util.ArrayList;
import java.util.Random;

public abstract class RangeAttackUnit extends BaseHero {
    protected int projectiles, maxProjectiles;
    protected int accuracy;

    public RangeAttackUnit(int projectiles, int maxProjectiles, int accuracy, String name, Pos pos, int strength, int maxStrength, int armor, int maxArmor, int armorBreak) {
        super(name, pos, strength, maxStrength, armor, maxArmor, armorBreak);
        this.projectiles = projectiles;
        this.maxProjectiles = maxProjectiles;
        this.accuracy = accuracy;
    }

    protected abstract void rangeStrengthAttack(BaseHero targetHero);

    protected void rangeArmorAttack(BaseHero targetHero) {
        if (new Random().nextInt(1, 101) <= this.accuracy) {
            targetHero.getArmorDamage(this.armorBreak);
        } else {
            System.out.println(this.name + " misses...");
        }
    }

    protected void replenishProjectiles(int newProjectiles) {
        this.projectiles += Math.min(newProjectiles, this.maxProjectiles - this.projectiles);
    }

    @Override
    public void turn(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allies) {
        if (this.projectiles == 0) {
            System.out.println(this.name + " has nothing to shoot with...");
            return;
        }
        if (this.isDead) {
            System.out.println(this.name+" is very very dead...");
            return;
        }
        this.targetHero = this.nearestAliveEnemy(enemies);
    }
}
