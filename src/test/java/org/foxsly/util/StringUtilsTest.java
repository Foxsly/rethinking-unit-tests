package org.foxsly.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Tim Belcher
 */
public class StringUtilsTest {

    @Test
    public void testStripNonAlphabeticCharacters_null() {
        String input = null;
        String output = StringUtils.stripNonAlphabeticCharacters(input);
        assertNull("Null should be returned", output);
    }

    @Test
    public void testStripNonAlphabeticCharacters_withNumbers() {
        String input = "Sircon1";
        String output = StringUtils.stripNonAlphabeticCharacters(input);
        assertEquals("Numbers should be stripped", "Sircon", output);
    }

    @Test
    public void testStripNonAlphabeticCharacters_withSpecialCharacters() {
        String input = "Sircon!";
        String output = StringUtils.stripNonAlphabeticCharacters(input);
        assertEquals("Special Characters should be stripped", "Sircon", output);
    }

    @Test
    public void testStripNonAlphabeticCharacters_withNumbersAndSpecialCharacters() {
        String input = "Sircon1!";
        String output = StringUtils.stripNonAlphabeticCharacters(input);
        assertEquals("Numbers and Special Characters should be stripped", "Sircon", output);
    }
}
