package baseball.game;

import java.util.List;
import java.util.stream.IntStream;

import static baseball.common.Constants.*;

public class GameResult {
    private Integer strike;
    private Integer ball;

    public GameResult() {
        this.strike = EMPTY_COUNT;
        this.ball = EMPTY_COUNT;
    }

    public void checkResult(List<Integer> userNumbers, List<Integer> computerNumbers) {
        checkStrike(userNumbers, computerNumbers);
        checkBall(userNumbers, computerNumbers);
    }

    private void checkStrike(List<Integer> userNumbers, List<Integer> computerNumbers) {
        strike = (int) IntStream.range(0, userNumbers.size())
                .filter(i -> userNumbers.get(i).equals(computerNumbers.get(i)))
                .count();
    }

    private void checkBall(List<Integer> userNumbers, List<Integer> computerNumbers) {
        long ballCount = IntStream.range(0, userNumbers.size())
                .filter(i -> computerNumbers.contains(userNumbers.get(i)) && !userNumbers.get(i).equals(computerNumbers.get(i)))
                .count();
        ball = (int) ballCount;
    }

    public boolean isNothing() {
        return strike == EMPTY_COUNT && ball == EMPTY_COUNT;
    }

    public boolean isThreeStrike() {
        return strike == STRIKE_OUT_SIZE;
    }

    public void printResult() {
        if (isNothing()) {
            System.out.println(NOTHING);
            return;
        }
        System.out.println(toStringResult(ball, strike));
    }

    private static String toStringResult(Integer ball, Integer strike) {
        StringBuilder stringBuilder = new StringBuilder();
        if (ball != EMPTY_COUNT) {
            stringBuilder.append(ball + BALL);
        }
        if (strike != EMPTY_COUNT) {
            stringBuilder.append(strike + STRIKE);
        }
        return stringBuilder.toString();
    }

}

