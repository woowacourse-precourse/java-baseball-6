package baseball;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.EnumMap;
import java.util.List;

public class PlayResult {

    public static final int RESULT_SIZE = 3;

    private final EnumMap<CompareResult, Long> countByResult;

    public PlayResult(final List<CompareResult> compareResults) {
        this.countByResult = mapResults(compareResults);
    }

    private EnumMap<CompareResult, Long> mapResults(
            final List<CompareResult> compareResults
    ) {
        return compareResults.stream()
                .collect(groupingBy(result -> result,
                        () -> new EnumMap<>(CompareResult.class),
                        counting())
                );
    }

    public boolean isNothing() {
        return getCountOf(CompareResult.NOTHING) == RESULT_SIZE;
    }

    public long getStrikes() {
        return getCountOf(CompareResult.STRIKE);
    }

    public long getBalls() {
        return getCountOf(CompareResult.BALL);
    }

    private long getCountOf(final CompareResult compareResult) {
        return countByResult.getOrDefault(compareResult, 0L);
    }
}
