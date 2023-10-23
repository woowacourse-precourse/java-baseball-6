package controller;

import domain.Number;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballController {
    private List<Number> numbers = new ArrayList<>();

    public void initGame() {
        OutputView.startGame();
    }

    public void playGame() {
        resetGame();
        do {
            playRound();
        } while (!isEnd());
        gameOver();
    }

    private static void resetGame() {
        Number.reset();
    }

    private void playRound() {
        OutputView.inputNumber();
        numbers = inputNumbers();
        printResult();
    }

    private List<Number> inputNumbers() {
        return InputView.inputNumbers().stream()
                .map(Number::new)
                .toList();
    }

    private void printResult() {
        OutputView.printResult(Number.getStrike(numbers), Number.getBall(numbers));
    }

    private boolean isEnd() {
        return Number.getStrike(numbers) == 3;
    }

    private static void gameOver() {
        OutputView.gameOver();
    }

    public boolean restartGame() {
        OutputView.restartGame();
        return InputView.restartGame();
    }
}
