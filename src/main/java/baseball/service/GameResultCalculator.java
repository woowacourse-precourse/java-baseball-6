package baseball.service;

import baseball.domain.Result;

import java.util.List;
import java.util.Objects;

public class GameResultCalculator {
    private static final int size = 3;

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
