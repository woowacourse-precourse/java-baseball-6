package baseball;

import java.util.Set;
import java.util.stream.Collectors;

public class PlayerValidator {

    public void validateExpectedNumbers(String numbers){
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

    private Set<Integer> checkDuplicated(String numbers){
        return numbers.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toSet());
    }

    private String getExpectedNumbersErrorMessage() {
        return String.format(ErrorMessage.INPUT_DIFFERENT_THREE_NUMBERS.getMessage()
                , BaseballRole.MAX_BASEBALL_NUMBER_SIZE.getValue());
    }
}
