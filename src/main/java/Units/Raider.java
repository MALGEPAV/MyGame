package Units;
import Aux.Pos;


public class Raider extends MeleeAttackUnit {
    public Raider(String name, Pos pos){

        super(1,name,pos,13,13,9,9,4, 8);
    }
    @Override
    public String getInfo() {
        return "Разбойник ";
    }
}
