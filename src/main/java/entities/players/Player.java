package entities.players;

import entities.Entity;
import items.Item;
import items.consumables.Consumable;
import items.gears.Gear;
import items.weapons.Weapon;


import java.util.ArrayList;
import java.util.List;


public class Player extends Entity {
    private long id;
    private Weapon weapon;
    private Gear gear;
    private int currency;
    private int maxExp;
    private boolean isAlive;

    private List<Item> inventory = new ArrayList();

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Player(){
        super();
        this.id = -1;
        maxExp = 23;
        lvlUp = false;
    }

    public Player(String name, int hitpoints, int attack, int magic, int shield, int barrier, long id, int currency) {
        super(name, hitpoints, attack, magic, shield, barrier);
        this.id = id;
        this.currency = currency;
        isAlive = true;
        maxExp = 23;
        lvlUp = false;
    }

    public boolean isLvlUp() {
        return lvlUp;
    }

    public void setLvlUp(boolean lvlUp) {
        this.lvlUp = lvlUp;
    }

    private boolean lvlUp;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public List<Item> getInventory() {
        for(Item x : inventory) {
            if (x == null) {
                inventory.remove(x);
            }
        }
        return inventory;
    }

    public void setInvenlotory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public void addCurrency(int money){
        currency += money;
    }

    public void subCurrency(int money){
        currency -= money;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfile(){
        String profile = "";
        profile +=
                "PLAYER: " + super.getName() + "\n" +
                "LVL: " + super.getLevel() + "\n" +
                "HP: " + super.getHitPoints() + "\n" +
                "DROPPINGS: $" + currency + "\n" +
                "WEAPON: " + weapon.getName() + "\n" +
                "GEAR: " + gear.getName() + "\n" +
                "ATTACK: " + (super.getAttack() + weapon.getAttack()) +  "\n" +
                "MAGIC: " + (super.getMagic() + weapon.getMagic()) + "\n" +
                "SHIELD: " + (super.getShield() + gear.getShield()) + "\n" +
                "BARRIER: " + (super.getBarrier() + gear.getBarrier());
        return profile;

    }

    public String getNullProfile(){
        String profile = "";
        if(this.getGear() == null && !(this.getWeapon() == null)){
            profile +=
                    "PLAYER: " + super.getName() + "\n" +
                            "LVL: " + super.getLevel() + "\n" +
                            "HP: " + super.getHitPoints() + "\n" +
                            "DROPPINGS: $" + currency + "\n" +
                            "WEAPON: " + weapon.getName() + "\n" +
                            "GEAR: NONE" + "\n" +
                            "ATTACK: " + (super.getAttack() + weapon.getAttack()) +  "\n" +
                            "MAGIC: " + (super.getMagic() + weapon.getMagic()) + "\n" +
                            "SHIELD: " + super.getShield()  + "\n" +
                            "BARRIER: " + super.getBarrier();
        }else if(this.getWeapon() == null && !(this.getGear() == null)){
            profile +=
                    "PLAYER: " + super.getName() + "\n" +
                            "LVL: " + super.getLevel() + "\n" +
                            "HP: " + super.getHitPoints() + "\n" +
                            "DROPPINGS: $" + currency + "\n" +
                            "WEAPON: NONE " +"\n" +
                            "GEAR: " + gear.getName() + "\n" +
                            "ATTACK: " + super.getAttack() +  "\n" +
                            "MAGIC: " + super.getMagic()  + "\n" +
                            "SHIELD: " + (super.getShield() + gear.getShield()) + "\n" +
                            "BARRIER: " + (super.getBarrier() + gear.getBarrier());
        }else{
            profile +=
                    "PLAYER: " + super.getName() + "\n" +
                            "LVL: " + super.getLevel() + "\n" +
                            "HP: " + super.getHitPoints() + "\n" +
                            "DROPPINGS: $" + currency + "\n" +
                            "WEAPON: NONE " +"\n" +
                            "GEAR: NONE" + "\n" +
                            "ATTACK: " + super.getAttack() +  "\n" +
                            "MAGIC: " + super.getMagic()  + "\n" +
                            "SHIELD: " + super.getShield()  + "\n" +
                            "BARRIER: " + super.getBarrier();
        }
        return profile;
    }

    public void equip (Item i) {
        if(i instanceof Weapon){
            getInventory().add(weapon);
            setWeapon((Weapon) i);
            return;
        }
        if(i instanceof Gear){
            getInventory().add(gear);
            setGear((Gear) i);
            return;
        }
        System.out.println("You can only equip \'<swords | shields | wands | robes>\'");
    }

    public void use(Item i){
        if(i instanceof Weapon || i instanceof Gear){
            equip(i);
        }
        if(i instanceof Consumable){
            ((Consumable) i).getBuff();
        }
    }

    public Gear getGear() {
        return gear;
    }

    public void setGear(Gear gear) {
        this.gear = gear;
    }

    public void addExperience(int exp){
        setExperience(getExperience() + exp);
        int newEXP = getExperience();
        if(newEXP >= maxExp){
            setLevel(getLevel() + 1);
            maxExp += maxExp /10;

            setHitPoints(getHitPoints() + (int) (10 * Math.random() + 10));
            setAttack(getAttack() + (int) (2 * Math.random() + 1));
            setShield(getAttack() + (int) (2 * Math.random() + 1));
            setMagic(getAttack() + (int) (2 * Math.random() + 1));
            setBarrier(getAttack() + (int) (2 * Math.random() + 1));

            lvlUp = true;
            setExperience(newEXP - maxExp);
        }
    }

    public void subExperience(int exp){
        setExperience(getExperience() - exp);
    }
}
