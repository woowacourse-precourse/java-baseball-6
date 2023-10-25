package baseball.domain.ball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Baseballs {

    public static final int CORRECT_SIZE = 3;
    public static final int START_INDEX = 0;
    public static final int END_INDEX = 3;
    List<Baseball> baseballs;

    public Baseballs(List<Integer> values) {
        validate(values);
        this.baseballs = createBalls(values);
    }

    public int getStrikeCount(Baseballs otherBaseballs) {
        int result = 0;
        for (Baseball baseball : this.baseballs) {
            if (otherBaseballs.isStrike(baseball)) {
                result++;
            }
        }
        return result;
    }

    private boolean isStrike(Baseball otherBaseball) {
        for (Baseball baseball : this.baseballs) {
            if (baseball.isMatch(otherBaseball)) {
                return true;
            }
        }
        return false;
    }

    public int getBallCount(Baseballs otherBaseballs) {
        int result = 0;
        for (Baseball baseball : this.baseballs) {
            if (otherBaseballs.isBall(baseball)) {
                result++;
            }
        }
        return result;
    }

    private boolean isBall(Baseball otherBaseball) {
        for (Baseball baseball : this.baseballs) {
            if (baseball.isPartialMatch(otherBaseball)) {
                return true;
            }
        }
        return false;
    }

    private List<Baseball> createBalls(List<Integer> values) {
        return IntStream.range(START_INDEX, END_INDEX)
                .mapToObj(index -> new Baseball(new Number(values.get(index)), index))
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> values) {
        validateDuplication(values);
        validateSize(values);
    }

    private void validateDuplication(List<Integer> values) {
        if (hasDuplicates(values)) {
            throw new IllegalArgumentException("서로 다른 수가 입력되어야합니다.");
        }
    }

    private boolean hasDuplicates(List<Integer> values) {
        return values.stream()
                .distinct() // 중복 제거
                .count() != values.size();
    }

    private void validateSize(List<Integer> values) {
        if (values.size() != CORRECT_SIZE) {
            throw new IllegalArgumentException("숫자의 길이는 3이어야합니다.");
        }
    }
}
