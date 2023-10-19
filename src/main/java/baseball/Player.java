package baseball;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Player {

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
        return n -> n >= BaseballRole.MIN_BASEBALL_NUMBER.getValue() && n <= BaseballRole.MAX_BASEBALL_NUMBER.getValue();
    }

    private void validateNumberSize(Set<Integer> numbers) {
        if (numbers.size() != BaseballRole.MAX_BASEBALL_NUMBER_SIZE.getValue()){
            throw new IllegalArgumentException(ErrorMessage.INPUT_ONE_TO_NINE_DIFFERENT_THREE_NUMBERS.getMessage());
        }
    }


}
