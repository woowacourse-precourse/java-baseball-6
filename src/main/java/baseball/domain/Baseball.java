package baseball.domain;

import baseball.config.GameConfig;
import java.util.ArrayList;
import java.util.List;

public class Baseball {

    private static final int BANNED_NUMBER = GameConfig.BANNED_NUMBER;
    private static final int BASEBALL_LENGTH = GameConfig.BASEBALL_LENGTH;

    private List<Integer> baseball;

    public Baseball() {
        baseball = new ArrayList<>();
    }

    public Baseball(List<Integer> baseball) {
        validateLength(baseball);
        validateNoBannedNumber(baseball);
        validateNoDuplicateNumbers(baseball);
        this.baseball = baseball;
    }

    private void validateLength(List<Integer> baseball) {
        if (baseball.size() != BASEBALL_LENGTH) {
            throw new IllegalArgumentException(); // TODO 커스텀 예외 만들기
        }
    }

    private void validateNoBannedNumber(List<Integer> baseball) {
        if (baseball.contains(BANNED_NUMBER)) {
            throw new IllegalArgumentException(); // TODO 커스텀 예외 만들기
        }
    }

    private void validateNoDuplicateNumbers(List<Integer> baseball) {
        if (baseball.size() != baseball.stream().distinct().count()) {
            throw new IllegalArgumentException(); // TODO 커스텀 예외 만들기
        }
    }
}
