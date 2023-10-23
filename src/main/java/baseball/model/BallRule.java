package baseball.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BallRule implements GameRule {

    @Override
    public int calculate(final String computerNumber, final String userNumber) {
        String[] computerValues = computerNumber.split("");
        String[] userValues = userNumber.split("");

        boolean[] match = recordMatchedPositions(computerValues, userValues);

        Set<String> onlyComputerSet = createUniqueNumberSet(computerValues, match);
        Set<String> onlyUserSet = createUniqueNumberSet(userValues, match);

        onlyComputerSet.retainAll(onlyUserSet);

        return onlyComputerSet.size();
    }

    private boolean[] recordMatchedPositions(final String[] computerValues, final String[] userValues) {
        boolean[] match = new boolean[computerValues.length];

        for (int i = 0; i < computerValues.length; i++) {
            if (computerValues[i].equals(userValues[i])) {
                match[i] = true;
            }
        }

        return match;
    }

    private Set<String> createUniqueNumberSet(final String[] numbers, final boolean[] match) {
        return IntStream.range(0, numbers.length)
                .filter(index -> !match[index])
                .mapToObj(index -> numbers[index])
                .collect(Collectors.toCollection(HashSet::new));
    }
}
