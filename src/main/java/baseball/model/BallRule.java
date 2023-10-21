package baseball.model;

import baseball.converter.IntegerInputConverter;
import baseball.converter.StringInputConverter;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BallRule implements GameRule {

    @Override
    public int calculate(final int hitter, final int pitcher) {
        String[] origin = StringInputConverter.toArray(IntegerInputConverter.toString(hitter));
        String[] test = StringInputConverter.toArray(IntegerInputConverter.toString(pitcher));

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
}
