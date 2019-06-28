import items.Item;
import items.gears.Armour;
import items.gears.Gear;
import items.gears.Robe;
import items.weapons.Sword;
import items.weapons.Wand;
import items.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    private  List<Item> items = new ArrayList();
    private List<Weapon> weapons = new ArrayList();
    private  List<Gear> gears = new ArrayList();
    private List<Item> nitroItems = new ArrayList();

    private Weapon rookiesSword = new Sword("Rookie's Sword", "A sword for the little guy.", 101, 50, 25);
    private Weapon rougesSword =  new Sword("Rouge's Sword", "The little guy grew up and the sword did too!", 102, 500, 50);
    private Weapon warriorsSword = new Sword("Warrior's Sword", "SWORD BIG, YOU BAD!", 103, 5000, 75);
    private Weapon berserkersSword = new Sword("Berserker's Sword", "RAAAAWW POWWEEEEER!", 104, 50000, 100);

    private Weapon learnersWand = new Wand("Learner's Wand", "Ooo, a sparkly stick!", 201, 50, 25);
    private Weapon scholarsWand = new Wand("Scholar's Wand", "OKAY, STICK DOES DAMAGE NOW!", 202, 500, 50);
    private Weapon magiciansWand = new Wand("Magician's Wand", "Okay there Magic Mike, calm down", 203, 5000, 75);
    private Weapon sorcerersWand = new Wand("Sorcerer's Wand", "MAGIC SCHOOL BUS AIN'T GOT NOTHING ON THIS", 204, 50000, 100);

    private Weapon godWeapon = new Weapon("God's Weapon", "Crafted by the God of Death, decimate your foes with the power of destruction", 501, 999999, 999, 999);
    private Weapon superMeat = new Weapon("Super Meat Sword", "ALL MY MEAT IN ONE WHOLE HEAP", 502, 99999, 999, 0);
    private Weapon forkKnife = new Weapon("Fork Knife", "Taste the power of 13 year old gamers",503, 99999, 500, 500 );
    private Weapon bfg = new Weapon("BFG", "It's a Big Fucking Gun", 504, 99999, 0,999);
    private Weapon ponySword = new Weapon ("Pony Sword", "SATANTECH INCORPERATED", 505, 99999, 999, 999);


    private  Gear rookieArmour = new Armour("Rookie's Armour", "DING!", 301, 50, 25);
    private Gear rougeArmour =  new Armour("Rouge's Armour", "CLINK!", 302, 500, 50);
    private  Gear warriorArmour = new Armour("Warrior's Armour", "CLANK!", 303, 5000, 75);
    private  Gear berserkerArmour = new Armour("Berserker's Armour", "CLUNK!", 304, 50000, 100);

    private  Gear learnersRobe = new Robe("Learner's Robe", "Isn't that a Graduation Gown?", 401, 50, 25);
    private  Gear scholarsRobe = new Robe("Scholar's Robe", "I prefer the design for Gryffindor, but this will do", 402, 500, 50);
    private   Gear magiciansRobe = new Robe("Magician's Robe", "Got my rep from the Lollipop Guild.", 403, 5000, 75);
    private  Gear sorcerersRobe = new Robe("Sorcerer's Robe", "Smells like Gandalf", 404, 50000, 100);;

    private Gear godGear = new Gear("God's Gear", "Crafted by the God of Life, be enveloped by the power of creation", 506, 999999, 9999, 9999);
    private Gear diamondArmour = new Gear("Enchanted Diamond Armour", "Unbreaking III, Protection V, Aqua Affinity, Thorns III, Depth Strider", 507, 99999, 999, 0);
    private Gear tos = new Gear("Discord's Terms of Service", "https://discordapp.com/terms", 508, 99999, 999, 999);
    private Gear warFrame = new Gear("Warframe", "Alien tech from your feet to your neck!", 509, 99999, 99, 99);
    private Gear hypeSquad = new Gear("Hype Squad", "Fabricated from Brave, Brilliant, and Balanced bodies.", 510, 99999, 500, 500);

    public ItemManager(){
        createWeapons();
        createGears();
        createItems();
        createWeapons();
        createGears();
        createNitro();
    }

    public void createItems(){
        List <Weapon> tempWeapons = weapons;
        List <Gear> tempGears = gears;
        while(tempWeapons.size()> 0 && tempGears.size() > 0){
            items.add(tempWeapons.remove(0));
            items.add(tempGears.remove(0));
        }
    }

    public void createWeapons(){
        weapons.add(rookiesSword);
        weapons.add(rougesSword);
        weapons.add(warriorsSword);
        weapons.add(berserkersSword);

        weapons.add(learnersWand);
        weapons.add(scholarsWand);
        weapons.add(magiciansWand);
        weapons.add(sorcerersWand);
    }

    public void createGears(){
        gears.add(rookieArmour);
        gears.add(rougeArmour);
        gears.add(warriorArmour);
        gears.add(berserkerArmour);

        gears.add(learnersRobe);
        gears.add(scholarsRobe);
        gears.add(magiciansRobe);
        gears.add(sorcerersRobe);
    }

    public void createNitro(){
        nitroItems.add(godWeapon);
        nitroItems.add(superMeat);
        nitroItems.add(bfg);
        nitroItems.add(forkKnife);
        nitroItems.add(ponySword);

        nitroItems.add(godGear);
        nitroItems.add(diamondArmour);
        nitroItems.add(tos);
        nitroItems.add(warFrame);
        nitroItems.add(hypeSquad);
    }

    public List<Item> getNitroItems() {
        return nitroItems;
    }

    public void setNitroItems(List<Item> nitroItems) {
        this.nitroItems = nitroItems;
    }

    public void setGears(List<Gear> gears) {
        this.gears = gears;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems(){
        return items;
    }

    public List<Weapon> getWeapons(){
        return weapons;
    }

    public List<Gear> getGears(){
        return gears;
    }
}
