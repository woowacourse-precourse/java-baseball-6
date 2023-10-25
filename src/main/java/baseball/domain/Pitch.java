package baseball.domain;

import baseball.enums.GameConfig;
import java.util.List;

public record Pitch(List<Integer> numbers) {
    public Pitch {
        validateUniqueNumberCount(numbers);
        validateRange(numbers);
    }

    private void validateUniqueNumberCount(List<Integer> numbers) {
        int distinctCount = (int) numbers.stream()
                .distinct()
                .count();
        if (GameConfig.PITCH_COUNT.notEquals(distinctCount)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        int minNumber = GameConfig.MIN_NUMBER.getValue();
        int maxNumber = GameConfig.MAX_NUMBER.getValue();
        int withinRangeCount = (int) numbers.stream()
                .filter(number -> minNumber <= number && number <= maxNumber)
                .count();

        if (GameConfig.PITCH_COUNT.notEquals(withinRangeCount)) {
            throw new IllegalArgumentException(String.format("%d ~ %d 사이의 숫자여야 합니다.", minNumber, maxNumber));
        }
    }

    public int get(int index) {
        return numbers.get(index);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
