// DemoHomeFactory.java
package Main.home;

import Main.devices.*;

public class DemoHomeFactory {
    public static Home createDemoHome() {
        Home home = new Home();

        // Living rooms with full device set
        Room guestRoom = new Room("GuestRoom");
        guestRoom.addDevice(new Light("GuestRoom Light"));
        guestRoom.addDevice(new MotionSensor("GuestRoom MotionSensor"));
        guestRoom.addDevice(new Thermostat("GuestRoom Thermostat"));
        guestRoom.addDevice(new SmartTV("GuestRoom SmartTV"));
        guestRoom.addDevice(new AirConditioner("GuestRoom AirConditioner"));
        home.addRoom(guestRoom);

        Room famRoom = new Room("FamRoom");
        famRoom.addDevice(new Light("FamRoom Light"));
        famRoom.addDevice(new MotionSensor("FamRoom MotionSensor"));
        famRoom.addDevice(new Thermostat("FamRoom Thermostat"));
        famRoom.addDevice(new SmartTV("FamRoom SmartTV"));
        famRoom.addDevice(new AirConditioner("FamRoom AirConditioner"));
        home.addRoom(famRoom);

        // Child rooms
        Room childRoom1 = new Room("ChildRoom1");
        childRoom1.addDevice(new Light("ChildRoom1 Light"));
        childRoom1.addDevice(new MotionSensor("ChildRoom1 MotionSensor"));
        childRoom1.addDevice(new Thermostat("ChildRoom1 Thermostat"));
        childRoom1.addDevice(new SmartTV("ChildRoom1 SmartTV"));
        childRoom1.addDevice(new PlayStation("ChildRoom1 PlayStation"));
        home.addRoom(childRoom1);

        Room childRoom2 = new Room("ChildRoom2");
        childRoom2.addDevice(new Light("ChildRoom2 Light"));
        childRoom2.addDevice(new MotionSensor("ChildRoom2 MotionSensor"));
        childRoom2.addDevice(new Thermostat("ChildRoom2 Thermostat"));
        home.addRoom(childRoom2);

        // Parent room
        Room parentRoom = new Room("ParentRoom");
        parentRoom.addDevice(new Light("ParentRoom Light"));
        parentRoom.addDevice(new MotionSensor("ParentRoom MotionSensor"));
        parentRoom.addDevice(new Thermostat("ParentRoom Thermostat"));
        parentRoom.addDevice(new SmartTV("ParentRoom SmartTV"));
        parentRoom.addDevice(new AirConditioner("ParentRoom AirConditioner"));
        home.addRoom(parentRoom);

        // Admin room
        Room adminRoom = new Room("AdminRoom");
        adminRoom.addDevice(new Light("AdminRoom Light"));
        adminRoom.addDevice(new MotionSensor("AdminRoom MotionSensor"));
        adminRoom.addDevice(new Thermostat("AdminRoom Thermostat"));
        adminRoom.addDevice(new WashingMachine("AdminRoom WashingMachine"));
        adminRoom.addDevice(new GarageDoor("AdminRoom GarageDoor"));
        home.addRoom(adminRoom);

        // Guest bedroom
        Room guestBedroom = new Room("GuestBedroom");
        guestBedroom.addDevice(new Light("GuestBedroom Light"));
        guestBedroom.addDevice(new MotionSensor("GuestBedroom MotionSensor"));
        guestBedroom.addDevice(new Thermostat("GuestBedroom Thermostat"));
        home.addRoom(guestBedroom);

        // Shared spaces
        Room guestToilet = new Room("GuestToilet");
        guestToilet.addDevice(new Light("GuestToilet Light"));
        guestToilet.addDevice(new MotionSensor("GuestToilet MotionSensor"));
        home.addRoom(guestToilet);

        Room toilet1 = new Room("Toilet1");
        toilet1.addDevice(new Light("Toilet1 Light"));
        toilet1.addDevice(new MotionSensor("Toilet1 MotionSensor"));
        home.addRoom(toilet1);

        Room toilet2 = new Room("Toilet2");
        toilet2.addDevice(new Light("Toilet2 Light"));
        toilet2.addDevice(new MotionSensor("Toilet2 MotionSensor"));
        home.addRoom(toilet2);

        Room shower1 = new Room("Shower1");
        shower1.addDevice(new Light("Shower1 Light"));
        shower1.addDevice(new MotionSensor("Shower1 MotionSensor"));
        home.addRoom(shower1);

        Room shower2 = new Room("Shower2");
        shower2.addDevice(new Light("Shower2 Light"));
        shower2.addDevice(new MotionSensor("Shower2 MotionSensor"));
        home.addRoom(shower2);

        Room kitchen = new Room("Kitchen");
        kitchen.addDevice(new Light("Kitchen Light"));
        kitchen.addDevice(new Thermostat("Kitchen Thermostat"));
        home.addRoom(kitchen);

        Room diningRoom = new Room("DiningRoom");
        diningRoom.addDevice(new Light("DiningRoom Light"));
        diningRoom.addDevice(new Thermostat("DiningRoom Thermostat"));
        home.addRoom(diningRoom);

        // Global devices
        home.addGlobalDevice(new DoorLock("MainDoorLock"));
        home.addGlobalDevice(new SecurityAlarm("SecurityAlarm"));

        return home;
    }
}
