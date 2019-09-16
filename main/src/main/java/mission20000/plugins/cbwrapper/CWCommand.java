package mission20000.plugins.cbwrapper;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.jetbrains.annotations.NotNull;

public class CWCommand implements CommandExecutor {
    @NotNull private final CBWrapper cbWrapper = CBWrapper.getInstance();
    @NotNull private final PluginDescriptionFile descFile = cbWrapper.getDescription();
    @Override
    public boolean onCommand(@NotNull CommandSender sender,@NotNull  Command cmd,@NotNull  String s,@NotNull  String[] args) {
        if (!cmd.getName().equalsIgnoreCase("cw")) {
            return false;
        }
            String name = sender.getName();
            int x = 0;
            int y = 0;
            int z = 0;
            boolean haspos = false;
            World world = null;
            if((sender instanceof BlockCommandSender)) {


                Block block = ((BlockCommandSender)sender).getBlock();
                x = block.getX();
                y = block.getY();
                z = block.getZ();
                world = block.getWorld();
                haspos = true;
            }
            if(sender instanceof Player) {
                if (args.length > 0){
                    sender.sendMessage(ChatColor.DARK_RED + "Error: Executing commands with this command can only be done with a command block!");
                    return true;
                }
                sender.sendMessage(ChatColor.AQUA + "================{" + ChatColor.WHITE + descFile.getFullName() + ChatColor.AQUA + "}================");
                sender.sendMessage(ChatColor.BLUE + "Authors: " + descFile.getAuthors().toString());
                sender.sendMessage(ChatColor.BLUE + "Version: " + descFile.getVersion());
                return true;
            }

            int i;
            for(i = 0; i < args.length; i++) {

                if(args[i].equalsIgnoreCase("-u")) {
                    if(args.length - ++i >= 1) {
                        name = args[i];
                    } else {
                        sender.sendMessage("Not enough arguments for -u. Expected -u <username>");
                        return false;
                    }
                }
                if(args[i].equalsIgnoreCase("-w")) {
                    world = cbWrapper.getServer().getWorld(args[++i]);
                    if(world == null) {
                        sender.sendMessage("World '" + args[i] + "' does not exist");
                        return false;
                    }
                }
                if(args[i].equalsIgnoreCase("-o")) {
                    if(args.length - ++i >= 3) {
                        if(!haspos && args[i].startsWith("~")) {
                            sender.sendMessage("The console has no position for a relative offset");
                            return false;
                        }
                        x = Utils.parseOffset(x, args[i++]);
                        if(!haspos && args[i].startsWith("~")) {
                            sender.sendMessage("The console has no position for a relative offset");
                            return false;
                        }
                        y = Utils.parseOffset(y, args[i++]);
                        if(!haspos && args[i].startsWith("~")) {
                            sender.sendMessage("The console has no position for a relative offset");
                            return false;
                        }
                        z = Utils.parseOffset(z, args[i]);
                    } else {
                        CBWrapper.getInstance().getLogger().info("test 2");
                        sender.sendMessage("Not enough arguments for -o. Expected -o <x> <y> <z>");
                        return false;
                    }
                }
                CBWrapper.getInstance().getLogger().info("test");
            }
            Location loc = new Location(world,x,y,z);
            if (args.length > 0) {
                String concatargs = "";
                for (i = 0; i < args.length; i++) {
                    concatargs = concatargs + args[i] + " ";
                }
                if(world == null) {
                    sender.sendMessage("The -w flag is necessary for the console");
                    return true;
                }

                cbWrapper.getCompatManager().processCommand(name, loc, cbWrapper.getServer(), concatargs, sender);
            } else {
                sender.sendMessage("Not enough arguments");
                return true;
            }
            return true;
    }
}
