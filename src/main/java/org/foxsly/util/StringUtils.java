package org.foxsly.util;

/**
 * @author Tim Belcher
 */
public class StringUtils {
    private StringUtils() {} // Utility class; do not instantiate.

    /**
     * Strips out all non-alphabetic characters from the string and replaces them with nothing.
     * @param string the string to remove characters from
     * @return the alphabetic character-only string, or null if the input is null
     */
    public static String stripNonAlphabeticCharacters(String string) {
        return string != null ? string.replaceAll("[^a-zA-Z]", "") : string;
    }

    /**
     * Capitalizes the first character of a word, if it's a letter. Does nothing if it's not.
     * Doesn't handle null inputs
     * @param string the string to capitalize
     * @return the capitalized string
     */
    public static String capitalize(final String string) {
        final char firstChar = string.charAt(0);
        if (Character.isUpperCase(firstChar)) {
            // already capitalized
            return string;
        }

        return String.valueOf(Character.toUpperCase(firstChar)) + string.substring(1);
    }
}
