package entities;

public abstract class Entity {
    private String name;
    private int level;
    private int experience;
    private int hitPoints;
    private int attack;
    private int magic;
    private int shield;
    private int barrier;

    public Entity(){
        this.name = "";
        this.level = 1;
        this.experience = 1;
        this.hitPoints = 0;
        this.attack = 0;
        this.magic = 0;
        this.shield = 0;
        this.barrier = 0;

    }

    public Entity(String name, int hitpoints, int attack, int magic, int shield, int barrier){
        this.name = name;
        this.hitPoints = hitpoints;
        this.attack = attack;
        this.magic = magic;
        this.shield = shield;
        this.barrier = barrier;
        this.level = 1;
        this.experience = 1;
    }

    public int getShield() {
        try{
            return shield;
        }catch(NullPointerException e){
            return 0;
        }
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public String getName() {
        try{
            return name;
        }catch(NullPointerException e){
            return "NONE:";
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMagic() {
        try{
            return magic;
        }catch(NullPointerException e){
            return 0;
        }
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getBarrier() {
        try{
            return barrier;
        }catch(NullPointerException e){
            return 0;
        }
    }

    public void setBarrier(int barrier) {
        this.barrier = barrier;
    }

    public int getAttack() {
        try{
            return attack;
        }catch(NullPointerException e){
            return 0;
        }
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public abstract String getProfile();

    public void addHitPoints(int points){
        hitPoints+= points;

    }

    public void subHitPoints(int points){
        hitPoints-= points;
    }
}
