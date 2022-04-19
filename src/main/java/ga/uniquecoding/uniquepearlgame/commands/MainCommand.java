package ga.uniquecoding.uniquepearlgame.commands;

import dev.jorel.commandapi.CommandAPICommand;
import ga.uniquecoding.uniquepearlgame.UniquePearlGame;
import ga.uniquecoding.uniquepearlgame.managers.GameManager;
import ga.uniquecoding.uniquepearlgame.managers.GlobalManager;
import ga.uniquecoding.uniquepearlgame.managers.PlayerManager;
import ga.uniquecoding.uniquepearlgame.utils.HexUtils;
import org.bukkit.configuration.file.FileConfiguration;

public class MainCommand {

    private UniquePearlGame plugin;
    private FileConfiguration config;
    private GlobalManager manager;

    public MainCommand(UniquePearlGame plugin, GlobalManager manager) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
        this.manager = manager;
    }

    public void register() {
        CommandAPICommand gameJoin = new CommandAPICommand("join")
                .executesPlayer((player, args) -> {
                    GameManager gameManager = new GameManager(plugin);
                    PlayerManager playerManager = gameManager.getPlayerManager();

                    if (manager.containsPlayer(player.getUniqueId())) {
                        player.sendMessage(HexUtils.colorify(config.getString("already-in-game-message")));
                        return;
                    }

                    if (!playerManager.isFull()) {
                        playerManager.addPlayer(player.getUniqueId());
                    } else {
                        player.sendMessage(HexUtils.colorify(config.getString("full-game-message")));
                    }
                });

        CommandAPICommand gameLeave = new CommandAPICommand("leave")
                .executesPlayer((player, args) -> {
                    if (manager.containsPlayer(player.getUniqueId())) {
                        player.sendMessage(HexUtils.colorify(config.getString("not-in-game-message")));
                        return;
                    }
                });
    }

}
