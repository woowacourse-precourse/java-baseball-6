package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.BaseballGame;
import baseball.domain.PlayResult;
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
        BaseballGame baseballGame = new BaseballGame();
        play(baseballGame);
    }

    private void play(BaseballGame baseballGame) {
        while (canPlay(baseballGame)) {
            Balls userBalls = initializeUserBalls();
            PlayResult playResult = baseballGame.play(userBalls);

            outputView.printResult(playResult.getBall(), playResult.getStrike());
        }

        outputView.printEndMessage();
        decideToRestartOrNot(baseballGame);
    }

    private boolean canPlay(BaseballGame baseballGame) {
        return !baseballGame.isGameEnd();
    }

    private Balls initializeUserBalls() {
        String inputBallNumbers = inputView.inputBallNumbers();
        List<Integer> numbers = convertToIntegerList(inputBallNumbers);

        return new Balls(numbers);
    }

    private List<Integer> convertToIntegerList(String inputBallNumbers) {
        return Arrays.stream(inputBallNumbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void decideToRestartOrNot(BaseballGame baseballGame) {
        int restartOptionNumber = inputView.inputRestartOptionNumber();

        if (restartOptionNumber == RESTART_NUMBER) {
            baseballGame.restart();
            play(baseballGame);
        }
    }
}
