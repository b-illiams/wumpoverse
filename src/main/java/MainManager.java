import entities.Entity;
import entities.enemies.Enemy;
import entities.players.Player;
import items.Item;
import items.gears.Gear;
import items.weapons.Weapon;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MainManager extends ListenerAdapter {
    private String prefix;
    private String message;

    private ItemManager iManager;
    private ShopManager sManager;
    private PlayerManager pManager;
    private EnemyManager eManager;
    private BattleManager bManager;
    private EncounterManager enManager;

    public MainManager(){
        prefix = ".";
        message = "";

        iManager = new ItemManager();
        sManager = new ShopManager();
        pManager = new PlayerManager();
        eManager = new EnemyManager();
        bManager = new BattleManager();
        enManager = new EncounterManager();
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void getEvents(MessageReceivedEvent event) {

        message = event.getMessage().getContentDisplay();
        if(prefix.equals(message.substring(0, prefix.length()))){
            System.out.println("Command Detected");
            if(!(pManager.getPlayer(event) == null)){
                try{
                    if(message.substring(prefix.length(), prefix.length() + 6).equals("prefix")){
                        changePrefix(event);
                    }
                }catch(StringIndexOutOfBoundsException e){ }
                try{
                    if(message.substring(prefix.length(), prefix.length() + 4).equals("shop")){
                        sendMessage(event, "Entering the shop");
                        shop(event);
                    }
                }catch(StringIndexOutOfBoundsException e){ }

                try{
                    if(message.substring(prefix.length(), prefix.length() + 9).equals("inventory")){
                        sendMessage(event, "Opening player inventory . . .");
                        inventory(event);
                    }
                }catch(StringIndexOutOfBoundsException e){ }

                try{
                    if(message.substring(prefix.length(), prefix.length() + 6).equals("search")){
                        sendMessage(event, "Searching the area . . .");
                        search(event);
                    }
                }catch(StringIndexOutOfBoundsException e){ }

                try{
                    if(message.substring(prefix.length(), prefix.length() + 7).equals("profile")){
                        sendMessage(event, "Checking profile . . .");
                        profile(event);
                    }
                }catch(StringIndexOutOfBoundsException e){ }

                try{
                    if(message.substring(prefix.length(), prefix.length() + 5).equals("reset")){
                        sendMessage(event, "Resetting player . . .");
                        reset(event);
                    }
                }catch(StringIndexOutOfBoundsException e){ }

            }else{
                try{
                    if(message.substring(prefix.length(), prefix.length() + 5).equals("start")){
                        sendMessage(event, "Starting game . . .");
                        start(event);
                    }else{
                        sendMessage(event, "To start your journey, do \'.start <sword | wand>\'!");
                    }
                }catch(StringIndexOutOfBoundsException e){
                    sendMessage(event, "To start your journey, do \'.start <sword | wand>\'!");
                }
            }

            try{
                if(message.substring(prefix.length(), prefix.length() + 4).equals("help")){
                    sendMessage(event, "Sending help . . .");
                    help(event);
                }else{ }
            }catch(StringIndexOutOfBoundsException e){ }
        }

    }

    public void changePrefix(MessageReceivedEvent event) {
        //TODO: ADMIN ACCESS ONLY
        System.out.println(message.substring(prefix.length(), prefix.length() + 6));
        sendMessage(event, "Prefix Command Activated");
        if(!(message.substring(prefix.length() + 7).equals(""))){
            System.out.println(message.substring(prefix.length() + 7));
            setPrefix(message.substring(prefix.length() + 7));
            sendMessage(event, "Prefix Changed to: " + getPrefix());
        }
    }

    public void shop(MessageReceivedEvent event) {

        try {
            String shopItems = "\nSHOP: \n";
            List<Item> tempShop = sManager.getShop();
            int tempShopSize = tempShop.size();
            int count = 0;
            for (Item x : tempShop) {
                if (x.equals(null)) {
                    System.out.println("Sold");
                    shopItems += "Sold \n";
                } else {
                    count++;
                    shopItems += "[" + count + "] " + x.getName() + ": " + x.getDescription() + " --- $" + x.getPrice() + "\n";
                }
            }
            sendMessage(event, shopItems);

            if (message.substring(prefix.length() + 5).contains("buy")) {
                sendMessage(event, "Making a purchase");
                if (!(message.substring(prefix.length() + 9).equals(null))) {
                    String numString = message.substring(prefix.length() + 9);
                    int index = -1;
                    System.out.print(numString);
                    if (numString.equals("1")) {
                        index = 0;
                        if(pManager.getPlayer(event).getCurrency() >= tempShop.get(index).getPrice()){
                            pManager.getPlayer(event).getInventory().add(tempShop.get(index));
                            pManager.getPlayer(event).subCurrency(tempShop.get(index).getPrice());
                            sendMessage(event, "Added " + tempShop.get(index).getName() + " to " +  pManager.getPlayer(event).getName() + "'s inventory!");
                            tempShop.remove(index);
                        }
                    }
                    if (numString.equals("2")) {
                        index = 1;
                        if(pManager.getPlayer(event).getCurrency() >= tempShop.get(index).getPrice()){
                            pManager.getPlayer(event).getInventory().add(tempShop.get(index));
                            pManager.getPlayer(event).subCurrency(tempShop.get(index).getPrice());
                            sendMessage(event, "Added " + tempShop.get(index).getName() + " to " +  pManager.getPlayer(event).getName() + "'s inventory!");
                            tempShop.remove(index);
                        }
                    }
                    if (numString.equals("3")) {
                        index = 2;
                        if(pManager.getPlayer(event).getCurrency() >= tempShop.get(index).getPrice()){
                            pManager.getPlayer(event).getInventory().add(tempShop.get(index));
                            pManager.getPlayer(event).subCurrency(tempShop.get(index).getPrice());
                            sendMessage(event, "Added " + tempShop.get(index).getName() + " to " +  pManager.getPlayer(event).getName() + "'s inventory!");
                            tempShop.remove(index);
                        }
                    }
                    if (numString.equals("4")) {
                        index = 3;
                        if(pManager.getPlayer(event).getCurrency() >= tempShop.get(index).getPrice()){
                            pManager.getPlayer(event).getInventory().add(tempShop.get(index));
                            pManager.getPlayer(event).subCurrency(tempShop.get(index).getPrice());
                            sendMessage(event, "Added " + tempShop.get(index).getName() + " to " +  pManager.getPlayer(event).getName() + "'s inventory!");
                            tempShop.remove(index);
                        }
                    }
                    if (numString.equals("5")) {
                        index = 4;
                        if(pManager.getPlayer(event).getCurrency() >= tempShop.get(index).getPrice()){
                            pManager.getPlayer(event).getInventory().add(tempShop.get(index));
                            pManager.getPlayer(event).subCurrency(tempShop.get(index).getPrice());
                            sendMessage(event, "Added " + tempShop.get(index).getName() + " to " +  pManager.getPlayer(event).getName() + "'s inventory!");
                            tempShop.remove(index);
                        }
                    }
                    if (numString.equals("6")) {
                        index = 5;
                        if(pManager.getPlayer(event).getCurrency() >= tempShop.get(index).getPrice()){
                            pManager.getPlayer(event).getInventory().add(tempShop.get(index));
                            pManager.getPlayer(event).subCurrency(tempShop.get(index).getPrice());
                            sendMessage(event, "Added " + tempShop.get(index).getName() + " to " +  pManager.getPlayer(event).getName() + "'s inventory!");
                            tempShop.remove(index);
                        }
                    }
                    if(tempShopSize > tempShop.size()){
                        sManager.setShop(tempShop);
                    }else{
                        sendMessage(event, "Not enough money!");
                    }
                }
            }
            if (message.substring(prefix.length() + 5).equals("reset")) {
                //TODO: ADMIN ACCESS ONLY
                sendMessage(event, "Shop reset!");
                tempShop.removeAll(tempShop);
                sManager.resetShop();
            }
        } catch (NullPointerException e) {
            System.out.println("Smells like null");
        }
    }

    public void inventory(MessageReceivedEvent event){
        try{

            String inventoryItems = "";
            int count = 0;
            for(Item x: pManager.getPlayer(event).getInventory()){
                count++;
                inventoryItems += "["+ count + "] " + x.getName() + ": " + x.getDescription() + "\n";
            }
            sendMessage(event, inventoryItems);

            if(message.substring(prefix.length() + 10).contains("use")){
                int i = 0;
                try{
                    i = Integer.parseInt(message.substring(prefix.length() + 14));
                }catch(InputMismatchException e){

                }
                int index = -1 + i;
                if(pManager.getPlayer(event).getInventory().get(index) instanceof Weapon || pManager.getPlayer(event).getInventory().get(index) instanceof Gear){
                    sendMessage(event, pManager.getPlayer(event).getName() + " has equipped " + pManager.getPlayer(event).getInventory().get(index).getName());
                    pManager.getPlayer(event).use(pManager.getPlayer(event).getInventory().remove(index));
                }else{
                    pManager.getPlayer(event).use(pManager.getPlayer(event).getInventory().remove(index));
                }

            }
        }catch(NullPointerException e){
            sendMessage(event, "Your inventory is empty!");
        }
    }

    public void search(MessageReceivedEvent event){
        int rndmSelect = (int) (100 * Math.random());

        if(rndmSelect <= 65){
            int rndmMoney = (int) (9 * Math.random()) + 1;
            int rndmScale = (int) (10 * Math.random()) + 1;
            rndmMoney*= rndmScale;
            pManager.getPlayer(event).addCurrency(rndmMoney);
            sendMessage(event, "None of those critters, but you found " + rndmMoney + " droppings!");
        }
        if(65 < rndmSelect && rndmSelect <= 90){
            Enemy enemy = eManager.gameSelect();
            sendMessage(event, enManager.getEncounterMessage(enemy));
            pManager.addPlayer(bManager.battle(pManager.getPlayer(event), enemy), event);
            if(pManager.getPlayer(event).isAlive() == true){
                sendMessage(event, pManager.getPlayer(event).getName() + " won!");
                pManager.getPlayer(event).setAlive(true);
            }else{
                sendMessage(event, pManager.getPlayer(event).getName() +" lost!");
                pManager.getPlayer(event).setAlive(true);
            }

            if(pManager.getPlayer(event).isLvlUp() == true){
                sendMessage(event, pManager.getPlayer(event).getName() + " leveled up!");
                pManager.getPlayer(event).setLvlUp(false);
            }
        }
        if(90 < rndmSelect && rndmSelect <=95){
            int rndmTreasure = (int) (iManager.getNitroItems().size() * Math.random());
            Item treasure;
            if(rndmTreasure % 3 == 0){
                treasure = iManager.getNitroItems().get(rndmTreasure);
            }else{
                treasure = iManager.getItems().get((int) (iManager.getItems().size() * Math.random()));
            }

            sendMessage(event, "TREASURE! " + pManager.getPlayer(event).getName() + " found " + treasure.getName() + "!");
            pManager.getPlayer(event).getInventory().add(treasure);
        }
        if(95 < rndmSelect){
            sendMessage(event, "You turned up with nothing . . .");
        }
    }

    public void profile(MessageReceivedEvent event){
        try{
            sendMessage(event, pManager.getPlayer(event).getProfile());
        }catch(NullPointerException e){
            System.out.println(e);
            sendMessage(event, pManager.getPlayer(event).getNullProfile());
        }

    }

    public void start (MessageReceivedEvent event) {
        if(message.substring(prefix.length() + 6).equals("sword")){
            sendMessage(event, "DEMACIA!");
            pManager.addPlayer(new Player(event.getAuthor().getName(), 100, 5, 1, 5, 1, event.getAuthor().getIdLong(), 100), event);
            pManager.getPlayer(event).setWeapon(iManager.getWeapons().get(0));
            pManager.getPlayer(event).setGear(iManager.getGears().get(0));
            return;
        }else if(message.substring(prefix.length() + 6).equals("wand")){
            sendMessage(event, "You're a Wizard Harry!");
            pManager.addPlayer(new Player(event.getAuthor().getName(), 100, 1, 5, 1, 5, event.getAuthor().getIdLong(), 100), event);
            pManager.getPlayer(event).setWeapon(iManager.getWeapons().get(4));
            pManager.getPlayer(event).setGear(iManager.getGears().get(4));
            return;
        }else{
        }
        sendMessage(event, "To start your journey, do \'.start <sword | wand>\'!");
    }

    public void reset(MessageReceivedEvent event){
        sendMessage(event, pManager.getPlayer(event).getName() + "'s player is reset!");
        pManager.getPlayers().remove(pManager.getPlayer(event));
    }

    public void help (MessageReceivedEvent event){
        List <String> commands = new ArrayList();
        String displayCommands = "Commands:\n";
        int count = 0;

        commands.add(".help - Sends command list to the user");
        commands.add(".start <sword | shield> - Creates new player.");
        commands.add(".inventory <use> <item-number> - Displays player's items.");
        commands.add(".shop <buy | reset> <item-number> - Displays shop items.");
        commands.add(".search - Finds droppings (currency), Finds Wumpos (enemy), Finds treasure (items)");
        commands.add(".profile - Displays player's stats and equipment");

        for (String x : commands){
            count++;
            displayCommands += "\n [" + count + "] " + x;
        }
        sendMessage(event, displayCommands);
    }

    public void sendMessage(MessageReceivedEvent event, String x){
        event.getMessage().getChannel().sendMessage("```\n" + x + "```\n").queue();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        System.out.println(event.getAuthor().getName() + ": " + event.getMessage().getContentDisplay());
        getEvents(event);
    }
}
