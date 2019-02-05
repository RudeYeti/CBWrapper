package misson20000.plugins.cbwrapper;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

import java.util.Map;

public class CWCommand implements CommandExecutor {
    CBWrapper cbWrapper = CBWrapper.getInstance();
    PluginDescriptionFile descFile = cbWrapper.getDescription();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("cb") || cmd.getName().equalsIgnoreCase("cw")) {
            String name = sender.getName();
            int x = 0;
            int y = 0;
            int z = 0;
            boolean haspos = false;
            World world = null;
            if((sender instanceof BlockCommandSender)) {
                Block block = ((BlockCommandSender)sender).getBlock();
                x = block.getLocation().getBlockX();
                y = block.getLocation().getBlockY();
                z = block.getLocation().getBlockZ();
                world = block.getLocation().getWorld();
                haspos = true;
            }
            if(sender instanceof Player) {
                if (args.length > 0){
                    sender.sendMessage(ChatColor.DARK_RED + "Error: Executing commands with this command can only be done with a command block!");
                }
                sender.sendMessage(ChatColor.AQUA + "================{" + ChatColor.WHITE + descFile.getFullName() + ChatColor.AQUA + "}================");
                sender.sendMessage(ChatColor.BLUE + "Authors: " + descFile.getAuthors().toString());
                sender.sendMessage(ChatColor.BLUE + "Version: " + descFile.getVersion());
                return true;
            }

            int i;
            for(i = 0; i < args.length; i++) {
                if(!args[i].startsWith("-")) {
                    break;
                }
                if(args[i].equals("-u")) {
                    if(args.length - ++i >= 1) {
                        name = args[i];
                    } else {
                        sender.sendMessage("Not enough arguments for -u. Expected -u <username>");
                        return false;
                    }
                }
                if(args[i].equals("-w")) {
                    world = cbWrapper.getServer().getWorld(args[++i]);
                    if(world == null) {
                        sender.sendMessage("World '" + args[i] + "' does not exist");
                        return false;
                    }
                }
                if(args[i].equals("-o")) {
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
                        sender.sendMessage("Not enough arguments for -o. Expected -o <x> <y> <z>");
                        return false;
                    }
                }
            }
            if (args.length > 0) {
                String concatargs = "";
                for (; i < args.length; i++) {
                    concatargs = concatargs + args[i] + " ";
                }
                if(world == null) {
                    sender.sendMessage("The -w flag is necessary for the console");
                    return false;
                }

                DummyPlayer dummy;
                Map<String, DummyPlayer> dummies = cbWrapper.getDummies();
                WorldEditAdapter weAdapter = cbWrapper.getWEAdapter();
                WorldEditPlugin wePlugin = cbWrapper.getWEPlugin();
                if(dummies.containsKey(name)) {
                    dummy = dummies.get(name);
                    dummy.teleport(new Location(world, x, y, z));
                } else {
                    dummy = new DummyPlayer(name, cbWrapper.getServer(),
                            world, x, y, z);

                    if(weAdapter != null) {
                        weAdapter.createSession(dummy.getUniqueId(), wePlugin.wrapPlayer(dummy).getSessionKey());
                    }

                    dummies.put(name, dummy);
                }
                cbWrapper.getServer().dispatchCommand(dummy, concatargs);
            } else {
                sender.sendMessage("Not enough arguments");
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
