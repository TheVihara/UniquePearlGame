package ga.uniquecoding.uniquepearlgame.managers;

import ga.uniquecoding.uniquepearlgame.UniquePearlGame;

import java.util.HashSet;
import java.util.UUID;

public class GlobalManager {

    private final UniquePearlGame plugin;
    private HashSet<UUID> globalPlayers = new HashSet<>();

    public GlobalManager(UniquePearlGame plugin) {
        this.plugin = plugin;
    }

    public void addPlayer(UUID uuid) {
        globalPlayers.add(uuid);
    }

    public void removePlayer(UUID uuid) {
        globalPlayers.remove(uuid);
    }

    public boolean containsPlayer(UUID uuid) {
        return globalPlayers.contains(uuid);
    }

    public HashSet<UUID> getGlobalPlayers() {
        return globalPlayers;
    }

    /*public GameManager getGame(UUID uuid) {
        return
    }
     */
}
