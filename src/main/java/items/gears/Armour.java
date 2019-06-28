package items.gears;

public class Armour extends Gear {
    public Armour(){
        super();
    }

    public Armour(String name, String description, int id, int price, int shield){
        super(name, description, id, price, shield, 0);
    }
}
