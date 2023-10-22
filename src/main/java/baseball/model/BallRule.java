package baseball.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BallRule implements GameRule {

    @Override
    public int calculate(final int hitter, final int pitcher) {
        String hitterValue = String.valueOf(hitter);
        String pitcherValue = String.valueOf(pitcher);
        String[] hitterNumbers = hitterValue.split("");
        String[] pitcherNumbers = pitcherValue.split("");

        boolean[] match = recordMatchedPositions(hitterNumbers, pitcherNumbers);

        Set<String> onlyHitterSet = createSet(hitterNumbers, match);
        Set<String> onlyPitcherSet = createSet(pitcherNumbers, match);

        intersection(onlyHitterSet, onlyPitcherSet);

        return calculateSize(onlyHitterSet);
    }

    private boolean[] recordMatchedPositions(final String[] hitterNumbers, final String[] pitcherNumbers) {
        boolean[] match = new boolean[hitterNumbers.length];

        for (int i = 0; i < hitterNumbers.length; i++) {
            if (hitterNumbers[i].equals(pitcherNumbers[i])) {
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

    private void intersection(final Set<String> hitterSet, final Set<String> pitcherSet) {
        hitterSet.retainAll(pitcherSet);
    }

    private int calculateSize(final Set<String> set) {
        return set.size();
    }
}
