package baseball.model.rule;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BallRule implements GameRule {

    @Override
    public int calculate(final String computerNumber, final String userNumber) {
        String[] computerValues = computerNumber.split("");
        String[] userValues = userNumber.split("");

        boolean[] strikeRecord = recordStrikePositions(computerValues, userValues);

        Set<String> onlyComputerSet = createUniqueNumberSetExceptStrike(computerValues, strikeRecord);
        Set<String> onlyUserSet = createUniqueNumberSetExceptStrike(userValues, strikeRecord);

        onlyComputerSet.retainAll(onlyUserSet);

        return onlyComputerSet.size();
    }

    private boolean[] recordStrikePositions(final String[] computerValues, final String[] userValues) {
        boolean[] strikeRecord = new boolean[computerValues.length];

        for (int i = 0; i < computerValues.length; i++) {
            if (computerValues[i].equals(userValues[i])) {
                strikeRecord[i] = true;
            }
        }

        return strikeRecord;
    }

    private Set<String> createUniqueNumberSetExceptStrike(final String[] numbers, final boolean[] strikeRecord) {
        return IntStream.range(0, numbers.length)
                .filter(index -> !strikeRecord[index])
                .mapToObj(index -> numbers[index])
                .collect(Collectors.toCollection(HashSet::new));
    }
}
