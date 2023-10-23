package baseball.controller;

import baseball.model.Balls;
import baseball.model.Computer;
import baseball.model.NumberInput;
import baseball.model.PlayResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private final Computer computer = new Computer();

    public void playGame() {
        InputView.printStartOfGame();
        newGame();
    }

    private void newGame() {
        Balls answerBalls = new Balls(computer.createRandomNumbers());

        playGameUntilCorrect(answerBalls);

        OutputView.printEndOfGame();

        askRetry();
    }

    private PlayResult playGameUntilCorrect(Balls answerBalls) {
        PlayResult playResult = answerBalls.checkBalls(getBalls());
        OutputView.printResult(playResult);

        if (playResult.isCorrect()) {
            return playResult;
        }

        return playGameUntilCorrect(answerBalls);
    }

    private Balls getBalls() {
        return new Balls(getInput());
    }

    private NumberInput getInput() {
        InputView.demandInput();
        return NumberInput.of(Console.readLine());
    }

    private void askRetry() {
        InputView.askRetry();
        String input = Console.readLine().trim();

        if (input.equals("2")) {
            return;
        }

        if (input.equals("1")) {
            newGame();
            return;
        }

//        InputView.askRetry();
//        askRetry();
    }
}
