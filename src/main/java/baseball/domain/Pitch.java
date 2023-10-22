package baseball.domain;

import baseball.enums.GameConfig;

import java.util.List;

public record Pitch(List<Integer> numbers) {
    public Pitch {
        validateDuplicateCount(numbers);
        validateRange(numbers);
    }

    private void validateDuplicateCount(List<Integer> numbers) {
        long distinctCount = numbers
                .stream()
                .distinct()
                .count();
        if (distinctCount != GameConfig.PITCH_COUNT.getValue()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        int minNumber = GameConfig.MIN_NUMBER.getValue();
        int maxNumber = GameConfig.MAX_NUMBER.getValue();
        long withinRangeCount = numbers
                .stream()
                .filter(number -> minNumber <= number && number <= maxNumber)
                .count();

        if (withinRangeCount != GameConfig.PITCH_COUNT.getValue()) {
            throw new IllegalArgumentException(String.format("%d ~ %d 사이의 숫자여야 합니다.", minNumber, maxNumber));
        }
    }
}
