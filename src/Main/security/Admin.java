// Admin.java
package Main.security;

import Main.devices.SmartDevice;

public class Admin extends User {
    public Admin() {
        super("Admin");
    }

    @Override
    public boolean canAccessDevice(SmartDevice device) {
        return true;
    }
}
