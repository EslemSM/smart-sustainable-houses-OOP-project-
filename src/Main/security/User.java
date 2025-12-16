// User.java
package Main.security;

import Main.devices.SmartDevice;

public abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public abstract boolean canAccessDevice(SmartDevice device);

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}
