import items.Item;
import items.gears.Armour;
import items.gears.Gear;
import items.gears.Robe;
import items.weapons.Sword;
import items.weapons.Wand;
import items.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

public class ShopManager {
    private List<Item> shop;
    private ItemManager iManager;
    private int shopSize;

    public ShopManager(){
            this.shopSize = 6;

        this.iManager = new ItemManager();
        this.shop = new ArrayList();


        resetShop();
    }

    public List<Item> getShop(){
        return shop;
    }

    public void setShop(List <Item> shop){
       this.shop = shop;
    }

    public void resetShop(){
        int tempSize = shopSize;
        shop.removeAll(shop);
        while(tempSize > 0){
            int rndm = (int) (iManager.getItems().size() * Math.random());
            shop.add(iManager.getItems().get(rndm));
            System.out.println(iManager.getItems().get(rndm));
            tempSize--;
        }
    }

    public Item buy(int index){
        return shop.remove(index);
    }
}
