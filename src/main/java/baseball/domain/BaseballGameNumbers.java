package baseball.domain;

import java.util.List;

public class BaseballGameNumbers {

    private static final int NUMBER_SIZE = 3;

    private final List<Integer> numbers;

    private BaseballGameNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static BaseballGameNumbers of(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDistinct(numbers);
        return new BaseballGameNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int countBall(BaseballGameNumbers opponent) {
        return (int) opponent.getNumbers().stream()
                .filter(this.numbers::contains)
                .filter(number -> opponent.getNumbers().indexOf(number) != this.numbers.indexOf(number))
                .count();
    }

    public int countStrike(BaseballGameNumbers opponent) {
        return (int) opponent.getNumbers().stream()
                .filter(this.numbers::contains)
                .filter(number -> opponent.getNumbers().indexOf(number) == this.numbers.indexOf(number))
                .count();
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자 3개만 입력 가능합니다.");
        }
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 9)) {
            throw new IllegalArgumentException("숫자 1부터 9까지만 입력 가능합니다.");
        }
    }

    private static void validateDistinct(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자는 중복하지 않게 입력해주세요.");
        }
    }
}
