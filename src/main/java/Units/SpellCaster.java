package Units;

public abstract class SpellCaster extends BaseHero {
    protected int mana;
    protected  int maxMana;

    public SpellCaster(int mana, int maxMana, String name, int x, int y, int strength, int maxStrength, int armor, int maxArmor, int armorBreak) {
        super(name, x, y, strength, maxStrength, armor, maxArmor, armorBreak);
        this.mana = mana;
        this.maxMana = maxMana;
    }
    protected abstract void castSpell(BaseHero targetHero);
}
