package ga.uniquecoding.uniquepearlgame.managers;

import java.util.HashSet;
import java.util.UUID;

public class PlayerManager {

    private final GameManager manager;
    private HashSet<UUID> players = new HashSet<>();

    public PlayerManager(GameManager manager) {
        this.manager = manager;
    }

    public HashSet<UUID> getPlayers() {
        return players;
    }

    public void addPlayer(UUID uuid) {
        players.add(uuid);
    }

    public void removePlayer(UUID uuid) {
        players.remove(uuid);
    }

    public void removeAll() {
        players.clear();
    }

    public boolean isFull() {
        return players.size() == manager.getMaxPlayers();
    }
}
