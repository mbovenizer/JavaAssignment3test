package org.example;
import java.util.HashSet;
import java.util.Set;

public class ColourTable {
    private int numColors;
    private Set<Integer> colorSet; // Stores all the colors as combined RGB values
    private int currentCount;

    public ColourTable(int numColors) {
        if (numColors > 255 || numColors < 0) {
            throw new IllegalArgumentException("Invalid palette size. It must be a power of two, greater than 1, and less than 1025.");
        }
        this.numColors = numColors;
        this.colorSet = new HashSet<>();
        this.currentCount = 0;
    }

    // Check if the ColourTable satisfies certain requirements
    public boolean satisfiesRequirements() {
        // Check if numColors is a power of two, and within the range 2 to 1024
        return (numColors & (numColors - 1)) == 0 && numColors > 1 && numColors < 1025;
    }
}