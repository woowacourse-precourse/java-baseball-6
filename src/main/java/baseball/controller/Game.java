package baseball.controller;

import static baseball.view.InputView.close;
import static baseball.view.InputView.inputNumbers;
import static baseball.view.InputView.inputRestart;
import static baseball.view.OutputView.printGameOver;
import static baseball.view.OutputView.printGameStart;
import static baseball.view.OutputView.printHint;

import baseball.model.Numbers;
import baseball.model.RandomNumbersGenerator;
import baseball.model.Result;

public class Game {
    public static void start() {
        printGameStart();
        Restart restart;
        do {
            play();
            printGameOver();
            restart = Restart.from(inputRestart());
        } while (restart.isTrue());
        close();
    }

    private static void play() {
        Numbers computer = RandomNumbersGenerator.generate();
        Result result;
        do {
            Numbers user = Numbers.from(inputNumbers());
            result = Result.of(computer, user);
            printHint(result.getHint());
        } while (result.isLessThanThreeStrikes());
    }
}
