package ga.uniquecoding.uniquepearlgame;

import ga.uniquecoding.uniquepearlgame.managers.GlobalManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class UniquePearlGame extends JavaPlugin {

    private GlobalManager manager;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.manager = new GlobalManager(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
