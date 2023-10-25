package baseball.Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BaseballComparator {
    public final int ballCount;
    public final int strikeCount;

    public BaseballComparator(int[] computer, int[] user) {
        this.ballCount = checkBall(computer, user);
        this.strikeCount = checkStrike(computer, user);
    }

    private int checkStrike(int[] computer, int[] user) {
        return (int) IntStream.range(0, GameConstant.MAX_NUM)
                .filter(i -> user[i] == computer[i])
                .count();
    }

    private int checkBall(int[] computer, int[] user) {
        return (int) IntStream.range(0, GameConstant.MAX_NUM)
                .filter(i -> user[i] != computer[i] && IntStream.of(computer).anyMatch(number -> number == user[i]))
                .count();
    }

    public boolean isThreeStrike() {
        return strikeCount == GameConstant.MAX_NUM;
    }
}
