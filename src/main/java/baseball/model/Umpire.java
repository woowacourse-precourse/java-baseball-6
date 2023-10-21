package baseball.model;

import static baseball.Constants.PLAY_NUMBER_DIGIT;

import baseball.converter.IntegerInputConverter;
import baseball.converter.StringInputConverter;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Umpire {

    private static final int DEFAULT_NUMBER = 0;

    private int computerNumber;
    private int userNumber;
    private boolean endFlag;

    private Umpire(final int computerNumber, final int userNumber, final boolean flag) {
        this.computerNumber = computerNumber;
        this.userNumber = userNumber;
        this.endFlag = flag;
    }

    public static Umpire createDefault() {
        return new Umpire(DEFAULT_NUMBER, DEFAULT_NUMBER, false);
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

        boolean[] match = recordMatchedPositions(origin, test);

        Set<String> onlyOriginSet = createSet(origin, match);
        Set<String> onlyTestSet = createSet(test, match);

        intersection(onlyOriginSet, onlyTestSet);

        return calculateSize(onlyOriginSet);
    }

    private boolean[] recordMatchedPositions(final String[] origin, final String[] test) {
        boolean[] match = new boolean[origin.length];

        for (int i = 0; i < origin.length; i++) {
            if (origin[i].equals(test[i])) {
                match[i] = true;
            }
        }

        return match;
    }

    private Set<String> createSet(final String[] array, final boolean[] match) {
        return IntStream.range(0, array.length)
                .filter(i -> !match[i])
                .mapToObj(i -> array[i])
                .collect(Collectors.toCollection(HashSet::new));
    }

    private void intersection(final Set<String> origin, final Set<String> test) {
        origin.retainAll(test);
    }

    private int calculateSize(final Set<String> set) {
        return set.size();
    }

    public boolean isGameEnd() {
        if (isGameFinish()) {
            endFlag = true;
        }
        return endFlag;
    }

    private boolean isGameFinish() {
        return countStrike() == PLAY_NUMBER_DIGIT;
    }

    public void prepareJudgement(final int computerNumber, final int userNumber) {
        this.computerNumber = computerNumber;
        this.userNumber = userNumber;
    }

    public void resetGame() {
        this.computerNumber = DEFAULT_NUMBER;
        this.userNumber = DEFAULT_NUMBER;
        this.endFlag = false;
    }
}
