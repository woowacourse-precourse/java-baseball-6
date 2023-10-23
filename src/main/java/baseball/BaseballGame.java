package baseball;

import static baseball.view.InputView.getNumbers;

import java.util.ArrayList;
import java.util.List;
import utils.ValidationUtils;

public class BaseballGame {

    public void play() {
        List<Integer> balls = getBallNumbers();
    }

    private List<Integer> getBallNumbers() {
        String inputNumbers = getNumbers();
        validateInput(inputNumbers);
        List<Integer> numbers = parseNumbers(inputNumbers);
        validateNumbers(numbers);
        return numbers;
    }

    private void validateInput(String inputNumbers) {
        if (!ValidationUtils.isNumber(inputNumbers)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자를 입력해 주세요.");
        }
    }

    private List<Integer> parseNumbers(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : inputNumbers.toCharArray()) {
            numbers.add(c - '0');
        }
        return numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumber(number);
        }
        if (ValidationUtils.isOtherNumbers(numbers)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 서로 다른 숫자를 입력해 주세요.");
        }
    }

    private static void validateNumber(Integer number) {
        if (ValidationUtils.isSingleNumber(number)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 1-9 사이의 숫자를 입력해 주세요.");
        }
    }
}

