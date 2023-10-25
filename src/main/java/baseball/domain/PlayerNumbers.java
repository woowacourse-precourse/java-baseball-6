package baseball.domain;

import baseball.message.ExceptionMessage;

import java.util.List;

public class PlayerNumbers {
    private static final int COUNT_OF_NUMBER = 3;
    private final List<Integer> numbers;

    public PlayerNumbers(List<Integer> numbers) {
        validateCountOfNumber(numbers);
        validateNumberHasDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateCountOfNumber(List<Integer> numbers) {
        if (numbers.size() != COUNT_OF_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_THREE.toString());
        }
    }

    private void validateNumberHasDuplicate(List<Integer> numbers) {
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException(ExceptionMessage.HAS_DUPLICATE.toString());
        }
    }

    public int get(int index) {
        return numbers.get(index);
    }
}
