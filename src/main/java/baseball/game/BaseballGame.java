package baseball.game;

import static baseball.constant.BaseballConstants.MAX_MATCH;
import static baseball.constant.BaseballString.GAME_START_MESSAGE;
import static baseball.constant.BaseballString.INPUT_NUMBER_MESSAGE;
import static baseball.constant.BaseballString.INPUT_RESTART_MESSAGE;
import static baseball.constant.BaseballString.STRIKE_ALL_MESSAGE;
import static baseball.converter.AfterBaseballStateConverter.stringToAfterBaseballState;
import static baseball.converter.BaseballStateConverter.stringToBaseballState;

import baseball.state.AfterBaseballState;
import baseball.state.BaseballResult;
import baseball.state.BaseballState;
import baseball.util.IoHelper;
import baseball.util.RandomGenerator;
import java.util.List;

public class BaseballGame implements Game {
    BaseballState computer;

    public void awake() {
        IoHelper.println(GAME_START_MESSAGE);
    }

    public void beforeLoop() {
        final List<Integer> randoms = RandomGenerator.generateUniqueRandomListOf(MAX_MATCH);

        computer = new BaseballState(randoms);
    }

    public void gameLoop() {
        final String input = IoHelper.promptColon(INPUT_NUMBER_MESSAGE);
        final BaseballState userGuess = stringToBaseballState(input);
        final BaseballResult result = computer.diff(userGuess);

        IoHelper.println(result.toString());
        if (result.isGameEnd()) {
            IoHelper.println(STRIKE_ALL_MESSAGE);
            GameManager.notifyEndGame();
        }
    }

    public void afterLoop() {
        final String input = IoHelper.promptln(INPUT_RESTART_MESSAGE);
        final AfterBaseballState afterState = stringToAfterBaseballState(input);

        if (afterState == AfterBaseballState.END_GAME) {
            GameManager.notifyEndGameManager();
        }
    }

    public void cleanup() {
    }
}
