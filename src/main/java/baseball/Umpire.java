package baseball;

import java.util.Arrays;
import java.util.HashSet;

public class Umpire {

    public static int countStrike(final int originNumber, final int testNumber) {
        int count = 0;
        String[] origin = convertStringToArray(convertNumberToString(originNumber));
        String[] test = convertStringToArray(convertNumberToString(testNumber));

        for (int i = 0; i < origin.length; i++) {
            if (isBothSame(origin[i], test[i])) {
                count++;
            }
        }

        return count;
    }

    private static String convertNumberToString(final int number) {
        return String.valueOf(number);
    }

    private static String[] convertStringToArray(final String input) {
        return input.split("");
    }

    private static boolean isBothSame(final String origin, final String test) {
        return origin.equals(test);
    }

    public static int countBall(final int originNumber, final int testNumber) {
        String[] origin = convertStringToArray(convertNumberToString(originNumber));
        String[] test = convertStringToArray(convertNumberToString(testNumber));

        boolean[] onlyOrigin = new boolean[origin.length];
        boolean[] onlyTest = new boolean[test.length];
        Arrays.fill(onlyOrigin, true);
        Arrays.fill(onlyTest, true);

        for (int i = 0; i < 3; i++) {
            if (origin[i].equals(test[i])) {
                onlyOrigin[i] = false;
                onlyTest[i] = false;
            }
        }

        HashSet<String> originSet = new HashSet<>();
        HashSet<String> testSet = new HashSet<>();

        for (int i = 0; i < origin.length; i++) {
            if (onlyOrigin[i]) {
                originSet.add(origin[i]);
            }
            if (onlyTest[i]) {
                testSet.add(test[i]);
            }
        }

        originSet.retainAll(testSet);

        return originSet.size();
    }
}
