package baseball.controller;

import baseball.model.Balls;
import baseball.model.Computer;
import baseball.model.NumberInput;
import baseball.model.PlayResult;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.Scanner;

public class BaseballGame {

    private static final Scanner SCANNER = new Scanner(System.in);
    private final Computer computer = new Computer();

    public void playGame() {
        InputView.printStartOfGame();
        Balls answerBalls = new Balls(computer.createRandomNumbers());

        playGameUntilCorrect(answerBalls);

        OutputView.printEndOfGame();
        InputView.askRetry();

        askRetry();
    }

    private Balls getBalls() {
        try {
            return new Balls(getInput());
        } catch (IllegalArgumentException e) {
            return getBalls();
        }
    }

    private NumberInput getInput() {
        InputView.demandInput();
        return NumberInput.of(SCANNER.nextLine());
    }

    private PlayResult playGameUntilCorrect(Balls answerBalls) {
        PlayResult playResult = answerBalls.checkBalls(getBalls());
        OutputView.printResult(playResult);

        if (playResult.isCorrect()) {
            return playResult;
        }

        return playGameUntilCorrect(answerBalls);
    }

    private void askRetry() {
        String input = SCANNER.nextLine().trim();

        if (input.equals("2")) {
            return;
        }

        if (input.equals("1")) {
            playGame();
            return;
        }

        InputView.askRetry();
        askRetry();
    }
}
