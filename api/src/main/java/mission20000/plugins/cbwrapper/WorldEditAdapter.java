package mission20000.plugins.cbwrapper;
 
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.session.SessionKey;
import com.sk89q.worldedit.session.SessionManager;
import com.sk89q.worldedit.session.storage.SessionStore;
 
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.UUID;
 
public class WorldEditAdapter {
    private final Map<UUID, Object> sessionsObject;
    private final SessionStore storeObject;
    private final Constructor<?> sessionHolderConstructor;
 
    @SuppressWarnings("unchecked")
    public WorldEditAdapter(SessionManager manager) throws ReflectiveOperationException {
        final Field sessionsField = SessionManager.class.getDeclaredField("sessions");
        sessionsField.setAccessible(true);
        sessionsObject = (Map<UUID, Object>) sessionsField.get(manager);
 
        final Field storeField = SessionManager.class.getDeclaredField("store");
        storeField.setAccessible(true);
        storeObject = (SessionStore) storeField.get(manager);
 
        Class<?> sessionHolderClass = null;
 
        for (Class<?> clazz : SessionManager.class.getDeclaredClasses()) {
            if (clazz.getSimpleName().equals("SessionHolder")) {
                sessionHolderClass = clazz;
                break;
            }
        }
 
        if (sessionHolderClass == null)
            throw new ReflectiveOperationException("SessionHolder class not found");
 
        sessionHolderConstructor = sessionHolderClass.getDeclaredConstructor(SessionKey.class, LocalSession.class);
        sessionHolderConstructor.setAccessible(true);
    }
 
    public void createSession(UUID uuid, SessionKey sessionKey) {
        try {
            sessionsObject.put(uuid,
                               sessionHolderConstructor.newInstance(sessionKey, storeObject.load(uuid)));
        } catch (ReflectiveOperationException | IOException e) {
            e.printStackTrace();
        }
    }
    public static void initialize(){

    }
} 
