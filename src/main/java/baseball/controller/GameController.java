package baseball.controller;

import static baseball.Constants.END_WANT;
import static baseball.Constants.PLAY_NUMBER_DIGIT;
import static baseball.Constants.PLAY_WANT;

import baseball.Umpire;
import baseball.factory.NumberFactory;
import baseball.model.ResumeNumber;
import baseball.view.EndView;
import baseball.view.ResultView;
import baseball.view.StartView;

public class GameController {

    private final ResumeNumber resumeNumber;

    public GameController() {
        this.resumeNumber = ResumeNumber.createDefault();
    }

    public void playBaseball() {
        printGameWelcome();
        while (isGameCanPlay()) {
            play();
        }
    }

    private static void printGameWelcome() {
        StartView.welcome();
    }

    private boolean isGameCanPlay() {
        return resumeNumber.isWantMoreGame();
    }

    private void play() {
        int computerNumber = selectNewNumber();

        while (true) {
            askNumberInput();

            int userNumber = InputController.receiveUserNumberWidthLength(PLAY_NUMBER_DIGIT);

            int ball = Umpire.countBall(computerNumber, userNumber);
            int strike = Umpire.countStrike(computerNumber, userNumber);

            ResultView.printResult(ball, strike);

            if (isStrikeEqualToGoal(strike)) {
                break;
            }
        }
        printGameEnd();
        AskController.askResumeInputWithOption(PLAY_WANT, END_WANT);
        updateResumeNumber();
    }

    private static void askNumberInput() {
        AskController.askNumberInput();
    }

    private boolean isStrikeEqualToGoal(final int strike) {
        return strike == PLAY_NUMBER_DIGIT;
    }

    private int selectNewNumber() {
        return NumberFactory.pickNumberWithLength(PLAY_NUMBER_DIGIT);
    }

    private static void printGameEnd() {
        EndView.end();
    }

    private void updateResumeNumber() {
        resumeNumber.updateNumber(receiveResumeNumber());
    }

    private int receiveResumeNumber() {
        return InputController.receiveResumeNumberWithOption(PLAY_WANT, END_WANT);
    }
}
