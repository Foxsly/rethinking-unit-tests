package org.foxsly.util;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.foxsly.matcher.RegularExpressionMatcher.matchesPattern;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeThat;

/**
 * @author Tim Belcher
 */
@RunWith(Theories.class)
public class TheoriesStringUtilsTest {
    @DataPoints
    public static String[] strings = {"sircon1", "sircon!", "sircon1!",
                                      "si1!rcon", "si rc! on", null};

    @Theory
    public void stripNonAlphabeticCharactersTheory(final String input) {
        final String output = StringUtils.stripNonAlphabeticCharacters(input);
        assertThat(output, not(matchesPattern("[^a-zA-Z]")));
    }

    @Theory
    public void capitalizeTheory(final String input) {
        assumeNotNull(input);
        assumeThat(Character.isLetter(input.charAt(0)), equalTo(true));
        final String output = StringUtils.capitalize(input);
        assertThat(Character.isUpperCase(output.charAt(0)), equalTo(true));
    }

    @Test(expected = NullPointerException.class)
    public void testCapitalize_null() {
        StringUtils.capitalize(null);
    }
}
