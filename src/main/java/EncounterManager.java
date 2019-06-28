import entities.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class EncounterManager {
    private List<String> wumpoEncounter = new ArrayList();
    private List<String> greatEncounter = new ArrayList();
    private List<String> terribleEncounter = new ArrayList();
    private List<String> wumpusEncounter = new ArrayList();

    //Yes I know it looks disgusting, I like making it have its own variable before putting it in an array. I'm weird don't kill me.
    private String w1 = "SHWUMPO WUMPO!";
    private String w2 = "That's too big to be a dropping . . .";
    private String w3 = "TREASURE! Oh wait . . .that's just a Wumpo.";
    private String w4 = "Damn it, I knew I should have renewed that Nitro Subscription . . .";
    private String w5 = "LEEEERROOOOY JEEEENKIIIINS!";
    private String w6 = "Ah shit, here we go again . . .";
    private String w7 = "Oh, I thought this was All the Foxes's house . . .";
    private String w8 = "You're not Jason Citron!";
    private String w9 = "Snuffleupawumpus!";
    private String w10 = "Dad?";
    private String w11 = "How the hell does that thing hold a weapon?";
    private String w12 = "Not gonna lie, looking dummy cute in that Gear Wumpo ;)";
    private String w13 = "YOU'RE BREATHTAKING!";
    private String w14 = "That's not an eGirl . . .";
    private String w15 = "SHOW ME YOUR MOVES!";

    private String g1 = "MAGICAL THREAT INCOMING";
    private String g2 = "Abracadabra!";
    private String g3 = "Definitely smells like Gandalf";
    private String g4 = "You know, those wizardly robes does wonders for his figure";
    private String g5 = "Alright Longbottom, let's see what you've got!";

    private String t1 = "PHYSICAL THREAT INCOMING";
    private String t2 = "You looked better in OPM season 1";
    private String t3 = "Hey Dwayne, is this one of your lifting buddies?";
    private String t4 = "You took living like Larry a little too seriously . . . way too seriously";
    private String t5 = "Never played Minecraft, but I'm guessing this is what Bedrock looks like";

    private String wumpus1 = "Is this what Megalovania looks like?";
    private String wumpus2 = "BRO, WHAT CLIENT ARE YOU USING?!";
    private String wumpus3 = "Now this . . . doesn't put a smile on my face";
    private String wumpus4 = "WUMPUS, I'VE COME TO BARGAIN!";
    private String wumpus5 = "Hey man, I payed my Nitro Subscription the other day. If this is about the time I was using light theme I  swear I won't do it again . . . Please? Oh god . . .";


    public EncounterManager(){
        createWumpoEncounter();
        createGreatEncounter();
        createTerribleEncounter();
        createWumpusEncounter();
    }

    public void createWumpoEncounter(){
        wumpoEncounter.add(w1);
        wumpoEncounter.add(w2);
        wumpoEncounter.add(w3);
        wumpoEncounter.add(w4);
        wumpoEncounter.add(w5);
        wumpoEncounter.add(w6);
        wumpoEncounter.add(w7);
        wumpoEncounter.add(w8);
        wumpoEncounter.add(w9);
        wumpoEncounter.add(w10);
        wumpoEncounter.add(w11);
        wumpoEncounter.add(w12);
        wumpoEncounter.add(w13);
        wumpoEncounter.add(w14);
        wumpoEncounter.add(w15);

    }
    public void createGreatEncounter(){
        greatEncounter.add(g1);
        greatEncounter.add(g2);
        greatEncounter.add(g3);
        greatEncounter.add(g4);
        greatEncounter.add(g5);

    }
    public void createTerribleEncounter(){
        terribleEncounter.add(t1);
        terribleEncounter.add(t2);
        terribleEncounter.add(t3);
        terribleEncounter.add(t4);
        terribleEncounter.add(t5);
    }
    public void createWumpusEncounter(){
        wumpusEncounter.add(wumpus1);
        wumpusEncounter.add(wumpus2);
        wumpusEncounter.add(wumpus3);
        wumpusEncounter.add(wumpus4);
        wumpusEncounter.add(wumpus5);
    }

    public String getEncounterMessage(Enemy enemy){
        String message = "";
        if(enemy.getName().contains("Wumpus")){
            int rndm = (int) (wumpusEncounter.size() * Math.random());
            message += wumpusEncounter.get(rndm);
        }else if(enemy.getName().contains("Great")){
            int rndm = (int) (greatEncounter.size() * Math.random());
            message += greatEncounter.get(rndm);
        }else if (enemy.getName().contains("Terrible")){
            int rndm = (int) (terribleEncounter.size() * Math.random());
            message += terribleEncounter.get(rndm);
        }else{
            int rndm = (int) (wumpoEncounter.size() * Math.random());
            message += wumpoEncounter.get(rndm);
        }
        return message+= "\n\n" + enemy.getName() + " has appeared!";
    }

    public List<String> getWumpoEncounter() {
        return wumpoEncounter;
    }

    public void setWumpoEncounter(List<String> wumpoEncounter) {
        this.wumpoEncounter = wumpoEncounter;
    }

    public List<String> getGreatEncounter() {
        return greatEncounter;
    }

    public void setGreatEncounter(List<String> greatEncounter) {
        this.greatEncounter = greatEncounter;
    }

    public List<String> getTerribleEncounter() {
        return terribleEncounter;
    }

    public void setTerribleEncounter(List<String> terribleEncounter) {
        this.terribleEncounter = terribleEncounter;
    }

    public List<String> getWumpusEncounter() {
        return wumpusEncounter;
    }

    public void setWumpusEncounter(List<String> wumpusEncounter) {
        this.wumpusEncounter = wumpusEncounter;
    }
}
