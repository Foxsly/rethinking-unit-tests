package org.foxsly.util;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @author Tim Belcher
 */
@RunWith(Enclosed.class)
public class EnclosedParameterizedStringUtilsTest {
    @RunWith(Parameterized.class)
    public static class StripNonAlphabeticCharactersTest {
        @Parameterized.Parameters(name = "{index}: strip {0} = {1}")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {null, null}, {"Sircon1", "Sircon"}, {"Sircon!", "Sircon"},
                    {"Sircon1!", "Sircon"}, {"Sir1!con", "Sircon"}, {"!1Sircon", "Sircon"}
            });
        }
        @Parameterized.Parameter(value = 0) public String input;
        @Parameterized.Parameter(value = 1) public String expected;

        @Test
        public void testStripNonAlphabeticCharacters() {
            String output = StringUtils.stripNonAlphabeticCharacters(input);
            assertEquals(expected, output);
        }
    }

    @RunWith(Parameterized.class)
    public static class CapitalizeTest {
        @Parameterized.Parameters(name = "{index}: strip {0} = {1}")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"sircon1", "Sircon1"}, {"junit", "Junit"},
                    {"1sircon", "1sircon"}, {"tim belcher", "Tim Belcher"}
            });
        }
        @Parameterized.Parameter(value = 0) public String input;
        @Parameterized.Parameter(value = 1) public String expected;

        @Test
        public void testStripNonAlphabeticCharactersCapitalize() {
            String output = StringUtils.capitalize(input);
            assertEquals(expected, output);
        }
    }
}
