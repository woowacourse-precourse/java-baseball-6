package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static baseball.Constants.*;

public class Result {
    private Integer strike;
    private Integer ball;

    public Result(List<Integer> computerNumbers, List<Integer> userNumbers) {
        this.strike = checkStrike(computerNumbers, userNumbers);
        this.ball = checkBall(computerNumbers, userNumbers);
    }

    private Integer checkStrike(List<Integer> userNumbers, List<Integer> computerNumbers) {
        return (int) IntStream.range(0, userNumbers.size())
                .filter(i -> userNumbers.get(i).equals(computerNumbers.get(i)))
                .count();
    }

    private Integer checkBall(List<Integer> userNumbers, List<Integer> computerNumbers) {
        Set<Integer> setNumbers = new HashSet<>(userNumbers);
        Set<Integer> setCompareNumbers = new HashSet<>(computerNumbers);
        setNumbers.retainAll(setCompareNumbers);
        return setNumbers.size() - checkStrike(userNumbers, computerNumbers);
    }

    public boolean isNothing() {
        return strike == EMPTY_COUNT && ball == EMPTY_COUNT;
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

