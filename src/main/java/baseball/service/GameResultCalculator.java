package baseball.service;

import baseball.domain.GameResult;

import java.util.List;
import java.util.Objects;

public class GameResultCalculator {
    private static final int size = 3;

    public static GameResult caculateGameResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strike = calculateStrikeCount(computerNumbers, userNumbers);
        int ball = (int) userNumbers.stream().filter(computerNumbers::contains).count() - strike;
        int out = size - ball - strike;

        return new GameResult(ball, strike, out);
    }

    public static int calculateStrikeCount(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int result = 0;

        for (int i = 0; i < size; i++) {
            if (Objects.equals(computerNumbers.get(i), userNumbers.get(i))) {
                result += 1;
            }
        }

        return result;
    }
}
