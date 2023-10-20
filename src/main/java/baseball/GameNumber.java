package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class GameNumber {

    private static final int GAME_NUMBER_SIZE = 3;

    private final List<Integer> numbers;

    public GameNumber(List<Integer> numbers) {
        this.numbers = numbers;
        validateSize();
        validateDuplicate();
        validateNoZeros();
    }

    private void validateSize() {
        if (numbers.size() != GAME_NUMBER_SIZE) {
            throw new IllegalArgumentException(GAME_NUMBER_SIZE + "개의 숫자가 입력되어야 합니다.");
        }
    }

    private void validateDuplicate() {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자는 입력될 수 없습니다.");
        }
    }

    private void validateNoZeros() {
        for (Integer value : numbers) {
            if (value == 0) {
                throw new IllegalArgumentException("입력에는 0이 포함될 수 없습니다.");
            }
        }
    }

    public Integer get(int index) {
        return numbers.get(index);
    }

    public boolean isContain(Integer value) {
        return numbers.contains(value);
    }

    public Result match(
            final GameNumber other
    ) {
        Result result = new Result(0, 0);
        for (int i = 0; i < GAME_NUMBER_SIZE; i++) {
            boolean isExist = this.isContain(other.get(i));
            boolean isRightOrder = Objects.equals(this.get(i), other.get(i));

            if (isExist && isRightOrder) result.addStrike();
            else if (isExist) result.addBall();

        }
        return result;
    }
}
