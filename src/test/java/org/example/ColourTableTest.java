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

}
