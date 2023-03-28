package Units;

public class Monk extends SpellCaster {
    public Monk(String name, int x, int y) {
        super(15,15,name,x,y,10,10,10,10,0);
    }

    @Override
    protected void castSpell(BaseHero targetHero) {

    }
    @Override
    public String getInfo() {
        return "Монах "+this.name;
    }
}
