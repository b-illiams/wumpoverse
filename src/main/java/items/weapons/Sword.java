package items.weapons;

public class Sword extends Weapon {
    public Sword(){
        super();
    }

    public Sword(String name, String description,  int id, int price, int attack){
        super(name, description, id, price, attack, 0);

    }
}
