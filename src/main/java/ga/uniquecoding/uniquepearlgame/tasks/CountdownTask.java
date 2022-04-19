package ga.uniquecoding.uniquepearlgame.tasks;

import ga.uniquecoding.uniquepearlgame.UniquePearlGame;
import ga.uniquecoding.uniquepearlgame.enums.GameState;
import ga.uniquecoding.uniquepearlgame.managers.GameManager;
import ga.uniquecoding.uniquepearlgame.utils.HexUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class CountdownTask extends BukkitRunnable {

    private final GameManager gameManager;
    private UniquePearlGame plugin;

    public CountdownTask(GameManager gameManager, UniquePearlGame plugin) {
        this.gameManager = gameManager;
        this.plugin = plugin;
    }

    private int timeLeft = plugin.getConfig().getInt("cooldown-seconds");

    @Override
    public void run() {
        timeLeft--;

        if (timeLeft <= 0) {
            cancel();
            gameManager.setGameState(GameState.ACTIVE);
            return;
        }

        for (UUID uuid : gameManager.getPlayerManager().getPlayers()) {
           Player player = Bukkit.getPlayer(uuid);
           if (player == null) return;

           player.sendMessage(HexUtils.colorify(plugin.getConfig().getString("game-start-message")));
        }
    }
}
