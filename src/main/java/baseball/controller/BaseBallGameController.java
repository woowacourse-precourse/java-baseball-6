package baseball.controller;

import baseball.application.BaseBallResult;
import baseball.application.GameUseCase;
import baseball.domain.Hint;
import baseball.controller.dto.BaseBallGameDto;

public class BaseBallGameController implements Game {

    private final GameUseCase gameUseCase;

    public BaseBallGameController(GameUseCase gameUseCase) {
        this.gameUseCase = gameUseCase;
    }

    @Override
    public String play(BaseBallGameDto input) {
        BaseBallResult report = gameUseCase.umpire(new NumericString(input.getInput()));

        if (report.isNoting()) {
            return Hint.NOTHING.toString();
        }

        StringBuilder result = new StringBuilder();
        if (report.haveBall()) {
            result.append(writeBall(report));
        }

        if (report.haveStrike()) {
            result.append(writeStrike(report));
        }

        return result.toString();
    }

    private String writeBall(BaseBallResult report) {
        return String.format("%d%s", report.getBall(), Hint.BALL);
    }

    private String writeStrike(BaseBallResult report) {
        String result = "";
        if (report.haveBall()) {
            result = " ";
        }
        return result + String.format("%d%s", report.getStrike(), Hint.STRIKE);
    }
}
