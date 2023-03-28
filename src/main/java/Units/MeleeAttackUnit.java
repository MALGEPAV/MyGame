package Units;

public abstract class MeleeAttackUnit extends BaseHero {
    protected int attackRange;

    public MeleeAttackUnit(int attackRange, String name, int x, int y, int strength, int maxStrength, int armor, int maxArmor, int armorBreak) {
        super(name, x, y, strength, maxStrength, armor, maxArmor, armorBreak);
        this.attackRange = attackRange;
    }

    protected boolean withinAttackRange(BaseHero targetHero) {
        return this.distanceFrom(targetHero) <= this.attackRange;
    }

    protected void meleeStrengthAttack(BaseHero targetHero) {
        if (this.withinAttackRange(targetHero)) targetHero.getStrengthDamage(Math.max(0,this.strength-targetHero.armor));
        else System.out.println("Too far for " + this.name + "...");
    }
    protected void meleeArmorAttack(BaseHero targetHero) {
        if (this.withinAttackRange(targetHero)) targetHero.getArmorDamage(this.armorBreak);
        else System.out.println("Too far for " + this.name + "...");
    }

}
