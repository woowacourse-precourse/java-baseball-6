package baseball.util;

import baseball.constant.Number;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersGenerator {

    private RandomNumbersGenerator() {
    }

    public static String generate() {
        return IntStream.generate(RandomNumbersGenerator::pickNumber)
                .distinct()
                .limit(Number.SIZE)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    private static int pickNumber() {
        return Randoms.pickNumberInRange(Number.MIN, Number.MAX);
    }
}
