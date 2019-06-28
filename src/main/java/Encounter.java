import entities.enemies.Enemy;

public class Encounter {
    private Enemy enemy;
    private String encounterMessage;

    public Encounter() {

    }

    public Encounter(Enemy enemy, String encounter) {
        this.enemy = enemy;
        this.encounterMessage = encounter;
    }

    public String getEncounterMessage() {
        return encounterMessage;
    }

    public void setEncounterMessage(String encounterMessage) {
        this.encounterMessage = encounterMessage;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}