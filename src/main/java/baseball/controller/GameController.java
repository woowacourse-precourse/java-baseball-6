package baseball.controller;

import static baseball.Constant.PLAY_NUMBER_DIGIT;

import baseball.model.GameRule;
import baseball.model.PlayNumber;
import baseball.model.RandomNumber;
import baseball.model.Referee;
import baseball.model.ResumeNumber;
import baseball.view.AskView;
import baseball.view.EndView;
import baseball.view.InputView;
import baseball.view.ResultView;
import baseball.view.StartView;

public class GameController {

    private ResumeNumber resumeNumber;
    private final InputView inputView;
    private final GameRule ballRule;
    private final GameRule strikeRule;

    public GameController(final InputView inputView, final GameRule ballRule, final GameRule strikeRule) {
        this.resumeNumber = ResumeNumber.createDefault();
        this.inputView = inputView;
        this.ballRule = ballRule;
        this.strikeRule = strikeRule;
        this.resumeNumber = ResumeNumber.createDefault();
    }

    public void playBaseball() {
        StartView.welcome();
        while (resumeNumber.isWantMoreGame()) {
            play();
        }
    }

    private void play() {
        PlayNumber computerNumber = RandomNumber.pickNumber();

        while (true) {
            AskView.printAskNumber();
            PlayNumber userNumber = inputView.readPlayNumber();

            int ball = Referee.answerResult(ballRule, computerNumber, userNumber);
            int strike = Referee.answerResult(strikeRule, computerNumber, userNumber);
            ResultView.printResult(ball, strike);

            if (isGameEnd(strike)) {
                break;
            }
        }

        EndView.end();
        AskView.printAskResume();
        updateResumeNumber();
    }

    private boolean isGameEnd(final int strike) {
        return strike == PLAY_NUMBER_DIGIT.getValue();
    }

    private void updateResumeNumber() {
        String resumeAnswer = inputView.readMorePlayAnswer();
        resumeNumber = ResumeNumber.from(resumeAnswer);
    }
}
