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

    // Get the number of colors allowed in the ColourTable
    public int getNumColors() {
        return this.numColors;
    }

    // Add a new color to the ColourTable
    public void add(int red, int green, int blue) {
        if (!areRGBValuesValid(red, green, blue)) {
            throw new IllegalArgumentException("Invalid RGB values. Each component must be between 0 and 255.");
        }
        if (currentCount >= numColors) {
            throw new IllegalStateException("The color table is full. Cannot add more colors.");
        }

        // Combine RGB values into a single integer
        int color = (red << 16) | (green << 8) | blue;

        // Check if the color is already in the set (duplicate)
        if (colorSet.contains(color)) {
            throw new IllegalStateException("Duplicate color. Cannot add the same color more than once.");
        }

        colorSet.add(color);
        currentCount++;
    }

    // Check if the provided RGB values are valid : test if they are within the range of 0-255
    public static boolean areRGBValuesValid(int red, int green, int blue) {
        return (red >= 0 && red <= 255) &&
                (green >= 0 && green <= 255) &&
                (blue >= 0 && blue <= 255);
    }

    // Compare two ColourTables to check if they contain the same set of colors
    public boolean comparison(ColourTable otherColourTable) {
        if (otherColourTable == null) {
            return false;
        }
        return this.colorSet.equals(otherColourTable.colorSet);
    }

}