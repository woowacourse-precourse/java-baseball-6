package baseball;

import baseball.controller.NumberBaseBallGame;
import baseball.strategy.ForbidDuplicationPolicy;
import baseball.strategy.RandomNumberGeneratePolicy;
import baseball.view.ConsoleInput;
import baseball.view.ConsoleOutput;

public class Application {

    private final static int NUMBER_OF_DIGITS = 3;

    public static void main(String[] args) {
        new NumberBaseBallGame(
                new ConsoleInput(),
                new ConsoleOutput()
        ).run(
                new RandomNumberGeneratePolicy(),
                new ForbidDuplicationPolicy(),
                NUMBER_OF_DIGITS
        );
    }
}
