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

        int userNumber = Integer.parseInt(Console.readLine());
        NumberValidator.assertDigitLength(userNumber, PLAY_NUMBER_DIGIT);
    }
}
