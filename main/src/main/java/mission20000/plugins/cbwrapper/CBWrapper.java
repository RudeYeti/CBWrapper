package mission20000.plugins.cbwrapper;

import java.lang.reflect.InvocationTargetException;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class CBWrapper extends JavaPlugin {
        
    private CompatManager compatManager;
    private static CBWrapper instance;
        
    @Override
    public void onEnable() {

        String packageName = getServer().getClass().getPackage().getName();
        String version = packageName.substring(packageName.lastIndexOf('.') + 1);
        this.getCommand("cw").setExecutor(new CWCommand());
        try {
            final Class clazz = Class.forName("mission20000.plugins.cbwrapper.compat." +version+".ICompatManager");
            if (CompatManager.class.isAssignableFrom(clazz)){
                compatManager = (CompatManager) clazz.getConstructor(Plugin.class).newInstance(this);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
            getLogger().severe("Could not find support for this version: " + version);

            throw new UnsupportedVersionException("Server version is not supported!",e);

        }
    }
    @Override
    public void onDisable() {

    }

    @Override
    public void onLoad() {
        instance = this;
    }

    public static synchronized CBWrapper getInstance() {
        return instance;
    }

    public CompatManager getCompatManager(){
        return compatManager;
    }

    private class UnsupportedVersionException extends RuntimeException{
        UnsupportedVersionException(String msg, Throwable cause){
            super(msg,cause);
            getServer().getPluginManager().disablePlugin(CBWrapper.getInstance());
        }
    }
}

