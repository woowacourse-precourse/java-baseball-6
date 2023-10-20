package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ComputerGenerator {

    public static final int COMPUTER_NUMBER_SIZE = 3;

    public static final int MIN_NUMBER = 1;

    public static final int MAX_NUMBER = 9;

    public static Computer generate() {
        return new Computer(generateNumbers());
    }

    private static List<Integer> generateNumbers() {
        return Stream.generate(ComputerGenerator::pickRandomNumber)
                .distinct()
                .limit(COMPUTER_NUMBER_SIZE)
                .collect(Collectors.toList());
    }

    private static int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
