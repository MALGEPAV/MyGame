package Units;
import Aux.Pos;

public abstract class SpellCaster extends BaseHero {
    protected int mana;
    protected  int maxMana;

    public SpellCaster(int mana, int maxMana, String name, Pos pos, int strength, int maxStrength, int armor, int maxArmor, int armorBreak, int initiative) {
        super(name, pos, strength, maxStrength, armor, maxArmor, armorBreak, initiative);
        this.mana = mana;
        this.maxMana = maxMana;
    }
    protected abstract void castSpell(BaseHero targetHero);
}
