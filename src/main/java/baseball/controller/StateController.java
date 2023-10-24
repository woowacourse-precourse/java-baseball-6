package baseball.controller;

import baseball.exception.ExceptionCheck;
import baseball.model.ComputerModel;
import baseball.model.ScoreState;
import baseball.random.RandomNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Map;

public class StateController {
    private static final int GAME_STATE_RESTART = 1;

    private ComputerModel computerModel;

    public void gameStart() {
        this.computerModel = new ComputerModel(RandomNumber.randomNumberGenerator());
    }

    public boolean repeatPlayerExpect() {
        Map<ScoreState, Integer> scoreMap;
        String playerNumber = InputView.inputPlayerNumber();

        ExceptionCheck.playerInputCheck(playerNumber);
        scoreMap = computerModel.scoreCalculator(playerNumber);
        gameScoreCheck(scoreMap);
        return scoreMap.get(ScoreState.STRIKE_SCORE) == 3;
    }

    public boolean gameStateChange() {
        OutputView.printRestartMessage();

        String playerNumber = InputView.inputRestartNumber();
        ExceptionCheck.restartInputCheck(playerNumber);
        return Integer.parseInt(playerNumber) == GAME_STATE_RESTART;
    }

    private void ballStrikeScoreCheck(int strikeScore, int ballScore) {
        if (strikeScore > 0 && ballScore == 0) {
            OutputView.printStrikeScore(strikeScore);
        }
        if (strikeScore == 0 && ballScore > 0) {
            OutputView.printBallScore(ballScore);
            System.out.println("");
        }
        if (strikeScore > 0 && ballScore > 0) {
            OutputView.printBallScore(ballScore);
            OutputView.printStrikeScore(strikeScore);
        }
    }

    private void gameScoreCheck(Map<ScoreState, Integer> scoreMap) {
        int strikeScore = scoreMap.get(ScoreState.STRIKE_SCORE);
        int ballScore = scoreMap.get(ScoreState.BALL_SCORE);

        if (strikeScore == 3) {
            OutputView.printStrikeScore(strikeScore);
            OutputView.printEndMessage();
        }
        if (strikeScore == 0 && ballScore == 0) {
            OutputView.printNothingScore();
        }
        if ((strikeScore > 0 || ballScore > 0) && strikeScore != 3) {
            ballStrikeScoreCheck(strikeScore, ballScore);
        }
    }
}
