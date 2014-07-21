package org.foxsly.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

/**
 * @author Tim Belcher
 */
@RunWith(Parameterized.class)
public class ParameterizedStringUtilsTest {

    @Parameters(name = "{index}: strip {0} = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {null, null}, {"Sircon1", "Sircon"}, {"Sircon!", "Sircon"},
            {"Sircon1!", "Sircon"}, {"Sir1!con", "Sircon"}, {"!1Sircon", "Sircon"}
        });
    }

    @Parameter(value = 0) public String input;

    @Parameter(value = 1) public String expected;

    @Test
    public void testStripNonAlphabeticCharacters() {
        String output = StringUtils.stripNonAlphabeticCharacters(input);
        assertEquals(expected, output);
    }
}
