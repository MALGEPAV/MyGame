package Aux;

public class Pos {
    public int x;
    public int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceFrom(Pos pos) {
        return Math.sqrt(Math.pow(this.x - pos.x, 2) + Math.pow(this.y - pos.y, 2));
    }

    @Override
    public String toString() {
        return "("+this.x+","+this.y+")";
    }
}
