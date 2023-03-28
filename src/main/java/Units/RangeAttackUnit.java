package Units;

import java.util.Random;

public abstract class RangeAttackUnit extends BaseHero {
    protected int projectiles, maxProjectiles;
    protected int accuracy;
    public RangeAttackUnit(int projectiles, int maxProjectiles, int accuracy, String name, int x, int y, int strength, int maxStrength, int armor, int maxArmor, int armorBreak) {
        super(name,x,y,strength,maxStrength,armor,maxArmor,armorBreak);
        this.projectiles = projectiles;
        this.maxProjectiles = maxProjectiles;
        this.accuracy = accuracy;
    }
    protected abstract void rangeStrengthAttack(BaseHero hero);
    protected void rangeArmorAttack(BaseHero targetHero){
        if (new Random().nextInt(1,101)<=this.accuracy) {
            targetHero.getArmorDamage(this.armorBreak);
        } else {
            System.out.println(this.name +" misses...");
        }
    }
    protected void replenishProjectiles(int newProjectiles) {
        this.projectiles += Math.min(newProjectiles, this.maxProjectiles-this.projectiles);
    }
}
