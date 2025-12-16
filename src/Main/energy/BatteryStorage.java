// BatteryStorage.java
package Main.energy;

public class BatteryStorage {
    private double capacity;
    private double charge;

    public BatteryStorage(double capacity, double initialCharge) {
        this.capacity = capacity;
        this.charge = Math.min(initialCharge, capacity);
    }

    public void charge(double amount) {
        this.charge = Math.min(this.capacity, this.charge + amount);
    }

    public void discharge(double amount) {
        this.charge = Math.max(0, this.charge - amount);
    }

    public double getCharge() {
        return this.charge;
    }

    public double getChargePercent() {
        return (charge / capacity) * 100.0;
    }
}
