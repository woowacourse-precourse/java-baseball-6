package baseball.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BallRule implements GameRule {

    @Override
    public int calculate(final int computer, final int user) {
        String computerValue = String.valueOf(computer);
        String userValue = String.valueOf(user);

        String[] computerNumbers = computerValue.split("");
        String[] userNumbers = userValue.split("");

        boolean[] match = recordMatchedPositions(computerNumbers, userNumbers);

        Set<String> onlyComputerSet = createUniqueNumberSet(computerNumbers, match);
        Set<String> onlyUserSet = createUniqueNumberSet(userNumbers, match);

        onlyComputerSet.retainAll(onlyUserSet);

        return onlyComputerSet.size();
    }

    private boolean[] recordMatchedPositions(final String[] computerNumbers, final String[] userNumbers) {
        boolean[] match = new boolean[computerNumbers.length];

        for (int i = 0; i < computerNumbers.length; i++) {
            if (computerNumbers[i].equals(userNumbers[i])) {
                match[i] = true;
            }
        }

        return match;
    }

    private Set<String> createUniqueNumberSet(final String[] array, final boolean[] match) {
        return IntStream.range(0, array.length)
                .filter(index -> !match[index])
                .mapToObj(index -> array[index])
                .collect(Collectors.toCollection(HashSet::new));
    }
}
