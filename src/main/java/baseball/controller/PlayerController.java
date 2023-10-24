package baseball.controller;

import baseball.view.InputView;
import java.util.ArrayList;
import java.util.List;

public class PlayerController {

    private InputView inputView = new InputView();

    public List<Integer> readAndValidateInputNumbers() {
        String inputString = inputView.readInputNumbers();
        validateNumbers(inputString);
        List<Integer> inputList = parseInputString(inputString);
        return inputList;
    }

    public Integer restartOrOver() {
        String inputString = inputView.readRestartOrOver();
        validateRestartOrOver(inputString);
        return Integer.parseInt(inputString);
    }

    private void validateRestartOrOver(String inputString) {
        if (inputString.length() != 1 || !inputString.equals("1") && !inputString.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }

    private List<Integer> parseInputString(String inputNumbers) {
        List<Integer> result = new ArrayList<>();
        for (String number : inputNumbers.split("")) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }

    private void validateNumbers(String inputString) {
        validateOutOfRange(inputString);
        validateInputSize(inputString);
        validateDuplicates(inputString);
    }

    private void validateOutOfRange(String inputString) {
        boolean allMatch = inputString.chars().allMatch(c -> c >= '1' && c <= '9');
        if (!allMatch) {
            throw new IllegalArgumentException("1과 9 사이의 숫자를 입력해주세요.");
        }
    }

    private void validateInputSize(String inputString) {
        if (inputString.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자만 입력할 수 있습니다.");
        }
    }

    private void validateDuplicates(String inputString) {
        if (inputString.chars().distinct().count() != inputString.length()) {
            throw new IllegalArgumentException("중복 없이 숫자를 입력해주세요.");
        }
    }
}
