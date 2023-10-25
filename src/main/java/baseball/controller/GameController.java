package baseball.controller;

import static baseball.Constant.PLAY_NUMBER_DIGIT;

import baseball.model.Referee;
import baseball.model.number.PlayNumber;
import baseball.model.number.RandomNumber;
import baseball.model.number.ResumeNumber;
import baseball.model.rule.GameRule;
import baseball.view.input.InputView;
import baseball.view.output.AskView;
import baseball.view.output.EndView;
import baseball.view.output.ResultView;
import baseball.view.output.StartView;

public class GameController {

    private final InputView inputView;
    private final GameRule ballRule;
    private final GameRule strikeRule;
    private ResumeNumber resumeNumber;

    public GameController(final InputView inputView, final GameRule ballRule, final GameRule strikeRule) {
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
        boolean isPlay = true;

        while (isPlay) {
            AskView.printAskNumber();
            PlayNumber userNumber = inputView.readPlayNumber();

            int ball = Referee.answerResult(ballRule, computerNumber, userNumber);
            int strike = Referee.answerResult(strikeRule, computerNumber, userNumber);
            ResultView.printResult(ball, strike);
            isPlay = !isGameEnd(strike);
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
