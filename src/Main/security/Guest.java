// Guest.java
package Main.security;

import Main.devices.SmartDevice;
import Main.devices.Light;

public class Guest extends User {
    public Guest() {
        super("Guest");
    }

    @Override
    public boolean canAccessDevice(SmartDevice device) {
        // Guest can only access lights
        return (device instanceof Light);
    }
}
