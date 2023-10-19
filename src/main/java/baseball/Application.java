package baseball;

import baseball.factory.NumberFactory;
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
        NumberValidator.assertInputNumberWithLength(userInput, PLAY_NUMBER_DIGIT);

        int computerNumber = NumberFactory.pickNumberWithLength(PLAY_NUMBER_DIGIT);
    }
}
