package mission20000.plugins.cbwrapper;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public abstract class CompatManager {
    protected WorldEditPlugin wePlugin;
    protected WorldEditAdapter weAdapter;
    protected Plugin plugin;
    public CompatManager(Plugin plugin){
        this.plugin = plugin;
        wePlugin = (WorldEditPlugin) this.plugin.getServer().getPluginManager().getPlugin("WorldEdit");
        if(wePlugin != null) {
            try {
                weAdapter = new WorldEditAdapter(wePlugin.getWorldEdit().getSessionManager());
            } catch(ReflectiveOperationException e) {
                weAdapter = null;
                wePlugin  = null;
                e.printStackTrace();
                this.plugin.getLogger().warning("Error while initializing WorldEditAdapter. Report this to CBWrapper devs. Until this is fixed, CBWrapper won't work properly with WorldEdit");
            }
        }
    }
    public abstract void processCommand(String dummyName, Location loc, Server server, String command, CommandSender sender);
}
