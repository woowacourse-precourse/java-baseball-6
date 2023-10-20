package baseball;

import baseball.factory.NumberFactory;
import baseball.validator.NumberValidator;
import baseball.view.AskView;
import baseball.view.EndView;
import baseball.view.ResultView;
import baseball.view.StartView;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int PLAY_NUMBER_DIGIT = 3;
    private static final int RESTART = 1;
    private static final int END = 2;

    public static void main(String[] args) {
        StartView.welcome();
        AskView.askNumberInput();

        String userInput = Console.readLine();
        NumberValidator.assertInputNumberWithLength(userInput, PLAY_NUMBER_DIGIT);

        int computerNumber = NumberFactory.pickNumberWithLength(PLAY_NUMBER_DIGIT);
        int userNumber = Integer.parseInt(userInput);

        int ball = Umpire.countBall(computerNumber, userNumber);
        int strike = Umpire.countStrike(computerNumber, userNumber);

        ResultView.printResult(ball, strike);

        if (strike == PLAY_NUMBER_DIGIT) {
            EndView.end(PLAY_NUMBER_DIGIT);
            AskView.askResume(RESTART, END);
        }
    }
}
