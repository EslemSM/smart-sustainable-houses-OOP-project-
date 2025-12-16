// Room.java
package Main.home;

import java.util.ArrayList;
import java.util.List;
import Main.devices.SmartDevice;

public class Room {
    private String name;
    private List<SmartDevice> devices;

    public Room(String name) {
        this.name = name;
        this.devices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    public List<SmartDevice> getDevices() {
        return devices;
    }
}
