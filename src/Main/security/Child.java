// Child.java
package Main.security;

import Main.devices.SmartDevice;
import Main.devices.Light;
import Main.devices.SmartTV;

public class Child extends User {
    public Child() {
        super("Child");
    }

    @Override
    public boolean canAccessDevice(SmartDevice device) {
        // Child can only access lights and smart TVs
        return (device instanceof Light) || (device instanceof SmartTV);
    }
}
