package Main.controller;

import Main.devices.*;
import Main.energy.EnergyManager;
import Main.energy.EnergyMode;
import Main.home.Home;
import Main.home.Room;
import Main.security.User;

import java.time.LocalTime;

public class CentralController implements AutomationController {

    private final Home home;
    private final EnergyManager energyManager;

    public CentralController(Home home, EnergyManager energyManager) {
        this.home = home;
        this.energyManager = energyManager;
    }

    // Called on each system tick with user context
    @Override
    public void tick(LocalTime systemTime, User currentUser) {

        // 🕙 Rule 1: Shut off all lights at 10:00 PM
        if (systemTime.getHour() == 22 && systemTime.getMinute() == 0) {
            home.getAllDevices().stream()
                    .filter(d -> d instanceof Light && d.isOn()
                            && currentUser.canAccessDevice(d))
                    .forEach(SmartDevice::turnOff);
        }

        // 🔋 Rule 2: Force ECO mode if battery < 10%
        if (energyManager.getBattery().getChargePercent() < 10
                && energyManager.getMode() != EnergyMode.ECO) {
            energyManager.getBattery().discharge(1);
            energyManager.decideMode();
        }

        // 🎮 Rule 3: Block Child from PlayStation after 8 PM
        if (currentUser.getName().equals("Child")
                && systemTime.getHour() >= 20) {
            home.getAllDevices().stream()
                    .filter(d -> d instanceof PlayStation && d.isOn()
                            && currentUser.canAccessDevice(d))
                    .forEach(SmartDevice::turnOff);
        }

        // 🚨 Rule 4: Disarm security alarm in ECO mode
        if (energyManager.getMode() == EnergyMode.ECO) {
            home.getAllDevices().stream()
                    .filter(d -> d instanceof SecurityAlarm && d.isOn())
                    .forEach(SmartDevice::turnOff);
        }

        // ❄️ Rule 5: Turn off AdminRoom AC if battery < 15%
        if (energyManager.getBattery().getChargePercent() < 15) {
            for (Room room : home.getRooms()) {
                if (room.getName().equals("AdminRoom")) {
                    room.getDevices().stream()
                            .filter(d -> d instanceof AirConditioner && d.isOn())
                            .forEach(SmartDevice::turnOff);
                }
            }
        }
    }

    public EnergyMode getCurrentEnergyMode() {
        return energyManager.getMode();
    }

    public double getBatteryLevel() {
        return energyManager.getBattery().getChargePercent();
    }
}
