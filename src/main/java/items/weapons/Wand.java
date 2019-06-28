package items.weapons;

public class Wand extends Weapon {
    public Wand(){
        super();
    }

    public Wand(String name, String description, int id, int price, int magic){
        super(name, description, id, price, 0, magic);

    }
}
