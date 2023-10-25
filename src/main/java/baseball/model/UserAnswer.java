package baseball.model;

import baseball.model.dto.AnswerComparisonResult;
import baseball.utils.GameAnswerManager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.error.ErrorMessage.*;

public class UserAnswer {

    public static final int ANSWER_DIGITS = 3;
    public static final int MAX_NUM_RANGE = 9;
    public static final int MIN_NUM_RANGE = 1;

    private List<Integer> numbers;

    public UserAnswer(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicates(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != ANSWER_DIGITS) {
            throw new IllegalArgumentException(INVALID_INPUT_SIZE);
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean matchRes = numbers.stream()
                .anyMatch(answer -> answer < MIN_NUM_RANGE || answer > MAX_NUM_RANGE);
        if (matchRes) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER_RANGE);
        }
    }

    private void validateDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
    }

    public AnswerComparisonResult compareAnswer(GameAnswerManager gameAnswerManager) {
        return gameAnswerManager.compareAnswer(this.numbers);
    }
}
