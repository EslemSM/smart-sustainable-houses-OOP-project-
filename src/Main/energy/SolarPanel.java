// SolarPanel.java
package Main.energy;

public class SolarPanel {
    private double currentOutput;

    // Simulate solar generation each update
    public double generateEnergy() {
        // Generate between 5 and 10 units per tick
        currentOutput = 5 + Math.random() * 5;
        return currentOutput;
    }

    public double getCurrentOutput() {
        return currentOutput;
    }
}
