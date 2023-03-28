package Units;

public class Raider extends MeleeAttackUnit {
    public Raider(String name, int x, int y){

        super(1,name,x,y,13,13,11,11,4);
    }
    @Override
    public String getInfo() {
        return "Разбойник "+this.name;
    }
}
