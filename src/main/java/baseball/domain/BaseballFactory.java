package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballFactory {
    private static final char ZERO_CHAR = '0';
    private static final int BASEBALLS_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private BaseballFactory() {
        throw new AssertionError();
    }

    public static ComputerBaseballs createComputerBaseballs() {
        List<Integer> ballNumbers = generateRandomNumbers();

        List<Baseball> baseballs = ballNumbers.stream()
                .map(Baseball::new)
                .toList();

        return new ComputerBaseballs(baseballs);
    }

    public static UserBaseballs createUserBaseballs(String ballNumberString) {
        List<Baseball> baseballs = ballNumberString.chars()
                .mapToObj(c -> new Baseball(c - ZERO_CHAR))
                .toList();

        return new UserBaseballs(baseballs);
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < BASEBALLS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }
}
