package baseball.controller;

import baseball.view.InputView;
import java.util.ArrayList;
import java.util.List;

public class PlayerController {

    private InputView inputView = new InputView();

    public List<Integer> readAndValidateInputNumbers() {
        String inputString = inputView.readInputNumbers();
        return parseInputString(inputString);
    }

    private List<Integer> parseInputString(String inputNumbers) {
        List<Integer> result = new ArrayList<>();
        for (String number : inputNumbers.split(",")) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }
}
