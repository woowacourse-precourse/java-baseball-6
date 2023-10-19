package baseball;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static baseball.RandomNumberCreateUtil.MAX_BASEBALL_NUMBER_SIZE;

public class Player {

    private static final int MIN_BASEBALL_NUMBER = 1;
    private static final int MAX_BASEBALL_NUMBER = 9;

    private Set<Integer> expectedNumbers;

    public void changeExpectedNumbers(String numbers) {
        Set<Integer> notDuplicateNumbers = checkDuplicated(numbers);
        validateNumberSize(notDuplicateNumbers);
        this.expectedNumbers = notDuplicateNumbers;
    }

    private Set<Integer> checkDuplicated(String numbers){
        return numbers.chars()
                .mapToObj(Character::getNumericValue)
                .filter(checkNumberRange())
                .collect(Collectors.toSet());
    }

    private Predicate<Integer> checkNumberRange() {
        return n -> n >= MIN_BASEBALL_NUMBER && n <= MAX_BASEBALL_NUMBER;
    }

    private void validateNumberSize(Set<Integer> numbers) {
        if (numbers.size() != MAX_BASEBALL_NUMBER_SIZE){
            throw new IllegalArgumentException(ErrorMessage.INPUT_ONE_TO_NINE_DIFFERENT_THREE_NUMBERS.getMessage());
        }
    }


}
