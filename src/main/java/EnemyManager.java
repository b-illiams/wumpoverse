import entities.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class EnemyManager {
    private List<Enemy> enemies;
    private List<Enemy> wizards;
    private List<Enemy> knights;
    ItemManager iManager = new ItemManager();
    Enemy wumpoKnight = new Enemy("Wumpo Knight", 100, 25, 0, 25, 0, iManager.getGears().get(0), iManager.getWeapons().get(0));
    Enemy wumpoWarrior = new Enemy("Wumpo Warrior", 500, 50, 0, 50, 25, iManager.getGears().get(1), iManager.getWeapons().get(1));
    Enemy wumpoBerserker = new Enemy("Wumpo Berserker", 1000, 75, 0, 75, 50, iManager.getGears().get(2), iManager.getWeapons().get(2));
    Enemy wumpoTerrible = new Enemy("Wumpo the Terrible", 5000, 100, 0, 100, 75, iManager.getGears().get(3), iManager.getWeapons().get(3));

    Enemy wumpoWizard = new Enemy("Wumpo Wizard", 100, 0, 25, 0, 25, iManager.getGears().get(4), iManager.getWeapons().get(4));
    Enemy wumpoMagician = new Enemy("Wumpo Magician", 500, 0, 50, 25, 50, iManager.getGears().get(5), iManager.getWeapons().get(5));
    Enemy wumpoSorccerer = new Enemy("Wumpo Sorcerer", 1000, 0, 75, 50, 75, iManager.getGears().get(6), iManager.getWeapons().get(6));
    Enemy wumpoGreat = new Enemy("Wumpo the Great", 5000, 0, 100, 75, 100, iManager.getGears().get(7), iManager.getWeapons().get(7));

    Enemy wumpus = new Enemy("The Wumpus", 9999, 999, 999, 999, 998, null, null);
    public EnemyManager(){
        enemies = new ArrayList();
        knights = new ArrayList();
        wizards = new ArrayList();
        createKnights();
        createWizards();
        createEnemies();
    }
    public void setEnemeies(List<Enemy> enemies){
        this.enemies = enemies;
    }
    public List<Enemy> getEnemies(){
        return enemies;
    }
    public void setWizards(List<Enemy> wizards){
        this.wizards = wizards;
    }
    public List<Enemy> getWizards(){
        return knights;
    }
    public void setKnights(List<Enemy> knights){
        this.knights = knights;
    }
    public List<Enemy> getKinghts(){
        return knights;
    }
    public void createEnemies(){
        enemies.addAll(knights);
        enemies.addAll(wizards);
        enemies.add(wumpus);
    }
    public void createWizards(){
        wizards.add(wumpoWizard);
        wizards.add(wumpoMagician);
        wizards.add(wumpoSorccerer);
        wizards.add(wumpoTerrible);
    }
    public void createKnights() {
        knights.add(wumpoKnight);
        knights.add(wumpoWarrior);
        knights.add(wumpoBerserker);
        knights.add(wumpoTerrible);
    }

    public Enemy gameSelect(){
        int rndmSelect = (int) (1000* Math.random());
        if(rndmSelect <= 449){
            int rndm = (int) (100 * Math.random());
            if(rndm <= 50){
                return wizards.get(0);
            }else if (50 < rndm && rndm <= 75){
                return wizards.get(1);
            }else if (75 < rndm && rndm < 100) {
                return wizards.get(2);
            }else{
                return wizards.get(3);
            }
        }
        if( 449 < rndmSelect && rndmSelect <= 998){
            int rndm = (int) (100 * Math.random());
            if(rndm <= 50){
                return knights.get(0);
            }else if (50 < rndm && rndm <= 75){
                return knights.get(1);
            }else if (75 < rndm && rndm < 100) {
                return knights.get(2);
            }else{
                return knights.get(3);
            }
        }else{
            return wumpus;
        }
    }
}
