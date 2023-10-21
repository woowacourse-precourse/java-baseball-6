package baseball.utils;

import static baseball.utils.BaseballGameConsoleValidator.isValidatedInput;
import static baseball.utils.NewGameStartFlag.START;
import static baseball.utils.NewGameStartFlag.UNAVAILABLE;
import static baseball.utils.NewGameStartFlag.getNewGameStart;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.util.VisibleForTesting;

public class BaseballGameReaderUtils {

    private static final int VALIDATE_INPUT_LENGTH_FOR_RESTART = 1;

    public static boolean askStartNewGame() {
        try {
            String answer = Console.readLine();
            return isNewGameStarted(answer);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @VisibleForTesting
    protected static boolean isNewGameStarted(String answer) {
        if (!isValidatedInput(answer, VALIDATE_INPUT_LENGTH_FOR_RESTART)) {
            throw new IllegalArgumentException();
        }
        int restartFlag = Integer.parseInt(answer);
        NewGameStartFlag newGameStartFlag = getNewGameStart(restartFlag);
        if (newGameStartFlag == UNAVAILABLE) {
            throw new IllegalArgumentException();
        }
        return newGameStartFlag == START;
    }
}
