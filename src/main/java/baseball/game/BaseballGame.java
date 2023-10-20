package baseball.game;

import static baseball.constant.BaseballConstants.MAX_MATCH;
import static baseball.constant.BaseballStrings.GAME_START_MESSAGE;
import static baseball.constant.BaseballStrings.INPUT_NUMBER_MESSAGE;
import static baseball.constant.BaseballStrings.INPUT_RESTART_MESSAGE;
import static baseball.constant.BaseballStrings.STRIKE_ALL_MESSAGE;
import static baseball.converter.AfterBaseballStateConverter.stringToAfterBaseballState;
import static baseball.converter.BaseballStateConverter.stringToBaseballState;

import baseball.state.BaseballState;
import baseball.util.IoHelper;
import baseball.util.RandomGenerator;

public class BaseballGame implements Game {
    BaseballState computer;

    public void awake() {
        IoHelper.println(GAME_START_MESSAGE);
    }

    public void beforeLoop() {
        final var randomDigitList = RandomGenerator.generateUniqueRandomDigitList(MAX_MATCH);
        computer = new BaseballState(randomDigitList);
    }

    public void gameLoop() {
        final var input = IoHelper.promptColon(INPUT_NUMBER_MESSAGE);
        final var userGuess = stringToBaseballState(input);
        final var result = computer.diff(userGuess);

        IoHelper.println(result.toString());
        if (result.isGameEnd()) {
            IoHelper.println(STRIKE_ALL_MESSAGE);
            GameManager.notifyEndGame();
        }
    }

    public void afterLoop() {
        final var input = IoHelper.promptln(INPUT_RESTART_MESSAGE);
        final var afterState = stringToAfterBaseballState(input);

        if (afterState.isEnd()) {
            GameManager.notifyEndGameManager();
        }
    }

    public void cleanup() {
    }
}
