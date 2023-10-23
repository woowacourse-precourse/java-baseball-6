package baseball.controller;

import baseball.util.InputParser;
import baseball.util.InputValidator;
import baseball.view.InputView;

import java.util.List;

public class BaseballGame {

    private static List<Integer> getUserNumberList() {
        String userNumber = InputView.getUserNumber();
        InputValidator.validateUserNumber(userNumber);

        return InputParser.parseUserNumber(userNumber);
    }

}
