package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.util.Constants;
import baseball.validator.InputValidator;

public class InputView {
    public String inputNumbers() {
        System.out.print(Constants.INPUT_NUMBERS_MESSAGE);
        String input = readLine().trim();

        InputValidator.validateInputLength(input);
        InputValidator.validateInputNumber(input);

        return input;
    }

    public String inputStartNewGame() {
        System.out.println(Constants.INPUT_START_NEW_GAME_OR_EXIT_MESSAGE);
        String input = readLine().trim();

        InputValidator.validateInputNumber(input);

        return input;
    }
}
