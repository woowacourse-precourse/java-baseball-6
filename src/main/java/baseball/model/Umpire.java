package baseball.model;

import baseball.Constants;
import baseball.converter.IntegerInputConverter;
import baseball.converter.StringInputConverter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Umpire {

    private static final int DEFAULT_NUMBER = 0;

    private int computerNumber;
    private int userNumber;

    private Umpire(final int computerNumber, final int userNumber) {
        this.computerNumber = computerNumber;
        this.userNumber = userNumber;
    }

    public static Umpire createDefault() {
        return new Umpire(DEFAULT_NUMBER, DEFAULT_NUMBER);
    }

    public int countStrike() {
        String[] origin = StringInputConverter.toArray(IntegerInputConverter.toString(computerNumber));
        String[] test = StringInputConverter.toArray(IntegerInputConverter.toString(userNumber));

        return (int) IntStream.range(0, origin.length)
                .filter(i -> isBothSame(origin[i], test[i]))
                .count();
    }

    private boolean isBothSame(final String origin, final String test) {
        return origin.equals(test);
    }

    public int countBall() {
        String[] origin = StringInputConverter.toArray(IntegerInputConverter.toString(computerNumber));
        String[] test = StringInputConverter.toArray(IntegerInputConverter.toString(userNumber));

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

    public void prepareJudgement(final int computerNumber, final int userNumber) {
        this.computerNumber = computerNumber;
        this.userNumber = userNumber;
    }

    public boolean isGameEnd() {
        return countStrike() == Constants.PLAY_NUMBER_DIGIT;
    }
}
