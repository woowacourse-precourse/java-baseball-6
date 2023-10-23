package baseball.controller;

import baseball.application.BaseBallResult;
import baseball.application.GameUseCase;
import baseball.domain.BaseBallNumberList;
import baseball.domain.NumericString;

public class BaseBallGameController {

    private final GameUseCase gameUseCase;

    public BaseBallGameController(GameUseCase gameUseCase) {
        this.gameUseCase = gameUseCase;
    }

    public String play(String input) {
        BaseBallResult execution = gameUseCase.execution(
                new BaseBallNumberList(new NumericString(input).toList()));

        return execution.getStrike()+"스트라이크";
    }
}
