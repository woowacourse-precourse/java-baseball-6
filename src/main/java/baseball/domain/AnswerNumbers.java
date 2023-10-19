package baseball.domain;

import baseball.constant.NumberConstant;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.constant.NumberConstant.*;

public class AnswerNumbers {

    private List<Integer> numbers;

    public AnswerNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != VALID_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자는 3개만 가능합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);

        if (nonDuplicateNumbers.size() != VALID_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

}
