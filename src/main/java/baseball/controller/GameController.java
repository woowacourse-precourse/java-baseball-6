package baseball.controller;

import baseball.factory.NumberFactory;
import baseball.model.Referee;
import baseball.model.ResumeNumber;
import baseball.view.EndView;
import baseball.view.ResultView;
import baseball.view.StartView;

public class GameController {

    private final ResumeNumber resumeNumber;
    private final Referee referee;

    public GameController() {
        this.resumeNumber = ResumeNumber.createDefault();
        this.referee = Referee.createDefault();
    }

    public void playBaseball() {
        StartView.welcome();
        while (resumeNumber.isWantMoreGame()) {
            play();
        }
    }

    private void play() {
        int computerNumber = NumberFactory.createNumber();

        while (!referee.isGameEnd()) {
            AskController.askNumberInput();
            int userNumber = InputController.receiveUserNumber();
            referee.prepareJudgement(computerNumber, userNumber);

            int ball = referee.countBall();
            int strike = referee.countStrike();
            ResultView.printResult(ball, strike);
        }

        EndView.end();
        AskController.askResumeInput();

        int resumeAnswer = InputController.receiveResumeNumber();
        resumeNumber.updateNumber(resumeAnswer);

        referee.resetGame();
    }
}
