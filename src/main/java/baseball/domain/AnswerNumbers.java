package baseball.domain;

import baseball.constant.NumberConstant;

import java.util.List;

import static baseball.constant.NumberConstant.*;

public class AnswerNumbers {

    private List<Integer> numbers;

    public AnswerNumbers(List<Integer> numbers) {

        this.numbers = numbers;
    }

    public void validateSize(List<Integer> numbers) {
        if (numbers.size() != VALID_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자는 3개만 가능합니다.");
        }
    }


}
