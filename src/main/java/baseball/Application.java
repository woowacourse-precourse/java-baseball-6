package baseball;

import baseball.validator.NumberValidator;
import baseball.view.AskView;
import baseball.view.StartView;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int PLAY_NUMBER_DIGIT = 3;

    public static void main(String[] args) {
        StartView.welcome();
        AskView.askNumberInput();

        String userInput = Console.readLine();
        NumberValidator.assertNumberValue(userInput);
        NumberValidator.assertDigitLength(userInput, PLAY_NUMBER_DIGIT);
        NumberValidator.assertEachNumberUnique(userInput);
    }
}
