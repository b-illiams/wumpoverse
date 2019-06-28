package items.gears;

public class Robe extends Gear{
    public Robe(){
        super();
    }

    public Robe(String name, String description, int id, int price, int barriers){
        super(name, description, id, price, 0, barriers);
    }
}
