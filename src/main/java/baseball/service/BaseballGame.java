package baseball.service;

import static baseball.utils.BaseballGamePrinterUtils.announceGameResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.assertj.core.util.VisibleForTesting;

public class BaseballGame {

    private static final int STRIKE_COUNT_TO_WIN = 3;
    private static final int NUMBER_TO_COMPARE = 3;
    private final List<Integer> baseballGameNumbers;

    public BaseballGame(List<Integer> baseballGameNumbers) {
        this.baseballGameNumbers = new ArrayList<>(baseballGameNumbers);
    }

    public boolean isPlayerWin(List<Integer> playerTargetNums) {
        int ballCount = calculateBall(playerTargetNums);
        int strikeCount = calculateStrike(playerTargetNums);
        announceGameResult(ballCount, strikeCount);
        return isCountToWin(strikeCount);
    }

    @VisibleForTesting
    protected int calculateBall(List<Integer> playerTargetNums) {
        return (int) IntStream.range(0, NUMBER_TO_COMPARE)
                .filter(i -> baseballGameNumbers.contains(playerTargetNums.get(i))
                        && !baseballGameNumbers.get(i).equals(playerTargetNums.get(i)))
                .count();
    }

    @VisibleForTesting
    protected int calculateStrike(List<Integer> playerTargetNums) {
        return (int) IntStream.range(0, NUMBER_TO_COMPARE)
                .filter(i -> baseballGameNumbers.get(i).equals(playerTargetNums.get(i)))
                .count();
    }

    @VisibleForTesting
    protected static boolean isCountToWin(int count) {
        return count == STRIKE_COUNT_TO_WIN;
    }
}
