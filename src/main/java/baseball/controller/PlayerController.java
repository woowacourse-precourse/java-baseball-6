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
    }

    private List<Integer> parseInputString(String inputNumbers) {
        List<Integer> result = new ArrayList<>();
        for (String number : inputNumbers.split(",")) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }

    private void validateNumbers(List<Integer> inputList) {
        validateOutOfRange(inputList);
    }

    private void validateOutOfRange(List<Integer> inputList) {
        inputList.stream()
                .filter(number -> number < 1 || number > 9)
                .findFirst()
                .ifPresent(number -> {
                    throw new IllegalArgumentException("숫자는 1 ~ 9 사이의 숫자만 입력할 수 있습니다.");
                });
    }
}
