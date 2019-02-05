package misson20000.plugins.cbwrapper;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Utils {
    public static int parseOffset(int orig, String offset) {
        if(offset.startsWith("~")) {
            if(offset.length() > 1) {
                return orig + Integer.parseInt(offset.substring(1));
            } else {
                return orig;
            }
        } else {
            return Integer.parseInt(offset);
        }
    }

    public static void sendToOps(String message){
        for (Player p : Bukkit.getOnlinePlayers()){
            if (!p.isOp()){
                continue;
            }
            p.sendMessage(message);
        }
    }
}
