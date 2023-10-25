package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.BaseballGame;
import baseball.domain.BaseballResult;
import baseball.domain.Computer;
import baseball.domain.GameState;
import baseball.domain.Player;
import baseball.dto.BaseballResultDto;
import baseball.utils.NumberGenerator;
import baseball.utils.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    public void run() {
        OutputView.printStart();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Computer computer = new Computer(numberGenerator);
        GameState state = GameState.RUNNING;

        while (state.isRunable()) {
            BaseballGame baseballGame = guessNumbers(computer);
            BaseballResult result = getBaseballResult(baseballGame);
            state = getGameState(result);
            computer = computer.resetOrMaintain(state, numberGenerator);
        }
    }

    private BaseballGame guessNumbers(Computer computer) {
        String input = InputView.inputNumber();
        Player player = new Player(input);
        return new BaseballGame(computer, player);
    }

    private BaseballResult getBaseballResult(BaseballGame baseballGame) {
        Baseball baseball = baseballGame.compare();
        BaseballResult result = BaseballResult.of(baseball);
        OutputView.printBaseballResult(
                new BaseballResultDto(baseball.ball(), baseball.strike(), result.getMessageFormat()));
        return result;
    }

    private GameState getGameState(BaseballResult baseballResult) {
        GameState state = GameState.of(baseballResult);
        if (state.isRunning()) {
            return GameState.RUNNING;
        }
        return selectRetryOrQuit();
    }

    private GameState selectRetryOrQuit() {
        OutputView.printDone();
        int gameStatus = InputView.inputRetryOrQuit();
        return GameState.of(gameStatus);
    }
}
