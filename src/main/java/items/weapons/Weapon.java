package items.weapons;

import items.Item;

public class Weapon extends Item {
    private int attack;
    private int magic;

    public Weapon (){
        super();
        this.attack = 0;
        this.magic = 0;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Weapon (String name, String description, int id, int price, int attack, int magic) {
        super(name, description, id, price);
        this.attack = attack;
        this.magic = magic;
    }
}
