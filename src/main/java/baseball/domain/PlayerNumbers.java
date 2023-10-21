package baseball.domain;

import java.util.List;

public class PlayerNumbers {

    private final List<Integer> numbers;

    public PlayerNumbers(List<Integer> numbers, int digitNumber) {
        validateNumbers(numbers, digitNumber);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers, int digitNumber) {
        if (invalidDigitNumber(numbers, digitNumber)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 " + digitNumber + "자리여야 합니다.");
        }
        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 1 이상 9 이하여야 합니다.");
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.subList(i + 1, numbers.size())
                    .contains(numbers.get(i))) {
                throw new IllegalArgumentException("[ERROR] 숫자는 서로 달라야 합니다.");
            }
        }
    }

    private boolean invalidDigitNumber(List<Integer> numbers, int digitNumber) {
        return numbers.size() != digitNumber;
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> !(1 <= number && number <= 9));
    }
}
