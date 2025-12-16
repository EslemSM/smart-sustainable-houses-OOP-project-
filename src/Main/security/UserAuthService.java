package Main.security;

import java.util.HashMap;
import java.util.Map;

public class UserAuthService {
    private static final Map<String, String> credentials = new HashMap<>();
    private static final Map<String, User> users = new HashMap<>();

    static {
        // Username -> password
        credentials.put("admin", "admin123");
        credentials.put("parent", "parent123");
        credentials.put("child", "child123");
        credentials.put("guest", "guest123");

        // Username -> User object
        users.put("admin", new Admin());
        users.put("parent", new Parent());
        users.put("child", new Child());
        users.put("guest", new Guest());
    }

    public static User authenticate(String username, String password) {
        if (credentials.containsKey(username)) {
            if (credentials.get(username).equals(password)) {
                return users.get(username);
            }
        }
        return null;
    }
}
