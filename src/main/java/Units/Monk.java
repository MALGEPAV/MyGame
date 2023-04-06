package Units;
import Aux.Pos;


public class Monk extends SpellCaster {
    public Monk(String name, Pos pos) {
        super(15,15,name,pos,10,10,10,10,0,5);
    }

    @Override
    protected void castSpell(BaseHero targetHero) {

    }
    @Override
    public String getInfo() {
        return "Монах ";
    }
}
