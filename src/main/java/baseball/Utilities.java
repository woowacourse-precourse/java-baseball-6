package baseball;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Utilities {

    public static String combineStrings(String target, String input) {
        return target + input;
    }

    public static int stringLength(String str) {
        return str.length();
    }

    public static String[] stringSplitToCharactersArray(String str) {
        return str.split("");
    }

    public static Set<String> arrayToSet(String[] array) {
        Set<String> set = new HashSet<>(Arrays.asList(array));
        return set;
    }

    public static int sizeOfSet(Set<String> set) {
        return set.size();
    }
}
