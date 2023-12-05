package baseball.model;

import java.util.List;

import static baseball.utils.validator.UserNumberValidator.*;


public class UserNumber {
    private final List<Integer> numbers;

    private UserNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static UserNumber from(List<Integer> numbers) {
        validateNonZero(numbers);
        validateDuplicate(numbers);
        validateSize(numbers);
        return new UserNumber(numbers);
    }

    public int findNumberByPosition(int position) {
        return numbers.get(position);
    }
}