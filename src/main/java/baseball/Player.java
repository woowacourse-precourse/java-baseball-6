package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Player {

    private List<Integer> expectedNumbers;

    public void changeExpectedNumbers(String numbers) {
        initExpectedNumbers();
        validateExpectedNumbers(numbers);
        expectedNumbers = getExpectedNumbers(numbers);
    }

    private void initExpectedNumbers() {
        expectedNumbers = new ArrayList<>();
    }

    private void validateExpectedNumbers(String numbers){
        validateNumberSize(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateNumberSize(String numbers) {
        if (numbers.length() != BaseballRole.MAX_BASEBALL_NUMBER_SIZE.getValue()){
            throw new IllegalArgumentException(getExpectedNumbersErrorMessage());
        }
    }

    private void validateDuplicateNumber(String numbers) {
        if (checkDuplicated(numbers).size() != BaseballRole.MAX_BASEBALL_NUMBER_SIZE.getValue()){
            throw new IllegalArgumentException(getExpectedNumbersErrorMessage());
        }
    }

    private String getExpectedNumbersErrorMessage() {
        return String.format(ErrorMessage.INPUT_DIFFERENT_THREE_NUMBERS.getMessage()
                , BaseballRole.MAX_BASEBALL_NUMBER_SIZE.getValue());
    }

    private Set<Integer> checkDuplicated(String numbers){
        return numbers.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toSet());
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
