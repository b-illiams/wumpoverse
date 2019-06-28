package entities.enemies;

import entities.Entity;
import items.Item;
import items.gears.Gear;
import items.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends Entity {
    List<Item> Loot = new ArrayList();
    private Weapon weapon;
    private Gear gear;
    public Enemy(){
        super();
    }

    public Enemy(String name, int hitpoints, int attack, int magic, int shield, int barrier, Gear g, Weapon w) {
        super(name, hitpoints, attack, magic, shield, barrier);
        gear = g;
        weapon = w;
    }

    public String getProfile(){
        String profile = "";

        profile +=
                "PLAYER: " + super.getName() + "\n" +
                        "HP: " + super.getHitPoints() + "\n" +
                        "ATTACK: " + super.getAttack() + "\n" +
                        "MAGIC: " + super.getMagic() + "\n" +
                        "SHIELD: " + super.getShield() + "\n" +
                        "BARRIER: " + super.getBarrier();

        return profile;
    }
    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }
}
