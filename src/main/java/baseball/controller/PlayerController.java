package baseball.controller;

import baseball.view.InputView;
import java.util.ArrayList;
import java.util.List;

public class PlayerController {

    private InputView inputView = new InputView();

    public List<Integer> readAndValidateInputNumbers() {
        String inputString = inputView.readInputNumbers();
        List<Integer> inputList = parseInputString(inputString);
        validateNumbers(inputList);
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

    private void validateNumbers(List<Integer> inputList) {
        validateOutOfRange(inputList);
        validateInputSize(inputList);
        validateDuplicates(inputList);
    }

    private void validateOutOfRange(List<Integer> inputList) {
        inputList.stream()
                .filter(number -> number < 1 || number > 9)
                .findFirst()
                .ifPresent(number -> {
                    throw new IllegalArgumentException("숫자는 1 ~ 9 사이의 숫자만 입력할 수 있습니다.");
                });
    }

    private void validateInputSize(List<Integer> inputList) {
        if (inputList.size() != 3) {
            throw new IllegalArgumentException("3개의 숫자만 입력할 수 있습니다.");
        }
    }

    private void validateDuplicates(List<Integer> inputList) {
        if (inputList.stream().distinct().count() != inputList.size()) {
            throw new IllegalArgumentException("중복 없이 숫자를 입력해주세요.");
        }
    }
}
