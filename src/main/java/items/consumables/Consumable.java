package items.consumables;

import items.Item;

public abstract class Consumable extends Item {
    public Consumable (){
        super();
    }

    public Consumable(String name, String description, int id, int price){
        super(name, description, id, price);
    }

    public abstract void getBuff();
}