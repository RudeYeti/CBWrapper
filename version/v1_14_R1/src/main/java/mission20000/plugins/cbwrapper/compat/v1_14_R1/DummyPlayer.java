package mission20000.plugins.cbwrapper.compat.v1_14_R1;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_14_R1.EntityPlayer;
import net.minecraft.server.v1_14_R1.PlayerInteractManager;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_14_R1.CraftServer;
import org.bukkit.craftbukkit.v1_14_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPlayer;
import org.bukkit.util.Vector;

import java.util.UUID;

public class DummyPlayer extends CraftPlayer{
    private String commandResult = "";

    private DummyPlayer(CraftServer server, EntityPlayer player){
        super(server,player);
    }
    public static DummyPlayer createDummyPlayer(String name, Server server, Vector pos, World world){
        CraftServer cServer = (CraftServer) server;
        CraftWorld craftWorld = (CraftWorld) world;
        PlayerInteractManager pim = new PlayerInteractManager(craftWorld.getHandle());
        UUID id = UUID.nameUUIDFromBytes(name.getBytes());
        GameProfile gp = new GameProfile(id, name);
        EntityPlayer player = new EntityPlayer(cServer.getServer(),((CraftWorld)world).getHandle(),gp,pim);
        player.setPosition(pos.getX(), pos.getY(),pos.getZ());
        return new DummyPlayer(cServer,player);
    }

    @Override
    public void sendMessage(String message) {
        super.sendMessage(message);
        commandResult = message;
    }

    public void sendMessage(String[] messages){
        super.sendMessage(messages);
        commandResult = String.join(" ", messages);
    }

    public String getCommandResult() {
        return commandResult;
    }
}
