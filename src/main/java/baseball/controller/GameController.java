package baseball.controller;

import baseball.Umpire;
import baseball.factory.NumberFactory;
import baseball.view.AskView;
import baseball.view.EndView;
import baseball.view.ResultView;
import baseball.view.StartView;

public class GameController {

    private static final int PLAY_NUMBER_DIGIT = 3;
    private static final int RESTART = 1;
    private static final int END = 2;

    public static void play() {
        boolean playWant = true;
        int computerNumber = selectNewNumber();

        StartView.welcome();

        while (playWant) {
            AskController.askNumberInput();

            int userNumber = InputController.receiveUserNumberWidthLength(PLAY_NUMBER_DIGIT);

            int ball = Umpire.countBall(computerNumber, userNumber);
            int strike = Umpire.countStrike(computerNumber, userNumber);

            ResultView.printResult(ball, strike);

            if (isStrikeEqualToGoal(strike)) {
                EndView.end(PLAY_NUMBER_DIGIT);
                AskView.askResume(RESTART, END);
                int resumeNumber = InputController.receiveResumeNumberWithOption(RESTART, END);
                if (isUserWantMoreGame(resumeNumber)) {
                    computerNumber = selectNewNumber();
                }
                if (isUserWantStopGame(resumeNumber)) {
                    playWant = false;
                }
            }
        }
    }

    private static boolean isStrikeEqualToGoal(final int strike) {
        return strike == PLAY_NUMBER_DIGIT;
    }

    private static boolean isUserWantMoreGame(final int resumeNumber) {
        return resumeNumber == RESTART;
    }

    private static int selectNewNumber() {
        return NumberFactory.pickNumberWithLength(PLAY_NUMBER_DIGIT);
    }

    private static boolean isUserWantStopGame(final int resumeNumber) {
        return resumeNumber == END;
    }
}
