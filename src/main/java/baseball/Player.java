package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Player {

    private final PlayerValidator playerValidator = new PlayerValidator();
    private List<Integer> expectedNumbers;

    public void changeExpectedNumbers(String numbers) {
        initExpectedNumbers();
        playerValidator.validateExpectedNumbers(numbers);
        expectedNumbers = getExpectedNumbers(numbers);
    }

    private void initExpectedNumbers() {
        expectedNumbers = new ArrayList<>();
    }

    private List<Integer> getExpectedNumbers(String numbers) {
        return numbers.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }

    public long compareBallCount(List<Integer> baseballNumbers) {
        return IntStream.range(0, BaseballRole.MAX_BASEBALL_NUMBER_SIZE.getValue())
                .filter(i -> !Objects.equals(expectedNumbers.get(i), baseballNumbers.get(i)))
                .filter(i -> baseballNumbers.contains(expectedNumbers.get(i)))
                .count();
    }

    public long compareStrikeCount(List<Integer> baseballNumbers) {
        return IntStream.range(0, BaseballRole.MAX_BASEBALL_NUMBER_SIZE.getValue())
                .filter(i -> Objects.equals(expectedNumbers.get(i), baseballNumbers.get(i)))
                .count();

    }
}
