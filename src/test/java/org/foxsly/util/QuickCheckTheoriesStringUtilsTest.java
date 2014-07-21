package org.foxsly.util;

import com.google.common.base.Strings;
import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import static org.foxsly.matcher.RegularExpressionMatcher.matchesPattern;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

/**
 * @author belcheti
 */
@RunWith(Theories.class)
public class QuickCheckTheoriesStringUtilsTest {
    @Theory
    public void stripNonAlphabeticCharactersTheory(
            @ForAll(sampleSize = 500) final String input) {
        final String output = StringUtils.stripNonAlphabeticCharacters(input);
        assertThat(output, not(matchesPattern("[^a-zA-Z]")));
    }

    @Theory
    public void capitalizeTheory(
            @ForAll @InRange(minChar = 0, maxChar = 100) final String input) {
        assumeThat(Strings.isNullOrEmpty(input), equalTo(false));
        assumeThat(Character.isLetter(input.charAt(0)), equalTo(true));
        final String output = StringUtils.capitalize(input);
        assertThat(Character.isUpperCase(output.charAt(0)), equalTo(true));
    }
}
