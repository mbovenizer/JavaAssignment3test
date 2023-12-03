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
}
