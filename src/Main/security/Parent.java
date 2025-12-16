// Parent.java
package Main.security;

import Main.devices.SmartDevice;

public class Parent extends User {
    public Parent() {
        super("Parent");
    }

    @Override
    public boolean canAccessDevice(SmartDevice device) {
        return true;
    }
}
