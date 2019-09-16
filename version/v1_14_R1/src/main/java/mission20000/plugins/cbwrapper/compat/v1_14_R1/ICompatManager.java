package mission20000.plugins.cbwrapper.compat.v1_14_R1;



import mission20000.plugins.cbwrapper.CompatManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;

public class ICompatManager extends CompatManager {
    public ICompatManager(Plugin plugin) {
        super(plugin);
    }
    private final Map<String, DummyPlayer> dummies = new HashMap<>();
    @Override
    public void processCommand(String dummyName, Location loc, Server server, String command, CommandSender sender) {
        DummyPlayer dummy;

        if(dummies.containsKey(dummyName)) {
            dummy = dummies.get(dummyName);
            dummy.teleport(loc);
        } else {
            dummy = DummyPlayer.createDummyPlayer(dummyName,server,new Vector(loc.getX(),loc.getY(),loc.getZ()),loc.getWorld());//new DummyPlayer(name, cbWrapper.getServer(), world, x, y, z);

            if(weAdapter != null) {
                weAdapter.createSession(dummy.getUniqueId(), wePlugin.wrapPlayer(dummy).getSessionKey());
            }

            dummies.put(dummyName, dummy);
        }
        plugin.getLogger().info(command);
        try {
            plugin.getLogger().info(String.format("Processing command %s by dummy player %s", command, dummy.getName()));
            if (dummy.performCommand(command)){
                plugin.getLogger().info(String.format("Command %s by dummy player %s sucessfully processed", command, dummy.getName()));
                plugin.getLogger().info(dummy.getCommandResult());
                sender.sendMessage(dummy.getCommandResult());
            }
        } catch (CommandException e){
            plugin.getLogger().warning(e.getMessage());
            e.printStackTrace();
        }

    }
}
