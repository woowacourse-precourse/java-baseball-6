package baseball.utils;

import static baseball.utils.BaseballGameConsoleValidator.isValidatedInputForPlayer;
import static baseball.utils.BaseballGameConsoleValidator.isValidatedInputForRestart;
import static baseball.utils.BaseballGamePrinterUtils.askPlayerTargetNums;
import static baseball.utils.BaseballGamePrinterUtils.printAskStartNewGame;
import static baseball.utils.NewGameStartFlag.START;
import static baseball.utils.NewGameStartFlag.UNAVAILABLE;
import static baseball.utils.NewGameStartFlag.getNewGameStart;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.util.VisibleForTesting;

public class BaseballGameReaderUtils {

    public static boolean askStartNewGame() {
        try {
            printAskStartNewGame();
            String answer = Console.readLine();
            return isNewGameStarted(answer);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @VisibleForTesting
    protected static boolean isNewGameStarted(String answer) {
        if (!isValidatedInputForRestart(answer)) {
            throw new IllegalArgumentException();
        }
        int restartFlag = Integer.parseInt(answer);
        NewGameStartFlag newGameStartFlag = getNewGameStart(restartFlag);
        if (newGameStartFlag == UNAVAILABLE) {
            throw new IllegalArgumentException();
        }
        return newGameStartFlag == START;
    }

    public static List<Integer> getPlayerTargetNums() {
        try {
            askPlayerTargetNums();
            return convertPlayerTargetNums(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @VisibleForTesting
    protected static List<Integer> convertPlayerTargetNums(String answer) {
        if (!isValidatedInputForPlayer(answer)) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(answer.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
