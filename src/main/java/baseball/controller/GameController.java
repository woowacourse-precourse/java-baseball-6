package baseball.controller;

import static baseball.Constants.END;
import static baseball.Constants.PLAY_NUMBER_DIGIT;
import static baseball.Constants.RESTART;

import baseball.Umpire;
import baseball.factory.NumberFactory;
import baseball.model.ResumeNumber;
import baseball.view.EndView;
import baseball.view.ResultView;
import baseball.view.StartView;

public class GameController {

    private final ResumeNumber resumeNumber;

    public GameController() {
        this.resumeNumber = ResumeNumber.from(RESTART);
    }

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
                AskController.askResumeInputWithOption(RESTART, END);
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
