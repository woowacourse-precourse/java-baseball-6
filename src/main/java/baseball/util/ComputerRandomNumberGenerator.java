package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComputerRandomNumberGenerator implements RandomNumberGenerator {
    private final int MIN_BALL_NUMBER = 1;
    private final int MAX_BALL_NUMBER = 9;

    @Override
    public int generateRandomNumber(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

    @Override
    public List<Integer> createUniqueNumbers(int size) {
        return Stream.generate(() -> generateRandomNumber(MIN_BALL_NUMBER, MAX_BALL_NUMBER))
                .distinct()
                .limit(size)
                .collect(Collectors.toList());
    }
}
