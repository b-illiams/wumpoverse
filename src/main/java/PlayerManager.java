import entities.players.Player;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {
    private List<Player> players;
    public List<EncounterManager> enManager;
    public List <EnemyManager> eManager;
    public List <BattleManager> bManager;
    public List <ItemManager> iManager;
    public List <ShopManager> sManager;

    public PlayerManager() {
        players = new ArrayList();
        enManager = new ArrayList<>();
        eManager = new ArrayList<>();
        bManager = new ArrayList<>();
        iManager = new ArrayList<>();
        sManager = new ArrayList<>();
    }

    public void addPlayer(Player player, MessageReceivedEvent event) {
        if (!(getPlayer(event) == null)) {
            long id = event.getAuthor().getIdLong();
            for(int i = 0; i < players.size(); i++) {
                if (players.get(i).getId() == id) {
                    players.set(i, player);
                }
            }
        } else{
            long id = event.getAuthor().getIdLong();
            player.setId(id);
            players.add(player);
        }
    }

    public Player getPlayer(MessageReceivedEvent event) {
        long id = event.getAuthor().getIdLong();
        for(int i = 0; i < players.size(); i++) {
            if (players.get(i).getId() == id) {
                return players.get(i);
            }
        }
        return null;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
