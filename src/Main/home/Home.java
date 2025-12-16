// Home.java
package Main.home;

import java.util.ArrayList;
import java.util.List;

import Main.devices.SmartDevice;
import Main.exceptions.DeviceNotFoundException;

public class Home {

    private List<Room> rooms;
    private List<SmartDevice> globalDevices;

    public Home() {
        rooms = new ArrayList<>();
        globalDevices = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addGlobalDevice(SmartDevice device) {
        globalDevices.add(device);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<SmartDevice> getGlobalDevices() {
        return globalDevices;
    }

    public List<SmartDevice> getAllDevices() {
        List<SmartDevice> all = new ArrayList<>();
        for (Room room : rooms) {
            all.addAll(room.getDevices());
        }
        all.addAll(globalDevices);
        return all;
    }

    // ✅ NEW METHOD — Custom exception usage
    public SmartDevice getDeviceByName(String name)
            throws DeviceNotFoundException {

        for (SmartDevice device : getAllDevices()) {
            if (device.getName().equalsIgnoreCase(name)) {
                return device;
            }
        }

        throw new DeviceNotFoundException(
                "Device with name '" + name + "' not found."
        );
    }
}
