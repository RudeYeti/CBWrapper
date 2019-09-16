package mission20000.plugins.cbwrapper.compat.v1_13_R2;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_13_R2.EntityPlayer;
import net.minecraft.server.v1_13_R2.PlayerInteractManager;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_13_R2.CraftServer;
import org.bukkit.craftbukkit.v1_13_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_13_R2.entity.CraftPlayer;
import org.bukkit.util.Vector;

import java.util.UUID;

public class DummyPlayer extends CraftPlayer{

    private DummyPlayer(CraftServer server, EntityPlayer player){
        super(server,player);
    }
    public static DummyPlayer createDummyPlayer(String name, Server server, Vector pos, World world){
        CraftServer cServer = (CraftServer) server;
        PlayerInteractManager pim = new PlayerInteractManager((net.minecraft.server.v1_13_R2.World) world);
        UUID id = UUID.nameUUIDFromBytes(name.getBytes());
        GameProfile gp = new GameProfile(id, name);
        EntityPlayer player = new EntityPlayer(cServer.getServer(),((CraftWorld)world).getHandle(),gp,pim);
        player.setPosition(pos.getX(), pos.getY(),pos.getZ());
        return new DummyPlayer(cServer,player);
    }
}
