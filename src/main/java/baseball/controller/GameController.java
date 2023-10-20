package baseball.controller;

import baseball.Umpire;
import baseball.factory.NumberFactory;
import baseball.validator.NumberValidator;
import baseball.validator.ResumeValidator;
import baseball.view.AskView;
import baseball.view.EndView;
import baseball.view.ResultView;
import baseball.view.StartView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    private static final int PLAY_NUMBER_DIGIT = 3;
    private static final int RESTART = 1;
    private static final int END = 2;

    public static void play() {
        boolean playWant = true;
        int computerNumber = NumberFactory.pickNumberWithLength(PLAY_NUMBER_DIGIT);

        StartView.welcome();

        while (playWant) {
            AskView.askNumberInput();

            String userInput = Console.readLine();
            NumberValidator.assertInputNumberWithLength(userInput, PLAY_NUMBER_DIGIT);

            int userNumber = Integer.parseInt(userInput);

            int ball = Umpire.countBall(computerNumber, userNumber);
            int strike = Umpire.countStrike(computerNumber, userNumber);

            ResultView.printResult(ball, strike);

            if (strike == PLAY_NUMBER_DIGIT) {
                EndView.end(PLAY_NUMBER_DIGIT);
                AskView.askResume(RESTART, END);
                String resumeInput = Console.readLine();
                ResumeValidator.assertResumeInput(resumeInput, RESTART, END);
                int resumeNumber = Integer.parseInt(resumeInput);
                if (resumeNumber == RESTART) {
                    computerNumber = NumberFactory.pickNumberWithLength(PLAY_NUMBER_DIGIT);
                }
                if (resumeNumber == END) {
                    playWant = false;
                }
            }
        }
    }
}
