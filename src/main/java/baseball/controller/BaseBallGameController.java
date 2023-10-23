package baseball.controller;

import baseball.application.BaseBallResult;
import baseball.application.GameUseCase;
import baseball.domain.Hint;

public class BaseBallGameController {

    private final GameUseCase gameUseCase;

    public BaseBallGameController(GameUseCase gameUseCase) {
        this.gameUseCase = gameUseCase;
    }

    public String play(String input) {
        BaseBallResult report = gameUseCase.umpire(new NumericString(input));

        if (report.isNoting()) {
            return Hint.NOTHING.toString();
        }

        StringBuilder result = new StringBuilder();
        if (report.haveBall()) {
            writeBall(report, result);
        }

        if (report.haveStrike()) {
            writeStrike(report, result);
        }

        return result.toString();
    }

    private void writeBall(BaseBallResult execution, StringBuilder result) {
        result.append(execution.getBall()).append(Hint.BALL);
    }

    private void writeStrike(BaseBallResult execution, StringBuilder result) {
        if (!result.isEmpty()) {
            result.append(" ");
        }
        result.append(execution.getStrike()).append(Hint.STRIKE);
    }
}
