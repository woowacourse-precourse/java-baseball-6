package baseball;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Player {

    private List<Integer> expectedNumbers;

    public void changeExpectedNumbers(String numbers) {
        Set<Integer> notDuplicateNumbers = checkDuplicated(numbers);
        validateNumberSize(notDuplicateNumbers);
        expectedNumbers.addAll(notDuplicateNumbers);
    }

    private Set<Integer> checkDuplicated(String numbers){
        return numbers.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toSet());
    }

    private void validateNumberSize(Set<Integer> numbers) {
        if (numbers.size() != BaseballRole.MAX_BASEBALL_NUMBER_SIZE.getValue()){
            throw new IllegalArgumentException(ErrorMessage.INPUT_ONE_TO_NINE_DIFFERENT_THREE_NUMBERS.getMessage());
        }
    }


    public long compareBallCount(List<Integer> baseballNumbers) {
        return expectedNumbers.stream()
                .filter(baseballNumbers::contains)
                .count();
    }

}
