package baseball.controller;

import baseball.model.Balls;
import baseball.model.InputNumbers;
import baseball.model.NumbersGenerator;
import baseball.model.PlayResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import static baseball.exception.ErrorMessage.INVALID_ANSWER_ABOUT_RETRY;

public class BaseballGame {
    public static final String RETRY = "1";
    public static final String QUIT = "2";
    private final NumbersGenerator numbersGenerator = new NumbersGenerator();

    public void play() {
        InputView.printStartOfGame();
        playGame();
    }

    private void playGame() {
        Balls answerBalls = new Balls(numbersGenerator.createRandomNumbers());

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

    private InputNumbers getInput() {
        InputView.demandInput();
        return InputNumbers.of(Console.readLine());
    }

    private void askRetry() {
        InputView.askRetry();
        String input = Console.readLine().trim();

        if (input.equals(RETRY)) {
            playGame();
            return;
        }

        if (input.equals(QUIT)) {
            return;
        }

        throw new IllegalArgumentException(INVALID_ANSWER_ABOUT_RETRY.toString());
    }
}
