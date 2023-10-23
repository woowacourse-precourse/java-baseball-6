package baseball.controller;

import baseball.application.BaseBallResult;
import baseball.application.GameUseCase;
import baseball.domain.NumericString;

public class BaseBallGameController {

    private final GameUseCase gameUseCase;

    public BaseBallGameController(GameUseCase gameUseCase) {
        this.gameUseCase = gameUseCase;
    }

    public String play(String input) {
        BaseBallResult execution = gameUseCase.execute(new NumericString(input));

        if (execution.isNoting()) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();

        if (execution.haveBall()) {
            result.append(execution.getBall()).append("볼");
        }

        if (execution.haveStrike()) {
            if (!result.isEmpty()) {
                result.append(" ");
            }
            result.append(execution.getStrike()).append("스트라이크");
        }

        return result.toString();
    }
}
