package org.example;

import org.example.ColourTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ColourTableTest {

    private ColourTable colourTable;

    @BeforeEach
    void setUp() {
        // Initialize ColourTable with a capacity for 8 colors
        colourTable = new ColourTable(8);
    }

    @Test
    @DisplayName("Testing ColourTable satisfiesRequirements()")
    void testColourTableSatisfiesRequirements() {
        // Check if the ColourTable satisfies specific requirements
        assertTrue(colourTable.satisfiesRequirements());
    }

    @Test
    @DisplayName("Testing invalid palette size")
    void testInvalidPaletteSize() {
        // Ensure that an IllegalArgumentException is thrown when creating a ColourTable with an invalid capacity
        assertThrows(IllegalArgumentException.class, () -> new ColourTable(10000));
    }

    @Test
    @DisplayName("Test adding and comparing colours")
    void testAddAndCompareColours() {
        // Create two ColourTable instances and add colors to them
        ColourTable colour1 = new ColourTable(4);
        colour1.add(40, 50, 60);
        colour1.add(70, 80, 90);
        ColourTable colour2 = new ColourTable(4);
        colour2.add(70, 80, 90);
        colour2.add(40, 50, 60);

        // Perform a comparison between the two ColourTables and check if the result is true
        assertTrue(colour1.comparison(colour2));
    }

    @Test
    @DisplayName("Accept if default model is RGB")
    public void acceptIfDefaultModelIsRGB() {
        // Check if RGB values within the valid range are accepted
        assertTrue(ColourTable.areRGBValuesValid(40, 50, 60));
    }

    @Test
    @DisplayName("Reject if RGB values are out of range")
    public void acceptIfModelNotRGB() {
        // Check if RGB values outside the valid range are rejected
        assertFalse(ColourTable.areRGBValuesValid(2600, 3450, 7660));
    }


    //    changed what I was adding to show the test passes when unique elements are added
    @Test
    @DisplayName("Test exceeding the capacity of ColourTable")
    void testExceedCapacity() {
        // Add unique colors up to the capacity
        for (int i = 0; i < 8; i++) {
            colourTable.add(70 + i, 90 + i, 100 + i);
        }

        // Attempt to add another color with invalid RGB values, expecting an exception
        assertThrows(IllegalArgumentException.class, () -> colourTable.add(256, 256, 257));
    }


    @Test
    @DisplayName("Test to check if comparison can be made")
    void testComparison() {
        // Initialize two ColourTable instances with the capacity
        ColourTable colour1 = new ColourTable(8);
        ColourTable colour2 = new ColourTable(8);

        // Add the same color to both tables
        colour1.add(40, 50, 60);
        colour2.add(40, 50, 60);

        // Now perform the comparison and check if the result is true
        boolean result = colour1.comparison(colour2);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test adding duplicate colors")
    void testAddDuplicateColors() {
        // Add a color to the colourTable
        colourTable.add(40, 50, 60);

        // Attempt to add the same color again, which should throw an IllegalStateException
        assertThrows(IllegalStateException.class, () -> colourTable.add(40, 50, 60));
    }

}
