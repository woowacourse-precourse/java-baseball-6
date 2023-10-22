package baseball.controller;

import baseball.exception.ExceptionCheck;
import baseball.model.ComputerModel;
import baseball.random.RandomNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.HashMap;
import java.util.Map;

public class StateController {
    public static final int GAMESTATE_RESTART = 1;
    static final InputView inputview = new InputView();
    static final OutputView outputView = new OutputView();
    static final RandomNumber random = new RandomNumber();
    static final ExceptionCheck exceptionCheck = new ExceptionCheck();

    private ComputerModel computerModel;

    public void gameStart() {
        this.computerModel = new ComputerModel(random.randomNumberGenerator());
    }

    public boolean repeatPlayerExpect() {
        Map<String, Integer> scoreMap;
        String playerNumber = inputview.inputPlayerNumber();

        exceptionCheck.playerInputCheck(playerNumber);
        scoreMap = computerModel.scoreCalculator(playerNumber);
        gameScoreCheck(scoreMap);
        return scoreMap.get("strikeScore") == 3;
    }

    public boolean gameStateChange() {
        String playerNumber;

        outputView.printRestartMessage();
        playerNumber = inputview.inputRestartNumber();
        exceptionCheck.restartInputCheck(playerNumber);
        return Integer.parseInt(playerNumber) == GAMESTATE_RESTART;
    }

    public void gameScoreCheck(Map<String, Integer> scoreMap) {
        int strikeScore = scoreMap.get("strikeScore");
        int ballScore = scoreMap.get("ballScore");

        if (strikeScore == 3) {
            outputView.printStrikeScore(strikeScore);
            outputView.printEndMessage();
        }
        if (strikeScore == 0 && ballScore == 0) {
            outputView.printNothingScore();
        }
        if (strikeScore > 0 && ballScore == 0) {
            outputView.printStrikeScore(strikeScore);
        }
        if (strikeScore == 0 && ballScore > 0) {
            outputView.printBallScore(ballScore);
            System.out.println("");
        }
        if (strikeScore > 0 && ballScore > 0) {
            outputView.printBallScore(ballScore);
            outputView.printStrikeScore(strikeScore);
        }
    }
}
