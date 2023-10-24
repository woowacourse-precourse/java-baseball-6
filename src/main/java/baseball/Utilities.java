package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

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

    public static int countTwoStringSame(String[] strArray1, String[] strArray2) {
        return (int) IntStream.range(0, strArray1.length)
                .filter(i -> strArray1[i].equals(strArray2[i]))
                .count();
    }
}
