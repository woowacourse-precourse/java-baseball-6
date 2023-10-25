package baseball.application;

import baseball.controller.input.Input;
import baseball.controller.output.Output;
import baseball.domain.ball.Balls;
import baseball.domain.game.GameOperator;
import baseball.domain.result.Result;

public class ConsoleInputOutput implements GameOperator {
    @Override
    public Balls batting() {
        Output.showInput();
        return Input.read();
    }

    @Override
    public void round(Result result) {
        Output.showResult(result);
    }

    @Override
    public boolean isContinue() {
        Output.showEndMessage();
        return Input.isContinue();
    }
}