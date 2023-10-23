package baseball;

import java.util.List;

public class Baseballs {
    private static final String SIZE_ERROR_MESSAGE = "3자리 수가 아닙니다.";
    private static final String DUPLICATION_ERROR_MESSAGE = "3개의 수가 서로 다르지 않습니다.";
    private final List<Baseball> baseballs;

    public Baseballs(final List<Integer> numbers) {
        validate(numbers);
        this.baseballs = makeBaseballList(numbers);
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateValue(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private void validateValue(final List<Integer> numbers) {
        long distinctCount = numbers.stream()
                .distinct()
                .count();
        if (distinctCount != 3) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    private List<Baseball> makeBaseballList(final List<Integer> numbers) {
        return numbers.stream()
                .map(Baseball::new)
                .toList();
    }

    public BaseballCompareResult compare(final Baseballs other) {
        int strike = calculateStrike(other);
        int contains = calculateHowManyContainsBaseball(other);
        int ball = contains - strike;

        return new BaseballCompareResult(ball, strike);
    }

    private int calculateStrike(final Baseballs other) {
        int strike = 0;
        for (int i = 0; i < baseballs.size(); i++) {
            if (baseballs.get(i).equals(other.baseballs.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int calculateHowManyContainsBaseball(final Baseballs other) {
        int contains = 0;
        for (Baseball baseball : baseballs) {
            if (other.contains(baseball)) {
                contains++;
            }
        }
        return contains;
    }

    private boolean contains(final Baseball baseball) {
        return baseballs.contains(baseball);
    }
}
