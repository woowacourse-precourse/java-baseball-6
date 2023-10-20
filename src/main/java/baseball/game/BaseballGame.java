package baseball.game;

import static baseball.converter.AfterBaseballStateConverter.stringToAfterBaseballState;
import static baseball.converter.BaseballStateConverter.stringToBaseballState;

import baseball.constant.BaseballString;
import baseball.state.AfterBaseballState;
import baseball.state.BaseballResult;
import baseball.state.BaseballState;
import baseball.util.IoHelper;
import baseball.util.RandomGenerator;
import java.util.List;

public class BaseballGame implements Game {
    BaseballState computer;

    public void awake() {
        IoHelper.println(BaseballString.GAME_START_MESSAGE);
    }

    public void beforeLoop() {
        final List<Integer> randoms = RandomGenerator.generateUniqueRandomListOf(3);

        computer = new BaseballState(randoms);
    }

    public void gameLoop() {
        final String input = IoHelper.promptColon(BaseballString.INPUT_NUMBER_MESSAGE);
        final BaseballState userGuess = stringToBaseballState(input);
        final BaseballResult result = computer.diff(userGuess);

        IoHelper.println(result.toString());
        if (result.isGameEnd()) {
            IoHelper.println(BaseballString.STRIKE_ALL_MESSAGE);
            GameManager.notifyEndGame();
        }
    }

    public void afterLoop() {
        final String input = IoHelper.promptln(BaseballString.INPUT_RESTART_MESSAGE);
        final AfterBaseballState afterState = stringToAfterBaseballState(input);

        if (afterState == AfterBaseballState.END_GAME) {
            GameManager.notifyEndGameManager();
        }
    }

    public void cleanup() {
    }
}
