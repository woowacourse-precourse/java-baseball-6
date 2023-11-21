package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.RandomGenerator;
import baseball.domain.Result;
import baseball.global.Const;
import baseball.util.parser.Parser;
import baseball.util.validator.Validator;
import baseball.view.Input;
import baseball.view.Output;

public class Game {
    private Balls computerBalls;

    public void game() {
        start();
        process();
        RestartOrExit();
    }

    private void start() {
        Input.welcome();
        resetRandomNumbers();
    }

    private void process() {
        String userInput = Input.requestNumbers();

        Balls userBalls = Balls.createOf(Parser.parseToNumeric(userInput));
        Result result = userBalls.calculateResult(computerBalls);

        Output.printGameResult(
                result.processResult()
        );

        winOrLose(result);
    }

    private void RestartOrExit() {
        Output.noticeWin();

        int restartInput = Parser.parseToInt(Input.askRestart());

        Validator.validateRestartInput(restartInput);

        restartOrExit(restartInput);
    }

    private void resetRandomNumbers() {
        computerBalls = Balls.createOf(RandomGenerator.generate());
    }

    private void winOrLose(Result result) {
        if (result.isLose()) {
            process();
        }
    }

    private void restartOrExit(int restartInput) {
        if (restartInput == Const.RESTART_INPUT) {
            game();
        }
    }
}
