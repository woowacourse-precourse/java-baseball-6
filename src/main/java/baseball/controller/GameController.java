package baseball.controller;

import baseball.model.Umpire;
import baseball.factory.NumberFactory;
import baseball.model.ResumeNumber;
import baseball.view.EndView;
import baseball.view.ResultView;
import baseball.view.StartView;

public class GameController {

    private final ResumeNumber resumeNumber;
    private final Umpire umpire;

    public GameController() {
        this.resumeNumber = ResumeNumber.createDefault();
        this.umpire = Umpire.createDefault();
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

        while (!isGameEnd()) {
            askNumberInput();
            playRound(computerNumber);
        }

        printGameEnd();
        askResumeInput();
        updateResumeNumber();
        clearUmpireMemory();
    }

    private int selectNewNumber() {
        return NumberFactory.createNumber();
    }

    private boolean isGameEnd() {
        return umpire.isGameEnd();
    }

    private static void askNumberInput() {
        AskController.askNumberInput();
    }

    private void playRound(final int computerNumber) {
        prepareGameJudgementWithComputer(computerNumber);
        printGameJudgement();
    }

    private void prepareGameJudgementWithComputer(int computerNumber) {
        umpire.prepareJudgement(computerNumber, receiveUserNumber());
    }

    private static int receiveUserNumber() {
        return InputController.receiveUserNumber();
    }

    private void printGameJudgement() {
        ResultView.printResult(countGameBall(), countGameStrike());
    }

    private int countGameBall() {
        return umpire.countBall();
    }

    private int countGameStrike() {
        return umpire.countStrike();
    }

    private static void printGameEnd() {
        EndView.end();
    }

    private static void askResumeInput() {
        AskController.askResumeInput();
    }

    private void updateResumeNumber() {
        resumeNumber.updateNumber(receiveResumeNumber());
    }

    private int receiveResumeNumber() {
        return InputController.receiveResumeNumber();
    }

    public void clearUmpireMemory() {
        umpire.resetGame();
    }
}
