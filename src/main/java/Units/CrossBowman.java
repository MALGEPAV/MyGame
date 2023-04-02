package Units;
import Aux.Pos;

import javax.swing.text.Position;
import java.util.ArrayList;
import java.util.Random;

public class CrossBowman extends RangeAttackUnit {
    private final int WEAPONDAMAGE;
    @Override
    protected void rangeStrengthAttack(BaseHero targetHero) {
        if (new Random().nextInt()<=this.accuracy) targetHero.getStrengthDamage(this.WEAPONDAMAGE-targetHero.armor);
        else System.out.println(this.name + " misses...");
    }
    public CrossBowman(String name, Pos pos) {
        super(15,15,85,name,pos,10,10,10,10,3);
        this.WEAPONDAMAGE = 10;
    }
    @Override
    public String getInfo() {
        return "Арбалетчик "+this.name;
    }

    @Override
    public void turn(ArrayList<BaseHero> enemies, ArrayList<BaseHero> allies) {
        super.turn(enemies, allies);
        if ((float)(this.WEAPONDAMAGE-targetHero.armor)/ (float)targetHero.strength >= 0.2)
            this.rangeStrengthAttack(targetHero);
        else this.rangeArmorAttack(targetHero);
    }
}
