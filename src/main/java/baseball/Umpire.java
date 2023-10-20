package baseball;

import baseball.converter.IntegerInputConverter;
import baseball.converter.StringInputConverter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Umpire {

    public static int countStrike(final int originNumber, final int testNumber) {
        String[] origin = StringInputConverter.toArray(IntegerInputConverter.convertToString(originNumber));
        String[] test = StringInputConverter.toArray(IntegerInputConverter.convertToString(testNumber));

        return (int) IntStream.range(0, origin.length)
                .filter(i -> isBothSame(origin[i], test[i]))
                .count();
    }

    private static boolean isBothSame(final String origin, final String test) {
        return origin.equals(test);
    }

    public static int countBall(final int originNumber, final int testNumber) {
        String[] origin = StringInputConverter.toArray(IntegerInputConverter.convertToString(originNumber));
        String[] test = StringInputConverter.toArray(IntegerInputConverter.convertToString(testNumber));

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
