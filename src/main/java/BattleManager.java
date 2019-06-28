import entities.Entity;
import entities.enemies.Enemy;
import entities.players.Player;
import items.weapons.Sword;
import items.weapons.Wand;

import java.util.InputMismatchException;

public class BattleManager {
    private Player player;
    int playerMaxHP;
    private Enemy enemy;

    public BattleManager(){
        player = null;
        enemy = null;
        playerMaxHP = -1;
    }

    public Player battle(Player p, Enemy e){
        player = p;
        enemy = e;
        playerMaxHP = player.getHitPoints();
        while(true){
            if(player.getHitPoints() < 0){
                int rndmMoney = (int) (player.getCurrency() * Math.random());
                int rndmEXP = (int) (15 * Math.random() + 10);
                player.setGear(null);
                player.setWeapon(null);
                player.setHitPoints(playerMaxHP);
                player.subCurrency(rndmMoney);
                p.addExperience(rndmEXP);
                player.setAlive(false);
                return p;
            }else if(enemy.getHitPoints() < 0){
                int rndmMoney = (int) ((player.getCurrency() * 1.2) * (Math.random()));
                int rndmEXP = (int) (5 * Math.random() + 10);
                p.addExperience(rndmEXP);
                player.setHitPoints(playerMaxHP);
                player.addCurrency(rndmMoney);
                p.addExperience(rndmEXP);
                return p;
            }else{
                turn();
            }
        }
    }

    public void turn(){
        int rndm = (int) (3 * Math.random()+1);
        //PLAYER TURN
        if(player.getWeapon() instanceof Sword){
            System.out.println("isSword");
            int attack = player.getWeapon().getAttack() + player.getAttack();
            int shield = enemy.getGear().getShield() + enemy.getShield();
            int dmg = attack - shield;

            if (dmg < 0){
                dmg = 1 * rndm;
            }else{
                dmg*= rndm;
            }

            enemy.subHitPoints(dmg);

        }else if(player.getWeapon() instanceof Wand){
            System.out.println("isWand");
            int magic = player.getWeapon().getMagic() + player.getMagic();
            int barrier = enemy.getGear().getBarrier() + enemy.getBarrier();
            int dmg = magic - barrier;

            if (dmg < 0){
                dmg = 1 * rndm;
            }else{
                dmg*= rndm;
            }

            enemy.subHitPoints(dmg);
        }else{
            System.out.println("isElse");

            int attack = 0;
            int shield = 0;
            int magic = 0;
            int barrier = 0;

            try{
                attack = player.getWeapon().getAttack() + player.getAttack();
                shield = enemy.getGear().getShield() + enemy.getShield();
                magic = player.getWeapon().getMagic() + player.getMagic();
                barrier = enemy.getGear().getBarrier() + enemy.getBarrier();
            }catch (NullPointerException e){
                attack = player.getAttack();
                shield = enemy.getGear().getShield() + enemy.getShield();
                magic = player.getMagic();
                barrier = enemy.getGear().getBarrier() + enemy.getBarrier();
            }

            int dmg = (attack + magic) - (shield + barrier);

            if (dmg < 0){
                dmg = 1 * rndm;
            }else{
                dmg*= rndm;
            }

            enemy.subHitPoints(dmg);
        }

        //ENEMY TURN
        if(enemy.getWeapon() instanceof Sword){
            int attack = 0;
            int shield = 0;
            try{
                attack = enemy.getWeapon().getAttack() + enemy.getAttack();
                shield = player.getGear().getShield() + player.getShield();
            }catch (NullPointerException e){
                attack = enemy.getWeapon().getAttack() + enemy.getAttack();
                shield = player.getShield();
            }

            int dmg = attack - shield;

            if (dmg < 0){
                dmg = 1 * rndm;
            }else{
                dmg*= rndm;
            }

            player.subHitPoints(dmg);

        }else if(enemy.getWeapon() instanceof Wand){
            int magic = 0;
            int barrier = 0;

            try{
                magic = enemy.getWeapon().getMagic() + enemy.getMagic();
                barrier = player.getGear().getBarrier() + player.getBarrier();
            }catch(NullPointerException e){
                magic = enemy.getWeapon().getMagic() + enemy.getMagic();
                barrier = player.getBarrier();
            }

            int dmg = magic - barrier;

            if (dmg < 0){
                dmg = 1 * rndm;
            }else{
                dmg*= rndm;
            }

            player.subHitPoints(dmg);
        }else{
            int attack = 0;
            int shield = 0;
            int magic = 0;
            int barrier = 0;

            try{
                attack = enemy.getWeapon().getAttack() + enemy.getAttack();
                shield = player.getGear().getShield() + player.getShield();
                magic = enemy.getWeapon().getMagic() + enemy.getMagic();
                barrier = player.getGear().getBarrier() + player.getBarrier();
            }catch(NullPointerException e) {
                attack = enemy.getWeapon().getAttack() + enemy.getAttack();
                shield = player.getShield();
                magic = enemy.getWeapon().getMagic() + enemy.getMagic();
                barrier = player.getBarrier();
            }

            int dmg = (attack + magic) - (shield + barrier);

            if (dmg < 0){
                dmg = 1 * rndm;
            }else{
                dmg*= rndm;
            }

            player.subHitPoints(dmg);
        }
    }
}
