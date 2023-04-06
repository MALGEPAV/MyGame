package Units;
import Aux.Pos;

import javax.swing.text.Position;

public class Mage extends SpellCaster {
    public Mage(String name, Pos pos) {

        super(20,20,name,pos,7,7,7,7,0, 6);
    }

    @Override
    protected void castSpell(BaseHero targetHero) {
    }
    @Override
    public String getInfo() {
        return "Маг ";
    }
}
