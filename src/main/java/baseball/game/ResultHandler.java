package baseball.game;

import static constant.Constant.GAME_END_MESSAGE;
import static constant.Constant.RESTART_COMMAND;
import static constant.Constant.TERMINATE_COMMAND;
import static constant.ErrorMessage.ERROR_MESSAGE;

import io.GameUserInterface;

public class ResultHandler {
    private final GameUserInterface ui;
    private final BaseballGameValueGenerator generator;

    public ResultHandler(GameUserInterface ui, BaseballGameValueGenerator generator) {
        this.ui = ui;
        this.generator = generator;
    }

    public void handleInningResult(InningResult inningResult) {
        if (inningResult.noMatchesExists()) {
            ui.print(inningResult.getNothingMessage());
            ui.print("\n");
            return;
        }
        if (inningResult.hasBalls()) {
            ui.print(inningResult.getBallMessage());
        }
        if (inningResult.hasStrikes()) {
            ui.print(inningResult.getStrikeMessage());
        }
        ui.print("\n");
    }

    public BaseballGameStatus handleThreeStrikes(String restartOrTerminate) {
        if (restartOrTerminate.equals(RESTART_COMMAND)) {
            return BaseballGameStatus.newGame(generator.generateThreeRandomNumbers());
        }
        if (restartOrTerminate.equals(TERMINATE_COMMAND)) {
            ui.println(GAME_END_MESSAGE);
            return BaseballGameStatus.terminate();
        }
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }
}