package baseball.controller;

import baseball.model.*;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    private List<Integer> userNumbers;
    private List<Integer> computerNumbers;
    private int strikeCount;
    private int ballCount;
    private boolean restartGame;
    private boolean restartCheck = true;

    private final RandomNum randomNumGenerator = new RandomNum();
    private final InputNum inputNumProcessor = new InputNum();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        outputView.startGame();
        computerNumbers = randomNumGenerator.generateRandomNumbers();
        playGame();
    }

    public void playGame() {
        userNumbers = inputNumProcessor.convertInputToNumbers(inputView.inputNum());
        Result result = new Result(userNumbers, computerNumbers);
        strikeCount = result.calculateStrikes();
        ballCount = result.calculateBalls();
        showResult();
    }

    public void showResult() {
        restartGame = outputView.showResult(strikeCount, ballCount);
        if (restartGame) {
            EndGame endGame = new EndGame(inputView.gameRestart());
            restartCheck = endGame.isRestart();
            if (restartCheck) {
                start();
            }
        }
        while (restartCheck) {
            playGame();
        }
    }
}