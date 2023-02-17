package lavarisingtest.lavarisingtest;

import lavarisingtest.lavarisingtest.Commands.CreateWorld;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.plugin.java.JavaPlugin;

public final class LavaRisingTest extends JavaPlugin {

    public static MiniMessage mm = MiniMessage.miniMessage();
    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("createworld").setExecutor(new CreateWorld());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
