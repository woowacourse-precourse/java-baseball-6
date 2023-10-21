package baseball.controller;

import baseball.domain.game.Balls;
import baseball.domain.game.BaseballGame;
import baseball.domain.game.result.PlayResult;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainController {
    private static final String DELIMITER = "";
    private static final int RESTART_NUMBER = 1;

    private final InputView inputView;
    private final OutputView outputView;

    public MainController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printStartMessage();

        start(new BaseballGame());
    }

    private void start(BaseballGame baseballGame) {
        play(baseballGame);

        outputView.printEndMessage();
        decideToRestartOrNot(baseballGame);
    }

    private void play(BaseballGame baseballGame) {
        while (canPlay(baseballGame)) {
            PlayResult playResult = baseballGame.play(initializeUserBalls());

            showPlayResult(playResult);
        }
    }

    private boolean canPlay(BaseballGame baseballGame) {
        return !baseballGame.isGameEnd();
    }

    private Balls initializeUserBalls() {
        List<Integer> numbers = convertToIntegerList(inputView.inputBallNumbers());

        return new Balls(numbers);
    }

    private List<Integer> convertToIntegerList(String inputBallNumbers) {
        return Arrays.stream(inputBallNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void showPlayResult(PlayResult playResult) {
        outputView.printResult(playResult.getBall(), playResult.getStrike());
    }

    private void decideToRestartOrNot(BaseballGame baseballGame) {
        int restartOptionNumber = inputView.inputRestartOptionNumber();

        if (canRestart(restartOptionNumber)) {
            baseballGame.restart();
            start(baseballGame);
        }
    }

    private boolean canRestart(int restartOptionNumber) {
        return restartOptionNumber == RESTART_NUMBER;
    }
}
