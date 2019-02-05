package misson20000.plugins.cbwrapper;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.block.Block;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Location;
import org.bukkit.World;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;

public final class CBWrapper extends JavaPlugin {
        
    private WorldEditPlugin  wePlugin;
    private WorldEditAdapter weAdapter;
    private static CBWrapper instance;
        
    private Map<String, DummyPlayer> dummies;
        
    @Override
    public void onEnable() {
        dummies = new HashMap<String, DummyPlayer>();
        this.getCommand("cw").setExecutor(new CWCommand());
        wePlugin = (WorldEditPlugin) this.getServer().getPluginManager().getPlugin("WorldEdit");
        if(wePlugin != null) {
            try {
                weAdapter = new WorldEditAdapter(wePlugin.getWorldEdit().getSessionManager());
            } catch(ReflectiveOperationException e) {
                weAdapter = null;
                wePlugin  = null;
                e.printStackTrace();
                this.getLogger().warning("Error while initializing WorldEditAdapter. Report this to CBWrapper devs. Until this is fixed, CBWrapper won't work properly with WorldEdit");
            }
        }
    }
    @Override
    public void onDisable() {

    }

    @Override
    public void onLoad() {
        instance = this;
    }



    public WorldEditAdapter getWEAdapter() {
        return weAdapter;
    }

    public WorldEditPlugin getWEPlugin() {
        return wePlugin;
    }

    public Map<String, DummyPlayer> getDummies() {
        return dummies;
    }

    public static synchronized CBWrapper getInstance() {
        return instance;
    }
}

