package baseball.domain;

import baseball.domain.gamenumber.GameNumber;
import baseball.domain.gamenumber.GameNumbers;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomGameNumbersGenerator {
    private RandomGameNumbersGenerator() {}

    public static GameNumbers generateRandomGameNumbers() {
        String randomGameNumbers = Stream.generate(RandomGameNumbersGenerator::pickRandomGameNumber)
                .distinct()
                .limit(GameNumbers.LENGTH)
                .collect(Collectors.joining());

        return new GameNumbers(randomGameNumbers);
    }

    private static String pickRandomGameNumber() {
        int randomGameNumber = Randoms.pickNumberInRange(GameNumber.MIN_NUMBER, GameNumber.MAX_NUMBER);

        return Integer.toString(randomGameNumber);
    }
}
