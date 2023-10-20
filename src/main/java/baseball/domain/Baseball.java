package baseball.domain;

import baseball.config.GameConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Baseball {

    private static final int BANNED_NUMBER = GameConfig.BANNED_NUMBER;
    private static final int BASEBALL_LENGTH = GameConfig.BASEBALL_LENGTH;

    private List<Integer> numbers;

    public Baseball() {
        numbers = new ArrayList<>();
    }

    public Baseball(List<Integer> numbers) {
        validateLength(numbers);
        validateNoBannedNumber(numbers);
        validateNoDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    public int countSameNumbers(Baseball compare) {
        return (int) compare.numbers.stream()
                .filter(number -> numbers.contains(number))
                .count();
    }

    public int countSameNumbersByIndex(Baseball compare) {
        return (int) IntStream.range(0, numbers.size())
                .filter(index -> numbers.get(index).equals(compare.numbers.get(index)))
                .count();
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != BASEBALL_LENGTH) {
            throw new IllegalArgumentException(); // TODO 커스텀 예외 만들기
        }
    }

    private void validateNoBannedNumber(List<Integer> numbers) {
        if (numbers.contains(BANNED_NUMBER)) {
            throw new IllegalArgumentException(); // TODO 커스텀 예외 만들기
        }
    }

    private void validateNoDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(); // TODO 커스텀 예외 만들기
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Baseball baseBall = (Baseball) o;
        return Objects.equals(numbers, baseBall.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
