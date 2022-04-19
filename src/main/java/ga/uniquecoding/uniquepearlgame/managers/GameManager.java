package ga.uniquecoding.uniquepearlgame.managers;

import ga.uniquecoding.uniquepearlgame.UniquePearlGame;
import ga.uniquecoding.uniquepearlgame.enums.GameState;
import org.bukkit.entity.Player;

public class GameManager {

    private final UniquePearlGame plugin;
    private final PlayerManager playerManager;
    private GameState gameState = GameState.WAITING;

    public GameManager(UniquePearlGame plugin) {
        this.playerManager = new PlayerManager(this);
        this.plugin = plugin;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getMaxPlayers() {
        return plugin.getConfig().getInt("max-players");
    }

    public void setMaxPlayers(int amount) {
        plugin.getConfig().set("max-players", amount);
    }

    public UniquePearlGame getPlugin() {
        return plugin;
    }
}
