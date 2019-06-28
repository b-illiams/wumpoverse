package items.gears;

import items.Item;

public class Gear extends Item {

    private int shield;
    private int barrier;

    public Gear (){
        super();
        this.shield = 0;
        this. barrier = 0;
    }

    public int getBarrier() {
        return barrier;
    }

    public void setBarrier(int barrier) {
        this.barrier = barrier;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public Gear (String name, String description, int id, int price, int shield, int barrier){
        super(name, description, id, price);
        this.shield = shield;
        this. barrier = barrier;
    }
}
